import java.util.UUID

class RegistroPrestamos() {
    private val prestamosActuales = mutableListOf<Prestamo>()

    private val historial = mutableListOf<Prestamo>()

    /**
     * Funcion que registra un prestamo
     * @param libro Libro que se añade al prestamo
     * @param usuario Usuario que toma prestado el libro
     */
    fun registrarPrestamo(libro: Libro, usuario: Usuario){
        val prestamo = Prestamo(usuario, libro)

        prestamosActuales.add(prestamo)
        historial.add(prestamo)
    }

    /**
     * Funcion que realiza la accion de devolver un libro
     * @param usuario Usuario que devuelve el libro
     * @param libro Libro que es devuelto
     */
    fun devolverPrestamo(usuario: Usuario, libro: Libro){
        val prestamo = Prestamo(usuario, libro)

        prestamosActuales.remove(prestamo)
    }


    /**
     * Consulta el historial especifico de un usuario
     * @param libro Libro que esta en el catalogo
     */
    fun historialLibroEspecifico(libro: Libro): List<Prestamo> {

        return historial.filter { it.libro == libro }

    }

    /**
     * Historial especifico de un usuario
     * @param usuario Usuario al que se le mira el historial
     */
    fun historialPrestamoUsuario(usuario: Usuario): List<Prestamo>{

       return historial.filter { it.usuario == usuario }
    }


}