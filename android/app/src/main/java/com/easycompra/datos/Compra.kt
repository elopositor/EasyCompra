package com.easycompra.datos

import android.content.Context
import com.easycompra.Product
import com.easycompra.clave
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/** Un producto del catalogo en Mi lista, con cuantas unidades. */
@Serializable
data class ItemCompra(val producto: Product, val cantidad: Int = 1) {
    val clave: String get() = clave(producto)
    val total: Double? get() = producto.unit_price?.let { it * cantidad }
}

private val json = Json { ignoreUnknownKeys = true; coerceInputValues = true }

/**
 * Productos del catalogo que se quieren comprar, para comparar lo que cuesta
 * la compra en cada supermercado. Se guardan enteros (precio, foto...) para
 * que la lista se vea igual sin conexion.
 */
class ListaProductosStore(context: Context) {

    private val prefs = context.getSharedPreferences("lista_productos", Context.MODE_PRIVATE)

    private val _items = MutableStateFlow(leer())
    val items: StateFlow<List<ItemCompra>> = _items.asStateFlow()

    private fun leer(): List<ItemCompra> = runCatching {
        val texto = prefs.getString("items", null) ?: return emptyList()
        json.decodeFromString<List<ItemCompra>>(texto)
    }.getOrDefault(emptyList())

    private fun guardar(lista: List<ItemCompra>) {
        _items.value = lista
        runCatching { prefs.edit().putString("items", json.encodeToString(lista)).apply() }
    }

    /** Si ya estaba, suma una unidad. */
    fun anadir(producto: Product) {
        val k = clave(producto)
        val actual = _items.value
        guardar(
            if (actual.any { it.clave == k }) actual.map { if (it.clave == k) it.copy(cantidad = it.cantidad + 1) else it }
            else actual + ItemCompra(producto)
        )
    }

    /** Con 0 o menos, se quita de la lista. */
    fun cambiarCantidad(clave: String, cantidad: Int) {
        guardar(
            if (cantidad <= 0) _items.value.filterNot { it.clave == clave }
            else _items.value.map { if (it.clave == clave) it.copy(cantidad = cantidad) else it }
        )
    }

    fun vaciar() = guardar(emptyList())
}

/** Productos marcados como favoritos, por su clave. */
class FavoritosStore(context: Context) {

    private val prefs = context.getSharedPreferences("favoritos", Context.MODE_PRIVATE)

    private val _claves = MutableStateFlow(prefs.getStringSet("claves", emptySet()).orEmpty().toSet())
    val claves: StateFlow<Set<String>> = _claves.asStateFlow()

    fun alternar(producto: Product) {
        val k = clave(producto)
        val nuevas = if (k in _claves.value) _claves.value - k else _claves.value + k
        _claves.value = nuevas
        runCatching { prefs.edit().putStringSet("claves", nuevas).apply() }
    }
}
