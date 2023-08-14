package co.edu.uniquindio.auto_ahora.model;

public class Moto extends Vehiculo {

    private int cilindraje;
    private double tam_tanque;

    public Moto(){}

    public Moto(String placa, String marca, String referencia, String modelo, int num_ruedas, int cilindraje, double tam_tanque, double precio) {
        super(placa, marca, referencia, modelo, num_ruedas, precio);
        this.cilindraje = cilindraje;
        this.tam_tanque = tam_tanque;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getTam_tanque() {
        return tam_tanque;
    }

    public void setTam_tanque(double tam_tanque) {
        this.tam_tanque = tam_tanque;
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
                "Cilindraje: " + this.getCilindraje() + "\n" +
                "Tamaño tanque: " + this.getTam_tanque();


    }
}
