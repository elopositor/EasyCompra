package com.easycompra.datos

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Lista de la compra guardada en preferencias, como en la v5. No necesita
 * Room: son pocas lineas, cambian a menudo y se vacian cada semana.
 */
class ListaCompraStore(context: Context) {

    private val prefs = context.getSharedPreferences("lista_compra", Context.MODE_PRIVATE)
    private val json = Json { ignoreUnknownKeys = true }

    private val _articulos = MutableStateFlow(leer())
    val articulos: StateFlow<List<ArticuloLista>> = _articulos.asStateFlow()

    private fun leer(): List<ArticuloLista> = runCatching {
        val texto = prefs.getString("articulos", null) ?: return emptyList()
        json.decodeFromString<List<ArticuloLista>>(texto)
    }.getOrDefault(emptyList())

    private fun guardar(lista: List<ArticuloLista>) {
        _articulos.value = lista
        runCatching {
            prefs.edit().putString("articulos", json.encodeToString(lista)).apply()
        }
    }

    fun anadir(nombre: String, cantidad: String = "", origen: String = "manual") {
        val limpio = nombre.trim()
        if (limpio.isEmpty()) return
        // Si ya esta pendiente, no se duplica.
        if (_articulos.value.any { !it.comprado && it.nombre.equals(limpio, true) }) return
        guardar(_articulos.value + ArticuloLista(nombre = limpio, cantidad = cantidad, origen = origen))
    }

    fun anadirVarios(articulos: List<ArticuloLista>) {
        val actuales = _articulos.value
        val nuevos = articulos.filterNot { nuevo ->
            actuales.any { !it.comprado && it.nombre.equals(nuevo.nombre, true) }
        }
        if (nuevos.isNotEmpty()) guardar(actuales + nuevos)
    }

    fun marcar(id: String, comprado: Boolean) {
        guardar(_articulos.value.map { if (it.id == id) it.copy(comprado = comprado) else it })
    }

    fun borrar(id: String) {
        guardar(_articulos.value.filterNot { it.id == id })
    }

    fun vaciarComprados() {
        guardar(_articulos.value.filterNot { it.comprado })
    }
}

/**
 * Cruza los ingredientes de una receta con lo que hay en la despensa.
 *
 * Solo cuenta lo que esta vinculado a un producto concreto o coincide por
 * nombre: adivinar mas alla de eso daria falsos "ya lo tienes" y acabarias
 * en el super sin la mitad de la compra.
 */
object Necesidades {

    fun estado(
        ingrediente: Ingrediente,
        raciones: Float,
        racionesBase: Int,
        despensa: List<ProductoConUbicaciones>,
    ): EstadoIngrediente {
        val factor = if (racionesBase > 0) raciones / racionesBase else 1f
        val necesario = ingrediente.baseQuantity * factor

        val producto = despensa.firstOrNull { it.producto.id == ingrediente.linkedProductId }
            ?: despensa.firstOrNull { it.producto.name.equals(ingrediente.name, true) }
            ?: return EstadoIngrediente.Falta

        // Se suma solo lo que este en una unidad convertible a la del ingrediente.
        var disponible = 0f
        for (ubicacion in producto.ubicaciones) {
            if (!Conversor.sePuedeConvertir(ubicacion.unit, ingrediente.unit)) continue
            disponible += Conversor.convertir(ubicacion.quantity, ubicacion.unit, ingrediente.unit) ?: 0f
        }

        return when {
            disponible <= 0f -> EstadoIngrediente.Falta
            disponible >= necesario -> EstadoIngrediente.Suficiente(disponible)
            else -> EstadoIngrediente.Parcial(disponible, necesario - disponible)
        }
    }

    /** Lo que hay que comprar para cocinar una receta con las raciones dadas. */
    fun queFalta(
        receta: RecetaCompleta,
        raciones: Float,
        despensa: List<ProductoConUbicaciones>,
    ): List<ArticuloLista> {
        val factor = if (receta.receta.baseServings > 0) raciones / receta.receta.baseServings else 1f
        return receta.ingredientes.mapNotNull { ingrediente ->
            val cantidad = when (val e = estado(ingrediente, raciones, receta.receta.baseServings, despensa)) {
                is EstadoIngrediente.Suficiente -> return@mapNotNull null
                is EstadoIngrediente.Parcial -> e.falta
                EstadoIngrediente.Falta -> ingrediente.baseQuantity * factor
            }
            ArticuloLista(
                nombre = ingrediente.name,
                cantidad = "${Conversor.formato(cantidad)} ${ingrediente.unit}",
                origen = "receta: ${receta.receta.name}",
            )
        }
    }
}
