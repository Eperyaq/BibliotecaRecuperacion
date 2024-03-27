fun main() {
    //Cosas a tener en cuenta, aunque el menú no diga nada, cuando añades un libro o borras o haces cualquier cosa, aunque no ponga nada, ningun print ni nada, lo está haciendo correctamente

    //Creamos los usuarios
    val listaUsuario = listOf(
     Usuario(nombre = "Elia")
    )

    //Creamos los libros

    val listaElementos = listOf(
        Dvd(titulo="Escondite video"),
        Dvd(titulo = "Los chichos", estado = TipoEstado.DISPONIBLE),
        Libro(titulo = "Los juguetes", autor =  "Yo", anioPublicacion =  22, tematica = "Miedo", estado = TipoEstado.DISPONIBLE),
        Libro(titulo = "Los Gatos", autor =  "Oscar", anioPublicacion =  2022, tematica = "Ficcion"),
        Libro(titulo = "Magia", autor =  "Hermenegildo", anioPublicacion =  1082, tematica = "Romance")
    )



    //Creamos las instancias necesarias para que funcione la biblioteca
    val catalogo = Catalogo()
    val gestorBiblioteca = RegistroPrestamos() // Creamos una variable de una clase que haya heredado el Igestor para poder meterlo en el constructor de la biblioteca ya que un interfaz no se puede instanciar por si solo.
    val biblioteca = GestorBiblioteca(gestorBiblioteca,catalogo)



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
                    "1-> Agregar un elemento al catálogo.\n" +
                    "2-> Eliminar un elemento del catálogo.\n" +
                    "3-> Realizar un préstamo.\n" +
                    "4-> Devolver un elemento.\n" +
                    "5-> Consultar la disponibilidad de un elemento. \n" +
                    "6-> Mostrar elementos dependiendo de su estado (Disponibles, Prestados, Todos)\n" +
                    "7-> Mostrar historial Específico del Elemento\n" +
                    "8-> Mostrar historial específico del Usuario\n" +
                    "9-> Salir."
            )
            val opciones = Consola.opciones(9)

            when (opciones){
                1-> biblioteca.agregar(listaElementos.random()) //Escoge un elemento random de la lista y lo añade
                2-> biblioteca.eliminar(listaElementos.random()) //Lo mismo pero esta vez lo elimina de la lista
                3-> biblioteca.prestar(listaUsuario.random(), listaElementos.random()) //Escoge un usuario Random y un elemento random para prestarle un libro a un usuario
                4-> biblioteca.devolver(listaUsuario.random(), listaElementos.random()) // Lo mismo pero devuelve un libro
                5-> biblioteca.consultarDisponibilidad(listaElementos.random().obtenerId())
                6-> Consola.mostrarLibros(catalogo, biblioteca) //Pequeño fallo aqui que no se porque, cuando quieres mirar todos los libros no te muestra ninguno, pero si que tiene, he usado el debugger y se agregan bien pero al mostrar TODOS los libros no muestra ninguno
                7-> Consola.mostrarInfo("${gestorBiblioteca.consultarHistorialElemento(listaElementos.random().obtenerId())}")
                8-> Consola.mostrarInfo("${gestorBiblioteca.consultarHistorialUsuario(listaUsuario.random())}")
                9-> pinguinito = false
            }

        }while ( pinguinito )
    }
    //Llamamos al menú para que funcione la biblioteca
    menu()

    /*
        EJEMPLO QUE FUNCIONA 100%

        lo unico que en el menu al ser random no siempre cuadra

    val libro1 = Libro(titulo = "Magia", autor =  "Hermenegildo", anioPublicacion =  1082, tematica = "Romance")
    val dvd =  Dvd(titulo="Escondite video")

    biblioteca.agregar(libro1)
    biblioteca.agregar(dvd)

    biblioteca.prestar(listaUsuario.random(), libro1)


   Consola.mostrarInfo("${gestorBiblioteca.consultarHistorialElemento(libro1.obtenerId())}")
   Consola.mostrarInfo("${gestorBiblioteca.consultarHistorialUsuario(listaUsuario.random())}")

     */



}