fun main() {
    //Cosas a tener en cuenta, aunque el menú no diga nada, cuando añades un libro o borras o haces cualquier cosa, aunque no ponga nada, ningun print ni nada, lo está haciendo correctamente

    //Creamos los usuarios
    val listaUsuario = listOf(
     Usuario(nombre = "Elia"),
     Usuario(nombre = "Ale"),
     Usuario(nombre = "Oscar")
    )

    //Creamos los libros
    val listaLibro = listOf(
    Libro(titulo = "Los juguetes", autor =  "Yo", anioPublicacion =  22, tematica = "Miedo", estado = TipoEstado.DISPONIBLE),
    Libro(titulo = "Los Perros", autor = "Manuel jesus", anioPublicacion = 217, tematica = "Risa", estado = TipoEstado.DISPONIBLE),
    Libro(titulo = "Los Gatos", autor =  "Oscar", anioPublicacion =  2022, tematica = "Ficcion"),
    Libro(titulo = "Animales", autor =  "Alejandro", anioPublicacion =  2012, tematica = "Terror"),
    Libro(titulo = "Colores", autor =  "Manuel Bouza", anioPublicacion =  1982, tematica = "Ficcion"),
    Libro(titulo = "Risas fuertes", autor =  "Pedro picapiedras", anioPublicacion =  8, tematica = "Comedia"),
    Libro(titulo = "Bomba nuclear", autor =  "Jose raul", anioPublicacion =  99, tematica = "Intriga"),
    Libro(titulo = "Magia", autor =  "Hermenegildo", anioPublicacion =  1082, tematica = "Romance")
    )

    //Creamos las instancias necesarias para que funcione la biblioteca
    val catalogo = Catalogo()
    val biblioteca = GestorBiblioteca()

    //Visualizar propiedades privadas, descomentar si quieres ver
/*
    Consola.mostrarInfo(listaLibro.random().obtenerTitulo())
    Consola.mostrarInfo(listaLibro.random().obtenerTematica())
    Consola.mostrarInfo("${listaUsuario.random().obtenerid()}")
    Consola.mostrarInfo(listaUsuario.random().obtenerNombre())

 */
    /**
     * Menú que te deja interactuar de distintas maneras con la biblioteca
     */
    fun menu(){
        var pinguinito = true

        Consola.mostrarInfo("Bienvenido a esta maravillosa Biblioteca creada por Eliaser Pérez")
        do {
            Consola.mostrarInfo("Que deseas hacer?\n" +
                    "1-> Agregar un libro al catálogo.\n" +
                    "2-> Eliminar un libro del catálogo.\n" +
                    "3-> Realizar un préstamo.\n" +
                    "4-> Devolver un libro.\n" +
                    "5-> Consultar la disponibilidad de un libro. \n" +
                    "6-> Mostrar libros dependiendo de su estado (Disponibles, Prestados, Todos)\n" +
                    "7-> Salir."
            )
            val opciones = Consola.opciones(7)

            when (opciones){
                1-> biblioteca.agregar(listaLibro.random()) //Escoge un libro random de la lista y lo añade
                2-> biblioteca.eliminar(listaLibro.random()) //Lo mismo pero esta vez lo elimina de la lista
                3-> biblioteca.prestar(listaUsuario.random(), listaLibro.random()) //Escoge un usuario Random y un libro random para prestarle un libro a un usuario
                4-> biblioteca.devolver(listaUsuario.random(), listaLibro.random()) // Lo mismo pero devuelve un libro
                5-> biblioteca.consultarDisponibilidad(listaLibro.random())
                6-> Consola.mostrarLibros(catalogo, biblioteca) //Pequeño fallo aqui que no se porque, cuando quieres mirar todos los libros no te muestra ninguno, pero si que tiene, he usado el debugger y se agregan bien pero al mostrar TODOS los libros no muestra ninguno
                7-> pinguinito = false
            }

        }while ( pinguinito )
    }
    //Llamamos al menú para que funcione la biblioteca
    menu()

}