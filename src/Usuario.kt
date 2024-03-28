/**
 * Clase que representa a un usuario de la biblioteca.
 *
 * Esta clase contiene información sobre un usuario, incluyendo su identificador, nombre y
 * la lista de libros que ha prestado.
 *
 * @property id El identificador único del usuario.
 * @property nombre El nombre del usuario.
 * @property listaElementosPrestados La lista de elementos que ha prestado el usuario.
 * @constructor Crea un nuevo usuario con el ID, nombre y lista de libros prestados dados.
 */
class Usuario(private val nombre:String, private val listaElementosPrestados:MutableList<ElementoBiblioteca>) {

    private var id = nuevoId() // Lo pongo aqui para que no haga falta que se le de un ID al usuario y que asi sea automático
    companion object{
        private var id:Int = 1
        fun nuevoId():Int{
            return id++
        }

        //Companion object creado para que cada vez que se instancie un usuario le de un ID nuevo y que asi no se repitan
    }
    /**
     * Constructor para instanciar un objeto usando solo el nombre
     * @param nombre del usuario
     */
    constructor(nombre: String): this(nombre, mutableListOf())

    /**
     * Agrega un elemento a la lista de elementos prestados de este usuario
     * @param elemento que se le presta al usuario
     */
    fun agregar(elemento:ElementoBiblioteca){
        listaElementosPrestados.add(elemento)
    }

    /**
     * Elimina un libro de la lista de elementos prestados de este usuario
     * @param elemento el elemento que se elimina de la lista
     */
    fun eliminar(elemento: ElementoBiblioteca){
        listaElementosPrestados.remove(elemento)
    }

    /**
     * Muestra los elementos que tiene en propiedad este usuario
     */
    fun consultarLibrosPrestados(){
        Consola.mostrarInfo("$listaElementosPrestados")
    }

    /**
     * Obtienes el id del usuario
     */
    fun obtenerid() = id

    /**
     * Obtienes el nombre del usuario
     */
    fun obtenerNombre() = nombre

    /**
     * ToString modificado para que salga este cada vez que se printee
     */
    override fun toString(): String {
        return "Id: $id,Nombre: $nombre, Lista libros: $listaElementosPrestados"
    }
}