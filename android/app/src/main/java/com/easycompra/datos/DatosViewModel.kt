package com.easycompra.datos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

/**
 * Estado de despensa, recetario, planificador y lista de la compra.
 *
 * Va todo en un mismo ViewModel a proposito: las cuatro cosas se cruzan
 * constantemente (una receta mira la despensa, el plan mira las recetas, y
 * ambos escriben en la lista de la compra), y separarlos obligaria a
 * sincronizar cuatro copias del mismo estado.
 */
class DatosViewModel(app: Application) : AndroidViewModel(app) {

    private val db = BaseDatos.obtener(app)
    private val listaStore = ListaCompraStore(app)

    val despensa: StateFlow<List<ProductoConUbicaciones>> =
        db.despensa().productos()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val recetas: StateFlow<List<RecetaCompleta>> =
        db.recetas().recetas()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val plan: StateFlow<List<EntradaPlan>> =
        db.plan().todas()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val lista: StateFlow<List<ArticuloLista>> = listaStore.articulos

    /** Productos marcados como "necesito comprar" en la despensa. */
    val porComprar: StateFlow<List<ProductoDespensa>> =
        db.despensa().porComprar()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // ── Despensa ───────────────────────────────────────────────────────────

    fun anadirADespensa(
        nombre: String,
        categoria: String,
        subcategoria: String,
        cantidad: Float,
        unidad: String,
        descripcion: String,
    ) = viewModelScope.launch {
        val limpio = nombre.trim()
        if (limpio.isEmpty()) return@launch
        // Si el producto ya existe se le anade otra ubicacion, no se duplica.
        val existente = despensa.value.firstOrNull { it.producto.name.equals(limpio, true) }
        val producto = existente?.producto ?: ProductoDespensa(name = limpio)
        if (existente == null) db.despensa().guardarProducto(producto)
        db.despensa().guardarUbicacion(
            UbicacionDespensa(
                productId = producto.id,
                category = categoria,
                subcategory = subcategoria,
                description = descripcion.trim(),
                quantity = cantidad,
                unit = unidad,
            )
        )
    }

    fun cambiarCantidad(ubicacion: UbicacionDespensa, cantidad: Float) = viewModelScope.launch {
        if (cantidad <= 0f) db.despensa().borrarUbicacion(ubicacion)
        else db.despensa().guardarUbicacion(
            ubicacion.copy(quantity = cantidad, updatedAt = System.currentTimeMillis())
        )
    }

    fun borrarDeDespensa(producto: ProductoDespensa) = viewModelScope.launch {
        db.despensa().borrarProducto(producto)
    }

    fun marcarPorComprar(producto: ProductoDespensa, necesita: Boolean) = viewModelScope.launch {
        db.despensa().marcarPorComprar(producto.id, necesita)
        if (necesita) listaStore.anadir(producto.name, origen = "despensa")
    }

    // ── Recetario ──────────────────────────────────────────────────────────

    fun guardarReceta(
        receta: Receta,
        ingredientes: List<Ingrediente>,
        pasos: List<PasoReceta>,
    ) = viewModelScope.launch {
        db.recetas().guardarCompleta(
            receta.copy(updatedAt = System.currentTimeMillis()),
            ingredientes.map { it.copy(recipeId = receta.id) },
            pasos.mapIndexed { i, p -> p.copy(recipeId = receta.id, stepNumber = i + 1) },
        )
    }

    fun borrarReceta(receta: Receta) = viewModelScope.launch {
        db.recetas().borrar(receta)
    }

    fun marcarFavorita(receta: Receta) = viewModelScope.launch {
        db.recetas().marcarFavorita(receta.id, !receta.isFavorite)
    }

    /** Lleva a la lista de la compra lo que falta para cocinar la receta. */
    fun comprarLoQueFalta(receta: RecetaCompleta, raciones: Float) {
        listaStore.anadirVarios(Necesidades.queFalta(receta, raciones, despensa.value))
    }

    // ── Planificador ───────────────────────────────────────────────────────

    fun planificar(
        fecha: LocalDate,
        comida: String,
        nombre: String,
        recetaId: String?,
        raciones: Float,
        notas: String,
    ) = viewModelScope.launch {
        if (nombre.isBlank()) return@launch
        db.plan().guardar(
            EntradaPlan(
                date = fecha.toString(),
                mealSlot = comida,
                recipeId = recetaId,
                displayName = nombre.trim(),
                servings = raciones,
                notes = notas.trim(),
            )
        )
    }

    fun borrarDelPlan(entrada: EntradaPlan) = viewModelScope.launch {
        db.plan().borrar(entrada)
    }

    /** Todo lo que hace falta para las comidas planificadas de una semana. */
    fun comprarParaLaSemana(dias: List<LocalDate>) {
        val fechas = dias.map { it.toString() }.toSet()
        val entradas = plan.value.filter { it.date in fechas && it.recipeId != null }
        val articulos = entradas.flatMap { entrada ->
            val receta = recetas.value.firstOrNull { it.receta.id == entrada.recipeId }
                ?: return@flatMap emptyList()
            Necesidades.queFalta(receta, entrada.servings, despensa.value)
        }
        listaStore.anadirVarios(articulos)
    }

    // ── Lista de la compra ─────────────────────────────────────────────────

    fun anadirALista(nombre: String, cantidad: String = "") = listaStore.anadir(nombre, cantidad)
    fun marcarComprado(id: String, comprado: Boolean) = listaStore.marcar(id, comprado)
    fun borrarDeLista(id: String) = listaStore.borrar(id)
    fun vaciarComprados() = listaStore.vaciarComprados()

    /** Nombres de la despensa, para sugerir al escribir un ingrediente. */
    val nombresDespensa: StateFlow<List<String>> = db.despensa().productos()
        .map { lista -> lista.map { it.producto.name }.sorted() }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
