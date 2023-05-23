package org.example.controlador;

import org.example.modelo.Estado;
import org.example.modelo.ModeloTablaEstado;
import org.example.vista.VentanaEdo;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorEstado extends MouseAdapter {
    private VentanaEdo view;
    private ModeloTablaEstado modelo;

    public ControladorEstado(VentanaEdo view) {
        this.view = view;
        modelo = new ModeloTablaEstado();
        this.view.getTblEstados().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {

            modelo.cargarDatos();
            this.view.getTblEstados().setModel(modelo);
            this.view.getTblEstados().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            Estado estado = new Estado();
            estado.setId(0);
            estado.setNombreEdo(this.view.getTxtEstado().getText());
            estado.setCapital(this.view.getTxtCapital().getText());
            estado.setMunicipio(this.view.getTxtMunicipio().getText());
            estado.setPoblacion(this.view.getTxtPoblacion().getText());
            estado.setURL(this.view.getTxtUrl().getText());

            if (modelo.agregarEstado(estado)) {
                JOptionPane.showMessageDialog(view, "se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblEstados().updateUI();
            } else {
                JOptionPane.showMessageDialog(view,
                        "No se pudo agregar a la base de datos. por favor revise su conexion"
                        , "Error al insertar"
                        , JOptionPane.ERROR_MESSAGE);
            }
        }
        this.view.limpiar();
    }
}

