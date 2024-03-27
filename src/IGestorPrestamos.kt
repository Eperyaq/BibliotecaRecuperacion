import java.util.UUID

interface IGestorPrestamos {

    fun registrarPrestamo(idElemento:UUID, usuario: Usuario)

    fun registrarDevolucion(idElemento:UUID, usuario: Usuario)

    fun consultarHistorialElemento(idElemento:UUID): List<Prestamo>

    fun consultarHistorialUsuario(usuario: Usuario): List<Prestamo>

}