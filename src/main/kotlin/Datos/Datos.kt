package Datos

import BBDD.Conexion
import Personas.Cliente
import Personas.Empleado
import RespuestasTablasConexion.ResumenPedido
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDate
import java.time.LocalTime

object Datos {

        var emple: Empleado? = null
        var cli: Cliente? = null
        var resu: ResumenPedido? = null



        var mensaje = ""

        fun guardarBitacoraPedidos(mensaje:String){
                try {
                        var fechaActual = LocalDate.now().toString()
                        var horaActual = LocalTime.now().toString().substring(0,8)
                        var texto = FileWriter("BitacoraDePedidos.log", true)
                        texto.write(fechaActual +" - "+ horaActual + " - " + mensaje + "\r\n")
                        texto.close()
                }catch (e: IOException){
                        println(e)
                }catch (e:Exception){
                        println(e)
                }
        }

        fun guardarBitacoraErrores(mensaje: String){
                try {
                        var fechaActual = LocalDate.now().toString()
                        var horaActual = LocalTime.now().toString().substring(0,8)
                        var texto = FileWriter("BitacoraDeErrores.log", true)
                        texto.write(fechaActual + " - " + horaActual + " - " + mensaje + "\r\n")
                        texto.close()
                }catch (e: IOException){
                        println(e)
                }catch (e:Exception){
                        println(e)
                }
        }

        fun gestionErrores(e:Exception,informacion:String){
                var fechaActual = LocalDate.now().toString()
                var horaActual = LocalTime.now().toString().substring(0,8)
                mensaje = fechaActual+" - " + horaActual +" - " + e.toString()+" - "+informacion
//                Mensaje.automatico(-1) ESTO SON LATIGAZOS IGUALMENTE, PERO BUENO...LO PREGUNTO CUANTO DE MAL ESTA
                guardarBitacoraErrores(mensaje)
                Conexion.cod = -1
                println(mensaje)
        }


}