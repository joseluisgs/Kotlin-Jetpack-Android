package es.joseluisgs.jetpacktutorial.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.repositories.FavoriteFilmsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the [FavsFragment]
 */
@HiltViewModel
class FavFilmsViewModel
@Inject constructor(
    private val favsRepository: FavoriteFilmsRepository
) : ViewModel() {
    // Mis propiedades reactivas: Listas de favoritos y si esta cargando...
    val favsLiveData = MutableLiveData<List<Film>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getFavFilms() {
        viewModelScope.launch {
            isLoading.postValue(true)
            // val favs = favsRepository.getAll()
            // Voy a hacerlo con flujos de datos
            favsRepository.getAll().collect { films ->
                favsLiveData.postValue(films)
                isLoading.postValue(false)
            }
            // favsLiveData.postValue(favs)
            // isLoading.postValue(false)
        }
    }
}