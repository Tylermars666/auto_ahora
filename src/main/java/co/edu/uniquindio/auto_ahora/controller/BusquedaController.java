package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.Concesionario;
import co.edu.uniquindio.auto_ahora.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BusquedaController implements Initializable {

    @FXML
    private Button btn_filtro;

    @FXML
    private ComboBox<?> cmb_filtro_busqueda;

    @FXML
    private TableColumn<?, ?> col_marca;

    @FXML
    private TableColumn<?, ?> col_modelo;

    @FXML
    private TableColumn<?, ?> col_numero_ruedas;

    @FXML
    private TableColumn<?, ?> col_placa;

    @FXML
    private TableColumn<?, ?> col_precio;

    @FXML
    private TableColumn<?, ?> col_referencia;

    @FXML
    private TableView<Vehiculo> tbt_lista_vehiculos;

    @FXML
    private TextField txt_valor_filtro;

    private ObservableList<Vehiculo> vehiculos;

    @FXML
    void aplicarFiltroBusqueda(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        vehiculos = FXCollections.observableArrayList();                                         //Lista para cargar en la tabla

        this.col_placa.setCellValueFactory(new PropertyValueFactory<>("placa"));               //Estas lineas son para indicarle
        this.col_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));               //a la tabla de la ventana de busqueda
        this.col_referencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));     //cuales son los valores que se van
        this.col_modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));             //a agregar a cada columna
        this.col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.col_numero_ruedas.setCellValueFactory(new PropertyValueFactory<>("num_ruedas"));

        for(Vehiculo vehiculo : Concesionario.getInstancia().getDataBase().getListaVehiculos()){    //Este ciclo recorre los objetos
            this.vehiculos.add(vehiculo);                                                           //y los va agregando a la tabla
            this.tbt_lista_vehiculos.setItems(vehiculos);                                          //en este caso, todos los vehiculos
        }


    }
}
