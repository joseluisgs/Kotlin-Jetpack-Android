package es.joseluisgs.jetpacktutorial.database

import androidx.room.Database
import androidx.room.RoomDatabase
import es.joseluisgs.jetpacktutorial.database.entities.FilmEntity

/**
 * Configuración de las base de datos
 */
@Database(
    // Array de las entidades a crear
    entities = [FilmEntity::class],
    version = 1
)
abstract class FilmsDb : RoomDatabase() {
    // Dao de la base de datos por cada entidad
    abstract fun filmDao(): FilmsDao
}