package com.example._11_teledominospizza

import BBDD.Conexion
import Datos.Datos
import Pizzeria.Empleado
import Utilidades.Mensaje
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ListView
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent
import javafx.scene.text.Text
import javafx.stage.Modality
import javafx.stage.Stage
import java.awt.event.ActionListener

import java.net.URL
import java.util.*
import javax.swing.Timer

class CambioTurnoController:Initializable {


    var todosEmpleados = Conexion.obtenerTodosEmpleado()
    var emple:Empleado? = null
    var tiempo = 1
    var listaActualizada = false

    companion object{
        lateinit var temporizador:Timer
    }

    @FXML
    lateinit var cambioTurnoFxid: Button

    @FXML
    private lateinit var horasText: Text

    @FXML
    private lateinit var listViewEmpleados: ListView<Any>

    @FXML
    private lateinit var minutosText: Text

    @FXML
    private lateinit var nombreEmpleado: Text

    @FXML
    private lateinit var nombreEmpleadoBusquedaField: TextField

    @FXML
    private lateinit var segundosText: Text



    override fun initialize(p0: URL?, p1: ResourceBundle?) {
    try {


        for (empleado in todosEmpleados) {
            listViewEmpleados.items.add(empleado)
        }

        if (Datos.emple != null){
            nombreEmpleado.text = Datos.emple!!.nombre
        }



        temporizador = Timer(500, object : ActionListener {
            override fun actionPerformed(e: java.awt.event.ActionEvent?) {
                Platform.runLater {
                    if (nombreEmpleadoBusquedaField.text.isEmpty() && !listaActualizada) {
                        todosEmpleados = Conexion.obtenerTodosEmpleado()
                        listViewEmpleados.items.clear()
                        for (empleado in todosEmpleados) {
                            listViewEmpleados.items.add(empleado)
                        }
                        listaActualizada = true
                    }
                    tiempo++
                }
            }
        })
        temporizador.start()
    }catch (ex:Exception){
        println(ex)
    }

    }


    @FXML
    fun BuscarEmpleadoButton(event: ActionEvent) {
        todosEmpleados = Conexion.buscarEmpleado(nombreEmpleadoBusquedaField.text)!!
        listViewEmpleados.items.clear()
        for (empleado in todosEmpleados){
            listViewEmpleados.items.add(empleado)
        }
        listaActualizada = false
    }


    @FXML
    fun cambioTurnoButton(event: ActionEvent) {
        Datos.emple = emple
        Mensaje.mostrarMensaje("Turno cambiado, Bievendid@ ${emple!!.nombre}")
        cambioTurnoFxid.style ="-fx-background-color: C3FCB9;"
        val stage = cambioTurnoFxid.scene.window as Stage
        stage.close()
    }

    @FXML
    fun volverEstacionButton(event: ActionEvent) {
        val fxmlLoader  = FXMLLoader(HelloApplication::class.java.getResource("estacion-view.fxml"))
        val scene = Scene(fxmlLoader.load())
        val stage = Stage()
        stage.title = "Estación de trabajo"
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.showAndWait()
    }

    @FXML
    fun empleClickOnMouse(mouseEvent: MouseEvent) {
        emple = listViewEmpleados.selectionModel.selectedItem as Empleado?
        Datos.emple = emple
        cambioTurnoFxid.style ="-fx-background-color: B9F4FC;"
        cambioTurnoFxid.requestFocus()
    }


}
