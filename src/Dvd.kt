import java.util.UUID

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
    override fun toString(): String {
        return "Id: $id, titulo: $titulo, estado: $estado"
    }
}