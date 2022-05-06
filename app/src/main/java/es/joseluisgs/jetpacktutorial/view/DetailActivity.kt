package es.joseluisgs.jetpacktutorial.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.joseluisgs.jetpacktutorial.R
import es.joseluisgs.jetpacktutorial.data.Film
import es.joseluisgs.jetpacktutorial.databinding.ActivityDetailBinding
import es.joseluisgs.jetpacktutorial.view.DetailFragment.Companion.EXTRA

class DetailActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Le asignamos la vista
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtenemos el film
        getExtras()?.let {
            setFragment(DetailFragment.newInstance(it))
        } ?: finish()
    }

    // Obtenemos los extras es decir la película por un intent
    private fun getExtras(): Film? = intent.extras?.getParcelable(EXTRA)

    private fun setFragment(fragmentToChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmentToChange)
            .commit()
    }
}