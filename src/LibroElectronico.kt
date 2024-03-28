import java.util.*

class LibroElectronico(private val id: UUID = UtilidadesBiblioteca.generarIdentificadorUnico(), private val titulo:String, private val estado: TipoEstado = TipoEstado.DISPONIBLE, private val formatoDigital:Boolean, private val tamanioArchivo:Int ): ElementoBiblioteca(id, titulo, estado) {

    /**
     * Obtienes el id del libro Electronico
     */
    override fun obtenerId() = id

    /**
     * Obtienes el titulo del libro Electronico
     */
    override fun obtenerTitulo() = titulo

    /**
     * Obtienes el estado del Libro Electronico
     */
    override fun obtenerEstado() = estado
}