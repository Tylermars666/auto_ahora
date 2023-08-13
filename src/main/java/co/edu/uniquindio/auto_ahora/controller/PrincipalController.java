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
    private Button btn_menu_actualizar;

    @FXML
    private Button btn_menu_busqueda;

    @FXML
    private Button btn_menu_eliminar;

    @FXML
    private Button btn_menu_registro;

    @FXML
    private Button btn_menu_ventas;

    @FXML
    void abrirMenuActualizar(ActionEvent event) {

    }

    @FXML
    void abrirMenuBusqueda(ActionEvent event) {

    }

    @FXML
    void abrirMenuEliminar(ActionEvent event) {

    }

    @FXML
    void abrirMenuRegistro(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/auto_ahora/view/registro-view.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Registros");
        stage.setScene(scene);

        RegistroController controller = loader.getController();
        stage.show();

    }

    @FXML
    void abrirMenuVentas(ActionEvent event) {

    }

}
