package es.joseluisgs.jetpacktutorial.mappers

import es.joseluisgs.jetpacktutorial.apis.dto.FilmDto
import es.joseluisgs.jetpacktutorial.database.entities.FilmEntity
import es.joseluisgs.jetpacktutorial.models.Film

/**
 * Mapeadores para peliculas
 */
fun FilmDto.toFilm(): Film {
    return Film(
        id = id,
        name = name,
        director = director,
        rate = rate,
        image = image,
        synopsis = synopsis
    )
}

fun Film.toFilmDTO(): FilmDto {
    return FilmDto(
        id = id,
        name = name,
        director = director,
        rate = rate,
        image = image,
        synopsis = synopsis
    )
}

@JvmName("FilmDTOListToFilmsList")
fun List<FilmDto>.toFilms(): List<Film> =
    this.map { it.toFilm() }

fun FilmEntity.toFilm(): Film {
    return Film(
        id = id,
        name = name,
        director = director,
        rate = rate,
        image = image,
        synopsis = synopsis
    )
}

fun Film.toFilmEntity(): FilmEntity {
    return FilmEntity(
        id = id,
        name = name,
        director = director,
        rate = rate,
        image = image,
        synopsis = synopsis
    )
}

@JvmName("FilmEntityListToFilmsList")
fun List<FilmEntity>.toFilms(): List<Film> =
    this.map { it.toFilm() }