/**
 * Clase que gestiona una lista de elementos de biblioteca.
 * siendo T el tipo de elementos que se van a gestionar, debe ser un subtipo de ElementoBiblioteca.
 */
class GestorElementos<T: ElementoBiblioteca> {

    val listaElemento = mutableListOf<T>()

    /**
     * Agrega un elemento a la lista de elementos
     * @param elemento Elemento a añadir en la lista
     */
    fun agregar( elemento: T ) {
        listaElemento.add(elemento)
    }

    /**
     * Elimina un elemento de la lista de elementos
     * @param elemento Elemento a eliminar de la lista
     */
    fun eliminar( elemento: T ) {
            listaElemento.remove(elemento)
    }

    /**
     * Retorna el contenido de la lista de los elementos
     */
    fun retornarElementos(): MutableList<T>{
        return listaElemento
    }

    /**
     * Filtra una lista de elementos dependiendo del criterio que des
     * @param elementos Lista de elementos a filtrar segun el criterio
     * @param criterio Criterio por el cual se va a filtrar la lista
     * @return Lista de elementos basada en el criterio dado
     */
    fun filtrarPorCriterio(elementos: List<T>, criterio: (T) -> Boolean): List<T>{
        return elementos.filter(criterio)
    }


}