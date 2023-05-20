 package com.example._11_teledominospizza

    import BBDD.Conexion
    import Datos.Datos
    import Pizzeria.Cliente
    import Pizzeria.Empleado
    import Utilidades.Mensaje
    import javafx.application.Platform
    import javafx.event.ActionEvent
    import javafx.fxml.FXML
    import javafx.fxml.FXMLLoader
    import javafx.fxml.Initializable
    import javafx.scene.Scene
    import javafx.scene.control.*
    import javafx.scene.control.cell.PropertyValueFactory
    import javafx.scene.input.MouseEvent
    import javafx.stage.Modality
    import javafx.stage.Stage
    import java.awt.event.ActionListener
    import java.net.URL
    import java.util.*
    import javax.swing.Timer

 class AdminController:Initializable {

     var emple:Empleado? = null
     var cli:Cliente? = null
     var admin:Int = 0
     var contraseñasIguales:Boolean = false
     var todosEmpleados = Conexion.obtenerTodosEmpleado()
     var allClientesAdmin = Conexion.obtenerTodosCliente()
     var tiempo = 1
     var listaEmpleActualizada = false
     var listaClieActualizada = false

     constructor()


     companion object {
         lateinit var temporizador : Timer
     }

    @FXML
    private lateinit var administradorCheck: CheckBox

    @FXML
    private lateinit var telefonoClienteTabla: TableColumn<Cliente, String>
    @FXML
    private lateinit var apellidoClienteField: TextField

    @FXML
    private lateinit var apellidoEmpleField: TextField

    @FXML
    private lateinit var apellidoEmpleadoTabla: TableColumn<Empleado, String>

    @FXML
    private lateinit var contraseñaField: TextField

    @FXML
    private lateinit var direccionClienteField: TextField

    @FXML
    private lateinit var dniClienteField: TextField

    @FXML
    private lateinit var dniClienteTabla: TableColumn<Cliente, String>

    @FXML
    private lateinit var dniEmpleField: TextField

    @FXML
    private lateinit var dniEmpleadoTabla: TableColumn<Empleado, String>

    @FXML
    private lateinit var nombreAdministrador: Menu

    @FXML
    private lateinit var nombreClienteField: TextField

    @FXML
    private lateinit var nombreClienteTabla: TableColumn<Cliente, String>

    @FXML
    private lateinit var nombreEmpleBusquedaField: TextField

    @FXML
    private lateinit var nombreEmpleField: TextField

    @FXML
    private lateinit var nombreEmpleadoTabla: TableColumn<Empleado, String>

    @FXML
    private lateinit var busquedaClientesField: TextField

    @FXML
    private lateinit var observaEmpleado: TextArea

    @FXML
    private lateinit var observacionesCliente: TextArea

    @FXML
    private lateinit var repetContraseField: TextField

    @FXML
    private lateinit var tablaEmpleados: TableView<Empleado>

    @FXML
    private lateinit var tablaClientesAdmin: TableView<Cliente>

    @FXML
    private lateinit var telefonoClienteField: TextField

    @FXML
    private lateinit var telefonoEmpleField: TextField

     @FXML
     fun delAllClientes(event: ActionEvent) {

     }

     @FXML
     fun dellAllPedidos(event: ActionEvent) {

     }

     @FXML
     fun diezClientesButton(event: ActionEvent) {
         Conexion.insertar10Clientes()
     }

     @FXML
     fun diezEmpleadosButton(event: ActionEvent) {
         Conexion.insertar10Empleados()
     }

     @FXML
     fun diezPedidosButton(event: ActionEvent) {

     }

     @FXML
     fun DelAllEmple(event: ActionEvent) {

     }

     override fun initialize(p0: URL?, p1: ResourceBundle?) {

        try {

            tablaEmpleados.isEditable = true
            nombreEmpleadoTabla.cellValueFactory = PropertyValueFactory<Empleado, String>("nombre")
            apellidoEmpleadoTabla.cellValueFactory = PropertyValueFactory<Empleado, String>("apellido")
            dniEmpleadoTabla.cellValueFactory = PropertyValueFactory<Empleado, String>("dni")

            this.tablaClientesAdmin.isEditable = true
            telefonoClienteTabla.cellValueFactory = PropertyValueFactory("telefono")
            dniClienteTabla.cellValueFactory = PropertyValueFactory("dni")
            nombreClienteTabla.cellValueFactory = PropertyValueFactory("nombre")

            nombreAdministrador.text = Datos.emple!!.nombre

            temporizador = Timer(200, object : ActionListener {
                override fun actionPerformed(e: java.awt.event.ActionEvent?) {
                    try {

                        Platform.runLater{
                            if (nombreEmpleBusquedaField.text.isEmpty() && !listaEmpleActualizada) {
                                if (todosEmpleados.isNotEmpty()){
                                    rellenarTablaEmpleados()
                                }

                                listaEmpleActualizada = true
                            }

                            if (busquedaClientesField.text.isEmpty() && !listaClieActualizada) {
                                if (allClientesAdmin.isNotEmpty()){
                                    rellenarTablaClientes()
                                }
                                listaClieActualizada = true
                            }
                        }

                        tiempo++
                    }catch (e:Exception){
                        println(e)
                        println("fallo en timer AdminController")
                    }
                }
            })


        temporizador.start()
        }catch (ex:Exception){
            println(ex)
        }

     }

    @FXML
    fun buscarEmpleadoButton(event: ActionEvent) {
        todosEmpleados = Conexion.buscarEmpleado(nombreEmpleBusquedaField.text)!!
        tablaEmpleados.items.clear()
        for (empleado in todosEmpleados){
            tablaEmpleados.items.add(empleado)
        }
        listaEmpleActualizada = false
    }

    @FXML
    fun buscarClienteButton(event: ActionEvent) {
        allClientesAdmin = Conexion.buscarCliente(busquedaClientesField.text)!!
        tablaClientesAdmin.items.clear()
        for (cliente in this.allClientesAdmin){
            this.tablaClientesAdmin.items.add(cliente)
        }
        listaClieActualizada = false
    }

    @FXML
    fun darDeAltaEmpleButton(event: ActionEvent) {
        if (administradorCheck.isSelected){
            admin = 1
        }
        if (contraseñaField.text == repetContraseField.text){
            contraseñasIguales = true
        }else{
            Mensaje.mostrarMensaje("Las contraseñas no son iguales")
        }
        emple = Empleado(
            nombreEmpleField.text,
            apellidoEmpleField.text,
            telefonoEmpleField.text,
            dniEmpleField.text,
            contraseñaField.text,
            admin,
            observaEmpleado.text,
            "rutaFoto")

        if (nombreEmpleField.text.isNotEmpty() &&
            apellidoEmpleField.text.isNotEmpty() &&
            telefonoEmpleField.text.isNotEmpty() &&
            dniEmpleField.text.isNotEmpty() &&
            contraseñaField.text.isNotEmpty() &&
            contraseñasIguales
        ){
            Conexion.insertarEmpleado(emple!!)
            rellenarTablaEmpleados()
        }
    }

    @FXML
    fun darDeAltaCliente(event: ActionEvent) {

        cli = Cliente(
            nombreClienteField.text,
            apellidoClienteField.text,
            telefonoClienteField.text,
            dniClienteField.text,
            direccionClienteField.text,
            observacionesCliente.text)

        if (nombreClienteField.text.isNotEmpty() &&
            apellidoClienteField.text.isNotEmpty() &&
            telefonoClienteField.text.isNotEmpty() &&
            dniClienteField.text.isNotEmpty() &&
            direccionClienteField.text.isNotEmpty()
        ){
            Conexion.insertarCliente(cli!!)
            rellenarTablaClientes()
        }

    }

    @FXML
    fun darDeBajaEmpleButton(event: ActionEvent) {
        if (Datos.emple != null){
            Mensaje.mostrarMensajeAlerta("Estás a punto de borrar al empleado ${Datos!!.emple!!.nombre} con dni ${Datos!!.emple!!.dni}")

            Conexion.darDeBajaEmpleado(emple!!.dni)
            tablaEmpleados.items.clear()
            todosEmpleados = Conexion.obtenerTodosEmpleado()
            for (empleados in todosEmpleados){
                tablaEmpleados.items.add(empleados)
            }
        }

    }

    @FXML
    fun darDeBajaCliente(event: ActionEvent) {
        if (Datos.cli != null){
            Mensaje.mostrarMensajeAlerta("Estás a punto de borrar al cliente ${Datos!!.cli!!.nombre} con dni ${Datos!!.cli!!.dni}")

            Conexion.darDeBajaCliente(cli!!.dni)
            tablaClientesAdmin.items.clear()
            allClientesAdmin = Conexion.obtenerTodosCliente()
            for (cliente in allClientesAdmin){
                tablaClientesAdmin.items.add(cliente)
            }
        }
    }

    @FXML
    fun empleadoClickOnMouse(event: MouseEvent) {
        emple = tablaEmpleados.selectionModel.selectedItem
        telefonoEmpleField.text = emple!!.telefono
        nombreEmpleField.text = emple!!.nombre
        apellidoEmpleField.text = emple!!.apellido
        dniEmpleField.text = emple!!.dni
        contraseñaField.text = emple!!.contraseña
        repetContraseField.text = emple!!.contraseña
        if (emple!!.tipo == 0) administradorCheck.isSelected = false else administradorCheck.isSelected = true
        Datos.emple = emple

        if (nombreEmpleBusquedaField.text.isEmpty()){

        }
    }

     @FXML
     fun clientesClickOnMouse(event: MouseEvent) {
         cli = tablaClientesAdmin.selectionModel.selectedItem
         telefonoClienteField.text = cli!!.telefono
         nombreClienteField.text = cli!!.nombre
         apellidoClienteField.text = cli!!.apellido
         dniClienteField.text = cli!!.dni
         direccionClienteField.text = cli!!.direccion

         Datos.cli = cli

         if (nombreEmpleBusquedaField.text.isEmpty()){

         }
     }

//     COMO CIERRO LAS VENTANAS "A" CUANDO VOY A LAS VENTANAS "B"
    @FXML
    fun entrarEstacionButtonMenu(event: ActionEvent) {
        val fxmlLoader  = FXMLLoader(HelloApplication::class.java.getResource("estacion-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        var stage = Stage()
        stage.title = "Estación de trabajo"
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL)
//        val stageLocal = telefonoEmpleField.scene.window as Stage
//        stageLocal.close()
        stage.showAndWait()
    }

    @FXML
    fun salirSistemaButtonMenu(event: ActionEvent) {
        val stage = telefonoEmpleField.scene.window as Stage
        stage.close()
    }

     private fun rellenarTablaEmpleados(){
         todosEmpleados = Conexion.obtenerTodosEmpleado()
         tablaEmpleados.items.clear()
         for (empleado in todosEmpleados) {
             tablaEmpleados.items.add(empleado)
         }
     }

     private fun rellenarTablaClientes(){
         allClientesAdmin = Conexion.obtenerTodosCliente()
         tablaClientesAdmin.items.clear()
         for (cliente in allClientesAdmin){
             tablaClientesAdmin.items.add(cliente)
         }
     }






 }

