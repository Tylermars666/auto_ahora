package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.Concesionario;
import co.edu.uniquindio.auto_ahora.model.Vehiculo;
import co.edu.uniquindio.auto_ahora.model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class VentasController implements Initializable {

    @FXML
    private Button btn_reporte;

    @FXML
    private Button btn_vender;

    @FXML
    private TableColumn<?, ?> col_comprador;

    @FXML
    private TableColumn<?, ?> col_tipo_vehiculo;

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
    private TableColumn<?, ?> col_vehiculo_vendido;

    @FXML
    private TableView<Vehiculo> tblVehiculosRegistrados;

    @FXML
    private TableView<Venta> tblVehiculosVendidos;

    @FXML
    private TextField txt_num_autos;

    @FXML
    private TextField txt_num_camiones;

    @FXML
    private TextField txt_num_motos;

    @FXML
    private TextField txt_codigo;

    @FXML
    private TextField txt_nombre_comprador;

    @FXML
    private TextField txt_placa_registrado;

    ObservableList<Vehiculo> vehiculos;
    ObservableList<Venta> vehiculos_vendidos;

    @FXML
    void seleccionarVehiculo(MouseEvent event) {

        Vehiculo vehiculo = this.tblVehiculosRegistrados.getSelectionModel().getSelectedItem();

        if(vehiculo!=null) {
            this.txt_placa_registrado.setText(vehiculo.getPlaca());

        }
    }

    @FXML
    void venderVehiculo(ActionEvent event) {

        Vehiculo vehiculo = this.tblVehiculosRegistrados.getSelectionModel().getSelectedItem();

        if(vehiculo==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar un vehículo primero");
            alert.showAndWait();
        }else{

            String codigo = this.txt_codigo.getText();
            String nombre_comprador = this.txt_nombre_comprador.getText();
            Venta venta = new Venta(codigo,nombre_comprador,vehiculo);

            Concesionario.getInstancia().getAdmin().venderVehiculo(venta);
            this.vehiculos_vendidos.add(venta);
            this.tblVehiculosVendidos.setItems(vehiculos_vendidos);
            this.tblVehiculosVendidos.refresh();

        }

    }

    @FXML
    void generarReporte(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        vehiculos = FXCollections.observableArrayList();

        this.col_marca_registrado.setCellValueFactory(new PropertyValueFactory<>("marca"));
        this.col_placa_registrado.setCellValueFactory(new PropertyValueFactory<>("placa"));
        this.col_precio_registrado.setCellValueFactory(new PropertyValueFactory<>("precio"));

        this.vehiculos.addAll(Concesionario.getInstancia().getDataBase().getListaVehiculos());
        this.tblVehiculosRegistrados.setItems(vehiculos);

        vehiculos_vendidos = FXCollections.observableArrayList();
        this.col_marca_vendido.setCellValueFactory(new PropertyValueFactory<>("marcaVendida"));
        this.col_placa_vendido.setCellValueFactory(new PropertyValueFactory<>("placaVendida"));

        this.vehiculos_vendidos.addAll(Concesionario.getInstancia().getDataBase().getListaVentas());
        this.tblVehiculosVendidos.setItems(vehiculos_vendidos);
    }
}
