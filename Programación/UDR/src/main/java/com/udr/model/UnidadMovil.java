package com.udr.model;

public class UnidadMovil {
    private int idUnidadMovil;
    private String estado;
    private String matricula;
    private String modelo;

    public UnidadMovil (){}

    public UnidadMovil(int idUnidadMovil, String estado, String matricula, String modelo) {
        this.idUnidadMovil = idUnidadMovil;
        this.estado = estado;
        this.matricula = matricula;
        this.modelo = modelo;
    }

    public int getIdUnidadMovil() {
        return idUnidadMovil;
    }

    public void setIdUnidadMovil(int idUnidadMovil) {
        this.idUnidadMovil = idUnidadMovil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    @Override
    public String toString (){
        return "ID: " +idUnidadMovil +  "Estado: " +estado +  "Matrícula: " +matricula +
                "Modelo: " +modelo;
    }
}
