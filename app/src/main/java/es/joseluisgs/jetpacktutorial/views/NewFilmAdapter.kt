package es.joseluisgs.jetpacktutorial.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.joseluisgs.jetpacktutorial.databinding.ItemFilmBinding
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.utils.getImageSrc


class NewFilmAdapter(
    // Lista de películas
    private val films: List<Film>,
    // Evento al pulsar una película
    private val onClickFilm: (Film) -> Unit
) : RecyclerView.Adapter<NewFilmAdapter.FilmsViewHolder>() {

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        val item = films[position]
        // bindeamos los datos y el evento al view holder
        holder.bind(item, onClickFilm)
    }

    // Lo hacemos así https://stackoverflow.com/questions/60423596/how-to-use-viewbinding-in-a-recyclerview-adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        // inflamos el layout del item
        val itemBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // devolvemos el view holder con el binding
        return FilmsViewHolder(itemBinding)
    }

    override fun getItemCount() = films.size

    class FilmsViewHolder(private val itemBinding: ItemFilmBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Film, onClickFilm: (Film) -> Unit) {
            itemBinding.tvTitle.text = item.name
            itemBinding.tvDirector.text = item.director
            itemBinding.tvRate.text = item.rate
            itemBinding.ivCover.setImageDrawable(getImageSrc(item.image, itemView.context))
            itemBinding.cardFilm.setOnClickListener { onClickFilm(item) }
        }
    }
}