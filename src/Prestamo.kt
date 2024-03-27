/**
 * Clase que guarda los datos del usuario y del libro que se presten
 *
 * @property usuario usuario al que se le presta un libro
 * @property libro Libro que se le presta al usuario
 */
data class Prestamo(val usuario: Usuario, val libro: Libro) {
}