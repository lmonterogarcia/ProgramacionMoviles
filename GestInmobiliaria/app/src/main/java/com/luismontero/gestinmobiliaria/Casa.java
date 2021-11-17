package com.luismontero.gestinmobiliaria;

public class Casa {

    private Integer iIdCasa, iNumero;
    private String sCalle;
    private Double dSuperficie;

    public Casa() {
    }

    public Casa(String sCalle, Integer iNumero, Double dSuperficie) {
        this.iNumero = iNumero;
        this.sCalle = sCalle;
        this.dSuperficie = dSuperficie;
    }

    public Casa(Integer iId, String sCalle, Integer iNumero, Double dSuperficie) {
        this.iIdCasa = iId;
        this.iNumero = iNumero;
        this.sCalle = sCalle;
        this.dSuperficie = dSuperficie;
    }

    public Integer getiIdCasa() {
        return iIdCasa;
    }

    public void setiIdCasa(Integer iIdCasa) {
        this.iIdCasa = iIdCasa;
    }

    public Integer getiNumero() {
        return iNumero;
    }

    public void setiNumero(Integer iNumero) {
        this.iNumero = iNumero;
    }

    public String getsCalle() {
        return sCalle;
    }

    public void setsCalle(String sCalle) {
        this.sCalle = sCalle;
    }

    public Double getdSuperficie() {
        return dSuperficie;
    }

    public void setdSuperficie(Double dSuperficie) {
        this.dSuperficie = dSuperficie;
    }

    @Override
    public String toString() {
        return "Casa [iId=" + iIdCasa + ", iNumero=" + iNumero + ", sCalle=" + sCalle + ", dSuperficie=" + dSuperficie
                + "]";
    }

}
