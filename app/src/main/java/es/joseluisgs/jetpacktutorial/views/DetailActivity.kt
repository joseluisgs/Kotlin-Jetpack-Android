package es.joseluisgs.jetpacktutorial.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import es.joseluisgs.jetpacktutorial.R
import es.joseluisgs.jetpacktutorial.databinding.ActivityDetailBinding
import es.joseluisgs.jetpacktutorial.models.Film
import es.joseluisgs.jetpacktutorial.views.DetailFilmFragment.Companion.EXTRA

@AndroidEntryPoint // <-- This is the entry point for the Hilt dependency injection. Actividades y Fragments
class DetailActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Le asignamos la vista
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Con los datos obtenidos se los pasamos al fragment que tenemos asignados
        getExtras()?.let {
            setFragment(DetailFilmFragment.newInstance(it))
        } ?: finish()
    }

    // Obtenemos los extras es decir la película por un intent Parceable...
    private fun getExtras(): Film? = intent.extras?.getParcelable(EXTRA)

    // Función para obtener el fragment y añadirlo a la vista
    private fun setFragment(fragmentToChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmentToChange)
            .commit()
    }
}