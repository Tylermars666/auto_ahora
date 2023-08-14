package co.edu.uniquindio.auto_ahora.controller;

import javafx.event.ActionEvent;
import co.edu.uniquindio.auto_ahora.model.Concesionario;
import co.edu.uniquindio.auto_ahora.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class BusquedaController implements Initializable {

    String filtro_seleccionado;

    String valor_filtro;

    @FXML
    private ComboBox<String> cmb_filtro_busqueda;

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

    private ObservableList<Vehiculo> vehiculos;                     //Observable List para tabla de vehiculos
    private ObservableList<Vehiculo> filtro_vehiculos;              //Observable List para tabla aplicando filtro
    private ObservableList<String> opciones_filtro;                 //Observable List para el Combobox

    @FXML
    void seleccionarFiltro(ActionEvent event) {

        //placa, marca, modelo, referencia, precio
        filtro_seleccionado = cmb_filtro_busqueda.getSelectionModel().getSelectedItem();



    }

    @FXML
    void filtrarTexto(KeyEvent event) {

        switch (filtro_seleccionado){

            case "placa":
               filtrarPorPlaca();
                break;

            case "marca":
               filtrarPorMarca();
                break;

            case "referencia":
                filtrarPorReferencia();
                break;

            case "modelo":
                filtrarPorModelo();
                break;

            case "precio":
                filtrarPorPrecio();
        }



    }

    public void filtrarPorPlaca(){

        valor_filtro = this.txt_valor_filtro.getText();
        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(vehiculo.getMarca().contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }
    }

    public void filtrarPorMarca(){
        valor_filtro = this.txt_valor_filtro.getText();
        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(vehiculo.getMarca().contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }
    }
    public void filtrarPorReferencia(){
        valor_filtro = this.txt_valor_filtro.getText();
        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(vehiculo.getReferencia().contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }
    }
    public void filtrarPorModelo(){
        valor_filtro = this.txt_valor_filtro.getText();
        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(vehiculo.getModelo().contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }

    }
    public void filtrarPorPrecio(){
        valor_filtro = this.txt_valor_filtro.getText();

        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(String.valueOf(vehiculo.getPrecio()).contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        opciones_filtro = FXCollections.observableArrayList("placa","marca","referencia","modelo","precio"); //Lineas para agregar
        cmb_filtro_busqueda.setItems(opciones_filtro);                                                     //opciones al combobox

        vehiculos = FXCollections.observableArrayList();
        filtro_vehiculos = FXCollections.observableArrayList();                                 //Lista para cargar en la tabla

        this.col_placa.setCellValueFactory(new PropertyValueFactory<>("placa"));               //Estas lineas son para indicarle
        this.col_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));               //a la tabla de la ventana de busqueda
        this.col_referencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));     //cuales son los valores que se van
        this.col_modelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));             //a agregar a cada columna
        this.col_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.col_numero_ruedas.setCellValueFactory(new PropertyValueFactory<>("num_ruedas"));

        this.vehiculos.addAll(Concesionario.getInstancia().getDataBase().getListaVehiculos());  //Este es un método que recorre los objetos
        this.tbt_lista_vehiculos.setItems(vehiculos);                                           //y los va agregando a la tabla
                                                                                                //en este caso, todos los vehiculos




    }
}
