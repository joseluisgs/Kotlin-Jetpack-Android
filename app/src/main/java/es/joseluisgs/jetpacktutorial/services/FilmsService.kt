package es.joseluisgs.jetpacktutorial.services

import es.joseluisgs.jetpacktutorial.models.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * Simulamos un repositorio de datos
 */
class FilmsService {
    // Lo transformamos en una corrutina, con Dispacher.IO
    suspend fun get(): List<Film> = withContext(Dispatchers.IO) {
        // Vamos a simular un retardo de 3 segundos
        delay(10000) // Mejor que Thread.sleep(3000)
        listOf(
            Film(
                id = 0,
                name = "El Padrino",
                director = "Francis Ford Coppola",
                rate = "10/10",
                image = "godfather",
                synopsis = "América, años 40. Don Vito Corleone (Marlon Brando) es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York. Tiene cuatro hijos: Connie (Talia Shire), el impulsivo Sonny (James Caan), el pusilánime Fredo (John Cazale) y Michael (Al Pacino), que no quiere saber nada de los negocios de su padre. Cuando Corleone, en contra de los consejos de 'Il consigliere' Tom Hagen (Robert Duvall), se niega a participar en el negocio de las drogas, el jefe de otra banda ordena su asesinato. Empieza entonces una violenta y cruenta guerra entre las familias mafiosas. "
            ),
            Film(
                id = 1,
                name = "La naranja mecánica",
                director = "Stanley Kubrick",
                rate = "10/10",
                image = "clockworkorange",
                synopsis = "Gran Bretaña, en un futuro indeterminado. Alex (Malcolm McDowell) es un joven muy agresivo que tiene dos pasiones: la violencia desaforada y Beethoven. Es el jefe de la banda de los drugos, que dan rienda suelta a sus instintos más salvajes apaleando, violando y aterrorizando a la población. Cuando esa escalada de terror llega hasta el asesinato, Alex es detenido y, en prisión, se someterá voluntariamente a una innovadora experiencia de reeducación que pretende anular drásticamente cualquier atisbo de conducta antisocial."
            )
        )
    }
}