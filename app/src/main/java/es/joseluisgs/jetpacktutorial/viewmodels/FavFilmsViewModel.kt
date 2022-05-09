package es.joseluisgs.jetpacktutorial.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.repositories.FavoriteFilmsRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for the [FavsFragment]
 */
class FavFilmsViewModel : ViewModel() {
    // Mis propiedades reactivas: Listas de favoritos y si esta cargando...
    val favsLiveData = MutableLiveData<List<Film>>()
    val isLoading = MutableLiveData<Boolean>()
    private val favsRepository: FavoriteFilmsRepository = FavoriteFilmsRepository()

    fun getFavFilms() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val favs = favsRepository.getAll()
            favsLiveData.postValue(favs)
            isLoading.postValue(false)
        }
    }
}