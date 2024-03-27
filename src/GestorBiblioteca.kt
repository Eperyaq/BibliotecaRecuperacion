class GestorBiblioteca() {
    private val catalogo = Catalogo()
    private val prestamos = RegistroPrestamos()

    /**
     * Agrega un libro al catalogo, a la lista con todos los libros
     * @param libro el libro a agregar al catalogo
     * @param catalogo el catalogo al que se esta agregando el libro
     */
    fun agregar(libro: Libro) {
        //Se le deberia asignar un UUID aqui pero ya lo asigne en el libro, asi hago un poquito de SRP y esto solo controla las entradas y los prestamos
        // aunque falta por hacer SRP pero no me voy a adelantar
        if (libro !in catalogo.listalibros){ // Comprueba que el libro no está en el catalogo, si no, lo añade
            catalogo.listalibros.add(libro)
        }else{
            Consola.mostrarInfo("El libro ya está en el catalogo")
        }

    }

    /**
     * Elimina un libro del catalogo
     * @param libro el libro a eliminar
     */
    fun eliminar(libro: Libro){
        if (libro in catalogo.listalibros){
            catalogo.listalibros.remove(libro)
        }else{
            Consola.mostrarInfo("El libro no está en el catálogo")
        }
    }

    /**
     * Realiza el préstamo de un libro, y por lo tanto cambia su estado pero no sin antes comprobarlo
     * @param libro Libro que se va a prestar
     * @param prestamos Lugar donde se quedan los prestamos archivados
     */
    fun prestar(usuario:Usuario, libro: Libro){

        if (libro.estado == TipoEstado.DISPONIBLE){

            libro.estado = TipoEstado.PRESTADO

            prestamos.registrarPrestamo(libro, usuario)// con este se mete en el historial y en el otro

        }else{
            Consola.mostrarInfo("El libro ya estaba prestado")
        }
    }

    /**
     * Realiza la devolucion de un libro, y por lo tanto cambia su estado pero no sin antes comprobarlo
     * @param libro Libro que se va a devolver
     * @param prestamos Lugar donde se quedan los prestamos archivados
     */
    fun devolver(usuario: Usuario, libro: Libro){

        if (libro.estado == TipoEstado.PRESTADO){
            libro.estado = TipoEstado.DISPONIBLE

            prestamos.devolverPrestamo(usuario, libro)
        }else{
            Consola.mostrarInfo("El libro ya estaba devuelto")
        }
    }

    /**
     * Consulta la disponibilidad del libro si es True, el libro está disponible, si no, no lo está
     * @param libro libro a comprobar
     * @param catalogo lugar en el que mirar si esta el [libro]
     */
    fun consultarDisponibilidad( libro: Libro ){
        if ( libro in catalogo.listalibros ) {
            Consola.mostrarInfo("Libro encontrado")
        } else {
            Consola.mostrarInfo("Libro no encontrado")
        }
    } //True, si esta, False no esta

    /**
     * Muestra todos los libros disponibles en ese momento
     * @param catalogo Lugar donde se guardan los libros
     */
    fun mostrarlibrosDisponibles(){

        val listaDisponibles = mutableListOf<Libro>()

         val disponibles = catalogo.listalibros.filter { libroDispo -> libroDispo.estado == TipoEstado.DISPONIBLE }

        listaDisponibles.addAll(disponibles)

        for (libro in listaDisponibles){
            Consola.mostrarInfo("$libro")
        }

    }

    /**
     * Muestra los libros que no están disponibles
     * @param catalogo lugar donde se guardan los libros
     */
    fun mostrarlibrosPrestados(){

        val listaPrestados = mutableListOf<Libro>()

        val disponibles = catalogo.listalibros.filter { libroNoDispo -> libroNoDispo.estado == TipoEstado.PRESTADO }

        listaPrestados.addAll(disponibles)

        for (libro in listaPrestados){
            Consola.mostrarInfo("$libro")
        }

    }

    /**
     * Muestra el historial del libro llamando a la funcion necesaria
     * @param usuario Usuario al que se le va a mirar el historial
     */
    fun mostrarHistorialUsuario(usuario: Usuario){

        prestamos.historialPrestamoUsuario(usuario)
    }

    /**
     * Muestra el historial del libro especifico llamando a la funcion necesaria
     * @param libro Libro del que se va a mostrar en el historial
     */
    fun mostrarHistorialLibro(libro: Libro){

        prestamos.historialLibroEspecifico(libro)
    }
}