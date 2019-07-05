package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import sample.BO.UsuarioBO;
import sample.DTO.Usuario;
import sample.Utils.Paginas;


import java.util.ArrayList;

public class LoginController {
    private UsuarioBO usuarioBO;
    private Roteador roteador;

    @FXML
    ChoiceBox users;

    @FXML
    private void initialize()
    {
        roteador = new Roteador();
        usuarioBO = new UsuarioBO();
        ArrayList<Usuario> list = usuarioBO.getUsuarios();

        users.setItems(FXCollections.observableArrayList(list));
        users.setValue(list.get(0));
    }

    @FXML
    public void entrar(){
            Usuario usuario = (Usuario) users.getValue();
            if(usuarioBO.entrar(usuario)) {
                Scene scene = users.getScene();
                roteador.rotear(Paginas.PRINCIPAL,scene);
            }
    }

}
