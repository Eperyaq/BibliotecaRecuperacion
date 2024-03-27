import java.util.UUID

class GestorBiblioteca(private val gestorPrestamo:IGestorPrestamos, private val catalogo: Catalogo) {

    /**
     * Agrega un libro al catalogo, a la lista con todos los libros
     * @param elemento el elemento a agregar al catalogo
     */
    fun agregar(elemento: ElementoBiblioteca) {
        //Se le deberia asignar un UUID aqui pero ya lo asigne en el libro, asi hago un poquito de SRP y esto solo controla las entradas y los prestamos
        // aunque falta por hacer SRP pero no me voy a adelantar
        if (elemento !in catalogo.listalibros) { // Comprueba que el libro no está en el catalogo, si no, lo añade
            catalogo.listalibros.add(elemento)
        } else {
            Consola.mostrarInfo("El elemento ya está en el catalogo")
        }

    }

    /**
     * Elimina un elemento del catalogo
     * @param elemento el elemento a eliminar
     */
    fun eliminar(elemento: ElementoBiblioteca) {
        if (elemento in catalogo.listalibros) {
            catalogo.listalibros.remove(elemento)
        } else {
            Consola.mostrarInfo("El elemento no está en el catálogo")
        }
    }

    /**
     * Realiza el préstamo de un libro, y por lo tanto cambia su estado pero no sin antes comprobarlo
     * @param usuario Usuario al que se le va a prestar el elemento
     * @param elemento elemento que se va a prestar
     */
    fun prestar(usuario: Usuario, elemento: ElementoBiblioteca) {

        if (elemento.obtenerEstado() == TipoEstado.DISPONIBLE) {
            elemento.cambiarEstado(TipoEstado.PRESTADO)

            gestorPrestamo.registrarPrestamo(elemento.obtenerId(), usuario)

            usuario.agregar(elemento) //se le agrega el libro al usuario que se le preste el libro

        } else {
            Consola.mostrarInfo("El elemento ya estaba prestado")
        }
    }

    /**
     * Realiza la devolucion de un elemento, y por lo tanto cambia su estado pero no sin antes comprobarlo
     * @param usuario Usuario que va a devolver el elemento
     * @param elemento Elemento que se va a devolver
     *
     */
    fun devolver(usuario: Usuario, elemento: ElementoBiblioteca) {

        if (elemento.obtenerEstado() == TipoEstado.PRESTADO) {
            elemento.cambiarEstado(TipoEstado.DISPONIBLE)

            gestorPrestamo.registrarDevolucion(elemento.obtenerId(), usuario)

            usuario.eliminar(elemento)
        } else {
            Consola.mostrarInfo("El Elemento ya estaba devuelto")
        }
    }

    /**
     * Consulta la disponibilidad del elemento
     * @param id id del elemento a comprobar
     */
    fun consultarDisponibilidad(id: UUID) {
        val elemento =
            catalogo.listalibros.find { elemento -> elemento.obtenerId() == id } //lambda que comprueba si el id del elemento es igual a algun id que este en catalogo

        if (elemento != null) {
            if (elemento.obtenerEstado() == TipoEstado.DISPONIBLE) {
                Consola.mostrarInfo("elemento disponible")
            }
        } else {
            Consola.mostrarInfo("elemento no Disponible")
        }
    }

    /**
     * Muestra todos los libros disponibles en ese momento
     */
    fun mostrarlibrosDisponibles() {

        val listaDisponibles = mutableListOf<ElementoBiblioteca>()

        val disponibles =
            catalogo.listalibros.filter { libroDispo -> libroDispo.obtenerEstado() == TipoEstado.DISPONIBLE }

        listaDisponibles.addAll(disponibles)

        for (libro in listaDisponibles) {
            Consola.mostrarInfo("$libro")
        }

    }

    /**
     * Muestra los libros que no están disponibles
     */
    fun mostrarlibrosPrestados() {

        val listaPrestados = mutableListOf<ElementoBiblioteca>()

        val disponibles =
            catalogo.listalibros.filter { libroNoDispo -> libroNoDispo.obtenerEstado() == TipoEstado.PRESTADO }

        listaPrestados.addAll(disponibles)

        for (libro in listaPrestados) {
            Consola.mostrarInfo("$libro")
        }

    }



}