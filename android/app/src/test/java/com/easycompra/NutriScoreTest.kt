package com.easycompra

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class NutriScoreTest {

    private fun producto(kcal: Double?, azucares: Double?, saturadas: Double?, sal: Double?, proteinas: Double? = null) =
        Product(
            name = "x",
            energy_kcal_100g = kcal,
            sugars_100g = azucares,
            saturated_fat_100g = saturadas,
            salt_100g = sal,
            proteins_100g = proteinas,
        )

    @Test fun patatasPajaComoEnLaV5() {
        // Patatas fritas paja Hacendado: la v5 las marcaba "Nutri D".
        assertEquals('D', NutriScore.nota(producto(545.0, 0.0, 2.9, 1.1, 6.9)))
    }

    @Test fun lecheDesnatadaSaleBien() {
        assertEquals('A', NutriScore.nota(producto(35.0, 4.7, 0.1, 0.13, 3.4)))
    }

    @Test fun chocolateSaleMal() {
        assertEquals('E', NutriScore.nota(producto(545.0, 50.0, 18.0, 0.2, 7.0)))
    }

    @Test fun sinDatosNoHayNota() {
        assertNull(NutriScore.nota(producto(100.0, null, 1.0, 0.5)))
    }
}
