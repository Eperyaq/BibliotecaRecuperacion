import java.util.UUID

/**
 * Clase que se encarga de proporcionar un ID unico gracias a su método
 */
class UtilidadesBiblioteca() {
    companion object{
        fun generarIdentificadorUnico():UUID{
            val UUID = UUID.randomUUID() //Generamos el UUID y lo retornamos
            return UUID
        }
    }

}