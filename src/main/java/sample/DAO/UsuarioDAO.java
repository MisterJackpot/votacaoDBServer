package sample.DAO;

import sample.DTO.Usuario;
import sample.Utils.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

    public UsuarioDAO() {
    }

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT ID, NOME FROM ALMOCO.USUARIO");
            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet.getString("NOME"),resultSet.getInt("ID"));
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try { resultSet.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }

        return usuarios;
    }

    public Usuario getUsuarioById(int id){
        Usuario usuario = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = Conexao.connectionToDerby();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT ID, NOME FROM ALMOCO.USUARIO WHERE ID = " + id);
            while (resultSet.next()) {
                usuario = new Usuario(resultSet.getString("NOME"),resultSet.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try { resultSet.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }

        return usuario;
    }
}
