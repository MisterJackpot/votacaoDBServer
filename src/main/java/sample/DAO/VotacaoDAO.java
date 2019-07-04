package sample.DAO;


import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;
import sample.Utils.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

public class VotacaoDAO {

    public VotacaoDAO() {
    }

    public boolean votar(Restaurante restaurante, Usuario usuario,Date dataVotacao) {

        Statement stmt = null;
        Connection connection = null;
        java.sql.Date dataSql = new java.sql.Date(dataVotacao.getTime());
        System.out.println(dataSql.toString());
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            stmt.execute("INSERT  INTO ALMOCO.VOTO (DATA,USUARIO,RESTAURANTE) VALUES ('"+dataSql+"',"+usuario.getId()+","+restaurante.getId()+")");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }finally {
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }

        return true;
    }

    public Votacao getVotacao(Date data){

        Votacao votacao = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        System.out.println(dataSql.toString());
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT ID, DATA, VENCEDOR FROM ALMOCO.VOTACAO WHERE DATA = '" + dataSql +"'");
            while (resultSet.next()) {
                votacao = new Votacao(resultSet.getDate("DATA"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try { resultSet.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }
        return votacao;
    }

    public void addVotacao(Votacao votacao){
        Statement stmt = null;
        Connection connection = null;
        java.sql.Date dataSql = new java.sql.Date(votacao.getData().getTime());
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO ALMOCO.VOTACAO (DATA) VALUES ('" + dataSql + "')");

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }
    }

    public HashMap<Integer, Restaurante> getVotos(Date data) {
        HashMap<Integer, Restaurante> votos = new HashMap<>();
        RestauranteDAO restauranteDAO = new RestauranteDAO();
        LoginDAO loginDAO = new LoginDAO();
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        System.out.println(dataSql.toString());
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT USUARIO, RESTAURANTE FROM ALMOCO.VOTO WHERE DATA = '" + dataSql +"'");
            while (resultSet.next()) {
                Restaurante restaurante = restauranteDAO.getRestauranteById(resultSet.getInt("RESTAURANTE"));
                votos.put(resultSet.getInt("USUARIO"),restaurante);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try { resultSet.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }
        return votos;
    }
}
