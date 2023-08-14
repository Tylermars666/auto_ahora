package co.edu.uniquindio.auto_ahora.persistence;

import co.edu.uniquindio.auto_ahora.model.Vehiculo;
import co.edu.uniquindio.auto_ahora.model.Venta;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Venta> listaVentas;

    public DataBase(){}

    public ArrayList<Vehiculo> getListaVehiculos(){
        return this.listaVehiculos;
    }

    public ArrayList<Venta> getListaVentas(){
        return this.listaVentas;
    }

    public void setVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }

    public void setVenta(Venta venta){
        listaVentas.add(venta);
    }
}
