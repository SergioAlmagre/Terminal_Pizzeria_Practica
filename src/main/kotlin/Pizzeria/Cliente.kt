package Pizzeria

class Cliente: Persona {

    val direccion: String

    constructor(
        nombre: String,
        apellido: String,
        dni: String,
        telefono: String,
        direccion: String,
        observaciones: String
    ) : super(nombre, apellido, telefono, dni, observaciones) {
        this.direccion = direccion
    }


    override fun toString(): String {
        return "${super.toString()},  Cliente(direccion='$direccion')"
    }


}