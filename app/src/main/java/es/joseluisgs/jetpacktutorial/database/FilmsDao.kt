package es.joseluisgs.jetpacktutorial.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import es.joseluisgs.jetpacktutorial.database.entities.FilmEntity

/**
 * The DAO for the film database.
 * Es donde indicamos las operaciones que se pueden realizar en la base de datos.
 * Funciones suspend para hacerlo asincrono con corrutinas.
 */
@Dao
interface FilmsDao {
    // Operaciones respecto a la base de datos o CRUD
    // Los voy a llamar igual que la operación SQL que encapsulan

    @Query("SELECT * FROM FAVORITES")
    suspend fun selectAll(): List<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Si ya existe un registro con el mismo id, lo reemplaza
    suspend fun insert(film: FilmEntity)

    @Query("SELECT * FROM FAVORITES WHERE id = :filmId")
    suspend fun selectById(filmId: Int): FilmEntity?

    @Query("DELETE FROM FAVORITES WHERE id = :filmId")
    suspend fun deleteById(filmId: Int)

    // Podriamos hacer el update ...

}