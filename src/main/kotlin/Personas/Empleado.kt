package Personas


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

class Empleado: Persona {

    var tipo:Int
    var contraseña: String
    var rutaFoto:String

    constructor(
        nombre: String,
        apellido: String,
        telefono: String,
        dni: String,
        contraseña: String,
        tipo: Int,
        observaciones: String,
        rutaFoto: String
    ) : super(nombre, apellido, telefono, dni, observaciones) {
        this.tipo = tipo
        this.contraseña = contraseña
        this.rutaFoto = rutaFoto
    }


    override fun toString(): String {
        return "Empleado ${super.toString()}, (contraseña='$contraseña', tipo=$tipo, rutaFoto='$rutaFoto')"
    }


}