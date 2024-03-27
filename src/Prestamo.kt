import java.util.UUID

/**
 * Clase que guarda los datos del usuario y del libro que se presten
 *
 * @property usuario usuario al que se le presta un objeto
 * @property id ID del objeto que se quiera prestar
 */
data class Prestamo(val id:UUID, val usuario: Usuario) {

}