package es.joseluisgs.jetpacktutorial.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.repositories.FavoriteFilmsRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for the DetailsFragment
 */
class DetailViewModel : ViewModel() {
    // si es favorito, como mutableLiveData y repositorio donde encontrarlo
    val isFavorite = MutableLiveData<Boolean>()
    private val favoritesRepository: FavoriteFilmsRepository = FavoriteFilmsRepository()

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