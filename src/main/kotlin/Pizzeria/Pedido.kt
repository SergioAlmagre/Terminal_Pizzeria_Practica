package Pizzeria

/**
 * atendidoEnLocal:
 * 0 - No, a domicilio
 * 1 - Si, en local
 *
 * mesa:
 * 0 - En domicilio
 *
 *
 */
class Pedido {

    var numPedido:Int?
    var telefonoCliente:String
    var fecha: String
    var hora:String
    var idPizza:Int
    var tiempoEspera:Double?
    var precioTotal:Double
    var atendidoEnLocal:Int
    var mesa:Int

    constructor(
        numPedido: Int?,
        telefonoCliente: String,
        fecha: String?,
        hora: String?,
        idPizza: Int,
        tiempoEspera: Double?,
        precioTotal: Double,
        atendidoEnLocal: Int,
        mesa: Int
    ) {
        this.numPedido = numPedido
        this.telefonoCliente = telefonoCliente
        this.fecha = fecha!!
        this.hora = hora!!
        this.idPizza = idPizza
        this.tiempoEspera = tiempoEspera
        this.precioTotal = precioTotal
        this.atendidoEnLocal = atendidoEnLocal
        this.mesa = mesa
    }

    override fun toString(): String {
        return "Pedido(numPedido=$numPedido, telefonoCliente='$telefonoCliente', fecha='$fecha', hora='$hora', idPizza=$idPizza, tiempoEspera=$tiempoEspera, precioTotal=$precioTotal, atendidoEnLocal=$atendidoEnLocal, mesa=$mesa)"
    }


}