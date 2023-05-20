package BBDD

import Datos.Factoria
import Pizzeria.*
import Utilidades.Mensaje
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.time.LocalDate
import java.time.LocalTime

object Conexion {

    // ********************* Atributos *************************
    var conexion: Connection? = null

    // Atributo a través del cual hacemos la conexión física.
    var sentenciaSQL: Statement? = null

    // Atributo que nos permite ejecutar una sentencia SQL
    var registros: ResultSet? = null


    fun abrirConexion(): Int {
        var cod = 0
        try {
            // Cargar el driver/controlador JDBC de MySql
            val controlador = "com.mysql.cj.jdbc.Driver"
            val URL_BD = "jdbc:mysql://" + Constantes.servidor + ":" + Constantes.puerto + "/" + Constantes.bbdd
            Class.forName(controlador)

            // Realizamos la conexión a una BD con un usuario y una clave.
            conexion = DriverManager.getConnection(URL_BD, Constantes.usuario, Constantes.passwd)
            sentenciaSQL = conexion!!.createStatement()
//            println("Conexion realizada con éxito")
        } catch (e: Exception) {
            println("Exception: " + e.message)
            cod = -1
        }
        return cod
    }

    fun cerrarConexion(): Int {
        var cod = 0
        try {
            conexion!!.close()

        } catch (ex: Exception) {
            println("Error al cerrar la conexión.")
            cod = -1
        }
        return cod
    }

    fun obtenerClienteDni(dni:String): Cliente? {
        var sentencia = "select * from cliente where dni = ?"
        var cli:Cliente? = null
        try{
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,dni)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                cli = Cliente(
                registros!!.getString(1),
                registros!!.getString(2),
                registros!!.getString(3),
                registros!!.getString(4),
                registros!!.getString(5),
                registros!!.getString(6),
                )}
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido un problema con la extracción de datos")
        }
        return cli
    }

    fun loginEmpleado(dni: String,contraseña:String):RespuestaConexion?{
        var sentencia = "select * from empleado where dni = ? and contraseña = ?"
        var emple:Empleado? = null
        var cod:Int = 0
        var rc:RespuestaConexion? = null
        try{
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,dni)
            pstmt.setString(2,contraseña)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                emple = Empleado(
                    registros!!.getString(1),
                    registros!!.getString(2),
                    registros!!.getString(3),
                    registros!!.getString(4),
                    registros!!.getString(5),
                    registros!!.getInt(6),
                    registros!!.getString(7),
                    registros!!.getString(8)
                )
                cod = 1
            }
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
            cod = -1
        }
        rc = RespuestaConexion(cod,emple!!)
        return rc
    }

    fun modificarEmpleado(emple:Empleado){
        var sentencia = "update empleado set nombre = ?, apellido = ?, dni = ?, telefono = ?,dni = ? , contraseña = ?, tipo = ?, observaciones = ?"
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,emple.nombre)
            pstmt.setString(2,emple.apellido)
            pstmt.setString(3,emple.telefono)
            pstmt.setString(4,emple.dni)
            pstmt.setString(5,emple.contraseña)
            pstmt.setInt(6,emple.tipo)
            pstmt.setString(7,emple.observaciones)
            pstmt.executeUpdate()
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido un problema con los datos")
        }
    }


    fun insertarCliente(cli:Cliente){
        var sentencia = "insert into cliente values (?,?,?,?,?,?)"
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,cli.nombre)
            pstmt.setString(2,cli.apellido)
            pstmt.setString(3,cli.dni)
            pstmt.setString(4,cli.telefono)
            pstmt.setString(5,cli.direccion)
            pstmt.setString(6,cli.observaciones)
            pstmt.executeUpdate()
            cerrarConexion()
            Mensaje.mostrarMensaje("Insertado con éxito")
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido un problema con la entrada de datos")
        }
    }

    fun totalEmpleados():Int{
        var sentencia = "select count (*) from empleado"
        var cantidad = 0
        try{
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            while (registros!!.next()){
                cantidad = registros!!.getInt(1)
            }
            pstmt.executeUpdate()
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
        }
        return cantidad
    }

    fun totalClientes():Int{
        var sentencia = "select count (*) from cliente"
        var cantidad = 0
        try{
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            while (registros!!.next()){
                cantidad = registros!!.getInt(1)
            }
            pstmt.executeUpdate()
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
        }
        return cantidad
    }

    fun obtenerTodosEmpleado():ArrayList<Empleado>{
        var sentencia = "select * from empleado"
        var emple: Empleado? = null
        var arrayEmple: ArrayList<Empleado> = ArrayList()
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                emple = Empleado(
                    registros!!.getString(1),
                    registros!!.getString(2),
                    registros!!.getString(3),
                    registros!!.getString(4),
                    registros!!.getString(5),
                    registros!!.getInt(6),
                    registros!!.getString(7),
                    registros!!.getString(8)
                )
                arrayEmple.add(emple)
            }
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido un problema con la extracción de datos")
        }
        return arrayEmple
    }

    fun obtenerTodosCliente():ArrayList<Cliente>{
        var sentencia = "select * from cliente"
        var cli: Cliente? = null
        var arrayCliente: ArrayList<Cliente> = ArrayList()
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                cli = Cliente(
                        registros!!.getString(1),
                registros!!.getString(2),
                registros!!.getString(3),
                registros!!.getString(4),
                registros!!.getString(5),
                registros!!.getString(6)
                )
                arrayCliente.add(cli)
            }
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido un problema con la extracción de datos")
        }
        return arrayCliente
    }

//    fun resulTablaClientesAdmin():ArrayList<ResTabClientesAdmin>{
//        var sentencia = "select cliente.nombre, cliente.dni, count(*) from pedido left join cliente on cliente.telefono = pedido.telefonocliente"
//        var res:ResTabClientesAdmin? = null
//        var resultados = ArrayList<ResTabClientesAdmin>()
//        try {
//            abrirConexion()
//            var pstmt = conexion!!.prepareStatement(sentencia)
//            registros = pstmt.executeQuery()
//            while (registros!!.next()){
//                res = ResTabClientesAdmin(
//                    registros!!.getString(1),
//                    registros!!.getString(2),
//                    registros!!.getInt(3)
//                )
//                resultados.add(res)
//            }
//            cerrarConexion()
//        }catch (ex:Exception){
//            println(ex)
//            println("Fallo en ResuTabalClient")
//        }
//        return resultados
//    }

    fun resultadosTablaEstacion():ArrayList<ResTabEsta>{
        var sentencia = "select pedido.numeropedido, cliente.dni, cliente.nombre, cliente.telefono, pedido.mesa, pizza.precio " +
                "from pedido join cliente on cliente.telefono = pedido.telefonocliente join pizza on pizza.id = pedido.idpizza group by pedido.numeropedido, " +
                "cliente.dni, cliente.nombre, cliente.telefono, pedido.mesa"
        var res:ResTabEsta? = null
        var resultados = ArrayList<ResTabEsta>()
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                res = ResTabEsta(
                    registros!!.getInt(1),
                    registros!!.getString(2),
                    registros!!.getString(3),
                    registros!!.getString(4),
                    registros!!.getInt(5),
                    registros!!.getDouble(6)
                )
                resultados.add(res)
            }
            cerrarConexion()
        }catch (ex:Exception){
            println("Fallo en resulTablaEstacion")
            println(ex)
        }
        return resultados

    }


    fun insertarPizza(pizza: Pizza){
        var sentencia = "insert into pizza values (default,?,?,?,?,?,?)"
        var pi: Pizza? = null
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,pizza.nombre)
            pstmt.setDouble(2,pizza.precio)
            pstmt.setInt(3,pizza.tamaño)
            pstmt.setInt(4,pizza.especial)
            pstmt.setInt(5,pizza.ingredienteExtra)
            pstmt.setString(6,pizza.hora)
            pstmt.executeUpdate()
            cerrarConexion()
        }catch (e:Exception){
            println(e)
            Mensaje.mostrarMensaje("Ha habído un fallo en la inserción de datos")
            println("problema en funcion insertarPizza")
        }

    }

    fun obtenerIdPizza(hora:String):Int{

        var idPi:Int = 0
        var sentencia = "select id from pizza where hora like ?"
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,hora)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                idPi = registros!!.getInt("id")
            }
            cerrarConexion()
        }catch (e:Exception){
            println(e)
            Mensaje.mostrarMensaje("No se ha podido obtener el id de la pizza por algún problema desconocido")
            println("problema en funcion obtenerPizza")
        }
        return idPi
    }



// COMO SE PODRIA PLANTEAR LAS CONSULTAS PARA GESTIONAR QUE SE SUME EL TIEMPO DE ESPERA
//    SI SE PUDIERA AÑADIR MAS DE UNA PIZZA A UN MISMO PEDIDO?????? 2 PREGUNTAS EN UNA
    fun insertarPedido(pedido:Pedido){
        var sentencia = "insert into pedido values (default,?,?,?,?,?,?,?,?)"
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1, pedido.fecha)
            pstmt.setDouble(2, pedido.tiempoEspera!!)
            pstmt.setInt(3,pedido.atendidoEnLocal)
            pstmt.setInt(4,pedido.mesa)
            pstmt.setInt(5,pedido.idPizza)
            pstmt.setString(6,pedido.telefonoCliente)
            pstmt.setString(7, pedido.hora)
            pstmt.setDouble(8,pedido.precioTotal)
            pstmt.executeUpdate()
            cerrarConexion()
            Mensaje.mostrarMensaje("Pedido lanzado!")
        }catch (ex:Exception){
            println(ex)
            println("problema en funcion insertarPedido")
        }
    }

//    fun obtenerPedido(numeroPedido:Int):Pedido?{
//        var sentencia = "select * from pedido where numpedido = ?"
//        var ped: Pedido? = null
//        try {
//            var pstmt = conexion!!.prepareStatement(sentencia)
//            pstmt.setInt(1,numeroPedido)
//            registros = pstmt.executeQuery()
//            while(registros!!.next()){
//                ped = Pedido(
//                    registros!!.getInt(1),
//                    registros!!.getString(2),
//                    registros!!.getString(3),
//                    registros!!.getString(4),
//                    registros!!.getInt(5),
//                    registros!!.getInt(6),
//                    registros!!.getInt(7),
//                    registros!!.getInt(8)
//                )
//            }
//
//        }catch (ex:Exception){
//            println(ex)
//        }
//        return ped
//    }

// COMO PUEDO USAR COMODINES EN LOS LAS CADENAS PARA BUSCAR POR EJEMPLO CADENAS QUE CONTENGAN %MAR% CON UNA SENTENCIA PREPARADA??
    fun buscarEmpleado(nombre:String):ArrayList<Empleado>?{
        var sentencia = "select * from empleado where upper (nombre) like ?"
        var emple:Empleado? = null
        var arrayEmple = ArrayList<Empleado>()
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,nombre)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                emple = Empleado(
                    registros!!.getString(1),
                    registros!!.getString(2),
                    registros!!.getString(3),
                    registros!!.getString(4),
                    registros!!.getString(5),
                    registros!!.getInt(6),
                    registros!!.getString(7),
                    registros!!.getString(8)
                )
                arrayEmple.add(emple)
            }
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
        }
        return arrayEmple
    }

    fun buscarCliente(nombre:String):ArrayList<Cliente>?{
        var sentencia = "select * from cliente where upper (nombre) like ?"
        var cli:Cliente? = null
        var arrayCli = ArrayList<Cliente>()
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,nombre)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                cli = Cliente(
                    registros!!.getString(1),
                    registros!!.getString(2),
                    registros!!.getString(3),
                    registros!!.getString(4),
                    registros!!.getString(5),
                    registros!!.getString(6),
                )
                arrayCli.add(cli)
            }
            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
        }
        return arrayCli
    }


//    fun buscarClienteResTablaAdmin(nombre:String):ArrayList<ResTabClientesAdmin>?{
//        var sentencia = "select cliente.nombre, cliente.dni, count (*) from pedido join cliente on " +
//                "cliente.telefono = pedido.telefonocliente where upper (nombre) like ?"
//        println(sentencia)
//        var res: ResTabClientesAdmin? = null
//        var arrayRes: ArrayList<ResTabClientesAdmin> = ArrayList()
//        try {
//            abrirConexion()
//            var pstmt = conexion!!.prepareStatement(sentencia)
//            pstmt.setString(1,nombre)
//                registros = pstmt.executeQuery()
//                while (registros!!.next()){
//                    res = ResTabClientesAdmin(
//                        registros!!.getString(1),
//                        registros!!.getString(2),
//                        registros!!.getInt(3)
//                    )
//                    arrayRes.add(res)
//                }
//                cerrarConexion()
//            }catch (ex:Exception){
//                println(ex)
//            println("Fallo en busclieRestTAbla")
//                Mensaje.mostrarMensaje("Ha habido un problema con la extracción de datos")
//            }
//            return arrayRes
//    }

    fun darDeBajaEmpleado(dni:String){
        var sentencia = "delete from empleado where dni = ?"
        try{
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,dni)
            pstmt.executeUpdate()
            cerrarConexion()
            Mensaje.mostrarMensaje("Empleado borrado con éxito")
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido algun error o no se ha encontrado al empleado")
        }
    }

    fun darDeBajaCliente(dni:String){
        var sentencia = "delete from cliente where dni = ?"
        try{
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,dni)
            pstmt.executeUpdate()
            cerrarConexion()
            Mensaje.mostrarMensaje("Cliente borrado con éxito")
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido algun error o no se ha encontrado al empleado")
        }
    }


    fun insertarEmpleado(emple:Empleado){
        var sentencia = "insert into empleado values (?,?,?,?,?,?,?,?)"
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,emple.nombre)
            pstmt.setString(2,emple.apellido)
            pstmt.setString(3,emple.telefono)
            pstmt.setString(4,emple.dni)
            pstmt.setString(5,emple.contraseña)
            pstmt.setInt(6,emple.tipo)
            pstmt.setString(7,emple.observaciones)
            pstmt.setString(8,emple.rutaFoto)
            pstmt.executeUpdate()
            cerrarConexion()
            Mensaje.mostrarMensaje("Usuario insertado con éxito!")
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido un error con la inserción de datos")
        }
    }

    fun obtenerResumen(numPedido:Int):ResumenPedido?{
        var sentencia = "select cliente.nombre, cliente.apellido, cliente.dni, cliente.telefono," +
                " cliente.direccion, pizza.id, pizza.nombre, pizza.tamaño, pizza.especial," +
                " pizza.ingrextra, pedido.numeropedido, pedido.fecha, pedido.hora, pedido.atendidoenlocal," +
                " pedido.mesa, pedido.preciototal from pedido join pizza on pizza.id = pedido.idpizza" +
                " join cliente on cliente.telefono = pedido.telefonocliente where pedido.numeropedido = ?"
        var resu:ResumenPedido? = null
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setInt(1,numPedido)
            registros = pstmt.executeQuery()
            while (registros!!.next()){
                resu = ResumenPedido(
                registros!!.getString(1),
                registros!!.getString(2),
                registros!!.getString(3),
                registros!!.getString(4),
                registros!!.getString(5),
                registros!!.getInt(6),
                registros!!.getString(7),
                registros!!.getInt(8),
                registros!!.getInt(9),
                registros!!.getInt(10),
                registros!!.getInt(11),
                registros!!.getString(12),
                registros!!.getString(13),
                registros!!.getInt(14),
                registros!!.getInt(15),
                registros!!.getDouble(16)
                )
            }

            cerrarConexion()
        }catch (ex:Exception){
            println(ex)
            Mensaje.mostrarMensaje("Ha habido algún error al mostrar el resumen del pedido")
        }
        return resu
    }


    fun obtenerNumPedido(hora:String):Int{
        var sentencia = "select numeropedido from pedido where hora like ?"
        var num = 0
        try {
            abrirConexion()
            var pstmt = conexion!!.prepareStatement(sentencia)
            pstmt.setString(1,hora)
            registros = pstmt.executeQuery()

            while (registros!!.next()){
              num = registros!!.getInt(1)
            }
            cerrarConexion()
        }catch (e:Exception){
            println(e)
            Mensaje.mostrarMensaje("Ha habido un problema al intentar obtener el número de pedido")
        }
    return num
    }

    fun insertar10Empleados(){
        try {
        for (i in 0..10){
            insertarEmpleado(Factoria.factoriaEmpleado())
        }
        }catch (e:Exception){
            println(e)
        }
    }

    fun insertar10Clientes(){
        try {
            for (i in 0..10){
                insertarCliente(Factoria.factoriaCliente())
            }
        }catch (e:Exception){
            println(e)
        }

    }








}