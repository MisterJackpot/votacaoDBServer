package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import sample.BO.RestauranteBO;
import sample.BO.VotacaoBO;
import sample.DTO.Restaurante;
import sample.Utils.*;

import java.util.ArrayList;
import java.util.Date;


public class ControllerPrincipal {

    private Roteador roteador;
    private RestauranteBO restauranteBO;
    private VotacaoBO votacaoBO;
    private AuthSession session;

    @FXML
    Button btnVoltar;

    @FXML
    ChoiceBox restaurantes;

    @FXML
    TextField dataVotacao;

    @FXML
    Button btnVotar;

    @FXML
    private void initialize()
    {
        roteador = new Roteador();
        restauranteBO = new RestauranteBO();
        votacaoBO = new VotacaoBO();

        ArrayList<Restaurante> list = restauranteBO.getRestaurantes();

        restaurantes.setItems(FXCollections.observableArrayList(list));
        dataVotacao.setDisable(true);
        Date data = votacaoBO.getVotacao().getData();
        dataVotacao.setText(Formatador.formatarData(data));

        session = AuthSession.getInstance();
        System.out.println(session.getUsuarioLogado());
    }

    @FXML
    public void voltar(){
        AuthSession.invalidarSession();
        Scene scene = btnVoltar.getScene();

        roteador.rotear(Paginas.LOGIN,scene);
    }

    @FXML
    public void votar(){
        Restaurante restaurante = (Restaurante) restaurantes.getValue();

        Response response = votacaoBO.votar(restaurante,session.getUsuarioLogado());

        if(response.getTipo().equals(Status.ERRO)){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(response.getMensagem());
            alerta.showAndWait();
        }
    }
}
