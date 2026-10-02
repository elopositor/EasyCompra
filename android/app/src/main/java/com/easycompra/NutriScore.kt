package com.easycompra

/**
 * Nutri-Score calculado con la formula oficial de 2023 para alimentos
 * generales, a partir de lo que publican los supermercados por 100 g.
 *
 * No se conocen la fibra ni el porcentaje de fruta y verdura, asi que cuentan
 * como cero: la nota puede salir algo peor que la oficial en productos con
 * mucha fibra o fruta. Sin energia, azucares, grasas saturadas o sal no se
 * calcula ("Nutri ?").
 */
object NutriScore {

    private val ENERGIA_KJ = doubleArrayOf(335.0, 670.0, 1005.0, 1340.0, 1675.0, 2010.0, 2345.0, 2680.0, 3015.0, 3350.0)
    private val AZUCARES = doubleArrayOf(3.4, 6.8, 10.0, 14.0, 17.0, 20.0, 24.0, 27.0, 31.0, 34.0, 37.0, 41.0, 44.0, 48.0, 51.0)
    private val SATURADAS = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0)
    private val SAL = DoubleArray(20) { (it + 1) * 0.2 }
    private val PROTEINAS = doubleArrayOf(2.4, 4.8, 7.2, 9.6, 12.0, 14.0, 17.0)

    /** 'A'..'E', o null si faltan datos. */
    fun nota(p: Product): Char? {
        val kcal = p.energy_kcal_100g ?: return null
        val azucares = p.sugars_100g ?: return null
        val saturadas = p.saturated_fat_100g ?: return null
        val sal = p.salt_100g ?: return null

        val negativos = puntos(kcal * 4.184, ENERGIA_KJ) + puntos(azucares, AZUCARES) +
            puntos(saturadas, SATURADAS) + puntos(sal, SAL)
        // Con 11 o mas puntos negativos las proteinas no compensan (regla 2023).
        val positivos = if (negativos >= 11) 0 else puntos(p.proteins_100g ?: 0.0, PROTEINAS)

        val total = negativos - positivos
        return when {
            total <= 0 -> 'A'
            total <= 2 -> 'B'
            total <= 10 -> 'C'
            total <= 18 -> 'D'
            else -> 'E'
        }
    }

    /** Cuantos umbrales supera el valor. */
    private fun puntos(valor: Double, umbrales: DoubleArray): Int = umbrales.count { valor > it }
}
