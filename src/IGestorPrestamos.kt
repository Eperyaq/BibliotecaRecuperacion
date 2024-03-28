import java.util.UUID

/**
 * Interfaz creada para que las clases que necesiten estos metodos puedan heredar y asi cumplir un principio SOLID
 */
interface IGestorPrestamos {

    /**
     * Registra un prestamo
     * @param idElemento Id unico del elemento para registrarlo en condiciones
     * @param usuario Usuario al que se le va a prestar el elemento
     */
    fun registrarPrestamo(idElemento:UUID, usuario: Usuario)

    /**
     * Registra una devolucion
     * @param idElemento Id unico del elemento para registrarlo en condiciones
     * @param usuario Usuario al que se le va a prestar el elemento
     */
    fun registrarDevolucion(idElemento:UUID, usuario: Usuario)

    /**
     * Consulta el hisotrial de un elemento especifico
     * @param idElemento Id unico del elemento
     * @return Retorna una lista con el historial del elemento
     */
    fun consultarHistorialElemento(idElemento:UUID): List<Prestamo>

    /**
     * Consulta el historial de un usuario especifico
     * @param usuario Usuario al que se le va a consultar el historial
     * @return Retorna una lista con el historial del usuario
     */
    fun consultarHistorialUsuario(usuario: Usuario): List<Prestamo>

}