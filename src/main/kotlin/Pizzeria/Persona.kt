package Pizzeria

open class Persona{
    val nombre: String
    val apellido: String
    val dni: String
    val telefono: String
    var observaciones: String

    constructor(nombre: String, apellido: String, dni: String, telefono: String, observaciones: String) {
        this.nombre = nombre
        this.apellido = apellido
        this.dni = dni
        this.telefono = telefono
        this.observaciones = observaciones
    }
}

