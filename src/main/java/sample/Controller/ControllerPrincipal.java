package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import sample.DTO.Restaurante;
import sample.Facade.VotacaoFacade;
import sample.Utils.*;


public class ControllerPrincipal {

    private Roteador roteador;
    private VotacaoFacade votacaoFacade;
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
        votacaoFacade = new VotacaoFacade();
        roteador = new Roteador();
        session = AuthSession.getInstance();

        votacaoFacade.inicializarFacade();

        restaurantes.setItems(FXCollections.observableArrayList(votacaoFacade.getRestaurantes()));
        dataVotacao.setDisable(true);

        dataVotacao.setText(Formatador.formatarData(votacaoFacade.getVotacaoDate()));

        validaVoto();
    }

    public void validaVoto(){
        Restaurante voto = votacaoFacade.getVoto(session.getUsuarioLogado());
        if (voto != null){
            restaurantes.setValue(voto.toString());
            restaurantes.setDisable(true);
            btnVotar.setDisable(true);
        }
        votacaoFacade.verificaVencedor();
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

        Response response = votacaoFacade.votar(restaurante,session.getUsuarioLogado());

        if(response.getTipo().equals(Status.ERRO)){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText(response.getMensagem());
            alerta.showAndWait();
        }

        validaVoto();
    }
}
