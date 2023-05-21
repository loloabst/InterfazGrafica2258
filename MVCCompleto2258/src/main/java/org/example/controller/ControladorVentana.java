package org.example.controller;

import org.example.model.Persona;
import org.example.view.Ventana;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControladorVentana implements MouseListener {
    private Ventana vista;
    private ArrayList<Persona> personas;

    public ControladorVentana(Ventana vista) {
        this.vista = vista;
        this.vista.getBtnBoton().addMouseListener(this);
        this.vista.getLblSaludo().addMouseListener(this);
        personas = new ArrayList<>();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("hola desde el controlador");



        if (e.getSource() == this.vista.getBtnBoton()){
            System.out.println("evento raton sobre el botón");
            vista.getLblSaludo().setText("hola " +  vista.getTxtNombre().getText());
            personas.add(new Persona(vista.getTxtNombre().getText()));
            this.limpiar();
        }
        if (e.getSource() == this.vista.getLblSaludo()){
            System.out.println("evento raton sobre la etiqueta");
            for (Persona p:personas) {
                System.out.println(p);
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    private void limpiar(){
        vista.getTxtNombre().setText("");

    }
}
