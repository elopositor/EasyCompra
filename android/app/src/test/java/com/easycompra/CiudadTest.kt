package com.easycompra

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class CiudadTest {

    @Test fun codigosPostales() {
        assertTrue(Ciudades.cpValido("33001"))
        assertTrue(Ciudades.cpValido("15001"))
        assertFalse(Ciudades.cpValido("3300"))
        assertFalse(Ciudades.cpValido("99001"))   // no hay provincia 99
        assertFalse(Ciudades.cpValido("00123"))
    }

    @Test fun froizSoloConTiendaEnLaProvincia() {
        // A Coruña -> Oleiros: vale.
        assertEquals("1_123", Froiz.codigoTienda(Froiz.Tienda(1, 123, "15172"), "15001"))
        // Oviedo -> le asigna una de Toledo: no hay Froiz cerca.
        assertNull(Froiz.codigoTienda(Froiz.Tienda(1, 118, "45280"), "33001"))
    }

    @Test fun mercadonaPrecioDelListadoYFichaDeGitHub() {
        val resumen = ApiFactory.json.decodeFromString<Mercadona.Resumen>("""
            {"id": "68130", "display_name": "Lechuga Iceberg", "thumbnail": "https://img/l.jpg",
             "share_url": "https://tienda.mercadona.es/product/68130",
             "price_instructions": {"unit_price": "1.05", "reference_price": "1.050", "reference_format": "ud"}}
        """)
        val ficha = Product(supermarket = "Mercadona", external_id = "68130", name = "Lechuga Iceberg",
            brand = "Hacendado", unit_price = 0.99, energy_kcal_100g = 14.0)
        val p = Mercadona.convertir(resumen, ficha)
        assertEquals(1.05, p.unit_price!!, 0.001)       // el precio es el de la ciudad
        assertEquals("Hacendado", p.brand)              // la marca, de la ficha
        assertEquals(14.0, p.energy_kcal_100g!!, 0.001)
        assertEquals("ud", p.reference_format)
        // Sin ficha tambien sale, sin marca ni nutricion.
        assertNull(Mercadona.convertir(resumen, null).brand)
    }
}
