package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Matrices extends JFrame {

    private JLabel lblTamano;
    private JTextField txtTamano;
    private JButton btnAceptar;

    private JPanel pnlMatriz1;
    private JPanel pnlMatriz2;
    private JPanel pnlBotones;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JTable tblResultado;

    private int tamano;
    private double[][] matriz1;
    private double[][] matriz2;
    private double[][] resultado;

    public Matrices() {
        super("Calculadora de Matrices");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de entrada de tamaño de matriz
        JPanel pnlTamano = new JPanel();
        lblTamano = new JLabel("Tamanio de la matriz:");
        txtTamano = new JTextField(5);
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tamano = Integer.parseInt(txtTamano.getText());
                crearPaneles();
            }
        });
        pnlTamano.add(lblTamano);
        pnlTamano.add(txtTamano);
        pnlTamano.add(btnAceptar);
        add(pnlTamano, BorderLayout.NORTH);

        setVisible(true);
    }

    private void crearPaneles() {
        // Panel de entrada de matriz 1
        pnlMatriz1 = new JPanel(new GridLayout(tamano, tamano));
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                JTextField txt = new JTextField(5);
                pnlMatriz1.add(txt);
            }
        }

        // Panel de entrada de matriz 2
        pnlMatriz2 = new JPanel(new GridLayout(tamano, tamano));
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                JTextField txt = new JTextField(5);
                pnlMatriz2.add(txt);
            }
        }

        // Panel de botones de operaciones
        pnlBotones = new JPanel(new FlowLayout());
        btnSumar = new JButton("Sumar");
        btnRestar = new JButton("Restar");
        btnMultiplicar = new JButton("Multiplicar");
        btnSumar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sumarMatrices();
            }
        });
        btnRestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restarMatrices();
            }
        });
        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                multiplicarMatrices();
            }
        });
        pnlBotones.add(btnSumar);
        pnlBotones.add(btnRestar);
        pnlBotones.add(btnMultiplicar);

        // Panel de resultado
        resultado = new double[tamano][tamano];
        tblResultado = new JTable(tamano, tamano);
        JScrollPane scrollPane = new JScrollPane(tblResultado);

        // Panel principal
        JPanel pnlPrincipal = new JPanel(new GridLayout(1, 4));
        pnlPrincipal.add(pnlMatriz1);
        pnlPrincipal.add(pnlMatriz2);
        pnlPrincipal.add(pnlBotones);
        pnlPrincipal.add(scrollPane);
        add(pnlPrincipal, BorderLayout.CENTER);

        revalidate();

    }

    private void sumarMatrices() {
        matriz1 = obtenerMatriz(pnlMatriz1);
        matriz2 = obtenerMatriz(pnlMatriz2);

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        mostrarResultado();
    }

    private void restarMatrices() {
        matriz1 = obtenerMatriz(pnlMatriz1);
        matriz2 = obtenerMatriz(pnlMatriz2);

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                resultado[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        mostrarResultado();
    }

    private void multiplicarMatrices() {
        matriz1 = obtenerMatriz(pnlMatriz1);
        matriz2 = obtenerMatriz(pnlMatriz2);

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < tamano; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        mostrarResultado();
    }

    private double[][] obtenerMatriz(JPanel pnlMatriz) {
        double[][] matriz = new double[tamano][tamano];
        Component[] componentes = pnlMatriz.getComponents();
        int indice = 0;
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                JTextField txt = (JTextField)componentes[indice];
                matriz[i][j] = Double.parseDouble(txt.getText());
                indice++;
            }
        }
        return matriz;
    }

    private void mostrarResultado() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                tblResultado.setValueAt(resultado[i][j], i, j);
            }
        }
    }
}


