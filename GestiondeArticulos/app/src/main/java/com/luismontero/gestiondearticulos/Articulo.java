package com.luismontero.gestiondearticulos;

public class Articulo {
    private String sNombre;
    private Double dPrecio;
    private Integer iStock;

    public Articulo() {
        this.sNombre = "";
        this.dPrecio = null;
        this.iStock = null;
    }
    
    public Articulo(String sNombre, Double dPrecio, Integer iStock) {
        this.sNombre = sNombre;
        this.dPrecio = dPrecio;
        this.iStock = iStock;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public Double getdPrecio() {
        return dPrecio;
    }

    public void setdPrecio(Double dPrecio) {
        this.dPrecio = dPrecio;
    }

    public Integer getiStock() {
        return iStock;
    }

    public void setiStock(Integer iStock) {
        this.iStock = iStock;
    }

    @Override
    public String toString() {
        return "Articulos{" +
                "sNombre='" + sNombre + '\'' +
                ", dPrecio=" + dPrecio +
                ", iStock=" + iStock +
                '}';
    }
}
