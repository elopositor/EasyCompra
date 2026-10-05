package com.easycompra

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.io.File

/**
 * Si Alimerka llega a un codigo postal.
 *
 * Su catalogo sale de GitHub (es casi igual en toda su zona), pero solo esta
 * en el noroeste. Su tienda, al darle un codigo postal, contesta con la tienda
 * que le corresponde; fuera de su zona da siempre la misma tienda generica.
 * Para no depender de su numero, se pregunta tambien por un codigo postal
 * claramente fuera (Valencia) y se comparan.
 */
object Alimerka {

    private const val FUERA_DE_ZONA = "46001"

    interface Api {
        @Headers("X-Requested-With: XMLHttpRequest")
        @GET("on/demandware.store/Sites-Alimerka-Site/default/Stores-FindByZipcode")
        suspend fun tienda(@Query("zipCode") cp: String, @Query("consent") consent: Boolean = true): Tienda
    }

    @Serializable
    class Tienda(val success: Boolean = false, val storeId: String? = null)

    /** true/false, o null si no se ha podido saber (entonces se ensena). */
    suspend fun llegaA(dir: File, cp: String, forzar: Boolean): Boolean? = withContext(Dispatchers.IO) {
        val fichero = File(dir, "alimerka_$cp.txt")
        if (!forzar) {
            fichero.takeIf { it.exists() }?.readText()?.toBooleanStrictOrNull()?.let { return@withContext it }
        }
        runCatching {
            val api = ApiFactory.alimerka()
            val aqui = api.tienda(cp)
            val fuera = api.tienda(FUERA_DE_ZONA)
            aqui.success && aqui.storeId != null && aqui.storeId != fuera.storeId
        }.onSuccess { llega ->
            runCatching { fichero.writeText(llega.toString()) }
        }.getOrNull()
    }
}
