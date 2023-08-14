package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.Camion;
import co.edu.uniquindio.auto_ahora.model.Concesionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroCamionController {

    @FXML
    private Button btnGuardarRegistroCamion;

    @FXML
    private TextField txtCap_Carga;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNumeroRuedas;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtReferencia;

    @FXML
    void guardarRegistroCamion(ActionEvent event) {

        String placa = this.txtPlaca.getText();                           //Métodos para obtener los valores
        String marca = this.txtMarca.getText();                          //de los campos de texto de GUI
        String referencia = this.txtReferencia.getText();
        String modelo = this.txtModelo.getText();
        double precio = Double.parseDouble(this.txtPrecio.getText());
        int num_ruedas = Integer.parseInt(this.txtNumeroRuedas.getText());
        int cap_carga = Integer.parseInt(this.txtCap_Carga.getText());

        Camion camion = new Camion(placa, marca, referencia, modelo, num_ruedas,precio, cap_carga);

        Concesionario.getInstancia().getAdmin().registrarVehiculo(camion);    //Registro de vehículo en la base de datos
    }

}
