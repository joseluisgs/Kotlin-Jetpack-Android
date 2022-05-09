package es.joseluisgs.jetpacktutorial

import android.app.Application
import androidx.room.Room
import es.joseluisgs.jetpacktutorial.database.FilmsDb

class FilmApp : Application() {
    /**
     * Hasta que hagamos la inyección de dependencias, necesitamos una referencia a la base de datos
     * para poder acceder a ella.
     * Es por ello que como ademas necesitamos el contexto, vamos a definir Application como
     * un Singleton. Esto no es lo correcto, pero nos sirve para salir del paso en este momento.
     */
    companion object {
        lateinit var instance: FilmApp
            private set // Anulamos el setter para que no se pueda modificar desde fuera
    }

    lateinit var room: FilmsDb

    override fun onCreate() {
        super.onCreate()
        // Creamos la instancia de Room, con el contexto de Application
        room = Room
            .databaseBuilder(this, FilmsDb::class.java, "films")
            .build()

        // almacenamos esta instancia
        instance = this
    }
}