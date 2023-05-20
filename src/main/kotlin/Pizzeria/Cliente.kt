package Pizzeria

class Cliente:Persona{

    val direccion: String
    constructor(
        nombre: String,
        apellido: String,
        dni: String,
        telefono: String,
        observaciones: String,
        direccion: String
    ) : super(nombre, apellido, dni, telefono, observaciones) {
        this.direccion = direccion
    }

    override fun toString(): String {
        return "${super.toString()},  Cliente(direccion='$direccion')"
    }


}