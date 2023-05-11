package org.example.modelo.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoLibroDB {
    public DemoLibroDB() {
    }
    public void insertStatement(){
        String elTitulo = "Arrancame la vida";
        String elAutor = "Angeles Matrera";
    try {
        Statement stm = ConexionSingleton.getInstance("librosDB.db").getConnection().createStatement();
        String sqlInsert = "INSERT INTO libros(titulo,autor) Values('"+elTitulo+"','"+elAutor+"')";
        int rowCount = stm.executeUpdate(sqlInsert);
        System.out.println("se insertaron " + rowCount + " registros");

    }catch (SQLException sqle){
        System.out.println("Error al conectar " + sqle.getMessage());
    }

    }
    public void insertPreparedStatement(){
        String elTitulo = "El principito";
        String elAutor = "No me acuerdo";
        String sqlInsert = "INSERT INTO libros(titulo, autor) VALUES(?, ?)";
        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("librosDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,elAutor);
            pstm.setString(2,elAutor);
            int rowCount = pstm.executeUpdate();
            System.out.println("se insertaron " + rowCount + " registros");
        }catch (SQLException sqle){
            System.out.println("Error Prepared statement " + sqle.getMessage());
        }

    }
}
