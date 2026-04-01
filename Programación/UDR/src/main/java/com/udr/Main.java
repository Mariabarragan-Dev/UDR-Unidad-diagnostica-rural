package com.udr;

import com.udr.controller.*;
import com.udr.db.Conexion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n UDR - Unidad de Diagnóstico Rural");
            System.out.println("1. Gestión de citas");
            System.out.println("2. Gestión de municipios");
            System.out.println("3. Gestión de rutas");
            System.out.println("4. Gestión de pacientes");
            System.out.println("5. Gestión de especialistas");
            System.out.println("6. Gestión de Tipos de prueba");
            System.out.println("7. Gestión de Unidades Móviles");
            System.out.println("8. Gestión de informes");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> new CitasController(scanner).mostrar();
                case 2 -> new MunicipioController(scanner).mostrar();
                case 3 -> new RutaController(scanner).mostrar();
                case 4 -> new PacienteController(scanner).mostrar();
                case 5 -> new EspecialistaController(scanner).mostrar();
                case 6 -> new TipoPruebaController(scanner).mostrar();
                case 7 -> new UnidadMovilController(scanner).mostrar();
                case 8 -> new InformeController(scanner).mostrar();
                case 0 -> {
                    Conexion.cerrar();
                    System.out.println("Adios.");}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}


