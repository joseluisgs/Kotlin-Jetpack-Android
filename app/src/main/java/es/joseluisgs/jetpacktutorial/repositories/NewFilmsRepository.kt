package es.joseluisgs.jetpacktutorial.repositories

import es.joseluisgs.jetpacktutorial.mappers.toFilms
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.services.FilmsService

/**
 * Implementa la lógica de repositorio para obtener los datos de las películas api rest
 */
class NewFilmsRepository {
    private val api = FilmsService()
    suspend fun get(): List<Film> = api.get().toFilms()
}
