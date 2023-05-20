package com.example._11_teledominospizza

import BBDD.Conexion
import Datos.Datos
import Pizzeria.Empleado
import Utilidades.Mensaje
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Scene
import javafx.scene.control.ComboBox
import javafx.scene.control.TextField
import javafx.scene.image.ImageView
import javafx.stage.Modality
import javafx.stage.Stage
import java.net.URL
import java.util.*

class LoginController:Initializable {

    var emple:Empleado? = null

    @FXML
    private lateinit var contraseñaField: TextField

    @FXML
    private lateinit var dniField: TextField

    @FXML
    private lateinit var elijaPerfil: ComboBox<Any>

    @FXML
    private lateinit var logoEmpresa: ImageView

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        elijaPerfil.promptText = "Seleccione perfil"
        elijaPerfil.items.add("Empleado")
        elijaPerfil.items.add("Administrador")
    }

    @FXML
    fun entrarButton(event: ActionEvent) {
        var rc = Conexion.loginEmpleado(dniField.text,contraseñaField.text)
        if (rc!!.codigo == 1){
            emple = rc!!.objeto as Empleado
        }
        else if(rc!!.codigo == -1){
            Mensaje.mostrarMensaje("Ha habido un problema con la extracción de datos")
        }
        else if (emple != null && elijaPerfil.selectionModel.isSelected(1) && emple!!.tipo == 1){
            Datos.emple = emple
            val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("admin-view.fxml"))
            val scene = Scene(fxmlLoader.load())
            val stage = Stage()
            stage.title = "Administracion"
            stage.scene = scene
            stage.initModality(Modality.APPLICATION_MODAL)
            val stageLocal = dniField.scene.window as Stage
            stageLocal.hide()
            stage.showAndWait()
        }else if(emple != null && elijaPerfil.selectionModel.isSelected(0) && emple!!.tipo == 0 ){
            val fxmlLoader  = FXMLLoader(HelloApplication::class.java.getResource("estacion-view.fxml"))
            val scene = Scene(fxmlLoader.load())
            val stage = Stage()
            stage.title = "Estación de trabajo"
            stage.scene = scene
            stage.initModality(Modality.APPLICATION_MODAL)
            val stageLocal = dniField.scene.window as Stage
            stageLocal.hide()
            stage.showAndWait()
        }
    }
}
