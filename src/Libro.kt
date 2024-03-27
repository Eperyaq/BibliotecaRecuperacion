import java.util.UUID

/**
 * Clase de datos que representa un libro.
 *
 * Esta clase contiene información sobre un libro, incluyendo su identificador, título, autor,
 * año de publicación, temática y estado.
 *
 * @property id El identificador único del libro.
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property anioPublicacion El año de publicación del libro.
 * @property tematica La temática o género del libro.
 * @property estado El estado del libro, que puede ser uno de los tipos de [TipoEstado].
 * @constructor Crea un nuevo libro con el ID, título, autor, año de publicación, temática y estado dados.
 */
data class Libro(val id: UUID = UtilidadesBiblioteca.generarIdentificadorUnico(),
                 private val titulo:String, private val autor:String,
                 private val anioPublicacion:Int,
                 private val tematica:String,
                 var estado: TipoEstado = TipoEstado.DISPONIBLE): ElementoBiblioteca(id, titulo, estado), Prestable {

    init {
        require(titulo.isNotEmpty()){"El titulo no puede estar vacio"}
        require(autor.isNotEmpty()){"El autor no puede estar vacio"}
        require(anioPublicacion in 1..2024){"El año de publicacion debe estar entre 1 y 2024"}
        require(tematica.isNotEmpty()){"El id no puede estar vacio"}
        require(estado == TipoEstado.PRESTADO || estado == TipoEstado.DISPONIBLE){"El estado debe ser o PRESTADO o DISPONIBLE"}
    }

    /**
     * obtiene el titulo
     */
    override fun obtenerTitulo() = titulo

    /**
     * obtiene el año de publicacion
     */
    fun obtenerAnioPublicacion() = anioPublicacion

    /**
     * obtiene la tematica del libro
     */
    fun obtenerTematica() = tematica

    /**
     * Realiza la accion de prestar un libro lo que cambia su estado de Disponible a prestado
     */
    override fun prestar() {
        if ( estado == TipoEstado.DISPONIBLE ){
            estado = TipoEstado.PRESTADO
        } else {
            Consola.mostrarInfo("Ya prestado" )
        }
    }

    /**
     * Realiza la accion de devolver un libro lo que cambia su estado de Prestado a disponible
     */
    override fun devolver() {
        if ( estado == TipoEstado.PRESTADO ) {
             estado = TipoEstado.DISPONIBLE
        } else {
            Consola.mostrarInfo("Ya devuelto")
        }
    }
}