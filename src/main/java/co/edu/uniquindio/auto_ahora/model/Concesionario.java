package co.edu.uniquindio.auto_ahora.model;

import co.edu.uniquindio.auto_ahora.persistence.DataBase;

public class Concesionario {


    public final String NOMBRE = "Auto Ahora";
    private static Concesionario instancia;
    private Administrador admin;
    private DataBase dataBase;

    private Concesionario(){

        dataBase = new DataBase();
        admin = new Administrador(dataBase);

    }

    public static Concesionario getInstancia(){     //Método para acceder a la instancia única de concesionario (SINGLETON)
        if(instancia==null){
            instancia = new Concesionario();
        }
        return instancia;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
