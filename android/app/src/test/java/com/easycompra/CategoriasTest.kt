package com.easycompra

import org.junit.Assert.assertEquals
import org.junit.Test

class CategoriasTest {

    private fun cat(nombre: String) = Categorias.de(Product(name = nombre))

    @Test fun mandaLaPrimeraPalabra() {
        assertEquals("Lácteos", cat("Leche fermentada de proteínas sabor chocolate"))
        assertEquals("Dulces y snacks", cat("Galletas integrales con leche"))
        assertEquals("Lácteos", cat("Yogur griego con plátano"))
    }

    @Test fun pluralesYAcentos() {
        assertEquals("Huevos", cat("Huevos camperos L"))
        assertEquals("Fruta y verdura", cat("Plátanos de Canarias"))
        assertEquals("Pasta, arroz y cereales", cat("Macarrones rayados"))
    }

    @Test fun frases() {
        assertEquals("Dulces y snacks", cat("Patatas fritas paja Hacendado"))
        assertEquals("Frutos secos", cat("Cocktail frutos secos"))
        assertEquals("Lácteos", cat("Preparado lácteo crecimiento"))
    }

    @Test fun parecidosQueNoSonLoMismo() {
        assertEquals("Pescado", cat("Tartar de salmón ahumado"))
        assertEquals("Embutido", cat("Panceta curada"))
        assertEquals("Pescado", cat("Sardinillas en aceite de oliva"))
    }

    @Test fun mascotasSiempreAparte() {
        assertEquals("Mascotas", cat("Snack para gatos de salmón"))
        assertEquals("Mascotas", cat("Alimento para perros con pollo"))
    }

    @Test fun loDesconocidoVaAOtros() {
        assertEquals(Categorias.OTROS, cat("Bandeja de servicio"))
    }
}
