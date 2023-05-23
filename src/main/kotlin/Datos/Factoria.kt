package Datos

import Personas.Cliente
import Personas.Empleado
import kotlin.random.Random

object Factoria {


    fun factoriaCliente(): Cliente {

        val nombres = listOf("Juan", "Ana", "Pedro", "Lucía", "Sofía", "Miguel", "Laura", "Luis", "María", "Carlos")
        val apellidos = listOf("García", "Fernández", "Martínez", "González", "López", "Pérez", "Rodríguez", "Sánchez", "Romero", "Álvarez")
        val letras = listOf("A","B","C","D","E","F","G","H","I")
        val direcciones = listOf("Calle Mayor, 10", "Avenida del Mar, 25", "Plaza España, 8", "Callejón de los Suspiros, 5", "Paseo del Prado, 20", "Calle del Sol, 17", "Calle de las Flores, 2", "Callejón del Gato, 13", "Calle del Agua, 7", "Paseo de la Castellana, 50")
        val observacionesList = listOf("Cliente habitual", "Pendiente de pago", "Pedido especial", "Sin gluten", "Sin lactosa", "Con alergia a los frutos secos", "Vegano", "Vegetariano", "Cliente nuevo", "Pedido grande")


        val nombre = nombres[Random.nextInt(0,nombres.size)]
        val apellido = apellidos[Random.nextInt(0,apellidos.size)]
        val dni = Random.nextInt(1000000,99999999).toString() + letras[Random.nextInt(0,letras.size)]
        val telefono = Random.nextInt(600000000,699999999).toString()
        val direccion = direcciones[Random.nextInt(0,direcciones.size)]
        val observaciones = observacionesList[Random.nextInt(0,observacionesList.size)]
        val cliente = Cliente(nombre, apellido, dni, telefono, direccion, observaciones)
        println(cliente)
        return cliente

    }


    fun factoriaEmpleado(): Empleado {

        val nombres = listOf("Juan", "Pedro", "Lucía", "María", "Pablo", "Ana", "Luis", "Laura", "Miguel", "Jorge")
        val apellidos = listOf("Gómez", "Martínez", "Fernández", "Rodríguez", "García", "Pérez", "Sánchez", "Jiménez", "Alonso", "Gutiérrez")
        val telefono = Random.nextInt(600000000,699999999).toString()
        val contraseñas = "1234"
        val tipos = listOf(0, 1) // supongamos que el tipo puede ser 1, 2 o 3
        val observaciones = listOf("Cliente habitual", "Buen vendedor", "Muy puntual", "Habla varios idiomas", "Siempre llega tarde")
        val rutasFoto = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

        return Empleado(
            nombres.random(),
            apellidos.random(),
            telefono,
            "${Random.nextInt(10000000, 99999999)}",
            contraseñas,
            tipos.random(),
            observaciones.random(),
            rutasFoto.random()
        )
    }



}