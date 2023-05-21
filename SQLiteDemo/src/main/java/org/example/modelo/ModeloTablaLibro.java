package org.example.modelo;

import org.example.modelo.persistencia.LibroDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaLibro implements TableModel {
    public static final int COLUMNS = 3;
    private ArrayList<Libro> datos;
    private LibroDAO ldao;

    public ModeloTablaLibro() {
        ldao = new LibroDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaLibro(ArrayList<Libro> datos) {
        this.datos = datos;
        ldao = new LibroDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int rowIndex) {
        switch (rowIndex){
            case 0:
                return "Id";
            case 1:
                return "Titulo";
            case 2:
                return "Autor";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getTitulo();
            case 2:
                return tmp.getAutor();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int colIndex) {
        switch (colIndex){
            case 0:
                //datos.get(rowIndex).getId(0);
                break;
            case 1:
                datos.get(rowIndex).setTitulo((String) o);
                break;
            case 2:
                datos.get(rowIndex).setAutor((String) o);
                break;
            default:
                System.out.println("no se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargarDatos(){
        try {
            ArrayList<Libro> tirar = ldao.obtenerTodo();
            System.out.println(tirar);
            datos = ldao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }
    public boolean agregarLibro(Libro libro) {
        boolean resultado = false;
        try {
            if (ldao.insertar(libro)){
                datos.add(libro);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}
