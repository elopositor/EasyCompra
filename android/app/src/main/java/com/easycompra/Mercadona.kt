package com.easycompra

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.File

/**
 * Mercadona con los precios y productos de la ciudad elegida.
 *
 * Mercadona sirve cada zona desde un almacen ("mad3", "bcn1", "4480"...) que
 * depende del codigo postal, y precios y surtido cambian de uno a otro. Su web
 * lo resuelve asi: le dice el codigo postal a la API, que contesta con el
 * almacen, y despues pide cada categoria de ese almacen. Lo mismo hace la app.
 *
 * El listado trae nombre, precio, precio por kilo y foto. La marca, los
 * ingredientes y la nutricion salen de los datos publicados en GitHub (de su
 * ficha), que se cruzan por el id del producto.
 *
 * Delante esta Akamai Bot Manager: con prisa (de 6 en 6) corta con 403 unos
 * minutos. Se pide de una en una y con pausa, como hace el sync de GitHub sin
 * problemas: ~45 s, una vez cada 12 horas y sin que la app espere por ello.
 */
object Mercadona {

    private const val VIGENCIA_MS = 12 * 60 * 60 * 1000L
    private const val PAUSA_MS = 200L

    // Secciones que no son comida: bodega, cosmetica, parafarmacia, bebe y limpieza.
    private val SIN_COMIDA = setOf(19, 20, 21, 22, 23, 24, 26)

    interface Api {
        @PUT("api/postal-codes/actions/change-pc/")
        suspend fun cambiarCp(@Body cuerpo: CambioCp): Response<ResponseBody>

        @GET("api/categories/")
        suspend fun arbol(@Query("wh") almacen: String, @Query("lang") lang: String = "es"): Arbol

        @GET("api/categories/{id}/")
        suspend fun categoria(
            @Path("id") id: Int,
            @Query("wh") almacen: String,
            @Query("lang") lang: String = "es",
        ): Categoria
    }

    @Serializable
    class CambioCp(val new_postal_code: String)

    @Serializable
    class Arbol(val results: List<Seccion> = emptyList())

    @Serializable
    class Seccion(val id: Int = 0, val categories: List<Sub> = emptyList())

    @Serializable
    class Sub(val id: Int = 0)

    @Serializable
    class Categoria(val categories: List<Bloque> = emptyList())

    @Serializable
    class Bloque(val products: List<Resumen> = emptyList())

    @Serializable
    class Resumen(
        val id: String = "",
        val display_name: String = "",
        val thumbnail: String? = null,
        val share_url: String? = null,
        val price_instructions: Precios = Precios(),
    )

    @Serializable
    class Precios(
        val unit_price: String? = null,
        val reference_price: String? = null,
        val reference_format: String? = null,
    )

    /** Producto del listado, completado con su ficha si se tiene. */
    fun convertir(r: Resumen, ficha: Product?): Product = Product(
        supermarket = "Mercadona",
        external_id = r.id,
        name = r.display_name.ifBlank { ficha?.name.orEmpty() },
        brand = ficha?.brand,
        photo_url = ficha?.photo_url ?: r.thumbnail,
        unit_price = r.price_instructions.unit_price?.toDoubleOrNull(),
        reference_price = r.price_instructions.reference_price?.toDoubleOrNull(),
        reference_format = r.price_instructions.reference_format,
        ean = ficha?.ean,
        ingredients = ficha?.ingredients,
        allergens = ficha?.allergens,
        contains_nata = ficha?.contains_nata ?: false,
        energy_kcal_100g = ficha?.energy_kcal_100g,
        fat_100g = ficha?.fat_100g,
        saturated_fat_100g = ficha?.saturated_fat_100g,
        carbohydrates_100g = ficha?.carbohydrates_100g,
        sugars_100g = ficha?.sugars_100g,
        proteins_100g = ficha?.proteins_100g,
        salt_100g = ficha?.salt_100g,
        share_url = r.share_url ?: ficha?.share_url,
    )

    private fun fichero(dir: File, cp: String) = File(dir, "mercadona_$cp.json")

    private fun leer(dir: File, cp: String): List<Product>? = runCatching {
        ApiFactory.json.decodeFromString<List<Product>>(fichero(dir, cp).readText())
    }.getOrNull()?.takeIf { it.isNotEmpty() }

    /** La copia guardada de [cp] si es de hace menos de 12 horas; si no, null. */
    suspend fun reciente(dir: File, cp: String): List<Product>? = withContext(Dispatchers.IO) {
        val f = fichero(dir, cp)
        if (System.currentTimeMillis() - f.lastModified() < VIGENCIA_MS) leer(dir, cp) else null
    }

    /**
     * Descarga el catalogo de Mercadona para [cp]. [fichas]: los productos
     * publicados en GitHub, por id, para la marca y la nutricion. Si falla, la
     * ultima copia guardada de esa ciudad; si no hay, null (y quien llama se
     * queda con los datos generales de GitHub).
     */
    suspend fun descargar(dir: File, cp: String, fichas: Map<String, Product>): List<Product>? =
        withContext(Dispatchers.IO) {
            val fichero = fichero(dir, cp)
            val guardados = leer(dir, cp)
            runCatching { pedir(cp, fichas) }
                .onSuccess { nuevos ->
                    if (nuevos.isNotEmpty()) {
                        runCatching { fichero.writeText(ApiFactory.json.encodeToString(nuevos)) }
                    }
                }
                .getOrNull()
                ?.takeIf { it.isNotEmpty() }
                ?: guardados
        }

    private suspend fun pedir(cp: String, fichas: Map<String, Product>): List<Product> = coroutineScope {
        val api = ApiFactory.mercadona()
        val almacen = api.cambiarCp(CambioCp(cp)).headers()["x-customer-wh"]
            ?: error("Mercadona no ha dado almacen para $cp")

        val subcategorias = api.arbol(almacen).results
            .filter { it.id !in SIN_COMIDA }
            .flatMap { s -> s.categories.map { it.id } }

        // ~140 categorias de una en una. Si una falla con 403, Akamai ha
        // cortado: no tiene sentido seguir (se queda con lo general).
        val categorias = mutableListOf<Categoria>()
        for (id in subcategorias) {
            delay(PAUSA_MS)
            val c = runCatching { api.categoria(id, almacen) }
            val error = c.exceptionOrNull()
            if (error is retrofit2.HttpException && error.code() == 403) throw error
            c.getOrNull()?.let { categorias += it }
        }
        categorias
            .flatMap { c -> c.categories.flatMap { it.products } }
            .distinctBy { it.id }
            .map { convertir(it, fichas[it.id]) }
    }
}
