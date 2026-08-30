package com.easycompra.datos

import java.util.Locale

/**
 * Las listas de categorias, unidades y comidas de la app v5, tal cual estaban.
 * Se conservan literalmente para que los datos escritos por aquella version
 * sigan encajando (las columnas guardan el texto, no un codigo).
 */
object Vocabulario {

    /** Ubicaciones de la despensa y sus subcategorias. */
    val DESPENSA: Map<String, List<String>> = mapOf(
        "Nevera" to listOf(
            "Lácteos", "Carnes", "Pescados y Mariscos", "Verduras y Frutas",
            "Quesos y Embutidos", "Huevos", "Platos preparados", "Otros",
        ),
        "Congelador" to listOf(
            "Carnes", "Pescados", "Verduras y Frutas", "Precocinados", "Helados", "Otros",
        ),
        "Despensa" to listOf(
            "Harinas y Cereales", "Pasta y Arroces", "Legumbres", "Conservas",
            "Salsas y Condimentos", "Especias", "Aceites y Vinagres", "Frutos secos",
            "Dulces y Snacks", "Pan y Bollería", "Otros",
        ),
        "Bebidas" to listOf(
            "Agua", "Zumos", "Refrescos", "Bebidas alcohólicas", "Infusiones y Café", "Otros",
        ),
        "Otros" to listOf(
            "Higiene personal", "Limpieza del hogar", "Mascotas", "Farmacia", "Varios",
        ),
    )

    val UNIDADES_DESPENSA = listOf(
        "unidad", "ración", "g", "kg", "ml", "l", "lata", "bote",
        "paquete", "caja", "bolsa", "botella", "docena", "taza", "cucharada",
    )

    val UNIDADES_RECETA = listOf(
        "unidad", "g", "kg", "ml", "l", "taza", "cucharada", "cucharadita",
        "lata", "bote", "paquete", "botella", "docena",
    )

    val CATEGORIAS_RECETA = listOf(
        "Desayunos", "Comidas rápidas", "Comidas elaboradas", "Cenas",
        "Postres", "Snacks", "Bebidas", "Otras",
    )

    const val DIFICULTAD_FACIL = "Fácil"
    const val DIFICULTAD_MEDIA = "Media"
    const val DIFICULTAD_DIFICIL = "Difícil"
    val DIFICULTADES = listOf(DIFICULTAD_FACIL, DIFICULTAD_MEDIA, DIFICULTAD_DIFICIL)

    val COMIDAS = listOf("Desayuno", "Comida", "Merienda", "Cena")

    fun iconoComida(comida: String): String = when (comida) {
        "Desayuno" -> "☀️"
        "Comida" -> "🍽️"
        "Merienda" -> "☕"
        else -> "🌙"
    }
}

/**
 * Convierte entre unidades del mismo tipo. Peso y volumen no se mezclan: no se
 * puede saber cuanto pesa un litro sin saber de que producto se trata.
 */
object Conversor {

    private val A_GRAMOS = mapOf("g" to 1f, "kg" to 1000f)

    private val A_MILILITROS = mapOf(
        "ml" to 1f,
        "l" to 1000f,
        "taza" to 240f,
        "cucharada" to 15f,
        "cucharadita" to 5f,
    )

    private fun grupo(unidad: String): String? {
        val u = unidad.lowercase(Locale.ROOT)
        return when {
            A_GRAMOS.containsKey(u) -> "peso"
            A_MILILITROS.containsKey(u) -> "volumen"
            else -> null
        }
    }

    /** null si las unidades no son convertibles entre si. */
    fun convertir(cantidad: Float, desde: String, hasta: String): Float? {
        val a = desde.lowercase(Locale.ROOT)
        val b = hasta.lowercase(Locale.ROOT)
        if (a == b) return cantidad

        A_GRAMOS[a]?.let { origen ->
            A_GRAMOS[b]?.let { destino -> return cantidad * origen / destino }
        }
        A_MILILITROS[a]?.let { origen ->
            A_MILILITROS[b]?.let { destino -> return cantidad * origen / destino }
        }
        return null
    }

    fun sePuedeConvertir(a: String, b: String): Boolean =
        a.lowercase(Locale.ROOT) == b.lowercase(Locale.ROOT) ||
            (grupo(a) != null && grupo(a) == grupo(b))

    /** 2.0 -> "2", 2.5 -> "2,5". */
    fun formato(cantidad: Float): String =
        if (cantidad == cantidad.toLong().toFloat()) cantidad.toLong().toString()
        else String.format(Locale.forLanguageTag("es-ES"), "%.1f", cantidad)
}
