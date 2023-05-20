package Utilidades

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

object Mensaje {

    fun mostrarMensaje(mensajeAMostrar:String){
        var alerta = Alert(Alert.AlertType.CONFIRMATION)
        alerta.title = "Atención"
        alerta.headerText = mensajeAMostrar
        alerta.contentText = "Pulse para continuar"
        alerta.showAndWait()
    }

    fun mostrarMensajeAlerta(mensajeAMostrar:String){
        var alerta = Alert(Alert.AlertType.WARNING)
        alerta.title = "Atención, esta acción es irreversible"
        alerta.headerText = mensajeAMostrar
        alerta.contentText = "¿Está seguro?"
        alerta.buttonTypes.remove(ButtonType.OK)
        alerta.buttonTypes.add(ButtonType.YES)
        alerta.buttonTypes.add(ButtonType.NO)
        alerta.showAndWait().orElse(ButtonType.NO)
    }

}