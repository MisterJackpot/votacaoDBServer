package sample.DAO;

import sample.DBMock;
import sample.DTO.Usuario;

import java.util.ArrayList;

public class LoginDAO {

    public LoginDAO() {
    }

    public ArrayList<Usuario> getUsuarios() {
        DBMock db = DBMock.getInstance();

        return db.getUsuarios();
    }
}
