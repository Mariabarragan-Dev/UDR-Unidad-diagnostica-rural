package com.udr.controller;

import com.udr.dao.EspecialistaDAO;
import com.udr.dao.UnidadMovilDAO;
import com.udr.model.UnidadMovil;

import java.util.List;
import java.util.Scanner;

public class UnidadMovilController {
    private UnidadMovilDAO gestorUnidadMovil = new UnidadMovilDAO();
    private Scanner teclado;

    public UnidadMovilController (Scanner teclado){
        this.teclado = teclado;
    }
    public void mostrar() {
        int opcion;
        do {
            System.out.println("Gestion de Unidades móviles");
            System.out.println("1. Ver a todas las unidades móviles");
            System.out.println("2. Buscar unidades móviles activas");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");

            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1 -> verTodos();
                case 2 -> verActivas();
                case 0 -> System.out.println("Volviendo");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }
    private void verTodos(){
        List<UnidadMovil> unidadMovil = gestorUnidadMovil.listarTodos();
        for (UnidadMovil um: unidadMovil){
            System.out.print(um.toString());
        }
    }
    private void verActivas(){
        List<UnidadMovil> unidades = gestorUnidadMovil.listarActivas();
        for (UnidadMovil um : unidades){
            System.out.print(um.toString());
        }

    }
}
