package sample.Utils;

import sample.DTO.Usuario;

public class AuthSession {
    private static AuthSession ourInstance;
    private Usuario usuarioLogado;

    public static AuthSession getInstance() {
        if(ourInstance == null){
            ourInstance = new AuthSession();
        }
        return ourInstance;
    }

    private AuthSession() {
    }

    public static void invalidarSession(){
        ourInstance = null;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
