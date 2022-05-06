package es.joseluisgs.jetpacktutorial.views

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.joseluisgs.jetpacktutorial.databinding.FragmentDetailBinding
import es.joseluisgs.jetpacktutorial.models.Film

class DetailFragment : Fragment() {
    // Definimos como le pasamos los datos por el intent
    companion object {
        const val EXTRA = "film"
        fun newInstance(
            film: Film
        ): DetailFragment {
            // Creamos el fragment y le pasamos los datos con putParceable
            val fragment = DetailFragment()
            val args = Bundle()
            args.putParcelable(EXTRA, film)
            fragment.arguments = args
            return fragment
        }
    }

    // Hacemos el binding del fragment con el layout
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!! // devuelve el _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Aplicamos el binding
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showContent(getFilmFromArguments())
    }

    private fun showContent(film: Film?) {
        film?.let {
            binding.tvTitle.text = it.name
            binding.tvDirector.text = it.director
            binding.tvSynopsis.text = it.synopsis
            binding.ivFilm.setImageDrawable(getImageSrc(it.image, context))
            binding.ivFav.setOnClickListener {
                binding.ivFav.setColorFilter(Color.parseColor("#00618D"))
            }
        }
    }

    // Obtiene la película del argumento Parceable
    private fun getFilmFromArguments(): Film? =
        arguments?.let {
            it.getParcelable(EXTRA) as? Film
        }

    private fun getImageSrc(name: String, context: Context?): Drawable? {
        return context?.let {
            val resources: Resources = context.resources
            val resourceId: Int = resources.getIdentifier(
                name, "drawable",
                context.packageName
            )
            resources.getDrawable(resourceId, null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}