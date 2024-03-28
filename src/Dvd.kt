import java.util.UUID

/**
 * Clase que representa a un DVD otro tipo de ElementoBiblioteca distinto para comprobar que se puede usar gracias a la herencia
 * @property id ID unico para diferenciarlo
 * @property titulo Titulo del dvd
 * @property estado Estado del dvd, prestado o disponible
 * @property duracion Duracion del Dvd
 * @property genero Genero del dvd
 */
class Dvd(private val id: UUID = UtilidadesBiblioteca.generarIdentificadorUnico(), private val titulo:String, private var estado: TipoEstado = TipoEstado.DISPONIBLE, private val duracion:Double, private val genero:String): ElementoBiblioteca(id, titulo, estado), Prestable {

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
     * Obtienes la duracion del DVD
     */
    fun obtenerDuracion() = duracion

    /**
     * Obtienes el genero del DVD
     */
    fun obtenerGenero() = genero

    /**
     * Realiza la accion de prestar un DVD lo que cambia su estado de Disponible a prestado
     */
    override fun prestar() {
        if ( estado == TipoEstado.DISPONIBLE ){
            estado = TipoEstado.PRESTADO
        } else {
            Consola.mostrarInfo("Ya prestado" )
        }
    }

    /**
     * Realiza la accion de devolver un DVD lo que cambia su estado de Prestado a disponible
     */
    override fun devolver() {
        if ( estado == TipoEstado.PRESTADO ) {
            estado = TipoEstado.DISPONIBLE
        } else {
            Consola.mostrarInfo("Ya devuelto")
        }
    }
    /**
     * ToString modificado para que salga esto cada vez que se printea un DVD
     */
    override fun toString(): String {
        return "Id: $id, titulo: $titulo, estado: $estado"
    }
}