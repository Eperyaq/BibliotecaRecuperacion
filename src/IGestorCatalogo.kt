import java.util.UUID

//La he hecho ahora porque no entendí bien el enunciado
/**
 * Interfaz para las operaciones básicas de un catalogo
 */
interface IGestorCatalogo<T: ElementoBiblioteca> {

    /**
     * Agrega un elemento al catálogo
     * @param elemento Elemento a añadir al catalogo
     */
    fun agregar(elemento:T)

    /**
     * Elimina un elemento del catalogo basandose en el elemento
     * @param elemento Elemento a eliminar del gestor
     */
    fun eliminar(elemento: T)

}