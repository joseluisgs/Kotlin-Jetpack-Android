package es.joseluisgs.jetpacktutorial.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FilmsApiClient {
    private const val API_URL = "https://jetpack-course-default-rtdb.firebaseio.com/"

    // Creamos una instancia de Retrofit con las llamadas a la API
    fun getInstance(): FilmsRest {
        return Retrofit.Builder().baseUrl(API_URL)
            // Nuestro conversor de JSON
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FilmsRest::class.java)
    }
}