package co.edu.uniquindio.auto_ahora.model;

import co.edu.uniquindio.auto_ahora.persistence.DataBase;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Administrador implements autoAhoraCRUD {

    private DataBase dataBase;

    public Administrador(DataBase dataBase){
        this.dataBase=dataBase;
    }

    @Override
    public void registrarVehiculo(Vehiculo vehiculo) {

        boolean existePlaca = false;

        for(Vehiculo v : dataBase.getListaVehiculos()){
            if (v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
                existePlaca = true;
                break;
            }
        }
        if(existePlaca){
            Alert alert = new Alert(Alert.AlertType.ERROR);     //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ya existe un vehículo con esa placa registrada");
            alert.showAndWait();
        }else{
            dataBase.setVehiculo(vehiculo);
        }



    }

    @Override
    public ArrayList<Vehiculo> listarVehiculos() {
        return null;
    }
}
