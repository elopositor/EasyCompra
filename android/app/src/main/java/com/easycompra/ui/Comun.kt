package com.easycompra.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

/** Fila que se desplaza en horizontal, para las tiras de chips. */
@Composable
fun Modifier.horizontalScrollable(): Modifier = this.horizontalScroll(rememberScrollState())

@Composable
fun Vacio(mensaje: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(mensaje, color = Color.Gray, textAlign = TextAlign.Center)
    }
}

private val ES = Locale.forLanguageTag("es-ES")

/** "lunes 1" para las cabeceras del planificador. */
fun diaLargo(fecha: LocalDate): String {
    val dia = fecha.dayOfWeek.getDisplayName(TextStyle.FULL, ES)
    return "${dia.replaceFirstChar { it.uppercase(ES) }} ${fecha.dayOfMonth}"
}

fun mesCorto(fecha: LocalDate): String =
    fecha.month.getDisplayName(TextStyle.FULL, ES).replaceFirstChar { it.uppercase(ES) }
