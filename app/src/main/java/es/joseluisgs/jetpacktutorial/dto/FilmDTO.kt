package es.joseluisgs.jetpacktutorial.dto

import com.google.gson.annotations.SerializedName

/**
 * DTO for a film
 * Usamos notaciones de GSON para indicar que los campos de la clase son
 */
data class FilmDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("rate")
    val rate: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("synopsis")
    val synopsis: String
)