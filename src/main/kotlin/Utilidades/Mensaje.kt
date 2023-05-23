package Utilidades

import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

object Mensaje {

    fun generico(textoMensaje:String){
        var alerta = Alert(Alert.AlertType.CONFIRMATION)
        alerta.title = "Atención"
        alerta.headerText = textoMensaje
        alerta.contentText = "Pulse para continuar"
        alerta.showAndWait()
    }

    fun automatico(codigo:Int):ButtonType{
        var alerta = Alert(Alert.AlertType.CONFIRMATION)

        when (codigo){
            -1 ->{
                alerta.title = "Ups..."
                alerta.headerText = "Ha ocurrido un error inesperado"
                alerta.contentText = "Vuelvalo a intentar mas tarde"
                alerta.buttonTypes.remove(ButtonType.CANCEL)
            }
            0 ->{
                alerta.headerText = "Datos no encontrados"
                alerta.contentText = "Pulse para continuar"
                alerta.buttonTypes.remove(ButtonType.CANCEL)
            }
            1 ->{
                alerta.headerText = "Proceso realizado con éxito"
                alerta.contentText = "Pulse para continuar"
                alerta.buttonTypes.remove(ButtonType.CANCEL)
            }
            9 ->{
                alerta = Alert(Alert.AlertType.WARNING)
                alerta.title = "Atención, esta acción es irreversible"
                alerta.headerText = "Estás a punto de realizar cambios de persona mayor"
                alerta.contentText = "¿Está seguro?"
                alerta.buttonTypes.remove(ButtonType.OK)
                alerta.buttonTypes.add(ButtonType.YES)
                alerta.buttonTypes.add(ButtonType.NO)
            }
        }
        return alerta.showAndWait().orElse(ButtonType.NO)
    }


}