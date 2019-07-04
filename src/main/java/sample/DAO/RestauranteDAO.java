package sample.DAO;


import sample.DTO.Restaurante;
import sample.Utils.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RestauranteDAO {

    public RestauranteDAO() {
    }

    public ArrayList<Restaurante> getRestaurantes() {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT ID, NOME FROM ALMOCO.RESTAURANTE");
            while (resultSet.next()) {
                Restaurante restaurante = new Restaurante(resultSet.getInt("ID"),resultSet.getString("NOME"));
                restaurantes.add(restaurante);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try { resultSet.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }

        return restaurantes;
    }

    public Restaurante getRestauranteById(int id){
        Restaurante restaurante = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT ID, NOME FROM ALMOCO.RESTAURANTE WHERE ID = " + id);
            while (resultSet.next()) {
                restaurante = new Restaurante(resultSet.getInt("ID"),resultSet.getString("NOME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try { resultSet.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }

        return restaurante;
    }
}
