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

    val FICHEROS = listOf("carrefour", "dia", "lidl", "mercadona")

    val json = Json {
        ignoreUnknownKeys = true   // campos nuevos en el origen: se ignoran
        coerceInputValues = true   // null en un campo no nulo: usa el defecto
        explicitNulls = false
        // Cinturon de seguridad: si una fuente vuelve a mandar un numero entre
        // comillas ("1.05"), se acepta en vez de tumbar la carga entera.
        isLenient = true
    }

    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    private fun retrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/")
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    fun servidor(baseUrl: String): EasyCompraApi =
        retrofit(baseUrl).create(EasyCompraApi::class.java)

    fun publica(): DatosPublicosApi =
        retrofit(BASE_DATOS).create(DatosPublicosApi::class.java)
}

/**
 * Decide de donde vienen los productos y guarda una copia en disco.
 *
 * Por defecto se leen los JSON publicados en GitHub: no hace falta arrancar
 * nada en el PC ni abrir ningun puerto. El backend propio sigue estando
 * disponible como origen alternativo desde Ajustes.
 */
class Repositorio(private val dirCache: File) {

    private val ficheroCache = File(dirCache, "productos.json")

    suspend fun cargar(origen: Origen, servidor: String, supermercado: String?): Datos {
        val datos = when (origen) {
            Origen.GITHUB -> desdeGitHub(supermercado)
            Origen.SERVIDOR -> desdeServidor(servidor, supermercado)
        }
        guardarCache(datos, supermercado)
        return datos
    }

    private suspend fun desdeGitHub(supermercado: String?): Datos = coroutineScope {
        val api = ApiFactory.publica()

        // El indice dice que ficheros hay y de cuando son. Si no se puede leer,
        // se tira de la lista conocida: es preferible a no mostrar nada.
        val indice = runCatching { api.indice(ApiFactory.BASE_DATOS + "index.json") }.getOrNull()

        val nombres = when {
            supermercado != null -> listOf(supermercado.lowercase())
            indice != null && indice.supermarkets.isNotEmpty() -> indice.supermarkets.keys.toList()
            else -> ApiFactory.FICHEROS
        }

        // Los ficheros se bajan a la vez, no uno detras de otro.
        val descargas = nombres.map { nombre ->
            async(Dispatchers.IO) {
                runCatching { api.productos("${ApiFactory.BASE_DATOS}$nombre.json") }
                    .getOrDefault(emptyList())
            }
        }
        val productos = descargas.awaitAll().flatten()

        if (productos.isEmpty()) {
            // Sin datos y sin excepcion: mejor fallar que ensenar una lista vacia
            // como si el catalogo estuviera realmente vacio.
            throw IllegalStateException("No se ha podido descargar ningun producto.")
        }
        Datos(productos = productos, actualizado = indice?.updated_at)
    }

    private suspend fun desdeServidor(url: String, supermercado: String?): Datos =
        withContext(Dispatchers.IO) {
            Datos(productos = ApiFactory.servidor(url).products(supermercado))
        }

    private fun guardarCache(datos: Datos, supermercado: String?) {
        runCatching {
            dirCache.mkdirs()
            val cache = Cache(
                productos = datos.productos,
                actualizado = datos.actualizado ?: "",
                supermercado = supermercado,
            )
            ficheroCache.writeText(ApiFactory.json.encodeToString(cache))
        }
    }

    /** Ultima descarga correcta, para cuando no hay red. */
    fun leerCache(supermercado: String?): Datos? = runCatching {
        if (!ficheroCache.exists()) return null
        val cache = ApiFactory.json.decodeFromString<Cache>(ficheroCache.readText())
        if (cache.productos.isEmpty()) return null
        // La copia guardada corresponde a otra seleccion de supermercado: solo
        // sirve si guardamos el catalogo completo, del que se puede filtrar.
        if (cache.supermercado != supermercado && cache.supermercado != null) return null
        Datos(
            productos = if (supermercado == null) cache.productos
            else cache.productos.filter { it.supermarket.equals(supermercado, true) },
            actualizado = cache.actualizado.ifBlank { null },
            deCache = true,
        )
    }.getOrNull()
}

enum class Origen { GITHUB, SERVIDOR }
