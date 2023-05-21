package org.example;

import org.example.controller.ControladorVentana;
import org.example.view.Ventana;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Ventana view = new Ventana("primer ejemplo mvc completo");
        ControladorVentana controller = new ControladorVentana(view);

    }
}