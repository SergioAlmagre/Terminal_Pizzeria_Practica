package Pizzeria

/**
 *
 * Tamaños:
 * 0 - Pequeña
 * 1 - Mediana
 * 2 - Grande
 *
 * Tipos
 * 0 - Tropical
 * 1 - Marinera
 * 2 - Carbonara
 * 3 - 4 quesos
 * 4 - Especial de la casa
 *
 * Ingredientes extra:
 * 0 - Ninguno
 * 1 - Queso
 * 2 - Champiñon
 * 3 - Cebolla
 * 4 - Jamón
 * 5 - Rucula
 *
 * Especial:
 * 0 - Ninguno
 * 1 - Vegana
 * 2 - Cuadrada
 * 3 - Borde con queso
 * 4 - Sin gluten
 */


data class Pizza(
    var id:Int?,
    var nombre:String,
    var precio: Double,
    var tamaño: Int,
    var especial: Int,
    var ingredienteExtra: Int,
    var hora:String
) {


}