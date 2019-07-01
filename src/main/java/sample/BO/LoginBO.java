package sample.BO;

import sample.DAO.LoginDAO;
import sample.DTO.Usuario;

import java.util.ArrayList;

public class LoginBO {
    LoginDAO loginDAO;

    public LoginBO() {
        loginDAO = new LoginDAO();
    }

    public ArrayList<Usuario> getUsuarios(){
        return loginDAO.getUsuarios();
    }

}
