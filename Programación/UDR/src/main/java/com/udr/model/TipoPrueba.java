package com.udr.model;

public class TipoPrueba {
    private int idTipoPrueba;
    private String categoria;
    private String duracion;
    private String preparacion;
    private String zona;

    public TipoPrueba (){}

    public TipoPrueba(int idTipoPrueba, String categoria, String duracion, String preparacion, String zona) {
        this.idTipoPrueba = idTipoPrueba;
        this.categoria = categoria;
        this.duracion = duracion;
        this.preparacion = preparacion;
        this.zona = zona;
    }

    public int getIdTipoPrueba() {
        return idTipoPrueba;
    }

    public void setIdTipoPrueba(int idTipoPrueba) {
        this.idTipoPrueba = idTipoPrueba;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString(){
        return "ID: " + idTipoPrueba + "Categoria: " + categoria +  "Duracion: " + duracion +
                "Preparacion: " + preparacion +  "Zona: " + zona;
    }
}
