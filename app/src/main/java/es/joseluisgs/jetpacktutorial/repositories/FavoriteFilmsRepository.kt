package es.joseluisgs.jetpacktutorial.repositories

import es.joseluisgs.jetpacktutorial.database.FilmsDao
import es.joseluisgs.jetpacktutorial.mappers.toFilmEntity
import es.joseluisgs.jetpacktutorial.mappers.toFilms
import es.joseluisgs.jetpacktutorial.models.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Repositorio de favoritos de películas
 */
class FavoriteFilmsRepository
@Inject constructor(
    private val filmsDao: FilmsDao
) {
    // Implementamos todas las funciones a realizar CRUD: Create, Read, Update, Delete...

    // Obtenemos todas las películas favoritas mapeando resultados a objetos de tipo [Film]
    suspend fun getAll(): Flow<List<Film>> = flow {
        filmsDao.selectAll().map { it.toFilms() }.collect { emit(it) }
    }.flowOn(Dispatchers.IO)

    // Obtenemos una película favorita por su id mapeando resultados a objetos de tipo [FilmEntity]
    suspend fun create(film: Film) {
        filmsDao.insert(film.toFilmEntity())
    }

    // existe??
    suspend fun exist(film: Film): Boolean =
        filmsDao.selectById(film.id) != null

    // Eliminamos una película favorita por su id
    suspend fun delete(film: Film) {
        filmsDao.deleteById(film.id)
    }
}