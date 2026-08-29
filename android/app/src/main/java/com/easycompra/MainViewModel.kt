package com.easycompra

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

enum class Orden(val etiqueta: String) {
    PRECIO("Precio"),
    AZUCARES("Azucares"),
    NOMBRE("Nombre"),
}

data class UiState(
    val cargando: Boolean = false,
    val error: String? = null,
    val aviso: String? = null,
    val productos: List<Product> = emptyList(),
    /** Ya filtrada y ordenada. La UI solo pinta esto. */
    val visibles: List<Product> = emptyList(),
    val busqueda: String = "",
    val supermercado: String? = null,
    val orden: Orden = Orden.PRECIO,
    val sinNata: Boolean = false,
    val origen: Origen = Origen.GITHUB,
    val servidor: String = MainViewModel.URL_POR_DEFECTO,
    val actualizado: String? = null,
)

class MainViewModel(app: Application) : AndroidViewModel(app) {

    companion object {
        const val URL_POR_DEFECTO = "http://192.168.1.131:8123"
        val SUPERMERCADOS = listOf(null, "Carrefour", "Lidl", "Mercadona", "Dia")

        /** Espera tras la ultima tecla antes de filtrar. */
        private const val RETARDO_BUSQUEDA_MS = 250L
    }

    private val prefs = app.getSharedPreferences("easycompra", Context.MODE_PRIVATE)
    private val repo = Repositorio(app.cacheDir)

    private val _state = MutableStateFlow(
        UiState(
            origen = runCatching {
                Origen.valueOf(prefs.getString("origen", Origen.GITHUB.name)!!)
            }.getOrDefault(Origen.GITHUB),
            servidor = prefs.getString("servidor", URL_POR_DEFECTO) ?: URL_POR_DEFECTO,
        )
    )
    val state: StateFlow<UiState> = _state.asStateFlow()

    /** Filtrado en curso: al teclear otra letra se cancela y se rehace. */
    private var trabajoFiltrado: Job? = null

    init {
        cargar()
    }

    fun setBusqueda(q: String) {
        // El texto se refleja al momento; filtrar 1.800 productos en cada tecla
        // bloqueaba el hilo de la interfaz, asi que eso se hace aparte y tarde.
        _state.value = _state.value.copy(busqueda = q)
        programarFiltrado(RETARDO_BUSQUEDA_MS)
    }

    fun setOrden(o: Orden) {
        _state.value = _state.value.copy(orden = o)
        programarFiltrado(0)
    }

    fun setSinNata(v: Boolean) {
        _state.value = _state.value.copy(sinNata = v)
        programarFiltrado(0)
    }

    fun setSupermercado(s: String?) {
        _state.value = _state.value.copy(supermercado = s)
        cargar()
    }

    fun setOrigen(o: Origen) {
        prefs.edit().putString("origen", o.name).apply()
        _state.value = _state.value.copy(origen = o)
        cargar()
    }

    /** Solo guarda: quien recarga es setOrigen, para no cargar dos veces. */
    fun setServidor(url: String) {
        prefs.edit().putString("servidor", url).apply()
        _state.value = _state.value.copy(servidor = url)
    }

    fun cargar() {
        val actual = _state.value
        _state.value = actual.copy(cargando = true, error = null, aviso = null)
        viewModelScope.launch {
            try {
                val datos = repo.cargar(actual.origen, actual.servidor, actual.supermercado)
                _state.value = _state.value.copy(
                    cargando = false,
                    productos = datos.productos,
                    actualizado = datos.actualizado,
                    error = null,
                )
            } catch (e: Throwable) {
                // Nada de lo que llegue por red debe cerrar la app. Y si hay una
                // copia guardada, se ensena en vez de dejar la pantalla vacia.
                val cache = repo.leerCache(actual.supermercado)
                _state.value = if (cache != null && cache.productos.isNotEmpty()) {
                    _state.value.copy(
                        cargando = false,
                        productos = cache.productos,
                        actualizado = cache.actualizado,
                        error = null,
                        aviso = "Sin conexion: mostrando los ultimos datos guardados.",
                    )
                } else {
                    _state.value.copy(cargando = false, productos = emptyList(), error = explicar(e))
                }
            }
            programarFiltrado(0)
        }
    }

    private fun programarFiltrado(retardoMs: Long) {
        trabajoFiltrado?.cancel()
        trabajoFiltrado = viewModelScope.launch {
            if (retardoMs > 0) delay(retardoMs)
            val actual = _state.value
            val lista = withContext(Dispatchers.Default) { filtrar(actual) }
            _state.value = _state.value.copy(visibles = lista)
        }
    }

    private fun explicar(e: Throwable): String = when (e) {
        is UnknownHostException ->
            if (_state.value.origen == Origen.GITHUB) "Sin conexion a internet."
            else "No se encuentra el servidor. Revisa la direccion en Ajustes."
        is ConnectException -> "El servidor no responde. Comprueba que esta arrancado y que el movil esta en la misma red."
        is SocketTimeoutException -> "Ha tardado demasiado en contestar."
        else -> e.message ?: e.javaClass.simpleName
    }

    /** Filtro y orden sobre lo ya descargado. Se llama fuera del hilo principal. */
    fun filtrar(s: UiState): List<Product> {
        var lista = s.productos

        val q = s.busqueda.trim().lowercase()
        if (q.isNotEmpty()) {
            lista = lista.filter { p ->
                p.name.contains(q, ignoreCase = true) ||
                    (p.brand ?: "").contains(q, ignoreCase = true)
            }
        }
        if (s.sinNata) {
            lista = lista.filter { !it.contains_nata }
        }
        lista = when (s.orden) {
            Orden.PRECIO -> lista.sortedBy { it.unit_price ?: Double.MAX_VALUE }
            Orden.AZUCARES -> lista.sortedBy { it.sugars_100g ?: Double.MAX_VALUE }
            Orden.NOMBRE -> lista.sortedBy { it.name.lowercase() }
        }
        // Sin duplicados: la lista se pinta con clave por producto y dos claves
        // iguales tumbarian la LazyColumn.
        return lista.distinctBy { clave(it) }
    }
}

/** Identificador estable de un producto, para reutilizar filas al filtrar. */
fun clave(p: Product): String = "${p.supermarket}|${p.external_id}|${p.name}"
