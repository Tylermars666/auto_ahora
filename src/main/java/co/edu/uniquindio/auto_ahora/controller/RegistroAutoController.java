package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.Concesionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroAutoController {

    @FXML
    private Button btnGuardarRegistroAutomovil;

    @FXML
    private TextField txtIsGasolina;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNumPuertas;

    @FXML
    private TextField txtNumRuedas;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtReferencia;

    @FXML
    void guardarRegistroAutomovil(ActionEvent event) {

        String placa = this.txtPlaca.getText();
        String marca = this.txtMarca.getText();
        String referencia = this.txtReferencia.getText();
        String modelo = this.txtModelo.getText();
        int num_ruedas = Integer.parseInt(this.txtNumRuedas.getText());
        int num_puertas = Integer.parseInt(this.txtNumPuertas.getText());


    }

}
