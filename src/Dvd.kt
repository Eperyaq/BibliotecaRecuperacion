import java.util.UUID

/**
 * Clase que representa a un DVD otro tipo de ElementoBiblioteca distinto para comprobar que se puede usar gracias a la herencia
 * @property id ID unico para diferenciarlo
 * @property titulo Titulo del dvd
 * @property estado Estado del dvd, prestado o disponible
 */
class Dvd(private val id: UUID = UtilidadesBiblioteca.generarIdentificadorUnico(), private val titulo:String, private val estado: TipoEstado = TipoEstado.DISPONIBLE): ElementoBiblioteca(id, titulo, estado) {

    /**
     * Obtienes el ID del dvd
     */
    override fun obtenerId() = id

    /**
     * Obtienes el titulo del dvd
     */
    override fun obtenerTitulo() = titulo

    /**
     * Obtienes el estado del dvd
     */
    override fun obtenerEstado() = estado

    /**
     * ToString modificado para que salga esto cada vez que se printea un DVD
     */
    override fun toString(): String {
        return "Id: $id, titulo: $titulo, estado: $estado"
    }
}