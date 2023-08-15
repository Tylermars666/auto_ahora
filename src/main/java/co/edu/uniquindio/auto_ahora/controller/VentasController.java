package co.edu.uniquindio.auto_ahora.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class VentasController {

    @FXML
    private Button btn_vender;

    @FXML
    private TableColumn<?, ?> col_marca_registrado;

    @FXML
    private TableColumn<?, ?> col_marca_vendido;

    @FXML
    private TableColumn<?, ?> col_placa_registrado;

    @FXML
    private TableColumn<?, ?> col_placa_vendido;

    @FXML
    private TableColumn<?, ?> col_precio_registrado;

    @FXML
    private TableColumn<?, ?> col_vehiculo_registrado;

    @FXML
    private TableColumn<?, ?> col_vehiculo_vendido;

    @FXML
    private TableView<?> tblVehiculosRegistrados;

    @FXML
    private TableView<?> tblVehiculosVendidos;

    @FXML
    private TextField txt_codigo;

    @FXML
    private TextField txt_nombre_comprador;

    @FXML
    private TextField txt_placa_registrado;

    @FXML
    void seleccionarVehiculo(MouseEvent event) {

    }

    @FXML
    void venderVehiculo(ActionEvent event) {

    }

}
