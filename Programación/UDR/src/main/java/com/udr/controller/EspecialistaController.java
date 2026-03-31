package com.udr.controller;

import com.udr.dao.EspecialistaDAO;
import com.udr.dao.InformeDAO;
import com.udr.model.Especialista;
import com.udr.model.Paciente;

import java.util.List;
import java.util.Scanner;

public class EspecialistaController {
    private EspecialistaDAO gestorEspecialista = new EspecialistaDAO();
    private Scanner teclado;

    public EspecialistaController (Scanner teclado){
        this.teclado = teclado;
    }
    public void mostrar() {
        int opcion;
        do {
            System.out.println("Gestion de Especialistas");
            System.out.println("1. Ver a todos los especialistas");
            System.out.println("2. Buscar por especialidad");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");

            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1 -> verTodos();
                case 2 -> verEspcialidad();
                case 0 -> System.out.println("Volviendo");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }
        private void verTodos() {
            List<Especialista> especialistas = gestorEspecialista.listarEspecialista();
            for (Especialista e : especialistas) {
                System.out.println(e.toString());
            }
        }
        private void verEspcialidad(){
        System.out.print("Introduce la especialidad: ");
        String especialidad = teclado.nextLine();
            List<Especialista> especialistas = gestorEspecialista.buscarPorEspecialidad(especialidad);
            for (Especialista e : especialistas) {
                System.out.println(e.toString());
            }
        }
    }