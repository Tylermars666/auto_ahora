package co.edu.uniquindio.auto_ahora.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistroMotoController implements Initializable {

    String opcion_ruedas;

    @FXML
    private Button btnGuardarRegistroMoto;

    @FXML
    private ComboBox<String> comb_ruedas;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtReferencia;

    @FXML
    private TextField txtTamTanque;

    @FXML
    void guardarRegistroMoto(ActionEvent event) {

    }

    @FXML
    void seleccionarNumRuedas(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> list = FXCollections.observableArrayList("2","4");
        comb_ruedas.setItems(list);
    }
}
