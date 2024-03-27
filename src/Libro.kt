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
                 var estado: TipoEstado = TipoEstado.DISPONIBLE){

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
    fun obtenerTitulo() = titulo

    /**
     * obtiene el año de publicacion
     */
    fun obtenerAnioPublicacion() = anioPublicacion

    /**
     * obtiene la tematica del libro
     */
    fun obtenerTematica() = tematica
}