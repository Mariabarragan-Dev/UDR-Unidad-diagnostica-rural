package com.udr.model;

public class Citas {
    private int idCitas;
    private String hora;
    private String estado;
    private String fecha;
    private int idPacientes;
    private int idEspecialista;
    private int idMunicipio;
    private int idtipoPrueba;
    private int idUnidadMovil;

    public Citas (){}


    public Citas(int idCitas, String hora, String estado, String fecha, int idPacientes, int idEspecialista, int idMunicipio, int idtipoPrueba, int idUnidadMovil) {
        this.idCitas = idCitas;
        this.hora = hora;
        this.estado = estado;
        this.fecha = fecha;
        this.idPacientes = idPacientes;
        this.idEspecialista = idEspecialista;
        this.idMunicipio = idMunicipio;
        this.idtipoPrueba = idtipoPrueba;
        this.idUnidadMovil = idUnidadMovil;
    }

    public int getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(int idPacientes) {
        this.idPacientes = idPacientes;
    }

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdtipoPrueba() {
        return idtipoPrueba;
    }

    public void setIdtipoPrueba(int idtipoPrueba) {
        this.idtipoPrueba = idtipoPrueba;
    }

    public int getIdUnidadMovil() {
        return idUnidadMovil;
    }

    public void setIdUnidadMovil(int idUnidadMovil) {
        this.idUnidadMovil = idUnidadMovil;
    }

    @Override
    public String toString() {
        return "ID: " + idCitas + "   Estado: " + estado +  "Fecha: " + fecha +
                "   Hora: " + hora + "   IDEspecialista: " + idEspecialista +
                "   IDMunicipio: " + idMunicipio + "   IDTipoPrueba: " + idtipoPrueba +
                "   IDUnidadMovil: " + idUnidadMovil +
                "   IDPacientes: " + idPacientes;
    }
}
