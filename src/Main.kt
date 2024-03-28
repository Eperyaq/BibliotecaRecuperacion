fun main() {
    /*
   Integrar la jerarquía de clases con el sistema de gestión existente,
    permitiendo que GestorBiblioteca interactúe con el Catalogo para realizar operaciones sobre ítems de la biblioteca.

    el GestorBiblioteca ya tiene acceso al catalogo gracias a GestorElementos, deberia inyectarle igualmente el catalogo? de hecho el catalogo agrega las cosas al gestor de los elementos

    */

    //Creamos los usuarios
    val listaUsuario = listOf(
     Usuario(nombre = "Elia"),
     Usuario(nombre = "Ale"),
     Usuario(nombre = "Pedro")
    )

    //Creamos los libros

    val listaElementos = listOf(
        Dvd(titulo="Escondite video", duracion = 20.5, genero = "Horror"),
        Dvd(titulo = "Los chichos", estado = TipoEstado.DISPONIBLE, duracion = 15.0, genero = "Risa"),
        Libro(titulo = "Los juguetes", autor =  "Yo", anioPublicacion =  22, tematica = "Miedo", estado = TipoEstado.DISPONIBLE),
        Libro(titulo = "Los Gatos", autor =  "Oscar", anioPublicacion =  2022, tematica = "Ficcion"),
        LibroElectronico(titulo = "HolaMundo", formatoDigital = true, tamanioArchivo = 55)
    )



    //Creamos las instancias necesarias para que funcione la biblioteca
    val gestorElementos = GestorElementos<ElementoBiblioteca>()
    val gestorBiblioteca = RegistroPrestamos() // Creamos una variable de una clase que haya heredado el Igestor para poder meterlo en el constructor de la biblioteca ya que un interfaz no se puede instanciar por si solo.
    val biblioteca = GestorBiblioteca(gestorBiblioteca,gestorElementos)


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
                    "5-> Salir"
            )
            val opciones = Consola.opciones(5)

            when (opciones){
                1-> gestorElementos.agregar(listaElementos.random()) //Escoge un elemento random de la lista y lo añade
                2-> gestorElementos.eliminar(listaElementos.random()) //Lo mismo pero esta vez lo elimina de la lista
                3-> biblioteca.prestar(listaUsuario.random(), listaElementos.random()) //Escoge un usuario Random y un elemento random para prestarle un libro a un usuario
                4-> biblioteca.devolver(listaUsuario.random(), listaElementos.random()) // Lo mismo pero devuelve un libro
                5-> pinguinito = false
            }

        }while ( pinguinito )
    }
    //Llamamos al menú para que funcione la biblioteca
    menu()
}