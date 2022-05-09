package es.joseluisgs.jetpacktutorial.views

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.joseluisgs.jetpacktutorial.databinding.ItemFilmBinding
import es.joseluisgs.jetpacktutorial.models.Film

class FavsAdapter(
    // Lista de datos
    private val films: List<Film>,
    // Evento al pulsar una película
    private val onClickFilm: (Film) -> Unit
) : RecyclerView.Adapter<FavsAdapter.FavsViewHolder>() {

    override fun onBindViewHolder(holder: FavsViewHolder, position: Int) {
        val item = films[position]
        holder.bind(item, onClickFilm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavsViewHolder {
        val itemBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavsViewHolder(itemBinding)
    }

    override fun getItemCount() = films.size

    class FavsViewHolder(private val itemBinding: ItemFilmBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Film, onClickFilm: (Film) -> Unit) {
            itemBinding.tvTitle.text = item.name
            itemBinding.tvDirector.text = item.director
            itemBinding.tvRate.text = item.rate
            itemBinding.ivCover.setImageDrawable(getImageSrc(item.image, itemView.context))
            itemBinding.cardFilm.setOnClickListener { onClickFilm(item) }
        }

        private fun getImageSrc(name: String, context: Context): Drawable {
            val resources: Resources = context.resources
            val resourceId: Int = resources.getIdentifier(
                name, "drawable",
                context.packageName
            )
            return resources.getDrawable(resourceId, null)
        }
    }
}