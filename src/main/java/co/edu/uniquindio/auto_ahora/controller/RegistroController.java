package co.edu.uniquindio.auto_ahora.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {

    @FXML
    private Button btnAutomovil;

    @FXML
    private Button btnCamion;

    @FXML
    private Button btnMoto;

    @FXML
    void abrirRegistroAutomovil(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/auto_ahora/view/registro-auto-view.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Registro Auto");
        stage.setScene(scene);

        RegistroAutoController controller = loader.getController();
        stage.show();
    }

    @FXML
    void abrirRegistroCamion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/auto_ahora/view/registro-camion-view.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Registro Camion");
        stage.setScene(scene);

        RegistroCamionController controller = loader.getController();
        stage.show();
    }

    @FXML
    void abrirRegistroMoto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/auto_ahora/view/registro-moto-view.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Registro Moto");
        stage.setScene(scene);

        RegistroMotoController controller = loader.getController();
        stage.show();
    }

}
