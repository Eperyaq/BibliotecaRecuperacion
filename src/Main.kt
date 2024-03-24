fun main() {

    //Creamos los libros
    val libro1 = Libro(titulo = "Los juguetes", autor =  "Yo", anioPublicacion =  22, tematica = "Miedo", estado = TipoEstado.DISPONIBLE)
    val libro2 = Libro(titulo = "Los Perros", autor = "Manuel jesus", anioPublicacion = 217, tematica = "Risa", estado = TipoEstado.DISPONIBLE)
    val libro3 = Libro(titulo = "Los Gatos", autor =  "Oscar", anioPublicacion =  2022, tematica = "Ficcion")
    val libro4 = Libro(titulo = "Animales", autor =  "Alejandro", anioPublicacion =  2012, tematica = "Terror")
    val libro5 = Libro(titulo = "Colores", autor =  "Manuel Bouza", anioPublicacion =  1982, tematica = "Ficcion")
    val libro6 = Libro(titulo = "Risas fuertes", autor =  "Pedro picapiedras", anioPublicacion =  8, tematica = "Comedia")
    val libro7 = Libro(titulo = "Bomba nuclear", autor =  "Jose raul", anioPublicacion =  99, tematica = "Intriga")
    val libro8 = Libro(titulo = "Magia", autor =  "Hermenegildo", anioPublicacion =  1082, tematica = "Romance")

    //Creamos las instancias necesarias para que funcione la biblioteca
    val catalogo = Catalogo()
    val prestamos = RegistroPrestamos()
    val biblioteca = GestorBiblioteca(catalogo, prestamos)

    //Agregamos los libros a la biblioteca
    biblioteca.agregar(libro1, catalogo)
    biblioteca.agregar(libro2, catalogo)
    biblioteca.agregar(libro3, catalogo)
    biblioteca.agregar(libro4, catalogo)
    biblioteca.agregar(libro5, catalogo)
    biblioteca.agregar(libro6, catalogo)
    biblioteca.agregar(libro7, catalogo)
    biblioteca.agregar(libro8, catalogo)

    //Realizamos los prestamos
    biblioteca.prestar(libro2)
    biblioteca.prestar(libro1)
    biblioteca.prestar(libro1)//Repetido para que salga mal a posta


    //Realizamos las devoluciones
    biblioteca.devolver(libro1)
    biblioteca.devolver(libro2)
    biblioteca.devolver(libro1)//Erroneo a posta

    //Borro algunos libros
    biblioteca.eliminar(libro3, catalogo)
    biblioteca.eliminar(libro4, catalogo)
    biblioteca.eliminar(libro5, catalogo)


    Consola.mostrarLibros(catalogo, biblioteca)


    /* mas adelante cuando busquemos los libros por ID
    fun menu(){
        val pinguinito = true

        Consola.mostrarInfo("Bienvenido a esta maravillosa Biblioteca creada por Eliaser Pérez")
        do {
            Consola.mostrarInfo("Que deseas hacer?\n" +
                    "1-> Agregar un libro al catálogo.\n" +
                    "2-> Eliminar un libro del catálogo.\n" +
                    "3-> Realizar un préstamo.\n" +
                    "4-> Devolver un libro.\n" +
                    "5-> Consultar la disponibilidad de un libro. \n" +
                    "6-> Mostrar libros dependiendo de su estado (Disponibles, Prestados, Todos)\n" +
                    "7-> Salir.")

            val opciones =Consola.opciones(7)

            when (opciones){
                1-> biblioteca.agregar()
            }

        }while (pinguinito)


    }

     */
}