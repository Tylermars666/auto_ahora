package co.edu.uniquindio.auto_ahora.controller;

import co.edu.uniquindio.auto_ahora.model.*;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
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
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class BusquedaController implements Initializable {

    //------------------------------------ATRIBUTOS------------------------------

    String filtro_seleccionado;                                    //Atributo que corresponde al filtro seleccionado del combobox

    String valor_filtro;                                           //Atributo que corresponde al valor de filtro escrito en textField

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtNumRuedas;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtReferencia;

    @FXML
    private TextField txtAdicional_1;

    @FXML
    private TextField txtAdicional_2;

    @FXML
    private Button txtEliminar;

    @FXML
    private Button btnActualizar;

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

    private ObservableList<Vehiculo> vehiculos;                           //Observable List para tabla de vehiculos

    private ObservableList<Vehiculo> filtro_vehiculos;                    //Observable List para tabla aplicando filtro

    private ObservableList<String> opciones_filtro;                       //Observable List para el Combobox


    //---------------------------------------MÉTODOS-------------------------------------------

    @FXML
    void seleccionarVehiculoTabla(MouseEvent event) {
        Vehiculo vehiculo = this.tbt_lista_vehiculos.getSelectionModel().getSelectedItem();

        if(vehiculo!=null){

            this.txtPlaca.setText(vehiculo.getPlaca());
            this.txtMarca.setText(vehiculo.getMarca());
            this.txtReferencia.setText(vehiculo.getReferencia());
            this.txtModelo.setText(vehiculo.getModelo());
            this.txtPrecio.setText(String.valueOf(vehiculo.getPrecio()));
            this.txtNumRuedas.setText(String.valueOf(vehiculo.getNum_ruedas()));

            switch (vehiculo.queSoy()){

                case "Auto":
                    Auto auto = (Auto) vehiculo;
                    this.txtAdicional_1.setText(String.valueOf(auto.getNum_puertas()));
                    this.txtAdicional_2.setText(String.valueOf(auto.isGasolina()));
                    break;

                case "Moto":
                    Moto moto = (Moto)vehiculo;
                    this.txtAdicional_1.setText(String.valueOf(moto.getCilindraje()));
                    this.txtAdicional_2.setText(String.valueOf(moto.getTam_tanque()));
                    break;

                case "Camion":
                    Camion camion = (Camion)vehiculo;
                    this.txtAdicional_1.setText(String.valueOf(camion.getCap_carga()));
            }
        }
    }

    @FXML
    void actualizarVehiculo(ActionEvent event) {

    }

    @FXML
    void eliminarVehiculo(ActionEvent event) {

    }

    @FXML
    void seleccionarFiltro(ActionEvent event) {

        filtro_seleccionado = cmb_filtro_busqueda.getSelectionModel().getSelectedItem();       //Método que almacena en String
                                                                                               //el atributo por el cual se va a
                                                                                               //filtrar la busqueda (combobox)
    }

    @FXML
    void filtrarTexto(KeyEvent event) {                                                    //Este método usa una estructura de decisión switch
                                                                                          //para decidir que método usar cuando para filtrar
        switch (filtro_seleccionado){                                                    //la busqueda cuando escribimos en el textField de la
                                                                                        //ventana de Busqueda
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




    //------------------------------------------------------REFACTOR METHODS------------------------------------

                                                                                           //Este método es el que se invoca cuando
    public void filtrarPorPlaca(){                                                        //elegimos 'placa' en el combobox y escribimos en el textField

        valor_filtro = this.txt_valor_filtro.getText();                                  //Guarda en la variable valor_filtro lo que escribimos en el textField
        if(valor_filtro.isEmpty()){                                                      //Si el textField está vacío, lo que hace esta línea es
            this.tbt_lista_vehiculos.setItems(vehiculos);                               //Setear en la tabla los valores que ya están en la base de datos
        }else{
            this.filtro_vehiculos.clear();                                              //Si el textfield no está vacío, lo que hace es limpiar la tabla
            for(Vehiculo vehiculo : this.vehiculos){                                    //Luego recorrer todos los objetos vehiculos dentro del
                if(vehiculo.getPlaca().contains(valor_filtro.toLowerCase())){          //ObservableList de vehiculos (que corresponden a los vehiculos registrados en la base de datos)
                    this.filtro_vehiculos.add(vehiculo);                               //Si lo que escribimos en el textfield es similar al atributo del vehiculo, se irá agregando a la tabla
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);                       //Por último se agregan a la tabla todos los vehiculos que coincidan
        }                                                                              //con la busqueda escrita en el textfield
    }

    public void filtrarPorMarca(){
        valor_filtro = this.txt_valor_filtro.getText();                       //Funciona igual que el anterior, solo cambia el atributo
        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(vehiculo.getMarca().toLowerCase().contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }
    }

    public void filtrarPorReferencia(){                                      //Funciona igual que el anterior, solo cambia el atributo
        valor_filtro = this.txt_valor_filtro.getText();
        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(vehiculo.getReferencia().toLowerCase().contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }
    }

    public void filtrarPorModelo(){                                         //Funciona igual que el anterior, solo cambia el atributo
        valor_filtro = this.txt_valor_filtro.getText();
        if(valor_filtro.isEmpty()){
            this.tbt_lista_vehiculos.setItems(vehiculos);
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(vehiculo.getModelo().toLowerCase().contains(valor_filtro.toLowerCase())){
                    this.filtro_vehiculos.add(vehiculo);
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }

    }

    public void filtrarPorPrecio(){
        valor_filtro = this.txt_valor_filtro.getText();                                      //Este funciona igual que los demás
                                                                                            //Solo cambia en un aspecto, ya que este es un atributo
        if(valor_filtro.isEmpty()){                                                         //de tipo double y tiene que hacerse un Parse a String
            this.tbt_lista_vehiculos.setItems(vehiculos);                                   //y luego si poder comparar los atributos
        }else{
            this.filtro_vehiculos.clear();
            for(Vehiculo vehiculo : this.vehiculos){
                if(String.valueOf(vehiculo.getPrecio()).contains(valor_filtro.toLowerCase())){   //El parse se hace en esta línea
                    this.filtro_vehiculos.add(vehiculo);                                         //con String.valueOf(vehiculo.getPrecio)
                }
            }
            this.tbt_lista_vehiculos.setItems(filtro_vehiculos);
        }
    }


}
