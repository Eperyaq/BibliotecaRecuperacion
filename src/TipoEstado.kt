/**
 * Enumeración que representa el estado de disponibilidad de un libro.
 *
 * define los posibles estados del libro DISPONIBLE o PRESTADO.
 *
 * @property desc Una descripción del estado de disponibilidad del libro.
 * @constructor Crea un nuevo tipo de estado con la descripción dada.
 */
enum class TipoEstado(private val desc:String) {
    DISPONIBLE ("Libro disponible"), //disponible para ser prestado
    PRESTADO ("Libro no disponible") //Ya prestado
}