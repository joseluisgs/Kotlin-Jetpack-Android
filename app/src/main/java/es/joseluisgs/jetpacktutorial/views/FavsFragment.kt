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
import es.joseluisgs.jetpacktutorial.databinding.FragmentFavsBinding
import es.joseluisgs.jetpacktutorial.viewmodels.FavFilmsViewModel

class FavsFragment : Fragment() {
    // Realizamos el binding
    private var _binding: FragmentFavsBinding? = null
    private val binding get() = _binding!!

    // Hacemos el viewmodel con liveData
    private val favsViewModel: FavFilmsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavsBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Se ejecuta una vez se haya hecho el onCreateView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtenemos las películas favoritas
        favsViewModel.getFavFilms()
        favsViewModel.favsLiveData.observe(viewLifecycleOwner) { films ->
            with(binding.recyclerFavs) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = FavsAdapter(films) {
                    // cuando se pulsa sobre una pelicula, se lanza una nueva actividad
                    val intentDetail = Intent(context, DetailActivity::class.java)
                    // Le añadimos la pelicula seleccionada como extra
                    intentDetail.putExtra(DetailFragment.EXTRA, it)
                    // lanzamos la actividad con el intent creado y el dato que necesita
                    startActivity(intentDetail)
                }
            }
        }
        favsViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.pbLoading.isVisible = isLoading
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}