import java.util.*

/**
 * Clase que representa a un catalogo Generico, que admite cualquier tipo de cosa siempre que sea un ElementoBiblioteca
 * @property gestorElementos Gestor de elementos inyectado para poder usarlo para agregar cosas al catalogo
 */
class Catalogo<T:ElementoBiblioteca>(private val gestorElementos:GestorElementos<T>): IGestorCatalogo<T>{

    /**
     * Agrega un libro al catalogo, a la lista con todos los libros del gestor de elementos
     * @param elemento el elemento a agregar al catalogo
     */
    override fun agregar(elemento: T) {
        //SRP hecho para que el catalogo se encargue de meter y sacar elementos de su propio catalogo asi gestorBiblioteca ya no lo tiene que hacer
            gestorElementos.agregar(elemento)
    }

    /**
     * Elimina un elemento del catalogo usando el gestor de elementos genérico
     * @param elemento el elemento a eliminar
     */
    override fun eliminar(elemento: T) {
            gestorElementos.eliminar(elemento)
    }


}