package co.edu.uniquindio.auto_ahora.model;

import co.edu.uniquindio.auto_ahora.persistence.DataBase;

import java.util.ArrayList;

public class Administrador implements autoAhoraCRUD {

    private DataBase dataBase;

    public Administrador(DataBase dataBase){
        this.dataBase=dataBase;
    }

    @Override
    public void registrarVehiculo(Vehiculo vehiculo) {
        dataBase.setVehiculo(vehiculo);
    }

    @Override
    public ArrayList<Vehiculo> listarVehiculos() {
        return null;
    }
}
