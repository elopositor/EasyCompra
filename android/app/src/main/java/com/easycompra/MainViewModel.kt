package com.easycompra

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.easycompra.datos.FavoritosStore
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

/**
 * Pestanas de orden de la v5. [deMenorAMayor] es el sentido al pulsarla por
 * primera vez: proteinas, de mas a menos; el resto, de menos a mas.
 */
enum class Orden(val etiqueta: String, val deMenorAMayor: Boolean = true) {
    AZUCARES("Azúcares"),
    CALORIAS("Calorías"),
    GRASAS("Grasas"),
    PROTEINAS("Proteínas", deMenorAMayor = false),
    PRECIO("Precio"),
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
    /** Vacio = todos. */
    val supermercados: Set<String> = emptySet(),
    /** null = todas. */
    val categoria: String? = null,
    /** Categorias que tienen algun producto, para no ensenar chips vacios. */
    val categorias: List<String> = emptyList(),
    val orden: Orden = Orden.AZUCARES,
    /** Pulsar otra vez la pestana del orden lo invierte. */
    val invertido: Boolean = false,
    val soloFavoritos: Boolean = false,
    /**
     * Sube cada vez que la lista cambia porque se ha tocado un filtro o la
     * busqueda. La pantalla vuelve arriba solo entonces: al volver del
     * detalle debe seguir donde estaba.
     */
    val resultadoId: Int = 0,
    val favoritos: Set<String> = emptySet(),
    val origen: Origen = Origen.GITHUB,
    val servidor: String = MainViewModel.URL_POR_DEFECTO,
    val actualizado: String? = null,
)

class MainViewModel(app: Application) : AndroidViewModel(app) {

    companion object {
        const val URL_POR_DEFECTO = "http://192.168.1.131:8123"
        val SUPERMERCADOS = listOf(null, "Mercadona", "Dia", "Carrefour", "Lidl")

        /** Espera tras la ultima tecla antes de buscar. */
        private const val RETARDO_BUSQUEDA_MS = 250L
    }

    private val prefs = app.getSharedPreferences("easycompra", Context.MODE_PRIVATE)
    private val repo = Repositorio(app.cacheDir)
    private val favoritosStore = FavoritosStore(app)

    private val _state = MutableStateFlow(
        UiState(
            origen = runCatching {
                Origen.valueOf(prefs.getString("origen", Origen.GITHUB.name)!!)
            }.getOrDefault(Origen.GITHUB),
            servidor = prefs.getString("servidor", URL_POR_DEFECTO) ?: URL_POR_DEFECTO,
            favoritos = favoritosStore.claves.value,
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
        _state.update {
            if (it.orden == o) it.copy(invertido = !it.invertido) else it.copy(orden = o, invertido = false)
        }
        programarFiltrado(0)
    }

    fun setCategoria(c: String?) {
        _state.update { it.copy(categoria = c) }
        programarFiltrado(0)
    }

    fun setSoloFavoritos(v: Boolean) {
        _state.update { it.copy(soloFavoritos = v) }
        programarFiltrado(0)
    }

    fun alternarFavorito(p: Product) {
        favoritosStore.alternar(p)
        _state.update { it.copy(favoritos = favoritosStore.claves.value) }
        // Sin volver arriba: se ha marcado desde la lista y hay que seguir ahi.
        if (_state.value.soloFavoritos) programarFiltrado(0, volverArriba = false)
    }

    /** null = Todos. Un supermercado se suma o se quita de la seleccion. */
    fun setSupermercado(s: String?) {
        _state.update {
            it.copy(
                supermercados = when {
                    s == null -> emptySet()
                    s in it.supermercados -> it.supermercados - s
                    else -> it.supermercados + s
                }
            )
        }
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
            val presentes = catalogo.mapTo(HashSet()) { it.categoria }
            _state.update {
                it.copy(
                    categorias = Categorias.TODAS.filter { c -> c in presentes },
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

    private fun programarFiltrado(retardoMs: Long, volverArriba: Boolean = true) {
        trabajoFiltrado?.cancel()
        trabajoFiltrado = viewModelScope.launch(sinCierres) {
            if (retardoMs > 0) delay(retardoMs)
            val actual = _state.value
            val entradas = catalogo
            val resultado = withContext(Dispatchers.Default) { filtrar(entradas, actual) }
            _state.update {
                it.copy(
                    visibles = resultado.productos,
                    aproximado = resultado.aproximado,
                    resultadoId = if (volverArriba) it.resultadoId + 1 else it.resultadoId,
                )
            }
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
        val supers = s.supermercados.mapTo(HashSet()) { it.lowercase() }
        val candidatas = entradas.filter { e ->
            (supers.isEmpty() || e.producto.supermarket.lowercase() in supers) &&
                (s.categoria == null || e.categoria == s.categoria) &&
                (!s.soloFavoritos || clave(e.producto) in s.favoritos)
        }
        val dato: (Product) -> Double? = when (s.orden) {
            Orden.AZUCARES -> { p -> p.sugars_100g }
            Orden.CALORIAS -> { p -> p.energy_kcal_100g }
            Orden.GRASAS -> { p -> p.fat_100g }
            Orden.PROTEINAS -> { p -> p.proteins_100g }
            Orden.PRECIO -> { p -> p.unit_price }
        }
        // Lo que no tiene el dato va al final, en un sentido y en el otro.
        val deMenorAMayor = s.orden.deMenorAMayor != s.invertido
        val orden: Comparator<Product> = compareBy(
            nullsLast(if (deMenorAMayor) naturalOrder() else reverseOrder<Double>())
        ) { p: Product -> dato(p) }
        val resultado = Busqueda.buscar(candidatas, s.busqueda, orden)
        // Sin duplicados: la lista se pinta con clave por producto y dos claves
        // iguales tumbarian la LazyColumn.
        return Busqueda.Resultado(resultado.productos.distinctBy { clave(it) }, resultado.aproximado)
    }
}

/** Identificador estable de un producto, para reutilizar filas al filtrar. */
fun clave(p: Product): String = "${p.supermarket}|${p.external_id}|${p.name}"
