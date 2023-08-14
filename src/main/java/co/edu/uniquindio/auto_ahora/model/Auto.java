package co.edu.uniquindio.auto_ahora.model;

public class Auto extends Vehiculo {

    private int num_puertas;
    private boolean isGasolina;

    public Auto(){}

    public Auto(String placa, String marca, String referencia, String modelo, int num_ruedas, int num_puertas, boolean isGasolina) {
        super(placa, marca, referencia, modelo, num_ruedas);
        this.num_puertas = num_puertas;
        this.isGasolina = isGasolina;
    }

    public int getNum_puertas() {
        return num_puertas;
    }

    public void setNum_puertas(int num_puertas) {
        this.num_puertas = num_puertas;
    }

    public boolean isGasolina() {
        return isGasolina;
    }

    public void setGasolina(boolean gasolina) {
        isGasolina = gasolina;
    }

    @Override
    public String toString() {
        return super.toString()+" num_puertas=" + num_puertas +
                ", isGasolina=" + isGasolina +
                '}';
    }
}
