package co.edu.uniquindio.auto_ahora.model;

public abstract class Vehiculo {

    private String placa;
    private double precio;
    private String marca;
    private String referencia;
    private String modelo;
    private int num_ruedas;

    public Vehiculo(){

    }

    public Vehiculo(String placa, String marca, String referencia, String modelo, int num_ruedas,double precio) {
        this.precio = precio;
        this.placa = placa;
        this.marca = marca;
        this.referencia = referencia;
        this.modelo = modelo;
        this.num_ruedas = num_ruedas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNum_ruedas() {
        return num_ruedas;
    }

    public double getPrecio(){return precio;}

    public void setPrecio(double precio){this.precio = precio;}

    public void setNum_ruedas(int num_ruedas) {
        this.num_ruedas = num_ruedas;
    }

    public abstract String queSoy();


}
