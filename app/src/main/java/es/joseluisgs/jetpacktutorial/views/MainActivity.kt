package es.joseluisgs.jetpacktutorial.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.joseluisgs.jetpacktutorial.R
import es.joseluisgs.jetpacktutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Creamos el binding de la vista
    private lateinit var binding: ActivityMainBinding

    // Los fragments a usar
    private val newsFragment = NewFilmsFragment()
    private val favsFragment = FavsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cambiamos esto
        //setContentView(R.layout.activity_main)
        // Por esto
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Le indicamos el fragment inicial a mostrar
        setFragment(newsFragment)

        // Le indicamos el listener del BottomNavigationView
        setViewBottomNavigationListener()
    }

    // Programamos cómo y de qué manera se cambian los fragments
    private fun setFragment(fragmentToChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmentToChange)
            .commit()
    }

    private fun setViewBottomNavigationListener() {
        // Donde teníamos esto:
        // val viewBottomNav = findViewById<BottomNavigationView>(R.id.viewBottomNavigation)
        // Tenemos ahora todo enlazado con binding sin findViewById
        val viewBottomNav = binding.viewBottomNavigation
        // Dependiendo de lo que pulsemos en el BottomNavigationView, cambiamos el fragment
        viewBottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.news -> setFragment(newsFragment)
                R.id.favs -> setFragment(favsFragment)
            }
            true
        }
    }
}