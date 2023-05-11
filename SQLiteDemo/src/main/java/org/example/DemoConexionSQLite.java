package org.example;

import java.sql.*;

import org.sqlite.JDBC;
public class DemoConexionSQLite {
    public static void main(String[] args) {
        String DB_URL = "jdbc:sqlite:librosDB.db";
        Connection conexion = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(DB_URL);
            Statement stm = conexion.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM libros; ");
            while (rst.next()){
                System.out.println(rst.getString(1) + " " + rst.getString(2));
            }
            conexion.close();
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
