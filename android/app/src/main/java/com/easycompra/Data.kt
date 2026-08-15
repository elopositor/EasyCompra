package com.easycompra

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
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

interface EasyCompraApi {
    @GET("products")
    suspend fun products(@Query("supermarket") supermarket: String?): List<Product>
}

object ApiFactory {

    private val json = Json {
        ignoreUnknownKeys = true   // campos nuevos del backend: se ignoran
        coerceInputValues = true   // null en un campo no nulo: usa el defecto
        explicitNulls = false
    }

    fun create(baseUrl: String): EasyCompraApi {
        val client = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/")
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(EasyCompraApi::class.java)
    }
}
