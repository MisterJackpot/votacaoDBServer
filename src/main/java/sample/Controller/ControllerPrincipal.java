package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import sample.Utils.AuthSession;

import java.io.IOException;

public class ControllerPrincipal {

    @FXML
    Button btnVoltar;

    @FXML
    private void initialize()
    {
        AuthSession session = AuthSession.getInstance();
        System.out.println(session.getUsuarioLogado());
    }

    @FXML
    public void voltar(){
        AuthSession.invalidarSession();
        Parent pagina = null;
        try {
            pagina = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = btnVoltar.getScene();
        scene.setRoot(pagina);
    }
}
