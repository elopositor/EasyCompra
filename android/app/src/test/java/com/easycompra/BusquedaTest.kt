package com.easycompra

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BusquedaTest {

    private val catalogo = Busqueda.indexar(
        listOf(
            Product(supermarket = "Mercadona", external_id = "1", name = "Yogur griego natural", brand = "Hacendado", unit_price = 1.5),
            Product(supermarket = "Dia", external_id = "2", name = "Leche semidesnatada", unit_price = 0.9),
            Product(supermarket = "Lidl", external_id = "3", name = "Leche entera", unit_price = 1.1),
            Product(supermarket = "Carrefour", external_id = "4", name = "Lechuga iceberg", unit_price = 0.8),
            Product(supermarket = "Mercadona", external_id = "5", name = "Pechuga de pollo", unit_price = 5.0),
            Product(supermarket = "Mercadona", external_id = "6", name = "Repollo", unit_price = 1.0),
            Product(supermarket = "Carrefour", external_id = "7", name = "Atún claro en aceite", unit_price = 3.0),
            Product(supermarket = "Dia", external_id = "8", name = "Piña en almíbar", unit_price = 2.0),
            Product(supermarket = "Lidl", external_id = "9", name = "Huevos camperos", unit_price = 2.5),
        )
    )
    private val porPrecio = compareBy<Product> { it.unit_price }

    private fun nombres(consulta: String) =
        Busqueda.buscar(catalogo, consulta, porPrecio).productos.map { it.name }

    @Test fun sinAcentosNiMayusculas() {
        assertEquals(listOf("Atún claro en aceite"), nombres("ATUN"))
        assertEquals(listOf("Piña en almíbar"), nombres("pina"))
    }

    @Test fun pluralYSingular() {
        assertEquals(listOf("Yogur griego natural"), nombres("yogures"))
        assertEquals(listOf("Huevos camperos"), nombres("huevo"))
        assertEquals(listOf("Leche semidesnatada", "Leche entera"), nombres("leches"))
    }

    @Test fun variasPalabrasEnCualquierOrden() {
        assertEquals(listOf("Yogur griego natural"), nombres("griego yogur"))
        assertEquals(listOf("Leche entera"), nombres("entera leche"))
    }

    @Test fun marcaYSupermercado() {
        assertEquals(listOf("Yogur griego natural"), nombres("hacendado"))
        assertEquals(listOf("Leche entera", "Huevos camperos"), nombres("lidl"))
    }

    @Test fun trozoDePalabraVaDetras() {
        // "pollo" es palabra en la pechuga y solo un trozo en "repollo".
        assertEquals(listOf("Pechuga de pollo", "Repollo"), nombres("pollo"))
        assertEquals(listOf("Leche semidesnatada"), nombres("desnatada"))
    }

    @Test fun palabraExactaAntesQueLasQueEmpiezanIgual() {
        val c = Busqueda.indexar(
            listOf(
                Product(external_id = "a", name = "Salmon ahumado", unit_price = 1.0),
                Product(external_id = "b", name = "Sal marina", unit_price = 2.0),
            )
        )
        assertEquals(
            listOf("Sal marina", "Salmon ahumado"),
            Busqueda.buscar(c, "sal", porPrecio).productos.map { it.name },
        )
    }

    @Test fun faltasDeOrtografia() {
        val r = Busqueda.buscar(catalogo, "yougur", porPrecio)
        assertTrue(r.aproximado)
        assertEquals("Yogur griego natural", r.productos.first().name)
        assertEquals("Leche semidesnatada", Busqueda.buscar(catalogo, "lehce semi", porPrecio).productos.first().name)
        assertEquals("Atún claro en aceite", nombres("atn claro").first())
    }

    @Test fun losParecidosNoSeMezclanConLosBuenos() {
        // Hay leches de verdad: la lechuga no debe salir.
        val r = Busqueda.buscar(catalogo, "leche", porPrecio)
        assertFalse(r.aproximado)
        assertEquals(listOf("Leche semidesnatada", "Leche entera"), r.productos.map { it.name })
    }

    @Test fun palabrasCortasNoSeAproximan() {
        assertTrue(nombres("xq").isEmpty())
    }

    @Test fun vacioDevuelveTodoOrdenado() {
        assertEquals(catalogo.size, nombres("  ").size)
        assertEquals("Lechuga iceberg", nombres("").first())
    }

    @Test fun distancia() {
        assertEquals(1, Busqueda.distancia("lehce", "leche"))
        assertEquals(1, Busqueda.distancia("yogurt", "yogur"))
        assertEquals(2, Busqueda.distancia("abc", "abcde"))
    }
}
