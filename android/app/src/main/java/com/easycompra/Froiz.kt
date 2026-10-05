package com.easycompra

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url
import java.io.File

/**
 * Froiz se descarga desde el movil, no desde GitHub como los demas.
 *
 * Su tienda online (supermercado.froiz.com) lee el catalogo de una API
 * publica, pero Cloudflare bloquea las IP de los servidores de GitHub (403,
 * tambien con navegador). Desde el movil, con una IP normal de casa o de
 * datos, responde sin problema: es como compra la gente desde su web.
 *
 * Son ~34 paginas de 200 articulos. Para no repetirlo en cada arranque se
 * guarda en disco y se reutiliza 12 horas, salvo al pulsar recargar.
 *
 * Cada tienda tiene su surtido (el precio es el mismo): se pide el de la
 * tienda que Froiz asigna al codigo postal. Si esa tienda es de otra
 * provincia (en Asturias le da una de Toledo), es que no hay Froiz cerca.
 */
object Froiz {

    private const val API = "https://servicios.froiz.com/api/products"
    private const val TIENDAS = "https://servicios.froiz.com/api/stores/postalcode"
    private const val IMAGENES = "https://imagedelivery.net/laxGYDNZyT04iZVpzPzryw"
    private const val TIENDA = "https://supermercado.froiz.com/product"
    private const val PAGINA = 200
    private const val VIGENCIA_MS = 12 * 60 * 60 * 1000L

    // Drogueria y perfumeria (7) e infantil (35) no son comida.
    private val SIN_COMIDA = setOf(7, 35)
    // De "Bodega y bebidas" (6) solo aguas, refrescos y zumos: nada de alcohol.
    private const val BEBIDAS = 6
    private const val SIN_ALCOHOL = "aguas-refrescos-y-zumos"

    private val UNIDADES = mapOf("Kilogramo" to "kg", "Litro" to "l", "Unidad" to "ud", "Docena" to "docena")
    private val NATA = Regex("\\bnata\\b", RegexOption.IGNORE_CASE)

    interface Api {
        // Sin esta cabecera la API responde en otro formato (JSON-LD, con los
        // productos en "hydra:member"); su propia web tambien la pone.
        @Headers("Accept: application/json")
        @GET
        suspend fun pagina(@Url url: String): Pagina

        @Headers("Accept: application/json")
        @GET
        suspend fun tienda(@Url url: String): Tienda
    }

    @Serializable
    class Tienda(val codEnt: Int? = null, val codSubent: Int? = null, val postalCode: String? = null)

    /** "1_123" para la API, o null si la tienda asignada es de otra provincia. */
    fun codigoTienda(t: Tienda, cp: String): String? {
        if (t.codEnt == null || t.codSubent == null) return null
        if (t.postalCode?.take(2) != cp.take(2)) return null
        return "${t.codEnt}_${t.codSubent}"
    }

    @Serializable
    class Pagina(val products: List<Articulo> = emptyList(), val stats: Stats = Stats())

    @Serializable
    class Stats(val totalPages: Int = 0)

    /** Solo los campos que se usan; la API trae muchos mas. */
    @Serializable
    class Articulo(
        val id: Long = 0,
        val name: String = "",
        val brand_name: String? = null,
        val enabled: Boolean = true,
        val category_id: Int? = null,
        val section_slug: String? = null,
        // La API mezcla numeros y numeros entre comillas: se leen como texto.
        val order_price: String? = null,
        val base_price: String? = null,
        val measurement_unit: String? = null,
        val measurement_unit_ratio: String? = null,
        val image_id: String? = null,
        val slug: String? = null,
    )

    /** Articulo de la API -> Product de la app. Null si no es comida. */
    fun convertir(a: Articulo): Product? {
        if (!a.enabled || a.name.isBlank() || a.category_id in SIN_COMIDA) return null
        if (a.category_id == BEBIDAS && a.section_slug != SIN_ALCOHOL) return null

        // order_price es lo que se paga hoy (con la oferta, si la hay).
        val precio = a.order_price?.toDoubleOrNull() ?: a.base_price?.toDoubleOrNull()
        val unidad = UNIDADES[a.measurement_unit]
        val cantidad = a.measurement_unit_ratio?.toDoubleOrNull()
        // 2,99 € por 0,225 kg -> 13,29 €/kg. Lo que va a granel tiene 1.
        val referencia = if (precio != null && unidad != null && cantidad != null && cantidad > 0) {
            Math.round(precio / cantidad * 100) / 100.0
        } else null

        return Product(
            supermarket = "Froiz",
            external_id = a.id.toString(),
            name = a.name,
            brand = a.brand_name,
            // La foto que da la API va firmada y caduca; esta variante no.
            photo_url = a.image_id?.let { "$IMAGENES/$it/desktop" },
            unit_price = precio,
            reference_price = referencia,
            reference_format = if (referencia != null) unidad else null,
            contains_nata = NATA.containsMatchIn(a.name),
            share_url = a.slug?.let { "$TIENDA/$it" },
        )
    }

    /**
     * Catalogo de comida de Froiz. Con [forzar], se descarga aunque la copia
     * guardada sea reciente. Si la descarga falla, vale la copia guardada,
     * sea de cuando sea; sin ella, lista vacia (y el resto sigue).
     */
    suspend fun productos(dir: File, cp: String, forzar: Boolean): List<Product> = withContext(Dispatchers.IO) {
        val fichero = File(dir, "froiz_$cp.json")
        val guardados = runCatching {
            ApiFactory.json.decodeFromString<List<Product>>(fichero.readText())
        }.getOrNull()

        val reciente = System.currentTimeMillis() - fichero.lastModified() < VIGENCIA_MS
        if (!forzar && reciente && !guardados.isNullOrEmpty()) return@withContext guardados

        runCatching { descargar(cp) }
            .onSuccess { nuevos ->
                if (nuevos.isNotEmpty()) {
                    runCatching { fichero.writeText(ApiFactory.json.encodeToString(nuevos)) }
                }
            }
            .getOrNull()
            ?.takeIf { it.isNotEmpty() }
            ?: guardados.orEmpty()
    }

    private suspend fun descargar(cp: String): List<Product> = coroutineScope {
        val api = ApiFactory.froiz()
        // Sin tienda en la provincia: Froiz no esta en esa ciudad.
        val tienda = codigoTienda(api.tienda("$TIENDAS/$cp"), cp) ?: return@coroutineScope emptyList()
        val primera = api.pagina("$API?page=1&size=$PAGINA&store=$tienda")
        // El resto de 4 en 4: rapido sin cargar a su servidor.
        val turnos = Semaphore(4)
        val resto = (2..primera.stats.totalPages.coerceAtMost(100)).map { n ->
            async { turnos.withPermit { api.pagina("$API?page=$n&size=$PAGINA&store=$tienda") } }
        }.awaitAll()
        (listOf(primera) + resto)
            .flatMap { it.products }
            .mapNotNull(::convertir)
            .distinctBy { it.external_id }
    }
}
