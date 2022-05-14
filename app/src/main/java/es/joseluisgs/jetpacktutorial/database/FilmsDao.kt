package es.joseluisgs.jetpacktutorial.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import es.joseluisgs.jetpacktutorial.database.entities.FilmEntity
import kotlinx.coroutines.flow.Flow

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
    fun selectAll(): Flow<List<FilmEntity>> // Devuelve un flow para que sea asincrono, no tiene que ser suspend
    // suspend fun selectAll(): List<FilmEntity> // Devuelve una lista para que sea sincrono
    /**
     * Puedes usar Flow with Room (flujo con Room) para recibir notificaciones
     * sobre los cambios en una base de datos. Cuando uses objetos de acceso a datos (DAO),
     * muestra un tipo Flow para obtener actualizaciones en tiempo real.
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Si ya existe un registro con el mismo id, lo reemplaza
    suspend fun insert(film: FilmEntity)

    @Query("SELECT * FROM FAVORITES WHERE id = :filmId")
    fun getFilmById(filmId: Int): Flow<FilmEntity?>
    // suspend fun selectById(filmId: Int): FilmEntity? // Podriamos hacerlo como flujo

    @Query("DELETE FROM FAVORITES WHERE id = :filmId")
    suspend fun deleteById(filmId: Int)

    // Podriamos hacer el update ...

}