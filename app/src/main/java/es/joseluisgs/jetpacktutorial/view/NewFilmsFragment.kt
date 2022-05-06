package es.joseluisgs.jetpacktutorial.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.joseluisgs.jetpacktutorial.R
import es.joseluisgs.jetpacktutorial.data.FilmsProvider
import es.joseluisgs.jetpacktutorial.view.DetailFragment.Companion.EXTRA

class NewFilmsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view.findViewById<RecyclerView>(R.id.recyclerNews)) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = FilmsAdapter(FilmsProvider.get()) {
                val intentDetail = Intent(context, DetailActivity::class.java)
                intentDetail.putExtra(EXTRA, it)
                startActivity(intentDetail)
            }
        }
    }
}