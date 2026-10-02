package com.easycompra

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
    /** Ya filtrada y ordenada. La UI solo pinta esto. */
    val visibles: List<Product> = emptyList(),
    /** true = no habia coincidencias exactas y se ensenan las parecidas. */
    val aproximado: Boolean = false,
    val hayCatalogo: Boolean = false,
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

        /** Espera tras la ultima tecla antes de buscar. */
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

    /**
     * Catalogo completo, ya preparado para buscar. Se descarga una vez: cambiar
     * de supermercado o de orden solo filtra lo que ya hay en el movil.
     */
    @Volatile
    private var catalogo: List<Busqueda.Entrada> = emptyList()

    private var trabajoCarga: Job? = null
    private var trabajoFiltrado: Job? = null

    /**
     * Ultima red de seguridad: un fallo inesperado en el buscador se ensena en
     * pantalla en vez de cerrar la app.
     */
    private val sinCierres = CoroutineExceptionHandler { _, e ->
        _state.update { it.copy(cargando = false, error = "Error interno: ${e.javaClass.simpleName}: ${e.message}") }
    }

    init {
        cargar()
    }

    fun setBusqueda(q: String) {
        // El texto se refleja al momento; la busqueda va aparte y algo despues,
        // para no repetirla en cada tecla.
        _state.update { it.copy(busqueda = q) }
        programarFiltrado(RETARDO_BUSQUEDA_MS)
    }

    fun setOrden(o: Orden) {
        _state.update { it.copy(orden = o) }
        programarFiltrado(0)
    }

    fun setSinNata(v: Boolean) {
        _state.update { it.copy(sinNata = v) }
        programarFiltrado(0)
    }

    fun setSupermercado(s: String?) {
        _state.update { it.copy(supermercado = s) }
        programarFiltrado(0)
    }

    fun setOrigen(o: Origen) {
        prefs.edit().putString("origen", o.name).apply()
        _state.update { it.copy(origen = o) }
        cargar()
    }

    /** Solo guarda: quien recarga es setOrigen, para no cargar dos veces. */
    fun setServidor(url: String) {
        prefs.edit().putString("servidor", url).apply()
        _state.update { it.copy(servidor = url) }
    }

    fun cargar() {
        // Pulsar recargar varias veces no lanza varias descargas a la vez.
        trabajoCarga?.cancel()
        _state.update { it.copy(cargando = true, error = null, aviso = null) }
        val actual = _state.value
        trabajoCarga = viewModelScope.launch(sinCierres) {
            var aviso: String? = null
            val datos = try {
                repo.cargar(actual.origen, actual.servidor)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Throwable) {
                // Nada de lo que llegue por red debe cerrar la app. Y si hay una
                // copia guardada, se ensena en vez de dejar la pantalla vacia.
                val cache = repo.leerCache()
                if (cache == null) {
                    _state.update { it.copy(cargando = false, hayCatalogo = false, error = explicar(e)) }
                    catalogo = emptyList()
                    programarFiltrado(0)
                    return@launch
                }
                aviso = "Sin conexion: mostrando los ultimos datos guardados."
                cache
            }
            catalogo = withContext(Dispatchers.Default) { Busqueda.indexar(datos.productos) }
            _state.update {
                it.copy(
                    cargando = false,
                    hayCatalogo = true,
                    actualizado = datos.actualizado,
                    error = null,
                    aviso = aviso,
                )
            }
            programarFiltrado(0)
        }
    }

    private fun programarFiltrado(retardoMs: Long) {
        trabajoFiltrado?.cancel()
        trabajoFiltrado = viewModelScope.launch(sinCierres) {
            if (retardoMs > 0) delay(retardoMs)
            val actual = _state.value
            val entradas = catalogo
            val resultado = withContext(Dispatchers.Default) { filtrar(entradas, actual) }
            _state.update { it.copy(visibles = resultado.productos, aproximado = resultado.aproximado) }
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

    /** Filtros, busqueda y orden sobre lo ya descargado. Fuera del hilo principal. */
    private fun filtrar(entradas: List<Busqueda.Entrada>, s: UiState): Busqueda.Resultado {
        val candidatas = entradas.filter { e ->
            (s.supermercado == null || e.producto.supermarket.equals(s.supermercado, ignoreCase = true)) &&
                (!s.sinNata || !e.producto.contains_nata)
        }
        val orden: Comparator<Product> = when (s.orden) {
            Orden.PRECIO -> compareBy { it.unit_price ?: Double.MAX_VALUE }
            Orden.AZUCARES -> compareBy { it.sugars_100g ?: Double.MAX_VALUE }
            Orden.NOMBRE -> compareBy { it.name.lowercase() }
        }
        val resultado = Busqueda.buscar(candidatas, s.busqueda, orden)
        // Sin duplicados: la lista se pinta con clave por producto y dos claves
        // iguales tumbarian la LazyColumn.
        return Busqueda.Resultado(resultado.productos.distinctBy { clave(it) }, resultado.aproximado)
    }
}

/** Identificador estable de un producto, para reutilizar filas al filtrar. */
fun clave(p: Product): String = "${p.supermarket}|${p.external_id}|${p.name}"
