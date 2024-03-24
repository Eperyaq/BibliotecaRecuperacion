import java.util.UUID

class UtilidadesBiblioteca() {
    companion object{
        fun generarIdentificadorUnico():UUID{
            val UUID = UUID.randomUUID() //Generamos el UUID y lo retornamos
            return UUID
        }
    }

}