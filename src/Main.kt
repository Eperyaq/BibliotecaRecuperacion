fun main() {

    //Creamos los libros
    val libro1 = Libro("1a","Los juguetes", "Yo", 22,"Miedo",TipoEstado.DISPONIBLE)
    val libro2 = Libro("12a","Los Perros", "Manuel jesus", 217,"Risa",TipoEstado.DISPONIBLE)
    val libro3 = Libro("111111b","Los Gatos", "Oscar", 2022,"Ficcion")
    val libro4 = Libro("14424F","Animales", "Alejandro", 2012,"Terror")
    val libro5 = Libro("12231J","Colores", "Manuel Bouza", 1982,"Ficcion")
    val libro6 = Libro("dqasd","Risas fuertes", "Pedro picapiedras", 8,"Comedia")
    val libro7 = Libro("Hola","Bomba nuclear", "Jose raul", 99,"Intriga")
    val libro8 = Libro("166ll","Magia", "Hermenegildo", 1082,"Romance")

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