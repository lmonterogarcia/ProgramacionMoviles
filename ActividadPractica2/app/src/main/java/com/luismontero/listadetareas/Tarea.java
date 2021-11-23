package com.luismontero.listadetareas;

public class Tarea {

    private Integer iIdTarea, iCategoria;
    private String sTitulo, sFecha, sHora;

    public Tarea() {

    }

    public Tarea(Integer iIdTarea, String sTitulo, String sFecha, String sHora, int iCategoria) {
        this.iIdTarea = iIdTarea;
        this.sTitulo = sTitulo;
        this.sFecha = sFecha;
        this.sHora = sHora;
        this.iCategoria = iCategoria;
    }

    public Integer getiIdTarea() {
        return iIdTarea;
    }

    public void setiIdTarea(Integer iIdTarea) {
        this.iIdTarea = iIdTarea;
    }

    public String getsTitulo() {
        return sTitulo;
    }

    public void setsTitulo(String sTitulo) {
        this.sTitulo = sTitulo;
    }

    public String getsFecha() {
        return sFecha;
    }

    public void setsFecha(String sFecha) {
        this.sFecha = sFecha;
    }

    public String getsHora() {
        return sHora;
    }

    public void setsHora(String sHora) {
        this.sHora = sHora;
    }

    public int getiCategoria() {
        return iCategoria;
    }

    public void setiCategoria(int iCategoria) {
        this.iCategoria = iCategoria;
    }
}
