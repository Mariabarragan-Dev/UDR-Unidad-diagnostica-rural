package com.udr.model;

public class Ruta {
    private int idMunicipio;
    private int idUnidadMovil;
    private String fecha;

    public Ruta (){}

    public Ruta(int idMunicipio, int idUnidadMovil, String fecha) {
        this.idMunicipio = idMunicipio;
        this.idUnidadMovil = idUnidadMovil;
        this.fecha = fecha;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdUnidadMovil() {
        return idUnidadMovil;
    }

    public void setIdUnidadMovil(int idUnidadMovil) {
        this.idUnidadMovil = idUnidadMovil;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString(){
        return "IDMunicipio: " + idMunicipio +  "IDUnidadMovil: " + idUnidadMovil + "Fecha: " + fecha;

    }
}
