package co.edu.uniquindio.auto_ahora.model;

import java.util.ArrayList;

public interface autoAhoraCRUD {

    //Registrar
    public void registrarVehiculo(Vehiculo vehiculo);

    //Listar
    public ArrayList<Vehiculo> listarVehiculos();


    //Eliminar

    public void eliminarVehiculo(Vehiculo vehiculo);

    //Vender
    public void venderVehiculo(Venta venta);

}
