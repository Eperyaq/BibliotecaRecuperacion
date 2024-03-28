import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GestorElementosTest<T:ElementoBiblioteca> {



    @Test
    fun agregar() {
        // Creamos los elementos a agregar
        val dvd =Dvd(titulo="Escondite video", duracion = 20.5, genero = "Horror")
        val gestor = GestorElementos<ElementoBiblioteca>()

        //Agregamos
        gestor.agregar(dvd)

        //Comprobamos
        assertEquals(1 , gestor.listaElemento.size)
    }

    @Test
    fun eliminar(){
        //Creamos los elementos a agregar
        val dvd =Dvd(titulo="Escondite video", duracion = 20.5, genero = "Horror")
        val libro = Libro(titulo = "Los juguetes", autor =  "Yo", anioPublicacion =  22, tematica = "Miedo", estado = TipoEstado.DISPONIBLE)
        val revista = Revista(titulo = "El mundo", edicion = "34 edicion", tematica = "Lloros")

        //Creamos el gestor
        val gestor = GestorElementos<ElementoBiblioteca>()

        //Agregamos y eliminamos para que el test funcione
        gestor.agregar(dvd)
        gestor.agregar(libro)
        gestor.agregar(revista)
        gestor.eliminar(dvd)


        //Comprobamos
        assertEquals(2 , gestor.listaElemento.size)

    }


}