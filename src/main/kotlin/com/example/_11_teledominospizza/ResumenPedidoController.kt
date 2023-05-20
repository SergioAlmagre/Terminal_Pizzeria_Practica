package com.example._11_teledominospizza

import Datos.Datos
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.image.ImageView
import javafx.scene.text.Text
import java.net.URL
import java.util.*

class ResumenPedidoController:Initializable {

    @FXML
    private lateinit var diaPedidoTxt: Text

    @FXML
    private lateinit var dni: Text

    @FXML
    private lateinit var horaPedidoTXT: Text

    @FXML
    private lateinit var imagenPizza: ImageView

    @FXML
    private lateinit var ingredienteExtra1: Text

    @FXML
    private lateinit var nombreCliente: Text

    @FXML
    private lateinit var nombreDomicilio: Text

    @FXML
    private lateinit var nombrePizza: Text

    @FXML
    private lateinit var numeroMesa: Text

    @FXML
    private lateinit var precioPedidoTxt: Text

    @FXML
    private lateinit var siNoAtendidoLocal: Text

    @FXML
    private lateinit var siNoIngredienteExtra: Text

    @FXML
    private lateinit var siNoSeleccionEspecial: Text

    @FXML
    private lateinit var tamañoPizza: Text

    @FXML
    private lateinit var telefono: Text

    @FXML
    private lateinit var idPedidoTXT: Text

    @FXML
    private lateinit var idPizzaTXT: Text

    @FXML
    private lateinit var tipoEspecialTXT: Text

    override fun initialize(p0: URL?, p1: ResourceBundle?) {

        try{
            nombreCliente.text = Datos.resu!!.nombreCliente + " " + Datos.resu!!.apellido
            dni.text = Datos.resu!!.dni
            telefono.text = Datos.resu!!.telefono
            nombreDomicilio.text = Datos.resu!!.direccion
            idPizzaTXT.text = Datos.resu!!.idPizza.toString()
            nombrePizza.text = Datos.resu!!.nombrePizza

            tamañoPizza.text = Datos.resu!!.tamaño.toString()
            siNoSeleccionEspecial
            tipoEspecialTXT.text

            idPedidoTXT.text = Datos.resu!!.numPedido.toString()
            diaPedidoTxt.text = Datos.resu!!.fecha
            horaPedidoTXT.text = Datos.resu!!.hora.substring(0,8)

            siNoAtendidoLocal.text
            numeroMesa.text = Datos.resu!!.mesa.toString()
            precioPedidoTxt.text = Datos.resu!!.precioTotal.toString() + " €"
        }catch (ex:Exception){
            println(ex)
            println("fallo en resumenPedidoController")
        }











    }


}
