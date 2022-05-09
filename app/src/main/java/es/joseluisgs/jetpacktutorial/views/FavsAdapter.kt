package es.joseluisgs.jetpacktutorial.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.joseluisgs.jetpacktutorial.databinding.ItemFilmBinding
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.utils.getImageSrc

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
    }
}