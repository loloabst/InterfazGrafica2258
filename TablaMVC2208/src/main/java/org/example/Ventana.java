package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblGenero;
    private JLabel lblPeso;
    private JLabel lblPlataforma;
    private JLabel lblDesarrollador;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtGenero;
    private JTextField txtPeso;
    private JTextField txtPlataforma;
    private JTextField txtDesarrollador;
    private JButton btnAgregar;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private ModeloTablaJuego modelo;
    private ArrayList<VideoJuego> info;
    private JScrollPane scroll;
    private JTable tblTabla;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(500, 700);
        layout = new GridLayout(2,1);
        this.setLayout(layout);
        //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(159, 255, 105));
        lblID = new JLabel("Id:");
        txtId = new JTextField(4);
        panel1.add(lblID);
        panel1.add(txtId);
        lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(30);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        lblGenero = new JLabel("Genero:");
        txtGenero = new JTextField(15);
        panel1.add(lblGenero);
        panel1.add(txtGenero);
        lblPeso = new JLabel("Peso (GB):");
        txtPeso = new JTextField(5);
        panel1.add(lblPeso);
        panel1.add(txtPeso);
        lblPlataforma = new JLabel("Plataforma:");
        txtPlataforma = new JTextField(15);
        panel1.add(lblPlataforma);
        panel1.add(txtPlataforma);
        lblDesarrollador = new JLabel("Desarrollador:");
        txtDesarrollador = new JTextField(25);
        panel1.add(lblDesarrollador);
        panel1.add(txtDesarrollador);
        btnAgregar = new JButton("Agregar Juego");
        panel1.add(btnAgregar);


        this.getContentPane().add(panel1,0);
        //panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(153, 119, 255));
        info = new ArrayList<>();
        info.add(new VideoJuego(1, "League of legends", "MOBA", 4.5,
                "Windows y Mac", "Riot Games"));
        modelo = new ModeloTablaJuego(info);
        tblTabla = new JTable(modelo);
        scroll = new JScrollPane(tblTabla);
        panel2.add(scroll);

        this.getContentPane().add(panel2,1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VideoJuego nuevo= new VideoJuego();
                nuevo.setId(Integer.parseInt(txtId.getText()));
                nuevo.setNombre(txtNombre.getText());
                nuevo.setGenero(txtGenero.getText());
                nuevo.setPesoEnGb(Double.parseDouble(txtPeso.getText()));
                nuevo.setPlataforma(txtPlataforma.getText());
                nuevo.setDesarrollador(txtDesarrollador.getText());
                //info.add(nuevo);
                modelo.agregarJuego(nuevo);
                tblTabla.updateUI();
            }
        });
        this.setVisible(true);
    }
}
