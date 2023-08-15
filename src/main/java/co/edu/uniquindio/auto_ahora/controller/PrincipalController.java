package co.edu.uniquindio.auto_ahora.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {


    @FXML
    private Button btn_menu_busqueda;

    @FXML
    private Button btn_menu_registro;

    @FXML
    private Button btn_menu_ventas;


    @FXML
    private Button btn_salir;

    @FXML
    void abrirMenuActualizar(ActionEvent event) {

    }

    @FXML
    void abrirMenuBusqueda(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/auto_ahora/view/busqueda-view.fxml"));

        Scene scene = new Scene(loader.load());                         //Metodo para conectar ventana principal con ventana Busqueda
        Stage stage = new Stage();
        stage.setTitle("Busqueda");
        stage.setScene(scene);

        BusquedaController controller = loader.getController();
        stage.show();

    }


    @FXML
    void abrirMenuRegistro(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/auto_ahora/view/registro-view.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();                                 //Método para conectar ventana principal con ventana de Registro
        stage.setTitle("Registros");
        stage.setScene(scene);

        RegistroController controller = loader.getController();
        stage.show();

    }

    @FXML
    void abrirMenuVentas(ActionEvent event) {

    }

    @FXML
    void cerrarAplicacion(ActionEvent event) {

    }

}
