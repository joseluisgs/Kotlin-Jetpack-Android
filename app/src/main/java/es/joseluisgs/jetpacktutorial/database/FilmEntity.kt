package es.joseluisgs.jetpacktutorial.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Definimos la entidad Película para Room.
 */
@Entity(tableName = "FAVORITES") // Nombre de la tabla
data class FilmEntity(
    @PrimaryKey // Indicamos que es la clave primaria
    @ColumnInfo(name = "id")
    val id: Int,

    // Nombre de la columna, si no se lo ponemos se llama como el nombre de la propiedad
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "director")
    val director: String,

    @ColumnInfo(name = "rate")
    val rate: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "synopsis")
    val synopsis: String
)