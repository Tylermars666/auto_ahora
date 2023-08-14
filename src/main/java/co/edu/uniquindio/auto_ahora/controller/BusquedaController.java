package co.edu.uniquindio.auto_ahora.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BusquedaController {

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
    private TableView<?> tbt_lista_vehiculos;

    @FXML
    private TextField txt_valor_filtro;

    @FXML
    void aplicarFiltroBusqueda(ActionEvent event) {

    }

}
