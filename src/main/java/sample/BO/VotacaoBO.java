package sample.BO;

import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;
import sample.Utils.Response;
import sample.Utils.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class VotacaoBO {

    private VotacaoDAO votacaoDAO;

    public VotacaoBO() {
        votacaoDAO = new VotacaoDAO();
    }

    public Response votar(Restaurante restaurante, Usuario usuario,Date dataVotacao){

        Votacao votacao = votacaoDAO.getVotacao(dataVotacao);
        HashMap<Usuario, Restaurante> votadores = votacao.getVotadores();

        if(votadores!=null && votadores.containsKey(usuario)){
            return new Response(Status.ERRO,"Usuario já votou");
        }else{
            votacaoDAO.votar(restaurante,usuario,dataVotacao);
            return new Response(Status.SUCESSO,"Voto computado");
        }
    }

    public Votacao getVotacao(Date data){
        return votacaoDAO.getVotacao(data);
    }

    public void setVotacao(Votacao votacao){
        votacaoDAO.setVotacao(votacao);
    }

}
