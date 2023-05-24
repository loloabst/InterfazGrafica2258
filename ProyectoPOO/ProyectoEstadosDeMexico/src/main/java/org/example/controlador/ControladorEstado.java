package org.example.controlador;

import org.example.modelo.Estado;
import org.example.modelo.ModeloTablaEstado;
import org.example.vista.VentanaEdo;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorEstado extends MouseAdapter {
    private VentanaEdo view;
    private ModeloTablaEstado modelo;

    public ControladorEstado(VentanaEdo view) {
        this.view = view;
        modelo = new ModeloTablaEstado();
        this.view.getTblEstados().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblEstados().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
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
        if (e.getSource() == view.getTblEstados()) {
            System.out.println("evento sobre la tabla");
            int index = this.view.getTblEstados().getSelectedRow();
            Estado tmp = modelo.getEstadoAtIndex(index);
            try {
                this.view.getImagenEstado().setIcon(tmp.getImagen());
            } catch (MalformedURLException mfue) {
                System.out.println(mfue.toString());
            }
        }
        if (e.getSource() == this.view.getBtnActualizar()) {
            int ind = this.view.getTblEstados().getSelectedRow();
            Estado estado = modelo.getEstadoAtIndex(ind);
            String index = String.valueOf(estado.getId());
            System.out.println("ControladorEstado dice: " + index);
            estado.setNombreEdo(this.view.getTxtEstadoE().getText());
            estado.setCapital(this.view.getTxtCapitalE().getText());
            estado.setMunicipio(this.view.getTxtMunicipioE().getText());
            estado.setPoblacion(this.view.getTxtPoblacionE().getText());
            estado.setURL(this.view.getTxtUrlE().getText());
            System.out.println("controladorEstado dice " + estado);
            System.out.println();
            System.out.println(estado);
            if (modelo.editarEstado(estado, index)) {
                JOptionPane.showMessageDialog(view, "se editó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblEstados().updateUI();
            } else {
                JOptionPane.showMessageDialog(view,
                        "No se pudo editar la base de datos. por favor revise su conexion"
                        , "Error al editar"
                        , JOptionPane.ERROR_MESSAGE);
            }
        }


        if (e.getSource() == this.view.getBtnBorrar()) {
            int ind = this.view.getTblEstados().getSelectedRow();
            Estado estado = modelo.getEstadoAtIndex(ind);
            String index = String.valueOf(estado.getId());
            System.out.println("ControladorEstado dice: " +index);
            System.out.println("ControladorEstado dice: " + index.getClass().getSimpleName());
            estado.setId(Integer.parseInt(this.view.getTxtIdE().getText()));

            if (modelo.borrarEstado(index)) {
                JOptionPane.showMessageDialog(view, "se borró correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblEstados().updateUI();
            } else {
                JOptionPane.showMessageDialog(view,
                        "No se pudo borrar la base de datos. por favor revise su conexion"
                        , "Error al borrar"
                        , JOptionPane.ERROR_MESSAGE);
            }
        }
        this.view.limpiar();
    }
}
