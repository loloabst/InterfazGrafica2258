package org.example;

import org.example.controlador.ControladorLibro;
import org.example.modelo.Libro;
import org.example.modelo.persistencia.DemoLibroDB;
import org.example.modelo.persistencia.LibroDAO;
import org.example.vista.VentanaLibro;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        DemoLibroDB demo = new DemoLibroDB();
//
//      /*  Libro libro = new Libro(0,"El juego", "desconocido");
//        if (demo.insertarLibro(libro)){
//            System.out.println("se inserto correctamente");
//        }else {
//            System.out.println("no se inserto");
//        }*/
//        System.out.println(demo.buscarLibroPorId(100));
//        System.out.println("-------------------------");
//        for (Libro tmp:demo.obtenerTodos()) {
//            System.out.println("Libro : " + tmp);
//
//        }
       /* LibroDAO ldao = new LibroDAO();
        *//*Libro libro = new Libro(1, "El perfume", "Patrick Suskind");
        try{
            if (ldao.update(libro)){
                System.out.println("se modifico correctamente");
            }else {
                System.out.println("no se pudo modificar");
            }
        }catch (SQLException sqle){
            System.out.println("error al insertar");
        }*//*
        try {
            Libro res = (Libro) ldao.buscarPorId("1");
            System.out.println(res);
            System.out.println("---------------");
            for (Object lib: ldao.obtenerTodo()) {
                System.out.println((Libro)lib);

            }
        }catch (SQLException sqle){
            System.out.println("error al eliminar");
            System.out.println(sqle.getMessage());
        }*/
        VentanaLibro view = new VentanaLibro("MVC y JDBC");
        ControladorLibro controller = new ControladorLibro(view);

    }
}