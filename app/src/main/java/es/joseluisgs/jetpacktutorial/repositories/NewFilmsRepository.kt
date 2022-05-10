package es.joseluisgs.jetpacktutorial.repositories

import es.joseluisgs.jetpacktutorial.mappers.toFilms
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.services.FilmsService
import javax.inject.Inject

/**
 * Implementa la lógica de repositorio para obtener los datos de las películas api rest
 */
class NewFilmsRepository
@Inject constructor(
    private val filmService: FilmsService
) {
    suspend fun get(): List<Film> = filmService.getAllFilms().toFilms()
}
