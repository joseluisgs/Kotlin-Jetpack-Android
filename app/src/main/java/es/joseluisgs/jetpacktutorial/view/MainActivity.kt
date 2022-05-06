package es.joseluisgs.jetpacktutorial.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import es.joseluisgs.jetpacktutorial.R

class MainActivity : AppCompatActivity() {

    private val newsFragment = NewFilmsFragment()
    private val favsFragment = FavsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(newsFragment)

        setViewBottomNavigationListener()
    }

    private fun setFragment(fragmentToChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmentToChange)
            .commit()
    }

    private fun setViewBottomNavigationListener() {
        val viewBottomNav = findViewById<BottomNavigationView>(R.id.viewBottomNavigation)
        viewBottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.news -> setFragment(newsFragment)
                R.id.favs -> setFragment(favsFragment)
            }
            true
        }
    }
}