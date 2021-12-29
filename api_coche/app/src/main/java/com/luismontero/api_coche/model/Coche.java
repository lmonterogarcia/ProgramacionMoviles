package com.luismontero.api_coche.model;

public class Coche {

    private int id_coche;
    private String marca;
    private int potencia;

    public Coche(int id_coche) {
    }

    public Coche(int id_coche, String marca, int potencia) {
        this.id_coche = id_coche;
        this.marca = marca;
        this.potencia = potencia;
    }

    public int getId_coche() {
        return id_coche;
    }

    public void setId_coche(int id_coche) {
        this.id_coche = id_coche;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Coche con id " + id_coche +
                "\n\tmarca: " + marca +
                "\n\tpotencia: " + potencia + " cv";
    }


}
