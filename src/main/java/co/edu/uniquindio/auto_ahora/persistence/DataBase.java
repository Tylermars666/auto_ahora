package co.edu.uniquindio.auto_ahora.persistence;

import co.edu.uniquindio.auto_ahora.model.Vehiculo;
import co.edu.uniquindio.auto_ahora.model.Venta;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Venta> listaVentas;

    public DataBase(){
        listaVehiculos = new ArrayList<Vehiculo>();
        listaVentas = new ArrayList<Venta>();
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
    }

    public void setVenta(Venta venta){
        listaVentas.add(venta);
    }
}
