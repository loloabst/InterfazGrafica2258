package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaEdo extends JFrame{
    private JLabel lblId;
    private JLabel lblEstado;
    private JLabel lblCapital;
    private JLabel lblPoblacion;
    private JLabel lblMunicipio;
    private JLabel lblUrl;
    private JTextField txtId;
    private JTextField txtEstado;
    private JTextField txtCapital;
    private JTextField txtPoblacion;
    private JTextField txtMunicipio;
    private JTextField txtUrl;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblEstados;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;//formulario para capturar
    private JPanel panel2;//tabla para mostrar libros
    private JPanel panel3;//panel para mostrar imagenes
    private JPanel panel4;//formulario para actualizar y eliminar

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblEstado() {
        return lblEstado;
    }

    public void setLblEstado(JLabel lblEstado) {
        this.lblEstado = lblEstado;
    }

    public JLabel getLblCapital() {
        return lblCapital;
    }

    public void setLblCapital(JLabel lblCapital) {
        this.lblCapital = lblCapital;
    }

    public JLabel getLblPoblacion() {
        return lblPoblacion;
    }

    public void setLblPoblacion(JLabel lblPoblacion) {
        this.lblPoblacion = lblPoblacion;
    }

    public JLabel getLblMunicipio() {
        return lblMunicipio;
    }

    public void setLblMunicipio(JLabel lblMunicipio) {
        this.lblMunicipio = lblMunicipio;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(JTextField txtEstado) {
        this.txtEstado = txtEstado;
    }

    public JTextField getTxtCapital() {
        return txtCapital;
    }

    public void setTxtCapital(JTextField txtCapital) {
        this.txtCapital = txtCapital;
    }

    public JTextField getTxtPoblacion() {
        return txtPoblacion;
    }

    public void setTxtPoblacion(JTextField txtPoblacion) {
        this.txtPoblacion = txtPoblacion;
    }

    public JTextField getTxtMunicipio() {
        return txtMunicipio;
    }

    public void setTxtMunicipio(JTextField txtMunicipio) {
        this.txtMunicipio = txtMunicipio;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblEstados() {
        return tblEstados;
    }

    public void setTblEstados(JTable tblEstados) {
        this.tblEstados = tblEstados;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public VentanaEdo(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);
        //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(239,200,200));
        lblId = new JLabel("Id: ");
        lblEstado = new JLabel("Estado: ");
        lblCapital = new JLabel("Capital: ");
        lblPoblacion = new JLabel("Poblacion: ");
        lblMunicipio = new JLabel("Municipios: ");
        lblUrl = new JLabel("URL: ");
        txtId = new JTextField(6);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtEstado = new JTextField(15);
        txtCapital = new JTextField(15);
        txtPoblacion = new JTextField(15);
        txtMunicipio = new JTextField(15);
        txtUrl = new JTextField(15);

        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblEstado);
        panel1.add(txtEstado);
        panel1.add(lblCapital);
        panel1.add(txtCapital);
        panel1.add(lblPoblacion);
        panel1.add(txtPoblacion);
        panel1.add(lblMunicipio);
        panel1.add(txtMunicipio);
        panel1.add(lblUrl);
        panel1.add(txtUrl);

        panel1.add(btnAgregar);
        // panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(55, 210, 28));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblEstados = new JTable();
        scrollPane = new JScrollPane(tblEstados);
        panel2.add(scrollPane);


        // panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(84, 245, 189));
        // panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(128, 104, 246));


        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        //

    }
    public void limpiar(){
        txtEstado.setText("");
        txtCapital.setText("");
        txtMunicipio.setText("");
        txtPoblacion.setText("");
        txtUrl.setText("");
    }
}

