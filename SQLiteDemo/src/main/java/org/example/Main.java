package org.example;

import org.example.modelo.persistencia.DemoLibroDB;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DemoLibroDB demo = new DemoLibroDB();
        demo.insertStatement();
        System.out.println("Con prepared");
        demo.insertPreparedStatement();
    }
}