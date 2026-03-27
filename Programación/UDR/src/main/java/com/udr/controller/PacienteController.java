package com.udr.controller;

import com.udr.dao.PacienteDAO;
import com.udr.model.Paciente;

import java.util.List;
import java.util.Scanner;

public class PacienteController {

    private PacienteDAO gestorPacientes = new PacienteDAO();
    private Scanner teclado;

    public PacienteController (Scanner teclado){
        this.teclado = teclado;
    }
    public void mostrar() {
        int opcion;

        do {
            System.out.println("Gestion de Pacientes");
            System.out.println("1. Ver todos los pacientes");
            System.out.println("2. Buscar por DNI");
            System.out.println("3. Registrar nuevo paciente");
            System.out.println("4. Actualizar telefono");
            System.out.println("5. Eliminar paciente");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1 -> verTodos();
                case 2 -> buscarPorDni();
                case 3 -> registrar();
                case 4 -> actualizar();
                case 5 -> eliminar();
                case 0 -> System.out.println("Volviendo");
                default -> System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }
    private void verTodos() {
        List<Paciente> pacientes = gestorPacientes.listarTodos();
        for (Paciente p : pacientes) {
            System.out.println(p.toString());
        }
    }
    private void buscarPorDni() {
        System.out.print("Introduce el DNI: ");
        String dni = teclado.nextLine();

        Paciente p = gestorPacientes.buscarPorDni(dni);

        if (p != null) {
            System.out.println(p.toString());
        } else {
            System.out.println("No se ha encontrado ningún paciente con ese DNI.");
        }
    }
    private void registrar() {
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = teclado.nextLine();

        System.out.print("DNI: ");
        String dni = teclado.nextLine();

        System.out.print("Fecha de nacimiento: ");
        String fecha = teclado.nextLine();

        System.out.print("Teléfono: ");
        String telefono = teclado.nextLine();

        System.out.print("ID del municipio: ");
        int idMunicipio = Integer.parseInt(teclado.nextLine());

        Paciente nuevo = new Paciente(0, nombre, apellidos, dni, fecha, telefono, idMunicipio);

        if (gestorPacientes.insertar(nuevo)) {
            System.out.println("Paciente registrado correctamente.");
        } else {
            System.out.println("No se ha podido registrar el paciente.");
        }
    }
    private void actualizar() {
        System.out.print("DNI del paciente: ");
        String dni = teclado.nextLine();

        System.out.print("Nuevo telefono: ");
        String telefono = teclado.nextLine();

        if (gestorPacientes.actualizar(dni, telefono)) {
            System.out.println("Telefono actualizado correctamente.");
        } else {
            System.out.println("No se encontro el paciente.");
        }
    }
    private void eliminar(){
       System.out.print("Escribe el DNI del paciente que se quiere eliminar: ");
       String dni = teclado.nextLine();

       if (gestorPacientes.eliminar(dni)){
           System.out.print("Paciente eliminado");

       } else {
           System.out.print("No se ha encontrado el paciente");
       }
    }
}
