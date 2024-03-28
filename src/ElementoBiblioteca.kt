import java.util.UUID

/**
 * Clase abstracta creada para que los elementos puedan heredar de este
 * @property id ID unico
 * @property titulo Titulo del elemento
 * @property estado Estado del elemento, disponible o prestado
 */
abstract class ElementoBiblioteca(private val id:UUID, private val titulo:String, private var estado: TipoEstado = TipoEstado.DISPONIBLE) {

    /**
     * Obtienes el Id del elemento
     */
     open fun obtenerId() = id

    /**
     * Obtienes el titulo del elemento
     */
    open fun obtenerTitulo() = titulo

    /**
     * Obtienes el estado del elemento
     */
    open fun obtenerEstado() = estado

    /**
     * Cambia el estado del elemento
     */
    fun cambiarEstado(nuevoEstado: TipoEstado){
      estado = nuevoEstado
    }
}