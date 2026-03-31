package com.udr.controller;

import com.udr.dao.TipoPruebaDAO;
import com.udr.dao.UnidadMovilDAO;
import com.udr.model.TipoPrueba;

import java.util.List;
import java.util.Scanner;

public class TipoPruebaController {
    private TipoPruebaDAO gestorTipoPrueba = new TipoPruebaDAO();
    private Scanner teclado;

    public TipoPruebaController (Scanner teclado){
        this.teclado = teclado;
    }
    public void mostrar() {
        int opcion;
        do {
            System.out.println("Gestion de tipos de prueba");
            System.out.println("1. Ver a todos los tipos de prueba");
            System.out.println("2. Buscar prueba por categoría");
            System.out.println("0. Volver");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(teclado.nextLine());
            switch (opcion) {
                case 1 -> verTodos();
                case 2 -> verCategoria();
                case 0 -> System.out.println("Volviendo");
                default -> System.out.println("Opción no valida.");
            }
        } while (opcion != 0);
    }
    private void verTodos(){
        List<TipoPrueba> tipoPreba = gestorTipoPrueba.listarTodos();
        for (TipoPrueba tp : tipoPreba){
            System.out.print(tp.toString());
        }
    }
    private void verCategoria(){
        System.out.print("Introduce la categoria: ");
        String categoria = teclado.nextLine();
        List<TipoPrueba> categoriaPrueba = gestorTipoPrueba.buscarPorCategoria(categoria);
        for (TipoPrueba tp : categoriaPrueba){
            System.out.print(tp.toString());
        }
    }
}
