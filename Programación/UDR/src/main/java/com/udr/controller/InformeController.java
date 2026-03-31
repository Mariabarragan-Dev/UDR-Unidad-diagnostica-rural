package com.udr.controller;

import com.udr.dao.InformeDAO;
import com.udr.model.Informe;

import java.util.List;
import java.util.Scanner;

public class InformeController {
private InformeDAO gestorInformes = new InformeDAO();
private Scanner teclado;
public InformeController(Scanner teclado)  {
    this.teclado = teclado;
}
public void mostrar (){
    int opcion;
    do {
        System.out.println("Gestion de Informes");
        System.out.println("1. Ver todos los informes");
        System.out.println("2. Registrar nuevo informe");
        System.out.println("0. Volver");
        System.out.print("Opcion: ");

        opcion = Integer.parseInt(teclado.nextLine());

        switch (opcion) {
            case 1 -> verTodos();
            case 2 -> registrar();
            case 0 -> System.out.println("Volviendo");
            default -> System.out.println("Opcion no valida.");
        }

    } while (opcion != 0);
}
    private void verTodos() {
        List<Informe> informes = gestorInformes.listarTodos();
        for (Informe i : informes) {
            System.out.println(i.toString());
        }
    }
    private void registrar() {
        System.out.print("ID de la cita: ");
        int idCita = Integer.parseInt(teclado.nextLine());

        System.out.print("ID del especialista: ");
        int idEspecialista = Integer.parseInt(teclado.nextLine());

        System.out.print("ID del paciente: ");
        int idPaciente = Integer.parseInt(teclado.nextLine());

        System.out.print("Fecha (AAAA-MM-DD): ");
        String fecha = teclado.nextLine();

        System.out.print("Resultado: ");
        String resultado = teclado.nextLine();

        Informe nuevo = new Informe(0, resultado, fecha, idCita, idEspecialista, idPaciente);

        if (gestorInformes.insertar(nuevo)) {
            System.out.println("Informe registrado correctamente.");
        } else {
            System.out.println("No se ha podido registrar el informe.");
        }
    }
}

