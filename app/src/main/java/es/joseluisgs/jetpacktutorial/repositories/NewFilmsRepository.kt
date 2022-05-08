package es.joseluisgs.jetpacktutorial.repositories

import es.joseluisgs.jetpacktutorial.mappers.toFilms
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.services.FilmsService

class NewFilmsRepository {
    private val api = FilmsService()
    suspend fun get(): List<Film> = api.get().toFilms()
}
