import java.util.UUID

/**
 * Clase la cual se encarga de registrar los prestamos de los elemento
 * Habiendo derivado esta de la interfaz IGestorPrestamos
 */
class RegistroPrestamos: IGestorPrestamos {

    //He tenido que cambiar esta clase casi entera porque si no al usar el IGestorPrestamos al ser un elemento y no un libro especifico si le paso por parametros el libro se quedaria
    //Capado solo a libros y necesitamos que sean libros, dvd, revistas, etc

    private val prestamosActuales = mutableMapOf<UUID, Usuario>() //uuid del libro y usuario
    private val historial = mutableListOf<Prestamo>()

    /**
     * Funcion que registra un prestamo
     * @param idElemento elemento que se añade al prestamo
     * @param usuario Usuario que toma prestado el libro
     */
    override fun registrarPrestamo( idElemento:UUID, usuario: Usuario ) {

        val prestamo = Prestamo(idElemento, usuario)

        prestamosActuales[idElemento] = usuario
        historial.add(prestamo)
    }

    /**
     * Funcion que realiza la accion de devolver un libro
     * @param usuario Usuario que devuelve el libro
     * @param idElemento elemento que es devuelto
     */
    override fun registrarDevolucion ( idElemento:UUID, usuario: Usuario ){
        val prestamo = Prestamo(idElemento, usuario)

        prestamosActuales.remove(idElemento)
        historial.add(prestamo) //el prestamos tambien se registra en el historial
    }

    /**
     * Consulta el historial especifico de un elemento
     * @param idElemento elemento que esta en el catalogo
     */
    override fun consultarHistorialElemento(idElemento: UUID): List<Prestamo> {

        return historial.filter { elemeto -> elemeto.id == idElemento }
    }

    /**
     * Historial especifico de un usuario
     * @param usuario Usuario al que se le mira el historial
     */
    override fun consultarHistorialUsuario(usuario: Usuario): List<Prestamo>{

       return historial.filter { elemento-> elemento.usuario == usuario }
    }


}