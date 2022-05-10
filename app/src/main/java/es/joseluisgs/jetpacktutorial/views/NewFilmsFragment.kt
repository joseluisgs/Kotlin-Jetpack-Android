package es.joseluisgs.jetpacktutorial.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import es.joseluisgs.jetpacktutorial.databinding.FragmentNewFilmsBinding
import es.joseluisgs.jetpacktutorial.viewmodels.NewFilmsViewModel
import es.joseluisgs.jetpacktutorial.views.DetailFilmFragment.Companion.EXTRA

@AndroidEntryPoint // <-- This is the entry point for the Hilt dependency injection. Actividades y Fragments
class NewFilmsFragment : Fragment() {
    // View Binding
    private var _binding: FragmentNewFilmsBinding? = null
    private val binding get() = _binding!!

    // Creamos la instancia a VieModel/LiveData y quedan atadas al ciclo de vida de la actividad del Fragment
    // si queremos que sea con el fragment, debemos usar el by viewModel
    private val newFilmsViewModel: NewFilmsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Se ejecuta una vez se haya hecho el onCreateView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtenemos los datos, ya los obtenemos de manera asincrona
        newFilmsViewModel.getNewFilms()
        // Aplicamos observer sobre el recicler en el ciclo de vida indicado en nuestra vista
        // Para recuperar las películas
        newFilmsViewModel.newsFilmsLiveData.observe(viewLifecycleOwner) { films ->
            // de nuestro recyclerView le pasamos una instancia de LinearLayoutManager
            with(binding.recyclerNews) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                // le pasamos una instancia de FilmsAdapter con las peliculas recuperadas del repositorio
                adapter = NewFilmAdapter(films) {
                    // cuando se pulsa sobre una pelicula, se lanza una nueva actividad
                    val intentDetail = Intent(context, DetailActivity::class.java)
                    // Le añadimos la pelicula seleccionada como extra
                    intentDetail.putExtra(EXTRA, it)
                    // lanzamos la actividad con el intent creado y el dato que necesita
                    startActivity(intentDetail)
                }
            }
        }
        // Patrón observer para el estado de la carga de datos
        newFilmsViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // La lista está oculta por defecto, y se muestra una vez hayamos terminado la carga
            // Mostramos el progressBar si está cargando si no ocultamos
            binding.recyclerNews.isVisible = !isLoading
            binding.pbLoading.isVisible = isLoading
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}