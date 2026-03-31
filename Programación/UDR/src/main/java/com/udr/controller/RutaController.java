package com.udr.controller;

import com.udr.dao.CitasDAO;
import com.udr.dao.MunicipioDAO;
import com.udr.dao.RutaDAO;
import com.udr.model.Municipio;
import com.udr.model.Ruta;

import java.util.List;
import java.util.Scanner;

public class RutaController {
    private RutaDAO gestorRutas = new RutaDAO();
    private Scanner teclado;

    public RutaController(Scanner teclado){
        this.teclado = teclado;
    }
    public void mostrar() {
        int opcion;
        do {
            System.out.println("Gestion de rutas");
            System.out.println("1. Ver todas las rutas");
            System.out.println("2. Ver rutas de hoy");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1 -> verTodas();
                case 2 -> verRutasHoy();
                case 0 -> System.out.println("Volviendo");
                default -> System.out.println("Opción no valida.");
            }
        } while (opcion != 0);
    }
    private void verTodas(){
        List<Ruta> rutas = gestorRutas.listarTodos();
        for (Ruta r : rutas){
            System.out.print(r.toString());
        }
    }
    private void verRutasHoy(){
        List<Ruta> rutasHoy = gestorRutas.listarRutasHoy();
        for (Ruta r : rutasHoy){
            System.out.print(r.toString());
        }
    }
}
