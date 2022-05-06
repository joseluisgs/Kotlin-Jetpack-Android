package es.joseluisgs.jetpacktutorial.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import es.joseluisgs.jetpacktutorial.data.FilmsProvider
import es.joseluisgs.jetpacktutorial.databinding.FragmentNewFilmsBinding
import es.joseluisgs.jetpacktutorial.view.DetailFragment.Companion.EXTRA

class NewFilmsFragment : Fragment() {
    // View Binding
    private var _binding: FragmentNewFilmsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerNews) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = FilmsAdapter(FilmsProvider.get()) {
                val intentDetail = Intent(context, DetailActivity::class.java)
                intentDetail.putExtra(EXTRA, it)
                startActivity(intentDetail)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}