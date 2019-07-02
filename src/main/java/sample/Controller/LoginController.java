package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import sample.BO.LoginBO;
import sample.DTO.Usuario;
import sample.Utils.Paginas;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    private LoginBO loginBO;
    private Roteador roteador;

    @FXML
    ChoiceBox users;

    @FXML
    private void initialize()
    {
        roteador = new Roteador();
        loginBO = new LoginBO();
        ArrayList<Usuario> list = loginBO.getUsuarios();

        users.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    public void entrar(){
            Usuario usuario = (Usuario) users.getValue();
            if(loginBO.entrar(usuario)) {
                Scene scene = users.getScene();
                roteador.rotear(Paginas.PRINCIPAL,scene);
            }
    }

}
