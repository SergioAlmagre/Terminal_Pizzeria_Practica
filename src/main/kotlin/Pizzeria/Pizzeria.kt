package Pizzeria

class Pizzeria {

    var direccion:String
    var telefono:String
    var pedidos:ArrayList<Pedido> = ArrayList()
    var turnos:ArrayList<Turno> = ArrayList()

    constructor(direccion: String, telefono: String) {
        this.direccion = direccion
        this.telefono = telefono
    }

}