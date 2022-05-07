package es.joseluisgs.jetpacktutorial.viewmodels

import androidx.lifecycle.MutableLiveData
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.repositories.NewFilmsRepository

/**
 * View Model para nuevas películas.
 */
class NewFilmsViewModel {
    // Contenedor de películas observables nuevas para las vistas y reposítorio de datos
    val newsFilmsLiveData = MutableLiveData<List<Film>>()
    private val newFilmsRepository: NewFilmsRepository = NewFilmsRepository()

    fun getNewFilms() {
        // Obtenemos las películas nuevas y las asignamos al contenedor, que será observado por las vistas
        val news = newFilmsRepository.get()
        newsFilmsLiveData.postValue(news)
    }
}