package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import sample.BO.LoginBO;
import sample.DTO.Usuario;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    private LoginBO loginBO;

    @FXML
    ChoiceBox users;

    @FXML
    private void initialize()
    {
        loginBO = new LoginBO();
        ArrayList<Usuario> list = loginBO.getUsuarios();

        users.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    public void entrar(){
        try {
            Parent pagina = FXMLLoader.load(getClass().getResource("/principal.fxml"));
            Scene scene = users.getScene();
            scene.setRoot(pagina);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
