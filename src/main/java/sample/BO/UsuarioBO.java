package sample.BO;

import sample.DAO.LoginDAO;
import sample.DTO.Usuario;
import sample.Utils.AuthSession;

import java.util.ArrayList;

public class UsuarioBO {
    LoginDAO loginDAO;

    public UsuarioBO() {
        loginDAO = new LoginDAO();
    }

    public ArrayList<Usuario> getUsuarios(){
        return loginDAO.getUsuarios();
    }

    public boolean entrar(Usuario usuario){
        AuthSession session = AuthSession.getInstance();
        session.setUsuarioLogado(usuario);
        return true;
    }

}
