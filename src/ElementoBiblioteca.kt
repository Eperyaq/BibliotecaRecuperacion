import java.util.UUID

abstract class ElementoBiblioteca(private val id:UUID, private val titulo:String, private var estado: TipoEstado) {

    /**
     * Obtienes el Id del objeto
     */
     open fun obtenerId() = id

    /**
     * Obtienes el titulo del objeto
     */
    open fun obtenerTitulo() = titulo

    /**
     * Obtienes el estado del objeto
     */
    open fun obtenerEstado() = estado

    /**
     * Cambia el estado del elemento
     */
    fun cambiarEstado(nuevoEstado: TipoEstado){
      estado = nuevoEstado
    }
}