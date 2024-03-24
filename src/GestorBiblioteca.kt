class GestorBiblioteca(catalogo: Catalogo, prestamos: RegistroPrestamos) {

    /**
     * Agrega un libro al catalogo, a la lista con todos los libros
     * @param libro el libro a agregar al catalogo
     * @param catalogo el catalogo al que se esta agregando el libro
     */
    fun agregar(libro: Libro, catalogo: Catalogo) {
        catalogo.listalibros.add(libro)
    }

    /**
     * Elimina un libro del catalogo
     * @param libro el libro a eliminar
     * @param catalogo el catalogo del que se elimina el libro.
     */
    fun eliminar(libro: Libro, catalogo: Catalogo){
        catalogo.listalibros.remove(libro)
    }

    /**
     * Realiza el préstamo de un libro, y por lo tanto cambia su estado pero no sin antes comprobarlo
     * @param libro Libro que se va a prestar
     * @param prestamos Lugar donde se quedan los prestamos archivados
     */
    fun prestar(libro: Libro){
        if (libro.estado == TipoEstado.DISPONIBLE){
            libro.estado = TipoEstado.PRESTADO
        }else{
            Consola.mostrarInfo("El libro ya estaba prestado")
        }
    }

    /**
     * Realiza la devolucion de un libro, y por lo tanto cambia su estado pero no sin antes comprobarlo
     * @param libro Libro que se va a devolver
     * @param prestamos Lugar donde se quedan los prestamos archivados
     */
    fun devolver(libro: Libro){
        if (libro.estado == TipoEstado.PRESTADO){
            libro.estado = TipoEstado.DISPONIBLE
        }else{
            Consola.mostrarInfo("El libro ya estaba devuelto")
        }
    }

    /**
     * Consulta la disponibilidad del libro si es True, el libro está disponible, si no, no lo está
     * @param libro libro a comprobar
     * @param catalogo lugar en el que mirar si esta el [libro]
     */
    fun consultarDisponibilidad(libro: Libro, catalogo: Catalogo)= libro in catalogo.listalibros //True, si esta, False no esta


    fun mostrarlibrosDisponibles(catalogo: Catalogo){

        val listaDisponibles = mutableListOf<Libro>()

         val disponibles = catalogo.listalibros.filter { libroDispo -> libroDispo.estado == TipoEstado.DISPONIBLE }

        listaDisponibles.addAll(disponibles)

        for (libro in listaDisponibles){
            Consola.mostrarInfo("$libro")
        }

    }

    fun mostrarlibrosPrestados(catalogo: Catalogo){

        val listaPrestados = mutableListOf<Libro>()

        val disponibles = catalogo.listalibros.filter { libroDispo -> libroDispo.estado == TipoEstado.PRESTADO }

        listaPrestados.addAll(disponibles)

        for (libro in listaPrestados){
            Consola.mostrarInfo("$libro")
        }

    }

}