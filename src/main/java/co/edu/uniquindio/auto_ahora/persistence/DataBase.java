package co.edu.uniquindio.auto_ahora.persistence;

import co.edu.uniquindio.auto_ahora.model.*;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Venta> listaVentas;

    public DataBase(){
        listaVehiculos = new ArrayList<Vehiculo>();
        listaVentas = new ArrayList<Venta>();
        listaVehiculos.add(new Auto("123","Toyota","Mate","2019",4,2,true,1600000.0));
        listaVehiculos.add(new Camion("456","Optimus","Extraterrestre","2020",6,1800000,350));
        listaVehiculos.add(new Moto("789","Suzuki","Negra","2017",2,200,3.5,1500000));
        listaVentas.add(new Venta("00001","Carlos Mancera",this.listaVehiculos.get(1)));
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
