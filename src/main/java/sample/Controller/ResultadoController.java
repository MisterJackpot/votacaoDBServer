package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import sample.BO.VotacaoBO;
import sample.DTO.Votacao;


import java.util.ArrayList;

public class ResultadoController {

    @FXML
    ListView<String> lista;

    @FXML
    private void initialize()
    {
        VotacaoBO votacaoBO = new VotacaoBO();
        ArrayList<Votacao> votacaos = votacaoBO.getVotacaoByStatus("F");

        lista.setItems(FXCollections.observableArrayList(votacaos.toString()));
    }
}