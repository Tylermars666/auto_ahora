package co.edu.uniquindio.auto_ahora.model;

import java.time.LocalDate;

public class Venta {

    private String marcaVendida;
    private String placaVendida;
    private String codigo;
    private String comprador;
    private Vehiculo vehiculo;
    private LocalDate fecha;

    public Venta(){
        fecha = LocalDate.now();
    }

    public Venta(String codigo, String comprador, Vehiculo vehiculo) {
        this.placaVendida = vehiculo.getPlaca();
        this.marcaVendida = vehiculo.getMarca();
        this.codigo = codigo;
        this.comprador = comprador;
        this.vehiculo = vehiculo;
    }

    public String getMarcaVendida() {
        return marcaVendida;
    }

    public void setMarcaVendida(String marcaVendida) {
        this.marcaVendida = marcaVendida;
    }

    public String getPlacaVendida() {
        return placaVendida;
    }

    public void setPlacaVendida(String placaVendida) {
        this.placaVendida = placaVendida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}


