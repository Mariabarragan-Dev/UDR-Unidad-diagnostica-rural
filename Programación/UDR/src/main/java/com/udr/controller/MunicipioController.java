package com.udr.controller;

import com.udr.dao.MunicipioDAO;
import com.udr.dao.TipoPruebaDAO;
import com.udr.model.Municipio;
import com.udr.model.TipoPrueba;

import java.util.List;
import java.util.Scanner;

public class MunicipioController {
    private MunicipioDAO gestorMunicipio = new MunicipioDAO();
    private Scanner teclado;

    public MunicipioController (Scanner teclado){
        this.teclado = teclado;
    }
    public void mostrar() {
        int opcion;
        do {
            System.out.println("Gestion de municipios");
            System.out.println("1. Ver a todos los municipios");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1 -> verTodos();
                case 0 -> System.out.println("Volviendo");
                default -> System.out.println("Opción no valida.");
            }
        } while (opcion != 0);
    }
    private void verTodos(){
        List<Municipio> municipios = gestorMunicipio.listarTodos();
        for (Municipio m : municipios){
            System.out.print(m.toString());
        }
    }
}
