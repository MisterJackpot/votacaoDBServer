package sample.BO;

import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;
import sample.Utils.Response;
import sample.Utils.Status;

import java.util.Date;
import java.util.HashMap;

public class VotacaoBO {

    private VotacaoDAO votacaoDAO;

    public VotacaoBO() {
        votacaoDAO = new VotacaoDAO();
    }

    public Response votar(Restaurante restaurante, Usuario usuario,Date dataVotacao){

        Votacao votacao = votacaoDAO.getVotacao(dataVotacao);
        HashMap<Integer, Restaurante> votos = this.getVotos(votacao);

        if(votos!=null && votos.containsKey(usuario.getId())){
            return new Response(Status.ERRO,"Usuario já votou");
        }else{
            votacaoDAO.votar(restaurante,usuario,dataVotacao);
            return new Response(Status.SUCESSO,"Voto computado");
        }
    }

    public HashMap<Integer, Restaurante> getVotos(Votacao votacao){
        HashMap<Integer, Restaurante> votos = votacaoDAO.getVotos(votacao.getData());

        return votos;
    }

    public Votacao getVotacao(Date data){
        return votacaoDAO.getVotacao(data);
    }

    public void addVotacao(Votacao votacao){
        votacaoDAO.addVotacao(votacao);
    }

}
