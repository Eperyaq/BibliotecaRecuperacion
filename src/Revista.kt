import java.util.UUID

/**
 * Clase que representa una revista, otro tipo de ElementoBiblioteca
 * @property id ID unico para diferenciarlo
 * @property titulo Titulo de la revista
 * @property estado Estado de la revista, prestado o disponible
 * @property edicion Edicion de la revista
 * @property tematica Tematica de la revista
 */
class Revista(private val id: UUID = UtilidadesBiblioteca.generarIdentificadorUnico(), private val titulo:String, private var estado: TipoEstado = TipoEstado.DISPONIBLE, private val edicion:String, private val tematica:String):ElementoBiblioteca(id, titulo, estado), Prestable {

    /**
     * Obtienes el id de la revista
     */
    override fun obtenerId() = id

    /**
     * Obtienes el titulo de la revista
     */
    override fun obtenerTitulo() = titulo

    /**
     * Obtienes el estado de la revista
     */
    override fun obtenerEstado() = estado

    /**
     * Obtienes la tematica de la revista
     */
    fun obtenerEdicion() = edicion

    /**
     * Obtienes la tematica de la revista
     */
    fun obtenerTematica() = tematica

    /**
     * Realiza la accion de prestar una revista lo que cambia su estado de Disponible a prestado
     */
    override fun prestar() {
        if ( estado == TipoEstado.DISPONIBLE ){
            estado = TipoEstado.PRESTADO
        } else {
            Consola.mostrarInfo("Ya prestado" )
        }
    }

    /**
     * Realiza la accion de devolver una revista lo que cambia su estado de Prestado a disponible
     */
    override fun devolver() {
        if ( estado == TipoEstado.PRESTADO ) {
            estado = TipoEstado.DISPONIBLE
        } else {
            Consola.mostrarInfo("Ya devuelto")
        }
    }
}