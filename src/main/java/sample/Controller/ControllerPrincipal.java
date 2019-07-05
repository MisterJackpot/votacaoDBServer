package sample.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DTO.Restaurante;
import sample.Facade.VotacaoFacade;
import sample.Utils.*;

import java.io.IOException;



public class ControllerPrincipal {

    private Roteador roteador;
    private static VotacaoFacade votacaoFacade;
    private AuthSession session;
    private static boolean func;

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
        func = true;

        votacaoFacade.inicializarFacade();

        restaurantes.setItems(FXCollections.observableArrayList(votacaoFacade.getRestaurantes()));
        dataVotacao.setDisable(true);

        atualizarTela();

        verificarTempo();
    }

    public void validaVoto(){
        Restaurante voto = votacaoFacade.getVoto(session.getUsuarioLogado());
        if (voto != null){
            restaurantes.setValue(voto.toString());
            restaurantes.setDisable(true);
            btnVotar.setDisable(true);
        }else{
            restaurantes.setDisable(false);
            btnVotar.setDisable(false);
        }
        votacaoFacade.verificaVencedor();
    }

    public void atualizarTela(){
        dataVotacao.setText(Formatador.formatarData(votacaoFacade.getVotacaoDate()));
        validaVoto();
    }

    public void verificarTempo(){
        new Thread(()->{
            do {
                votacaoFacade.verificaTempo();
                Platform.runLater(this::atualizarTela);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (func);
            Thread.currentThread().interrupt();
        }).start();
    }

    @FXML
    public void voltar(){
        AuthSession.invalidarSession();
        Scene scene = btnVoltar.getScene();
        func = false;

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

    @FXML
    public void resultados(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resultado.fxml"));
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Resultados");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
