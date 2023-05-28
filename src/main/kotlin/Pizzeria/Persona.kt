package Pizzeria

open class Persona{
    val nombre: String
    val apellido: String
    val telefono: String
    val dni: String
    var observaciones: String

    constructor(nombre: String, apellido: String, telefono: String, dni: String, observaciones: String) {
        this.nombre = nombre
        this.apellido = apellido
        this.telefono = telefono
        this.dni = dni
        this.observaciones = observaciones
    }


    override fun toString(): String {
        return "Persona(nombre='$nombre', apellido='$apellido', telefono='$telefono', dni='$dni', observaciones='$observaciones')"
    }


}

