package es.joseluisgs.jetpacktutorial.repositories

import es.joseluisgs.jetpacktutorial.mappers.toFilms
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.services.FilmsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Implementa la lógica de repositorio para obtener los datos de las películas api rest
 */
class NewFilmsRepository
@Inject constructor(
    private val filmService: FilmsService
) {
    suspend fun getAllFilms(): List<Film> = filmService.getAllFilms().toFilms()

    /**
     * Voy a hacerlo con un flujo de datos simplificado
     */
    suspend fun getAllFilmsAsFlow(): Flow<List<Film>> = flow {
        filmService.latestNews.map { it.toFilms() }.collect { emit(it) }
    }.flowOn(Dispatchers.IO)
}
