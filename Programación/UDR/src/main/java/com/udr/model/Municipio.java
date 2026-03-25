package com.udr.model;

public class Municipio {
    private int idMunicipio;
    private String cAutonoma;
    private String nombre;
    private String provincia;

    public Municipio (){}

    public Municipio(int idMunicipio, String cAutonoma, String nombre, String provincia) {
        this.idMunicipio = idMunicipio;
        this.cAutonoma = cAutonoma;
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getcAutonoma() {
        return cAutonoma;
    }

    public void setcAutonoma(String cAutonoma) {
        this.cAutonoma = cAutonoma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    @Override
    public String toString(){
        return "ID: " + idMunicipio +  "Nombre: " + nombre +  "Provincia: " + provincia +
                "C.Autonoma: " + cAutonoma;


    }
}
