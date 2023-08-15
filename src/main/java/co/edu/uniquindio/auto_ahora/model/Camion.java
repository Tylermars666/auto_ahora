package co.edu.uniquindio.auto_ahora.model;

public class Camion extends Vehiculo {

    int cap_carga;

    public Camion (){}

    public Camion (String placa, String marca, String referencia, String modelo, int num_ruedas,double precio, int cap_carga){

        super(placa, marca, referencia, modelo, num_ruedas, precio);
        this.cap_carga = cap_carga;
    }

    public int getCap_carga() {
        return cap_carga;
    }

    public void setCap_carga(int cap_carga) {
        this.cap_carga = cap_carga;
    }

    @Override
    public String queSoy() {
        return "Camion";
    }

    @Override
    public String toString(){          //Método toString para imprimir en consola los valores del objeto creado.

        return "Moto \n" +
                "Precio: " + this.getPrecio() + "\n" +
                "Placa: " + this.getPlaca() + "\n" +
                "Marca: " + this.getMarca() + "\n" +
                "Referencia: " + this.getReferencia() + "\n" +
                "Modelo: " + this.getModelo() + "\n" +
                "Numero de Ruedas: " + this.getNum_ruedas() + "\n" +
                "Capacidad de Carga: " + cap_carga;

    }
}
