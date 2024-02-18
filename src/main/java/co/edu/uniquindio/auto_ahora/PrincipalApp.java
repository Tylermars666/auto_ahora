package co.edu.uniquindio.auto_ahora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : Omar Piedrahita - Carlos Mancera
 * @description : Aplicación para gestionar registro y ventana de vehículos
 */

public class PrincipalApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApp.class.getResource("view/principal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(); //launch(PrincipalApp.class,args);
    }
}