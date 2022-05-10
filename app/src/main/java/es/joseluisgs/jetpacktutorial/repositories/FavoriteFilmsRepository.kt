package es.joseluisgs.jetpacktutorial.repositories

import es.joseluisgs.jetpacktutorial.FilmApp
import es.joseluisgs.jetpacktutorial.database.FilmsDao
import es.joseluisgs.jetpacktutorial.mappers.toFilmEntity
import es.joseluisgs.jetpacktutorial.mappers.toFilms
import es.joseluisgs.jetpacktutorial.models.Film
import javax.inject.Inject

/**
 * Repositorio de favoritos de películas
 */
class FavoriteFilmsRepository
@Inject constructor() {
    // Obtenemos la referencia al DAO
    private val database: FilmsDao = FilmApp.instance.room.filmDao()

    // Implementamos todas las funciones a realizar CRUD: Create, Read, Update, Delete...

    // Obtenemos todas las películas favoritas mapeando resultados a objetos de tipo [Film]
    suspend fun getAll(): List<Film> = database.selectAll().toFilms()

    // Obtenemos una película favorita por su id mapeando resultados a objetos de tipo [FilmEntity]
    suspend fun create(film: Film) {
        database.insert(film.toFilmEntity())
    }

    // existe??
    suspend fun exist(film: Film): Boolean =
        database.selectById(film.id) != null

    // Eliminamos una película favorita por su id
    suspend fun delete(film: Film) {
        database.deleteById(film.id)
    }
}