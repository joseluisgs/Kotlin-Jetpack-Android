package es.joseluisgs.jetpacktutorial.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Si implementa la interfaz Parcelable, podemos pasar objetos de esta clase a través de intents
 * https://stackoverflow.com/questions/7181526/how-can-i-make-my-custom-objects-parcelable#:~:text=Create%20Parcelable%20class%20without%20plugin,that's%20it.
 */
@Parcelize
data class Film(
    val id: Int,
    val name: String,
    val director: String,
    val rate: String,
    val image: String,
    val synopsis: String
) : Parcelable
