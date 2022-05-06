package es.joseluisgs.jetpacktutorial.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Si implementa la interfaz Parcelable, podemos pasar objetos de esta clase a través de intents
 */
@Parcelize
data class Film(
    val id: Int,
    val name: String,
    val director: String,
    val rate: String,
    val image: String,
    val synopsis: String
): Parcelable
