package sample.Controller;

import javafx.fxml.FXML;
import sample.Utils.AuthSession;

public class ControllerPrincipal {

    @FXML
    private void initialize()
    {
        AuthSession session = AuthSession.getInstance();
        System.out.println(session.getUsuarioLogado());
    }
}
