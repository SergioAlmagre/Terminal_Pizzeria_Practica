package RespuestasTablasConexion

data class ResumenPedido(var nombreCliente: String,
                         val apellido: String,
                         val dni: String,
                         val telefono: String,
                         val direccion: String,
                         var idPizza:Int,
                         var nombrePizza:String,
                         var tamaño: Int,
                         var especial: Int,
                         var ingredienteExtra: Int,
                         var numPedido:Int,
                         var fecha: String,
                         var hora:String,
                         var atendidoEnLocal:Int,
                         var mesa:Int,
                         var precioTotal:Double)
{


}