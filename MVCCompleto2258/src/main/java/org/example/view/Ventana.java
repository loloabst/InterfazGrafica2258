package org.example.view;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JTextField txtNombre;
    private JButton btnBoton;
    private JLabel lblSaludo;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(400,300);
        this.getContentPane().setLayout(new FlowLayout());
        txtNombre = new JTextField(13);
        btnBoton = new JButton("saludar");
        lblSaludo= new JLabel("...");
        this.getContentPane().add(txtNombre);
        this.getContentPane().add(btnBoton);
        this.getContentPane().add(lblSaludo);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JButton getBtnBoton() {
        return btnBoton;
    }

    public void setBtnBoton(JButton btnBoton) {
        this.btnBoton = btnBoton;
    }

    public JLabel getLblSaludo() {
        return lblSaludo;
    }

    public void setLblSaludo(JLabel lblSaludo) {
        this.lblSaludo = lblSaludo;
    }
}

