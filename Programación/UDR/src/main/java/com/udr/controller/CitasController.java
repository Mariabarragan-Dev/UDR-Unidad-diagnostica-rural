package com.udr.controller;

import com.udr.dao.CitasDAO;
import com.udr.model.Citas;


import java.util.List;
import java.util.Scanner;

public class CitasController {
    private CitasDAO gestorCitas = new CitasDAO();
    private Scanner teclado;

    public CitasController(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrar() {
        int opcion;

        do {
            System.out.println("Gestion de Citas");
            System.out.println("1. Ver todas las citas");
            System.out.println("2. Ver citas pendientes");
            System.out.println("3. Crear cita de resonancia");
            System.out.println("4. Cancelar cita");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1 -> verTodas();
                case 2 -> verPendientes();
                case 3 -> crearCita();
                case 4 -> cancelar();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }
    private void verTodas() {
        List<Citas> citas = gestorCitas.listarCitas();
        for (Citas c : citas) {
            System.out.println(c.toString());
        }
    }
    private  void verPendientes(){
        List<Citas> citas = gestorCitas.listarPendientes();
        for (Citas c: citas){
            System.out.print(c.toString());
        }
    }
    private void crearCita() {
        System.out.print("ID del paciente: ");
        int idPaciente = Integer.parseInt(teclado.nextLine());

        System.out.print("ID del municipio: ");
        int idMunicipio = Integer.parseInt(teclado.nextLine());

        System.out.print("Fecha: ");
        String fecha = teclado.nextLine();

        System.out.print("Hora: ");
        String hora = teclado.nextLine();

        if (gestorCitas.crearCitaResonancia(idPaciente, idMunicipio, fecha, hora)) {
            System.out.println("Cita creada correctamente.");
        } else {
            System.out.println("No se pudo crear la cita.");
        }
    }


    private void cancelar(){
        System.out.print("Escribe el ID de la cita que se quiere cancelar: ");
        int idCita = Integer.parseInt(teclado.nextLine());

        if (gestorCitas.cancelar(idCita)){
            System.out.print("Cita cancelada");

        } else {
            System.out.print("No se ha encontrado la cita");
        }
    }
}

