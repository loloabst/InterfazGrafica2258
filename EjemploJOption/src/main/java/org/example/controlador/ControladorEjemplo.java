package org.example.controlador;

import org.example.vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

public class ControladorEjemplo extends MouseAdapter {
    private Ventana view;
    public ControladorEjemplo(Ventana view) {
        this.view = view;
        this.view.getBtnMensaje().addMouseListener(this);
        this.view.getBtnEntrada().addMouseListener(this);
        this.view.getBtnOpcion().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if (e.getSource() == view.getBtnMensaje()){
            //System.out.println("mensaje");
            ImageIcon icono = new ImageIcon("exito.png");
            JOptionPane.showMessageDialog(view,
                    "hola desde el ejemplo",
                    "titulo personalizadon", JOptionPane.WARNING_MESSAGE,icono);
        }
        if (e.getSource() == view.getBtnEntrada()){
            System.out.println("entrada");
            String datos = JOptionPane.showInputDialog(view,
                    "ejemplo de entrada",
                    "titilo personalizado",
                    JOptionPane.QUESTION_MESSAGE);
            this.view.getLblResultado().setText(datos);
        }
        if (e.getSource() == view.getBtnOpcion()){
            //System.out.println("opcion");
            int respuesta = JOptionPane.showConfirmDialog(view,
                    "estas seguro de borrar el registro?",
            "confirmacion",
                    JOptionPane.YES_NO_OPTION
            );
            view.getLblResultado().setText("" + respuesta);
            if (respuesta == JOptionPane.YES_NO_OPTION){
                view.getLblResultado().setText("Elegiste la opcion SI");
            }else {
                view.getLblResultado().setText("Elegiste la opcion NO");
            }
        }


    }
}
