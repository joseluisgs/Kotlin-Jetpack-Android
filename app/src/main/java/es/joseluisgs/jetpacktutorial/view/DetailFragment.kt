package es.joseluisgs.jetpacktutorial.view

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.joseluisgs.jetpacktutorial.data.Film
import es.joseluisgs.jetpacktutorial.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    companion object {
        const val EXTRA = "film"
        fun newInstance(
            film: Film
        ): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putParcelable(EXTRA, film)
            fragment.arguments = args
            return fragment
        }
    }

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
                binding.ivFav.setColorFilter(Color.parseColor("#FFDAA95E"))
            }
        }
    }

    private fun getFilmFromArguments(): Film? =
        arguments?.let {
            it.getParcelable(EXTRA) as? Film
        }

    private fun getImageSrc(name: String, context: Context?): Drawable? {
        return context?.let {
            val resources: Resources = context.resources
            val resourceId: Int = resources.getIdentifier(
                name, "drawable",
                context?.packageName
            )
            resources.getDrawable(resourceId, null)
        }
    }
}