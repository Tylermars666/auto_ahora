package co.edu.uniquindio.auto_ahora.persistence;

import co.edu.uniquindio.auto_ahora.model.Auto;
import co.edu.uniquindio.auto_ahora.model.Vehiculo;
import co.edu.uniquindio.auto_ahora.model.Venta;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Venta> listaVentas;

    public DataBase(){
        listaVehiculos = new ArrayList<Vehiculo>();
        listaVentas = new ArrayList<Venta>();
        listaVehiculos.add(new Auto("123","Toyota","col123toy","Tacoma",4,4,true,1500000.0));
    }

    public ArrayList<Vehiculo> getListaVehiculos(){
        return this.listaVehiculos;
    }

    public ArrayList<Venta> getListaVentas(){
        return this.listaVentas;
    }

    public void setVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
        System.out.println(vehiculo.toString());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);     //Alerta de JavaFx para mostrar mensaje en la interfaz gráfica
        alert.setHeaderText(null);
        alert.setTitle("Registro Exitoso");
        alert.setContentText(vehiculo.toString());
        alert.showAndWait();
    }

    public void setVenta(Venta venta){
        listaVentas.add(venta);
    }
}
