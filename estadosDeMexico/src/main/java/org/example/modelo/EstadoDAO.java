package org.example.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EstadoDAO implements InterfazDAO {
    public EstadoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO estados(nombreEdo, Capital, Municipio, Poblacion, URL) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("estados.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Estado) obj).getNombreEdo());
        pstm.setString(2, ((Estado) obj).getCapital());
        pstm.setString(3, ((Estado) obj).getMunicipio());
        pstm.setString(4, ((Estado) obj).getPoblacion());
        pstm.setString(5, ((Estado) obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount < 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE estados SET nombreEdo = ?, Capital = ?, Municipio = ?, Poblacion = ?, URL = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("estados.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Estado) obj).getNombreEdo());
        pstm.setString(2, ((Estado) obj).getCapital());
        pstm.setString(1, ((Estado) obj).getMunicipio());
        pstm.setString(2, ((Estado) obj).getPoblacion());
        pstm.setString(1, ((Estado) obj).getURL());
        rowCount = pstm.executeUpdate();
        return rowCount < 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM estados WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("estados.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount < 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM estados";
        ArrayList<Estado> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("estados.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Estado(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5),rst.getString(6)));
        }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM estados WHERE id = ? ;";
        Estado estado = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("estados.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            estado = new Estado(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
            return estado;
        }
        return null;
    }
}
