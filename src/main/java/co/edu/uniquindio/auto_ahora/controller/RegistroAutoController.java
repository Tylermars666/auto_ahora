package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.Auto;
import co.edu.uniquindio.auto_ahora.model.Concesionario;
import co.edu.uniquindio.auto_ahora.model.Vehiculo;
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

public class RegistroAutoController implements Initializable {

    private String opcion = "true";

    @FXML
    private ComboBox<String> comb_gasolina;

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
        boolean is_gasolina = Boolean.parseBoolean(opcion);
        double precio = Double.parseDouble(this.txtPrecio.getText());
        Auto auto = new Auto(placa, marca, referencia, modelo, num_ruedas, num_puertas,is_gasolina,precio);

        Concesionario.getInstancia().getAdmin().registrarVehiculo(auto);


    }

    @FXML
    void seleccionarCombustible(ActionEvent event) {

        if(comb_gasolina.getSelectionModel().getSelectedItem().equalsIgnoreCase("si")){
            opcion = "true";
        }else{
            opcion = "false";
        }


    }

    public void initialize(URL url, ResourceBundle rb){
        ObservableList<String> list = FXCollections.observableArrayList("Si","No");
        comb_gasolina.setItems(list);

    }

}
