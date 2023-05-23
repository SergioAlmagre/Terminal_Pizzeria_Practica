package RespuestasTablasConexion

data class ResTabEsta(val numPedido:Int?,
                      val dniCliente:String?,
                      val nomCliente:String?,
                      val telefono:String?,
                      val mesa:Int?,
                      val total:Double?) {
    override fun toString(): String {
        return "Pedido Nº:$numPedido          DNI:$dniCliente                            Nombre:$nomCliente, telefono:$telefono, mesa:$mesa, total:$total)"
    }
}