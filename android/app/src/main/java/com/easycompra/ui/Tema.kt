package com.easycompra.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Colores de la app v5 ("la verde"), sacados tal cual de su codigo
 * descompilado (referencia/v5-descompilada/ui/theme).
 */
object Colores {
    val Verde = Color(0xFF00897B)
    val VerdeClaro = Color(0xFFB2DFDB)
    val VerdeSecundario = Color(0xFF26A69A)
    val Fondo = Color(0xFFF5F5F5)

    val NutriA = Color(0xFF038141)
    val NutriB = Color(0xFF85BB2F)
    val NutriC = Color(0xFFFECC02)
    val NutriD = Color(0xFFEF8200)
    val NutriE = Color(0xFFE63E11)
    val NutriDesconocido = Color(0xFF9E9E9E)

    val Mercadona = Color(0xFF00AEE0)
    val Dia = Color(0xFFE31837)
    val Carrefour = Color(0xFF004A97)
    val Lidl = Color(0xFFFFCC01)

    val StockBien = Color(0xFF10B981)
    val StockPoco = Color(0xFFF59E0B)
    val StockNada = Color(0xFFEF4444)
}

private val Esquema = lightColorScheme(
    primary = Colores.Verde,
    onPrimary = Color.White,
    primaryContainer = Colores.VerdeClaro,
    secondary = Colores.VerdeSecundario,
    background = Colores.Fondo,
    surface = Color.White,
)

@Composable
fun TemaEasyCompra(contenido: @Composable () -> Unit) {
    MaterialTheme(colorScheme = Esquema, content = contenido)
}

fun colorSupermercado(nombre: String): Color = when (nombre.lowercase()) {
    "mercadona" -> Colores.Mercadona
    "dia" -> Colores.Dia
    "carrefour" -> Colores.Carrefour
    "lidl" -> Colores.Lidl
    else -> Colores.NutriDesconocido
}

fun colorNutri(nota: Char?): Color = when (nota) {
    'A' -> Colores.NutriA
    'B' -> Colores.NutriB
    'C' -> Colores.NutriC
    'D' -> Colores.NutriD
    'E' -> Colores.NutriE
    else -> Colores.NutriDesconocido
}

/** Texto oscuro sobre los fondos claros (Lidl, Nutri C), blanco en el resto. */
private fun textoSobre(fondo: Color): Color =
    if (fondo == Colores.Lidl || fondo == Colores.NutriC) Color(0xFF1F1F1F) else Color.White

/** Etiqueta de color: "Mercadona", "Nutri D"... */
@Composable
fun Etiqueta(texto: String, fondo: Color, modifier: Modifier = Modifier, grande: Boolean = false) {
    Box(
        modifier
            .background(fondo, RoundedCornerShape(6.dp))
            .padding(horizontal = if (grande) 10.dp else 8.dp, vertical = if (grande) 5.dp else 3.dp)
    ) {
        Text(
            texto,
            color = textoSobre(fondo),
            fontSize = if (grande) 14.sp else 12.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
        )
    }
}

@Composable
fun EtiquetaSupermercado(nombre: String, grande: Boolean = false) =
    Etiqueta(nombre.replaceFirstChar { it.uppercase() }, colorSupermercado(nombre), grande = grande)

@Composable
fun EtiquetaNutri(nota: Char?, grande: Boolean = false) =
    Etiqueta("Nutri ${nota ?: '?'}", colorNutri(nota), grande = grande)

/** Barra superior verde de todas las secciones, como en la v5. */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraVerde(
    titulo: String,
    subtitulo: String? = null,
    navegacion: @Composable () -> Unit = {},
    acciones: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        title = {
            Column {
                Text(
                    titulo,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                if (subtitulo != null) {
                    Text(subtitulo, fontSize = 13.sp, color = Color.White.copy(alpha = 0.85f))
                }
            }
        },
        navigationIcon = navegacion,
        actions = acciones,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Colores.Verde,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
    )
}
