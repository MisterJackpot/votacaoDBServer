package sample.BO;

import sample.DAO.UsuarioDAO;
import sample.DTO.Usuario;
import sample.Utils.AuthSession;

import java.util.ArrayList;

public class UsuarioBO {
    UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarioDAO.getUsuarios();
    }

    public boolean entrar(Usuario usuario){
        AuthSession session = AuthSession.getInstance();
        session.setUsuarioLogado(usuario);
        return true;
    }

}
