package com.easycompra

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class FroizTest {

    private fun articulo(json: String) = ApiFactory.json.decodeFromString<Froiz.Articulo>(json)

    @Test fun precioDeOfertaYPrecioPorKilo() {
        // Tal cual llega de la API: order_price como numero, el resto como texto.
        val p = Froiz.convertir(articulo("""
            {"id": 7899, "name": "Queso García Baquero Ya Cortado curado 225 g", "brand_name": "García Baquero",
             "enabled": true, "category_id": 2, "section_slug": "quesos-envasados",
             "order_price": 2.99, "base_price": "5.20", "measurement_unit": "Kilogramo",
             "measurement_unit_ratio": "0.225", "image_id": "abc", "slug": "7899-queso"}
        """))!!
        assertEquals(2.99, p.unit_price!!, 0.001)
        assertEquals(13.29, p.reference_price!!, 0.001)
        assertEquals("kg", p.reference_format)
        assertEquals("Froiz", p.supermarket)
        assertEquals("https://imagedelivery.net/laxGYDNZyT04iZVpzPzryw/abc/desktop", p.photo_url)
    }

    @Test fun sinOfertaUsaElPrecioBase() {
        val p = Froiz.convertir(articulo("""
            {"id": 1, "name": "Lechuga iceberg", "category_id": 3, "base_price": "0.99",
             "measurement_unit": "Unidad", "measurement_unit_ratio": "1"}
        """))!!
        assertEquals(0.99, p.unit_price!!, 0.001)
        assertEquals("ud", p.reference_format)
    }

    @Test fun fueraDrogueriaYAlcohol() {
        assertNull(Froiz.convertir(articulo("""{"id": 2, "name": "Detergente", "category_id": 7, "base_price": "4.99"}""")))
        assertNull(Froiz.convertir(articulo("""{"id": 3, "name": "Vino tinto", "category_id": 6, "section_slug": "vinos", "base_price": "4.99"}""")))
        Froiz.convertir(articulo("""{"id": 4, "name": "Agua", "category_id": 6, "section_slug": "aguas-refrescos-y-zumos", "base_price": "0.30"}"""))!!
    }
}
