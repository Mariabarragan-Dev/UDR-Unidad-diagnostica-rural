package com.udr.model;

public class Paciente {
    private int idPaciente;
    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaNacimiento;
    private String telefono;
    private int idMunicipio;

    public Paciente(){}
    public Paciente(int idPaciente, String nombre, String apellidos, String dni, String fechaNacimiento, String telefono, int idMunicipio) {
        this.idMunicipio = idMunicipio;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.idPaciente = idPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    @Override
    public String toString() {
        return "ID: " + idPaciente + "  Nombre: " + nombre + " " + apellidos +
                "  DNI: " + dni + "  Telefono: " + telefono;
    }
}
