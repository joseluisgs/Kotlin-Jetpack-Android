package es.joseluisgs.jetpacktutorial.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.repositories.FavoriteFilmsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the DetailsFragment
 */
@HiltViewModel // This annotation is used to inject the repository into the ViewModel
class DetailViewModel
// Inyección por constructor
@Inject constructor(
    private val favoritesRepository: FavoriteFilmsRepository
) : ViewModel() {
    // si es favorito, como mutableLiveData y repositorio donde encontrarlo
    val isFavorite = MutableLiveData<Boolean>()

    // si es favorito, como mutableLiveData y repositorio donde encontrarlo
    fun isFavorite(film: Film?) {
        film?.let {
            viewModelScope.launch {
                val exist = favoritesRepository.exist(film)
                isFavorite.postValue(exist)
            }
        }
    }

    // establece si es favorito o no
    fun clickFavorite(film: Film) {
        viewModelScope.launch {
            if (favoritesRepository.exist(film)) {
                favoritesRepository.delete(film)
                isFavorite.postValue(false)
            } else {
                favoritesRepository.create(film)
                isFavorite.postValue(true)
            }
        }
    }
}