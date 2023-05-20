package com.example._11_teledominospizza

import BBDD.Conexion
import Datos.Datos
import Pizzeria.*
import Utilidades.Mensaje
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import java.net.URL
import java.util.*
import javafx.scene.control.SpinnerValueFactory
import javafx.scene.control.Spinner
import javafx.scene.image.Image
import javafx.stage.Modality
import javafx.stage.Stage
import java.awt.event.ActionListener
import java.time.LocalDate
import java.time.LocalTime
import javax.swing.Timer


class EstacionController:Initializable {

    var horaActual = LocalTime.now().toString()
    var fechaActual = LocalDate.now().toString()

    var resultadosTabla = Conexion.resultadosTablaEstacion()
    var todosClientes = Conexion.obtenerTodosCliente()

    var cli: Cliente? = null
    var resumen:ResumenPedido? =  null
    var pizza:Pizza? = null
    var pedido:Pedido? = null

    var emple = Datos.emple

    var precioPizza = 0.0
    var mesa = 0
    var atendidoEnLocal = 0
    var precioIngredienteExtra = 0.0
    var precioTotal = 0.0
    var tamaño = 0
    var numPedido = 0
    var listaClientesActualizada = false

    var simbolo = " €"
    var tiempo = 1
    var cont = 0

    companion object{
        var mediana = 4.9
        var grande = 9.90
        lateinit var temporizador:Timer
        lateinit var temporizador2:Timer
    }

    init {
        horaActual = horaActual.substring(0,10)
    }

// DECLARACIONES ELEMENTOS FX-ID GUI
    @FXML
    private lateinit var bordeCheck: CheckBox

    @FXML
    private lateinit var buscarClienteField: TextField

    @FXML
    private lateinit var cambioTurnoMenu: MenuItem

    @FXML
    private lateinit var carbonaraRadio: RadioButton

    @FXML
    private lateinit var cebollaRadio: RadioButton

    @FXML
    private lateinit var champiñonRadio: RadioButton

    @FXML
    private lateinit var cuadradaCheck: CheckBox

    @FXML
    private lateinit var dniClienteTabla: TableColumn<ResTabEsta, String>

    @FXML
    private lateinit var especialRadio: RadioButton

    @FXML
    private lateinit var fotoEmple: ImageView

    @FXML
    private lateinit var ingredieExtra: ToggleGroup

    @FXML
    private lateinit var jamonRadio: RadioButton

    @FXML
    private lateinit var listViewClientes: ListView<Cliente>

    @FXML
    private lateinit var logo: ImageView

    @FXML
    private lateinit var marineraRadio: RadioButton

    @FXML
    private lateinit var mesaSpinner: Spinner<Int>

    @FXML
    private lateinit var mesaTabla: TableColumn<ResTabEsta, Int>

    @FXML
    private lateinit var nombreClienteTabla: TableColumn<ResTabEsta, String>

    @FXML
    private lateinit var numPedidoTabla: TableColumn<ResTabEsta, Int>

    @FXML
    private lateinit var trabajadorActualField: TextField

    @FXML
    private lateinit var tipoPizza: ToggleGroup

    @FXML
    private lateinit var quesoRadio: RadioButton

    @FXML
    private lateinit var quesosRadio: RadioButton

    @FXML
    private lateinit var ruculaRadio: RadioButton

    @FXML
    private lateinit var salirMenu: MenuItem

    @FXML
    private lateinit var sinGlutenCheck: CheckBox

    @FXML
    private lateinit var tamañoPizzaCombo: ComboBox<Any>

    @FXML
    private lateinit var telefonoTabla: TableColumn<ResTabEsta, String>

    @FXML
    private lateinit var totalTabla: TableColumn<ResTabEsta, Double>

    @FXML
    private lateinit var tropicalRadio: RadioButton

    @FXML
    private lateinit var veganaCheck: CheckBox

    @FXML
    private lateinit var tablaEstacion: TableView<ResTabEsta>

    @FXML
    private lateinit var precioActualField: TextField


    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        try {

            ponerFotoEmpleado()

            precioActualField.text = precioTotal.toString() + simbolo

            tablaEstacion.isEditable = true
            numPedidoTabla.cellValueFactory = PropertyValueFactory("numPedido")
            dniClienteTabla.cellValueFactory = PropertyValueFactory("dniCliente")
            nombreClienteTabla.cellValueFactory = PropertyValueFactory("nomCliente")
            telefonoTabla.cellValueFactory = PropertyValueFactory("telefono")
            mesaTabla.cellValueFactory = PropertyValueFactory("mesa")
            totalTabla.cellValueFactory = PropertyValueFactory("total")

//         0 = A domicilio
            var factory = SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30)
            mesaSpinner.valueFactory = factory

            tamañoPizzaCombo.items.add("Pequeña")
            tamañoPizzaCombo.items.add("Mediana")
            tamañoPizzaCombo.items.add("Familiar")


            for (e in resultadosTabla) {
                tablaEstacion.items.add(e)
            }

            for (e in todosClientes){
                listViewClientes.items.add(e)
                listaClientesActualizada = true
            }


            temporizador = Timer(1000, object : ActionListener {
                override fun actionPerformed(e: java.awt.event.ActionEvent?) {

                    Platform.runLater {
                        sumarPrecioTamaño()
                        condicionSoloUnEspecial()
                        ponerFotoEmpleado()
                        trabajadorActualField.text = "Empleado actual: " + Datos.emple!!.nombre + " "+ Datos.emple!!.apellido

                    }

                    Platform.runLater{
                        if (buscarClienteField.text.isEmpty() && !listaClientesActualizada) {
                            if (todosClientes.isNotEmpty()){
                                rellenarTablaClientes()
                            }
                            listaClientesActualizada = true
                        }
                    }



                    tiempo++
                }
            })



            temporizador.start()
        }catch (ex:Exception){
            println(ex)
        }
    }

// RADIO BUTTONS
    @FXML
    fun TropicalOnAction(event: ActionEvent) {
        precioPizza = 10.50
        precioTotal = precioPizza
        precioActualField.text = precioTotal.toString() + simbolo
    }

    @FXML
    fun marineraOnAction(event: ActionEvent) {
        precioPizza = 11.50
        precioTotal = precioPizza
        precioActualField.text = precioTotal.toString() + simbolo
    }
    @FXML
    fun carbonaraOnAction(event: ActionEvent) {
        precioPizza = 12.50
        precioTotal = precioPizza
        precioActualField.text = precioTotal.toString() + simbolo
    }
    @FXML
    fun quesosOnAction(event: ActionEvent) {
        precioPizza = 13.50
        precioTotal = precioPizza
        precioActualField.text = precioTotal.toString() + simbolo
    }

    @FXML
    fun deLaCasaOnAction(event: ActionEvent) {
        precioPizza = 14.50
        precioTotal = precioPizza
        precioActualField.text = precioTotal.toString() + simbolo
    }

    @FXML
    fun cebollaOnAction(event: ActionEvent) {
        precioIngredienteExtra = 2.89
        precioTotal = precioPizza + precioIngredienteExtra
        precioActualField.text = precioTotal.toString() + simbolo
    }

    @FXML
    fun champiñonOnAction(event: ActionEvent) {
        precioIngredienteExtra = 2.10
        precioTotal = precioPizza + precioIngredienteExtra
        precioActualField.text = precioTotal.toString() + simbolo
    }

    @FXML
    fun jamonOnAction(event: ActionEvent) {
        precioIngredienteExtra = 3.90
        precioTotal = precioPizza + precioIngredienteExtra
        precioActualField.text = precioTotal.toString() + simbolo
    }
    @FXML
    fun quesoOnAction(event: ActionEvent) {
        precioIngredienteExtra = 3.30
        precioTotal = precioPizza + precioIngredienteExtra
        precioActualField.text = precioTotal.toString() + simbolo
    }

    @FXML
    fun ruculaOnAction(event: ActionEvent) {
        precioIngredienteExtra = 1.80
        precioTotal = precioPizza + precioIngredienteExtra
        precioActualField.text = precioTotal.toString() + simbolo
    }


    @FXML
    fun aboutMenu(event: ActionEvent) {

    }

    @FXML
    fun buscarButton(event: ActionEvent) {
        todosClientes = Conexion.buscarCliente(buscarClienteField.text)!!
        listViewClientes.items.clear()
        for (cliente in this.todosClientes){
            this.listViewClientes.items.add(cliente)
        }
        listaClientesActualizada = false
    }

    @FXML
    fun calculadoraButton(event: ActionEvent) {

    }

    @FXML
    fun cambioTurnoButton(event: ActionEvent) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("cambioTurno-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = Stage()
        stage.title = "Administracion"
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.showAndWait()
    }

    @FXML
    fun cancelarPedido(event: ActionEvent) {

    }

    @FXML
    fun dolarAEuroMenu(event: ActionEvent) {

    }

    @FXML
    fun euroADolarMenu(event: ActionEvent) {

    }

    @FXML
    fun imprEnPantallaMenu(event: ActionEvent) {

    }

    @FXML
    fun imprEnPapelMenu(event: ActionEvent) {

    }

    @FXML
    fun clickOnMouseListView(event: MouseEvent) {
        cli = listViewClientes.selectionModel.selectedItem
    }

    @FXML
    fun lanzarPedido(event: ActionEvent) {

        try {
            pizza = prepararPizza()
            if (pizza != null){
                Conexion.insertarPizza(pizza!!)
                var hora = pizza!!.hora
                pizza!!.id = Conexion.obtenerIdPizza(hora)
                prepararPedido(pizza!!.id)
                Conexion.insertarPedido(pedido!!)

                resultadosTabla = Conexion.resultadosTablaEstacion()
                tablaEstacion.items.clear()
                for (e in resultadosTabla) {
                    tablaEstacion.items.add(e)
                }

                numPedido = Conexion.obtenerNumPedido(hora)
                mostrarResumen(numPedido)
            }
        }catch (ex:Exception){
            println("fallo en lanzar pedido")
            println(ex)
        }
    }


    @FXML
    fun pedidoClickOnMouse(event: MouseEvent) {
        numPedido = tablaEstacion.selectionModel.selectedItem.numPedido!!
        println(numPedido)
        mostrarResumen(numPedido)

//        pedidoSeleccionadoField.text = seleccionadoTabla.toString()

    }

    @FXML
    fun manualDeUsuarioMenu(event: ActionEvent) {

    }

    @FXML
    fun modificarDatosButton(event: ActionEvent) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("admin-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = Stage()
        stage.title = "Administracion"
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.showAndWait()


    }

    @FXML
    fun salirButton(event: ActionEvent) {


        val stageLocal = tropicalRadio.scene.window as Stage
        stageLocal.hide()
    }




// PREPARAR PIZZA
//    private fun prepararPizza(){
//
//        var ingredientesPizza = ArrayList<Ingrediente>()
//        var pizzasOf = arrayOf(tropicalRadio,marineraRadio,carbonaraRadio,quesoRadio,especialRadio)
//        var iExtraof = arrayOf(quesoRadio,champiñonRadio,champiñonRadio,jamonRadio,ruculaRadio)
//        var especialof = arrayOf(veganaCheck,cuadradaCheck,bordeCheck,sinGlutenCheck,)
//        var nombrePizza = ""
//        var seleccionada = 0
//        var tiempoEspera = 20.0
//        var ingreExtra:Ingrediente? = null
//        var especial = 0
//
//        cont = 0
//        for (ingrediente in iExtraof){
//            if (ingrediente.isSelected){
//                ingreExtra = Ingrediente(cont,ingrediente.text)
//            }
//            cont++
//        }
//
//        cont = 0
//        for (es in especialof){
//            if (es.isSelected){
//                especial = cont
//            }
//            cont++
//        }
//
//        cont = 0
//        for (e in pizzasOf){
//            if (e.isSelected){
//                seleccionada = cont
//                nombrePizza = e.text
//            }
//            cont++
//        }
//
//        when (seleccionada){
//            0 -> {
//                ingredientesPizza.add(Ingrediente(0,"harina"))
//                ingredientesPizza.add(Ingrediente(1,"queso"))
//                ingredientesPizza.add(Ingrediente(2,"tomate"))
//                ingredientesPizza.add(Ingrediente(4,"pollo"))
//                precioPizza = 10.50
//            }
//            1 -> {
//                ingredientesPizza.add(Ingrediente(0,"harina"))
//                ingredientesPizza.add(Ingrediente(1,"queso"))
//                ingredientesPizza.add(Ingrediente(2,"tomate"))
//                ingredientesPizza.add(Ingrediente(5,"piña"))
//                precioPizza = 11.50
//            }
//            2 -> {
//                ingredientesPizza.add(Ingrediente(0,"harina"))
//                ingredientesPizza.add(Ingrediente(1,"queso"))
//                ingredientesPizza.add(Ingrediente(2,"tomate"))
//                ingredientesPizza.add(Ingrediente(6,"nata"))
//                precioPizza = 12.50
//            }
//            3 -> {
//                ingredientesPizza.add(Ingrediente(0,"harina"))
//                ingredientesPizza.add(Ingrediente(1,"queso"))
//                ingredientesPizza.add(Ingrediente(2,"tomate"))
//                ingredientesPizza.add(Ingrediente(7,"bacon"))
//                precioPizza = 13.50
//            }
//            4 -> {
//                ingredientesPizza.add(Ingrediente(0,"harina"))
//                ingredientesPizza.add(Ingrediente(1,"queso"))
//                ingredientesPizza.add(Ingrediente(2,"tomate"))
//                ingredientesPizza.add(Ingrediente(8,"york"))
//                precioPizza = 14.50
//            }
//        }
//
//
//        sumarPrecioTamaño()
//        pizza = Pizza(null,nombrePizza,ingredientesPizza,ingreExtra!!,precioPizza,tamaño,especial)
//
//    }

    private fun prepararPizza():Pizza?{
//        var ingredientesPizza = ArrayList<Ingrediente>()
        var pizzasOf = arrayOf(tropicalRadio,marineraRadio,carbonaraRadio,quesoRadio,especialRadio)
        var iExtraof = arrayOf(quesoRadio,champiñonRadio,champiñonRadio,jamonRadio,ruculaRadio)
        var especialof = arrayOf(veganaCheck,cuadradaCheck,bordeCheck,sinGlutenCheck,)
        var tamañoElegido = false
        var pizzaElegida = false
        var nombrePizza = ""
        var seleccionada = 0
        var ingreExtra:Int = 0
        var especial = 0
        var pi:Pizza? = null


        cont = -1
        seleccionada = cont
        for (e in pizzasOf){
            if (e.isSelected){
                seleccionada = cont
                nombrePizza = e.text
            }
            cont++
        }

        cont = -1
        for (ingrediente in iExtraof){
            if (ingrediente.isSelected){
//                ingreExtra = Ingrediente(cont,ingrediente.text)
                ingreExtra = cont
            }
            cont++
        }

        cont = -1
        for (es in especialof){
            if (es.isSelected){
                especial = cont
            }
            cont++
        }

        if(tamañoPizzaCombo.selectionModel.selectedIndex == -1){
            Mensaje.mostrarMensaje("Falta seleccionar el tamaño")
        }else{
            var tamaño = tamañoPizzaCombo.selectionModel.selectedIndex
            tamañoElegido = true
        }

        if (seleccionada == -1){
            Mensaje.mostrarMensaje("Falta seleccionar el típo de pizza")
        }else{
            pizzaElegida = true
        }


        if (tamañoElegido && pizzaElegida) {
            pi = Pizza(null, nombrePizza, precioTotal, tamaño, especial, ingreExtra, horaActual)
        }else{
            pi = null
        }

        return pi
    }



    private fun prepararPedido(idPizza: Int?){
        try {
            if (mesaSpinner.valueFactory.value == 0) {
                atendidoEnLocal++
            }else{
                mesa = mesaSpinner.valueFactory.value
            }
//            pedido!!.tiempoEspera = tiempo.toDouble()

            pedido = Pedido(null, cli!!.telefono, fechaActual, horaActual, idPizza!!, 20.0, precioTotal, atendidoEnLocal, mesa)
        }catch (ex:Exception){
            println(ex)
            println("Fallo en prepararPedido")
        }
    }



    private fun sumarPrecioTamaño(){
        tamaño = tamañoPizzaCombo.selectionModel.selectedIndex
        when (tamaño){
            1 -> precioTotal + 5.90
            2 -> precioTotal + 9.80
        }
        precioActualField.text = precioTotal.toString() + simbolo
    }




    fun condicionSoloUnEspecial(){
        try {
            cont = 0
            var checkOf = arrayOf(cuadradaCheck, veganaCheck, bordeCheck, sinGlutenCheck)

            for (check in checkOf) {
                if (check.isSelected) {
                    cont++
                }
            }
            if (cont > 1) {
                for (check in checkOf) {
                    check.isSelected = false
                }
                Mensaje.mostrarMensaje("Recuerda que solo se puede una condición especial")
            }
        }catch (ex:Exception){
            println(ex)
        }
    }


    private fun ponerFotoEmpleado(){
        var ruta = "/FotosEmpleados/" + Datos.emple!!.rutaFoto+".jpg"
        val imProfile = Image(javaClass.getResourceAsStream(ruta))
        fotoEmple.image = imProfile
    }

    private fun mostrarResumen(numPedido:Int?){

        resumen = Conexion.obtenerResumen(numPedido!!)
        Datos.resu = resumen

        val fxmlLoader  = FXMLLoader(HelloApplication::class.java.getResource("resumen-pedido-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = Stage()
        stage.title = "Mostrando"
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.showAndWait()
    }

    private fun rellenarTablaClientes(){
        todosClientes = Conexion.obtenerTodosCliente()
        listViewClientes.items.clear()
        for (cliente in this.todosClientes){
            this.listViewClientes.items.add(cliente)
        }
        listaClientesActualizada = false
    }






}
