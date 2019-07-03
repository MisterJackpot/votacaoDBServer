package sample.Facade;

import sample.BO.RestauranteBO;
import sample.BO.VotacaoBO;
import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;
import sample.Utils.Formatador;
import sample.Utils.Response;

import java.util.ArrayList;
import java.util.Date;

public class VotacaoFacade {

    private RestauranteBO restauranteBO;
    private VotacaoBO votacaoBO;
    private ArrayList<Restaurante> restaurantes;
    private Votacao votacaoAtual;

    public VotacaoFacade() {
        restauranteBO = new RestauranteBO();
        votacaoBO = new VotacaoBO();
    }

    public void inicializarFacade(){
        Date date = new Date();
        String dateS = Formatador.formatarData(date);
        date = Formatador.parseData(dateS);

        votacaoAtual = votacaoBO.getVotacao(date);

        if(votacaoAtual == null){
            votacaoAtual = new Votacao(date);
            votacaoBO.setVotacao(votacaoAtual);
        }

        restaurantes = restauranteBO.getRestaurantes();
    }

    public ArrayList<Restaurante> getRestaurantes(){
        return restaurantes;
    }

    public Date getVotacaoDate(){
        return votacaoAtual.getData();
    }

    public Response votar(Restaurante restaurante, Usuario usuario){
        return votacaoBO.votar(restaurante,usuario,votacaoAtual.getData());
    }
}
