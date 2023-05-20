package Pizzeria

/**
 * Turno
 * horario:
 * 0 - Mañanas
 * 1 - Tardes
 * 2 - Noches
 * @constructor Create empty Turno
 */
class Turno {
    var horario:Int
    var empleado: Empleado
    var fecha:String

    constructor(horario: Int, empleado:Empleado, fecha:String) {
        this.horario = horario
        this.empleado = empleado
        this.fecha = fecha
    }
}