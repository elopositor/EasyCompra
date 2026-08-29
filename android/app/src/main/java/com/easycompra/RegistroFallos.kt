package com.easycompra

import android.content.Context
import android.os.Build
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Guarda en disco el error que cierra la app para poder verlo al volver a
 * abrirla. Sin esto, un cierre en un movil ajeno no deja ni rastro: no hay
 * Play Console detras (la APK se instala a mano) y sin cable USB no se puede
 * mirar el logcat.
 *
 * Recoge tambien memoria y modelo, porque el cierre que estamos persiguiendo
 * solo ocurre en un movil concreto y no en otros.
 *
 * Lo que NO queda registrado aqui es un ANR (la app se bloquea y el sistema la
 * mata) ni un cierre por falta de memoria del sistema: en esos casos no hay
 * excepcion. Que tras un cierre no haya informe es, en si mismo, un dato.
 */
object RegistroFallos {

    private const val FICHERO = "ultimo_fallo.txt"

    fun instalar(context: Context) {
        val app = context.applicationContext
        val anterior = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { hilo, error ->
            runCatching { guardar(app, hilo, error) }
            // Se deja pasar al handler del sistema: la app debe cerrarse igual.
            anterior?.uncaughtException(hilo, error)
        }
    }

    private fun guardar(context: Context, hilo: Thread, error: Throwable) {
        val runtime = Runtime.getRuntime()
        val mb = 1024L * 1024L
        val informe = buildString {
            appendLine("EasyCompra $VERSION_APP")
            appendLine(SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date()))
            appendLine(
                "Movil: ${Build.MANUFACTURER} ${Build.MODEL} " +
                    "(Android ${Build.VERSION.RELEASE}, API ${Build.VERSION.SDK_INT})"
            )
            appendLine(
                "Memoria: ${(runtime.totalMemory() - runtime.freeMemory()) / mb} MB usados " +
                    "de ${runtime.maxMemory() / mb} MB disponibles"
            )
            appendLine("Hilo: ${hilo.name}")
            appendLine()
            appendLine(error.stackTraceToString())
        }
        File(context.filesDir, FICHERO).writeText(informe)
    }

    fun leer(context: Context): String? =
        File(context.filesDir, FICHERO)
            .takeIf { it.exists() }
            ?.let { runCatching { it.readText() }.getOrNull() }
            ?.takeIf { it.isNotBlank() }

    fun borrar(context: Context) {
        runCatching { File(context.filesDir, FICHERO).delete() }
    }
}
