package org.example;

import org.example.controlador.ControladorEstado;
import org.example.vista.VentanaEdo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaEdo view = new VentanaEdo("Estados de México MVC y JDBC");
        ControladorEstado controller = new ControladorEstado(view);
    }
}