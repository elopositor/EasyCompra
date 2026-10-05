package com.easycompra

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.Cache as CacheHttp
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Todos los campos son opcionales y con valor por defecto a proposito.
 * La version anterior de la app se cerraba cuando el backend dejaba de enviar
 * un campo que su modelo declaraba como obligatorio. Asi no puede volver a
 * pasar: si el servidor anade o quita campos, la app sigue funcionando.
 */
@Serializable
data class Product(
    val supermarket: String = "",
    val external_id: String = "",
    val name: String = "",
    val brand: String? = null,
    val photo_url: String? = null,
    val unit_price: Double? = null,
    val reference_price: Double? = null,
    val reference_format: String? = null,
    val ean: String? = null,
    val ingredients: String? = null,
    val allergens: String? = null,
    val contains_nata: Boolean = false,
    val energy_kcal_100g: Double? = null,
    val fat_100g: Double? = null,
    val saturated_fat_100g: Double? = null,
    val carbohydrates_100g: Double? = null,
    val sugars_100g: Double? = null,
    val proteins_100g: Double? = null,
    val salt_100g: Double? = null,
    val share_url: String? = null,
)

@Serializable
data class InfoSupermercado(
    val file: String = "",
    val count: Int = 0,
    /** false = esa fuente fallo en el ultimo sync y sus datos son mas viejos. */
    val fresh: Boolean = true,
)

/** Manifiesto del repositorio de datos: que hay publicado y de cuando es. */
@Serializable
data class Indice(
    val updated_at: String = "",
    val supermarkets: Map<String, InfoSupermercado> = emptyMap(),
    val total: Int = 0,
)

/** Lo que se guarda en disco para poder abrir la app sin conexion. */
@Serializable
data class Cache(
    val productos: List<Product> = emptyList(),
    val actualizado: String = "",
    val supermercado: String? = null,
)

/** Resultado de una carga, sepa la UI de donde salio. */
data class Datos(
    val productos: List<Product>,
    val actualizado: String? = null,
    val deCache: Boolean = false,
    /** Algo que contar al usuario sin que sea un error (p. ej. precios generales). */
    val aviso: String? = null,
    /** false = Mercadona va con los precios generales y falta pedir los de la ciudad. */
    val mercadonaDeLaCiudad: Boolean = true,
)

/** API del backend propio (FastAPI), opcional. */
interface EasyCompraApi {
    @GET("products")
    suspend fun products(@Query("supermarket") supermarket: String?): List<Product>
}

/** Ficheros publicados en GitHub, que es el origen por defecto. */
interface DatosPublicosApi {
    @GET
    suspend fun productos(@Url url: String): List<Product>

    @GET
    suspend fun indice(@Url url: String): Indice
}

object ApiFactory {

    /** Repositorio publico de datos: no necesita servidor ni PC encendido. */
    const val BASE_DATOS =
        "https://raw.githubusercontent.com/elopositor/EasyCompra-datos/main/"

    /** Lo publicado en GitHub. Froiz no esta: se baja desde el movil (Froiz.kt). */
    val FICHEROS = listOf("alimerka", "carrefour", "dia", "lidl", "mercadona")

    val json = Json {
        ignoreUnknownKeys = true   // campos nuevos en el origen: se ignoran
        coerceInputValues = true   // null en un campo no nulo: usa el defecto
        explicitNulls = false
        // Cinturon de seguridad: si una fuente vuelve a mandar un numero entre
        // comillas ("1.05"), se acepta en vez de tumbar la carga entera.
        isLenient = true
    }

    /**
     * Con seis supermercados el catalogo son varios megas. Con cache HTTP, si
     * los datos no han cambiado desde la ultima vez (se publican una vez al
     * dia) GitHub contesta "sin cambios" y no se vuelven a bajar.
     */
    private var cache: CacheHttp? = null

    fun usarCache(dir: File) {
        if (cache == null) cache = CacheHttp(File(dir, "http"), 40L * 1024 * 1024)
    }

    private val client by lazy {
        OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    private fun retrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/")
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    fun servidor(baseUrl: String): EasyCompraApi =
        retrofit(baseUrl).create(EasyCompraApi::class.java)

    fun publica(): DatosPublicosApi =
        retrofit(BASE_DATOS).create(DatosPublicosApi::class.java)

    fun froiz(): Froiz.Api =
        retrofit("https://servicios.froiz.com/").create(Froiz.Api::class.java)

    fun mercadona(): Mercadona.Api =
        retrofit("https://tienda.mercadona.es/").create(Mercadona.Api::class.java)

    fun alimerka(): Alimerka.Api =
        retrofit("https://www.alimerkaonline.es/").create(Alimerka.Api::class.java)
}

/**
 * Decide de donde vienen los productos y guarda una copia en disco.
 *
 * Por defecto se leen los JSON publicados en GitHub: no hace falta arrancar
 * nada en el PC ni abrir ningun puerto. El backend propio sigue estando
 * disponible como origen alternativo desde Ajustes.
 */
class Repositorio(private val dirCache: File) {

    init {
        ApiFactory.usarCache(dirCache)
    }

    private val ficheroCache = File(dirCache, "productos.json")

    /** Siempre el catalogo completo: el filtro por supermercado se hace en el movil. */
    suspend fun cargar(origen: Origen, servidor: String, ciudad: Ciudad, forzar: Boolean = false): Datos {
        val datos = when (origen) {
            Origen.GITHUB -> desdeGitHub(ciudad, forzar)
            Origen.SERVIDOR -> desdeServidor(servidor)
        }
        guardarCache(datos)
        return datos
    }

    /**
     * Carrefour, Lidl y Dia: los de GitHub (su tienda online tiene precio
     * nacional). Mercadona: el de la ciudad, desde el movil, con la ficha de
     * GitHub. Alimerka: el de GitHub, solo si llega a la ciudad. Froiz: el de
     * la tienda de la ciudad, desde el movil.
     */
    private suspend fun desdeGitHub(ciudad: Ciudad, forzar: Boolean): Datos = coroutineScope {
        val api = ApiFactory.publica()
        // Lo que depende de la ciudad va a la vez que las descargas de GitHub.
        val froiz = async { runCatching { Froiz.productos(dirCache, ciudad.cp, forzar) }.getOrDefault(emptyList()) }
        val alimerkaLlega = async { runCatching { Alimerka.llegaA(dirCache, ciudad.cp, forzar) }.getOrNull() }

        // El indice dice que ficheros hay y de cuando son. Si no se puede leer,
        // se tira de la lista conocida: es preferible a no mostrar nada.
        // Un fallo puntual de red no debe dejar la app sin fecha: un reintento.
        val indice = runCatching { api.indice(ApiFactory.BASE_DATOS + "index.json") }
            .recoverCatching { api.indice(ApiFactory.BASE_DATOS + "index.json") }
            .getOrNull()

        val nombres = indice?.supermarkets?.keys?.toList()?.takeIf { it.isNotEmpty() }
            ?: ApiFactory.FICHEROS

        // Los ficheros se bajan a la vez, no uno detras de otro. Si uno falla,
        // se muestran los demas.
        val descargas = nombres.associateWith { nombre ->
            async(Dispatchers.IO) {
                runCatching { api.productos("${ApiFactory.BASE_DATOS}$nombre.json") }
                    .getOrDefault(emptyList())
            }
        }
        val porFichero = descargas.mapValues { it.value.await() }

        val generalMercadona = porFichero["mercadona"].orEmpty()
        fichasMercadona = generalMercadona.associateBy { it.external_id }
        // Lo de la ciudad, si hay copia reciente; si no, se pide despues
        // (mercadonaDeLaCiudad) sin hacer esperar a la app.
        val localMercadona = if (forzar) null else Mercadona.reciente(dirCache, ciudad.cp)
        // null = no se sabe: mejor ensenarlo que esconderlo por un fallo de red.
        val conAlimerka = alimerkaLlega.await() != false

        val productos = porFichero.filterKeys { it != "mercadona" && it != "alimerka" }.values.flatten() +
            (localMercadona ?: generalMercadona) +
            (if (conAlimerka) porFichero["alimerka"].orEmpty() else emptyList()) +
            froiz.await()

        if (productos.isEmpty()) {
            // Sin datos y sin excepcion: mejor fallar que ensenar una lista vacia
            // como si el catalogo estuviera realmente vacio.
            throw IllegalStateException("No se ha podido descargar ningun producto.")
        }
        Datos(
            productos = productos,
            actualizado = indice?.updated_at,
            mercadonaDeLaCiudad = localMercadona != null,
        )
    }

    /** Fichas de Mercadona de GitHub, para completar las de la ciudad. */
    private var fichasMercadona: Map<String, Product> = emptyMap()

    /** Mercadona con los precios y productos de la ciudad. Null si no se ha podido. */
    suspend fun mercadonaDeLaCiudad(ciudad: Ciudad): List<Product>? =
        runCatching { Mercadona.descargar(dirCache, ciudad.cp, fichasMercadona) }.getOrNull()

    private suspend fun desdeServidor(url: String): Datos =
        withContext(Dispatchers.IO) {
            Datos(productos = ApiFactory.servidor(url).products(null))
        }

    /** En disco y fuera del hilo de la interfaz: son un par de megas de JSON. */
    private suspend fun guardarCache(datos: Datos) = withContext(Dispatchers.IO) {
        runCatching {
            dirCache.mkdirs()
            val cache = Cache(productos = datos.productos, actualizado = datos.actualizado ?: "")
            ficheroCache.writeText(ApiFactory.json.encodeToString(cache))
        }
    }

    /** Ultima descarga correcta, para cuando no hay red. */
    suspend fun leerCache(): Datos? = withContext(Dispatchers.IO) {
        runCatching {
            if (!ficheroCache.exists()) return@runCatching null
            val cache = ApiFactory.json.decodeFromString<Cache>(ficheroCache.readText())
            // Las versiones anteriores podian guardar un solo supermercado: se
            // aprovecha igual, mejor eso que nada.
            Datos(
                productos = cache.productos,
                actualizado = cache.actualizado.ifBlank { null },
                deCache = true,
            ).takeIf { it.productos.isNotEmpty() }
        }.getOrNull()
    }
}

enum class Origen { GITHUB, SERVIDOR }
