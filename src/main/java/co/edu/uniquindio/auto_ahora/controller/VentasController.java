package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.*;
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

        Vehiculo vehiculo = this.tblVehiculosRegistrados.getSelectionModel().getSelectedItem();    //Selecciona el vehiculo
                                                                                                   //sobre el cual el usuario da click
        if(vehiculo==null){                                                                        //si el usuario no ha seleccionado un vehiculo
            Alert alert = new Alert(Alert.AlertType.ERROR);                                        //Salta alerta
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
            this.vehiculos.remove(vehiculo);
            this.tblVehiculosVendidos.setItems(vehiculos_vendidos);
            this.tblVehiculosRegistrados.refresh();
            this.tblVehiculosVendidos.refresh();

        }

    }

    @FXML
    void generarReporte(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);                                        //Salta alerta
        alert.setHeaderText(null);
        alert.setTitle("Reporte");
        alert.setContentText("AQUÍ VAN TODOS LOS AUTOS VENDIDOS");
        alert.showAndWait();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int cont_auto = 0;                                                                          //Contadores para saber cuantos vehiculos
        int cont_moto = 0;
        int cont_camion = 0;
        vehiculos = FXCollections.observableArrayList();                                          //hay de cada uno (auto, moto, camion)

        this.col_marca_registrado.setCellValueFactory(new PropertyValueFactory<>("marca"));      //Valores que se van a setear en la tabla de
        this.col_placa_registrado.setCellValueFactory(new PropertyValueFactory<>("placa"));      //vehiculos registrados
        this.col_precio_registrado.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.col_tipo_vehiculo.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));

        this.vehiculos.addAll(Concesionario.getInstancia().getDataBase().getListaVehiculos());   //Setear todos los registros de la 'ObservableList' vehiculos
        this.tblVehiculosRegistrados.setItems(vehiculos);                                        //directamente a la tabla

        for(Vehiculo vehiculo:vehiculos){                                                       //Este ciclo recorre los vehiculos
            switch (vehiculo.queSoy()){                                                 //Dependiendo de que vehiculo sea (auto, moto, camion)
                                                                                        //se suma al contador correspondiente para setearlo en el textField
                case "Auto":
                    cont_auto+=1;
                    break;

                case "Moto":
                    cont_moto+=1;
                    break;

                case "Camion":
                    cont_camion+=1;
                    break;
            }
        }

        this.txt_num_autos.setText(String.valueOf(cont_auto));                                 //Para setear los valores de contador en textField
        this.txt_num_motos.setText(String.valueOf(cont_moto));                                 //de cada vehiculo que se hayan obtenido en el ciclo
        this.txt_num_camiones.setText(String.valueOf(cont_camion));                               //estos deben ir en tipo String

        vehiculos_vendidos = FXCollections.observableArrayList();
        this.col_marca_vendido.setCellValueFactory(new PropertyValueFactory<>("marcaVendida"));  //De igual forma para setear valores y registros
        this.col_placa_vendido.setCellValueFactory(new PropertyValueFactory<>("placaVendida"));  //en la tabla de vehiculos vendidos
        this.col_comprador.setCellValueFactory(new PropertyValueFactory<>("comprador"));

        this.vehiculos_vendidos.addAll(Concesionario.getInstancia().getDataBase().getListaVentas());
        this.tblVehiculosVendidos.setItems(vehiculos_vendidos);
    }
}
