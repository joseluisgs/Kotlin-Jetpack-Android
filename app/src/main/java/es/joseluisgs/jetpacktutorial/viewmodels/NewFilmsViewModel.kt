package es.joseluisgs.jetpacktutorial.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.repositories.NewFilmsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View Model para nuevas películas.
 */
@HiltViewModel
class NewFilmsViewModel
@Inject constructor(
    private val newFilmsRepository: NewFilmsRepository
) : ViewModel() {
    // Contenedor de películas observables nuevas para las vistas y reposítorio de datos
    val newsFilmsLiveData = MutableLiveData<List<Film>>()

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