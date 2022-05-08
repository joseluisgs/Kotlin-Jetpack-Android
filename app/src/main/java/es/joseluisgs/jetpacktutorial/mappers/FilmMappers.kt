package es.joseluisgs.jetpacktutorial.mappers

import es.joseluisgs.jetpacktutorial.dto.FilmDTO
import es.joseluisgs.jetpacktutorial.models.Film

/**
 * Mapeadores para peliculas
 */
fun FilmDTO.toFilm(): Film {
    return Film(
        id = id,
        name = name,
        director = director,
        rate = rate,
        image = image,
        synopsis = synopsis
    )
}

fun Film.toFilmDTO(): FilmDTO {
    return FilmDTO(
        id = id,
        name = name,
        director = director,
        rate = rate,
        image = image,
        synopsis = synopsis
    )
}

fun List<FilmDTO>.toFilms(): List<Film> =
    this.map { it.toFilm() }