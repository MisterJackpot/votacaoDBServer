package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import sample.Utils.AuthSession;
import sample.Utils.Paginas;

import java.io.IOException;

public class ControllerPrincipal {

    private Roteador roteador;

    @FXML
    Button btnVoltar;

    @FXML
    private void initialize()
    {
        roteador = new Roteador();
        AuthSession session = AuthSession.getInstance();
        System.out.println(session.getUsuarioLogado());
    }

    @FXML
    public void voltar(){
        AuthSession.invalidarSession();
        Scene scene = btnVoltar.getScene();

        roteador.rotear(Paginas.LOGIN,scene);
    }
}
