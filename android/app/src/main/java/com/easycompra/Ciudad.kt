package com.easycompra

import kotlinx.serialization.Serializable

/** Donde se compra: decide precios y productos de Mercadona, Froiz y Alimerka. */
@Serializable
data class Ciudad(val cp: String, val nombre: String) {
    val etiqueta: String get() = if (nombre.isBlank()) "CP $cp" else nombre
}

object Ciudades {

    val SUGERIDAS = listOf(
        Ciudad("33001", "Oviedo"),
        Ciudad("33201", "Gijón"),
        Ciudad("15001", "A Coruña"),
        Ciudad("24001", "León"),
    )

    /** Cinco cifras y una provincia que exista (01 a 52). */
    fun cpValido(cp: String): Boolean =
        cp.length == 5 && cp.all { it.isDigit() } && cp.take(2).toInt() in 1..52
}
