package com.udr.model;

public class Especialista {

    private int idEspecialista;
    private String nombre;
    private String apellidos;
    private String especialidad;
    private String hospital;
    private String telefono;
    private String provincia;

    public Especialista (){}

    public Especialista(int idEspecialista, String nombre, String apellidos, String especialidad, String hospital, String telefono, String provincia) {
        this.idEspecialista = idEspecialista;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.hospital = hospital;
        this.telefono = telefono;
        this.provincia = provincia;
    }

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    @Override
    public String toString() {
        return "ID: " + idEspecialista + "   Nombre: " + nombre + " " + apellidos +
                "   Especialidad: " + especialidad + "   Telefono: " + telefono +
                "   Hospital: " + hospital +
                "   Provincia: " + provincia;
    }
}
