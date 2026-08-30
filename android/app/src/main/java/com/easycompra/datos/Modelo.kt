package com.easycompra.datos

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import androidx.room.Embedded
import java.util.UUID

/**
 * Modelo de la despensa, el recetario y el planificador.
 *
 * Las tablas y sus columnas son las mismas que tenia la app v5, para que los
 * datos sean compatibles si algun dia aparece una copia de aquella base.
 * Ver referencia/LEEME.md.
 */

fun nuevoId(): String = UUID.randomUUID().toString()

// ── Despensa ───────────────────────────────────────────────────────────────

@Entity(tableName = "pantry_products")
data class ProductoDespensa(
    @PrimaryKey val id: String = nuevoId(),
    val name: String,
    /** Marcado como "necesito comprar": aparece en la lista de la compra. */
    val needsToBuy: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
)

/**
 * Un mismo producto puede estar en varios sitios a la vez (media docena de
 * huevos en la nevera y otra caja en la despensa), y por eso las ubicaciones
 * son una tabla aparte y no columnas del producto.
 */
@Entity(
    tableName = "pantry_locations",
    foreignKeys = [ForeignKey(
        entity = ProductoDespensa::class,
        parentColumns = ["id"],
        childColumns = ["productId"],
        onDelete = ForeignKey.CASCADE,
    )],
    indices = [Index("productId")],
)
data class UbicacionDespensa(
    @PrimaryKey val id: String = nuevoId(),
    val productId: String,
    /** Nevera, Congelador, Despensa, Bebidas, Otros. */
    val category: String,
    val subcategory: String,
    val description: String = "",
    val quantity: Float = 1f,
    val unit: String = "unidad",
    val updatedAt: Long = System.currentTimeMillis(),
)

data class ProductoConUbicaciones(
    @Embedded val producto: ProductoDespensa,
    @Relation(parentColumn = "id", entityColumn = "productId")
    val ubicaciones: List<UbicacionDespensa>,
) {
    val total: Float get() = ubicaciones.sumOf { it.quantity.toDouble() }.toFloat()

    val estado: EstadoStock
        get() = when {
            ubicaciones.isEmpty() || total <= 0f -> EstadoStock.VACIO
            total <= 1f -> EstadoStock.BAJO
            else -> EstadoStock.OK
        }
}

enum class EstadoStock { OK, BAJO, VACIO }

// ── Recetario ──────────────────────────────────────────────────────────────

@Entity(tableName = "recipes")
data class Receta(
    @PrimaryKey val id: String = nuevoId(),
    val name: String,
    val category: String = "Otras",
    val photoUrl: String = "",
    val prepTimeMinutes: Int = 0,
    /** Raciones para las que estan pensadas las cantidades de la receta. */
    val baseServings: Int = 2,
    val difficulty: String = Vocabulario.DIFICULTAD_FACIL,
    val notes: String = "",
    val isFavorite: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
)

@Entity(
    tableName = "recipe_ingredients",
    foreignKeys = [ForeignKey(
        entity = Receta::class,
        parentColumns = ["id"],
        childColumns = ["recipeId"],
        onDelete = ForeignKey.CASCADE,
    )],
    indices = [Index("recipeId")],
)
data class Ingrediente(
    @PrimaryKey val id: String = nuevoId(),
    val recipeId: String,
    val name: String,
    val baseQuantity: Float = 1f,
    val unit: String = "unidad",
    /** Vinculo con un producto de la despensa, para saber si lo tienes. */
    val linkedProductId: String? = null,
    val ingredientNotes: String = "",
)

@Entity(
    tableName = "recipe_steps",
    foreignKeys = [ForeignKey(
        entity = Receta::class,
        parentColumns = ["id"],
        childColumns = ["recipeId"],
        onDelete = ForeignKey.CASCADE,
    )],
    indices = [Index("recipeId")],
)
data class PasoReceta(
    @PrimaryKey val id: String = nuevoId(),
    val recipeId: String,
    val stepNumber: Int,
    val description: String,
    val timeMinutes: Int = 0,
)

data class RecetaCompleta(
    @Embedded val receta: Receta,
    @Relation(parentColumn = "id", entityColumn = "recipeId")
    val ingredientes: List<Ingrediente>,
    @Relation(parentColumn = "id", entityColumn = "recipeId")
    val pasos: List<PasoReceta>,
)

/** Que parte de un ingrediente cubre la despensa. */
sealed interface EstadoIngrediente {
    data class Suficiente(val disponible: Float) : EstadoIngrediente
    data class Parcial(val disponible: Float, val falta: Float) : EstadoIngrediente
    data object Falta : EstadoIngrediente
}

// ── Planificador semanal ───────────────────────────────────────────────────

@Entity(tableName = "planner_entries")
data class EntradaPlan(
    @PrimaryKey val id: String = nuevoId(),
    /** Fecha en ISO (2026-08-30), para poder ordenar y filtrar por texto. */
    val date: String,
    /** Desayuno, Comida, Merienda o Cena. */
    val mealSlot: String,
    val recipeId: String? = null,
    val displayName: String,
    val servings: Float = 2f,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis(),
)

// ── Lista de la compra ─────────────────────────────────────────────────────

/**
 * No va en Room: es una lista corta y volatil que se guarda como JSON en las
 * preferencias, igual que hacia la v5 con ShoppingListStore.
 */
@kotlinx.serialization.Serializable
data class ArticuloLista(
    val id: String = nuevoId(),
    val nombre: String,
    val cantidad: String = "",
    val comprado: Boolean = false,
    /** De donde salio: "despensa", "receta: Lentejas", "manual". */
    val origen: String = "manual",
)
