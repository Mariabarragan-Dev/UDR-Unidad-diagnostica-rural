package com.udr.model;

public class Informe {
    private int idInforme;
    private String resultado;
    private String fecha;
    private int idCitas;
    private int idEspecialista;
    private int idPacientes;

    public Informe (){}

    public Informe(int idInforme, String resultado, String fecha, int idCitas, int idEspecialista, int idPacientes) {
        this.idInforme = idInforme;
        this.resultado = resultado;
        this.fecha = fecha;
        this.idCitas = idCitas;
        this.idEspecialista = idEspecialista;
        this.idPacientes = idPacientes;
    }

    public int getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public int getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(int idPacientes) {
        this.idPacientes = idPacientes;
    }
    @Override
    public String toString() {
        return "ID: " + idInforme +  "Fecha: " + fecha +
                "   Resultado: " + resultado + "   IDEspecialista: " + idEspecialista +
                "   IDCitas: " + idCitas +
                "   IDPacientes: " + idPacientes;
    }
}
