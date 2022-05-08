package es.joseluisgs.jetpacktutorial.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.repositories.NewFilmsRepository
import kotlinx.coroutines.launch

/**
 * View Model para nuevas películas.
 */
class NewFilmsViewModel : ViewModel() {
    // Contenedor de películas observables nuevas para las vistas y reposítorio de datos
    val newsFilmsLiveData = MutableLiveData<List<Film>>()
    private val newFilmsRepository: NewFilmsRepository = NewFilmsRepository()

    // Para saber si se ha cargado la lista de películas nuevas
    val isLoading = MutableLiveData<Boolean>()

    fun getNewFilms() {
        // Obtenemos las películas nuevas y las asignamos al contenedor, que será observado por las vistas
        // Lo hacemos asincronamente en un contexto propio (viewModel) para no bloquear el hilo principal
        viewModelScope.launch {
            isLoading.postValue(true)
            val news = newFilmsRepository.get()
            newsFilmsLiveData.postValue(news)
            isLoading.postValue(false)
        }
    }
}