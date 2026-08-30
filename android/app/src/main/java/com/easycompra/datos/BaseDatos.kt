package com.easycompra.datos

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DespensaDao {

    @Transaction
    @Query("SELECT * FROM pantry_products ORDER BY name COLLATE NOCASE")
    fun productos(): Flow<List<ProductoConUbicaciones>>

    @Transaction
    @Query("SELECT * FROM pantry_products WHERE id = :id")
    suspend fun producto(id: String): ProductoConUbicaciones?

    @Query("SELECT * FROM pantry_products WHERE needsToBuy = 1 ORDER BY name COLLATE NOCASE")
    fun porComprar(): Flow<List<ProductoDespensa>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarProducto(producto: ProductoDespensa)

    @Update
    suspend fun actualizarProducto(producto: ProductoDespensa)

    @Delete
    suspend fun borrarProducto(producto: ProductoDespensa)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarUbicacion(ubicacion: UbicacionDespensa)

    @Delete
    suspend fun borrarUbicacion(ubicacion: UbicacionDespensa)

    @Query("UPDATE pantry_products SET needsToBuy = :necesita WHERE id = :id")
    suspend fun marcarPorComprar(id: String, necesita: Boolean)
}

@Dao
interface RecetaDao {

    @Transaction
    @Query("SELECT * FROM recipes ORDER BY name COLLATE NOCASE")
    fun recetas(): Flow<List<RecetaCompleta>>

    @Transaction
    @Query("SELECT * FROM recipes WHERE id = :id")
    fun receta(id: String): Flow<RecetaCompleta?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardar(receta: Receta)

    @Delete
    suspend fun borrar(receta: Receta)

    @Query("UPDATE recipes SET isFavorite = :favorita WHERE id = :id")
    suspend fun marcarFavorita(id: String, favorita: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarIngredientes(ingredientes: List<Ingrediente>)

    @Query("DELETE FROM recipe_ingredients WHERE recipeId = :recetaId")
    suspend fun borrarIngredientes(recetaId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarPasos(pasos: List<PasoReceta>)

    @Query("DELETE FROM recipe_steps WHERE recipeId = :recetaId")
    suspend fun borrarPasos(recetaId: String)

    /** Guarda receta, ingredientes y pasos como una sola operacion. */
    @Transaction
    suspend fun guardarCompleta(receta: Receta, ingredientes: List<Ingrediente>, pasos: List<PasoReceta>) {
        guardar(receta)
        borrarIngredientes(receta.id)
        borrarPasos(receta.id)
        if (ingredientes.isNotEmpty()) guardarIngredientes(ingredientes)
        if (pasos.isNotEmpty()) guardarPasos(pasos)
    }
}

@Dao
interface PlanDao {

    @Query("SELECT * FROM planner_entries WHERE date BETWEEN :desde AND :hasta ORDER BY date, mealSlot")
    fun entradas(desde: String, hasta: String): Flow<List<EntradaPlan>>

    @Query("SELECT * FROM planner_entries ORDER BY date")
    fun todas(): Flow<List<EntradaPlan>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardar(entrada: EntradaPlan)

    @Delete
    suspend fun borrar(entrada: EntradaPlan)
}

@Database(
    entities = [
        ProductoDespensa::class,
        UbicacionDespensa::class,
        Receta::class,
        Ingrediente::class,
        PasoReceta::class,
        EntradaPlan::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class BaseDatos : RoomDatabase() {

    abstract fun despensa(): DespensaDao
    abstract fun recetas(): RecetaDao
    abstract fun plan(): PlanDao

    companion object {
        @Volatile
        private var instancia: BaseDatos? = null

        fun obtener(context: Context): BaseDatos = instancia ?: synchronized(this) {
            instancia ?: Room.databaseBuilder(
                context.applicationContext,
                BaseDatos::class.java,
                "easycompra.db",
            ).build().also { instancia = it }
        }
    }
}
