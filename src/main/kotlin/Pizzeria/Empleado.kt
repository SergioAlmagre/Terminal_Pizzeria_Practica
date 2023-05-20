package Pizzeria



/**
 * Empleado
 *
 * @property nombre
 * @property apellido
 * @property telefono
 * @property dni
 * @property contraseña
 * @property tipo
 *           0 - empleado normal
 *           1 - Administrador
 * @property observaciones
 * @constructor Create empty Empleado
 */

class Empleado:Persona{

    var tipo:Int
    var contraseña: String
    var rutaFoto:String

    constructor(
        nombre: String,
        apellido: String,
        dni: String,
        telefono: String,
        observaciones: String,
        tipo: Int,
        contraseña: String,
        rutaFoto: String
    ) : super(nombre, apellido, dni, telefono, observaciones) {
        this.contraseña = contraseña
        this.tipo = tipo
        this.rutaFoto = rutaFoto
    }

    override fun toString(): String {
        return "Empleado ${super.toString()}, (contraseña='$contraseña', tipo=$tipo, rutaFoto='$rutaFoto')"
    }


}