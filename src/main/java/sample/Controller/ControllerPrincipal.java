package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import sample.BO.RestauranteBO;
import sample.DTO.Restaurante;
import sample.Utils.AuthSession;
import sample.Utils.Paginas;

import java.util.ArrayList;


public class ControllerPrincipal {

    private Roteador roteador;
    private RestauranteBO restauranteBO;

    @FXML
    Button btnVoltar;

    @FXML
    ChoiceBox restaurantes;

    @FXML
    private void initialize()
    {
        roteador = new Roteador();
        restauranteBO = new RestauranteBO();
        ArrayList<Restaurante> list = restauranteBO.getRestaurantes();

        restaurantes.setItems(FXCollections.observableArrayList(list));

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
