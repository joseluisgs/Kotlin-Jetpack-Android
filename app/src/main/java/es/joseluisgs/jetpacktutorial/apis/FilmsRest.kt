package es.joseluisgs.jetpacktutorial.apis

import es.joseluisgs.jetpacktutorial.apis.dto.FilmDto
import retrofit2.Response
import retrofit2.http.GET

interface FilmsRest {
    // Get all films from the API
    @GET("films/-Mk8-Ge1Bs8EgrWMM4uV.json")
    suspend fun getAllFilms(): Response<List<FilmDto>>
}