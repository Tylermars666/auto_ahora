package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.Concesionario;
import co.edu.uniquindio.auto_ahora.model.Moto;
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

        String placa = this.txtPlaca.getText();                           //Métodos para obtener los valores de los campos
        String marca = this.txtMarca.getText();                           //de texto de la interfaz gráfica GUI
        String referencia = this.txtReferencia.getText();
        String modelo = this.txtModelo.getText();
        int num_ruedas = Integer.parseInt(opcion_ruedas);
        double precio = Double.parseDouble(this.txtPrecio.getText());
        double tam_tanque = Double.parseDouble(this.txtTamTanque.getText());
        int cilindraje = Integer.parseInt(this.txtCilindraje.getText());

        Moto moto = new Moto(placa, marca, referencia, modelo, num_ruedas,cilindraje,tam_tanque,precio);
        Concesionario.getInstancia().getAdmin().registrarVehiculo(moto);      //Registro de vehículo en la base de datos
    }

    @FXML
    void seleccionarNumRuedas(ActionEvent event) {

        opcion_ruedas = comb_ruedas.getSelectionModel().getSelectedItem();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {       //Método initialize que se implementa para
                                                                           //llenar los campos que se muestran en el combobox
        ObservableList<String> list = FXCollections.observableArrayList("2","4");
        comb_ruedas.setItems(list);
    }
}
