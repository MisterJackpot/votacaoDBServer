package sample.BO;

import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;

import java.util.ArrayList;

public class VotacaoBO {

    private VotacaoDAO votacaoDAO;

    public VotacaoBO() {
        votacaoDAO = new VotacaoDAO();
    }

    public boolean votar(Restaurante restaurante, Usuario usuario){

        Votacao votacao = votacaoDAO.getVotacao();
        ArrayList<Usuario> votadores = votacao.getVotadores();

        if(votadores!=null && votadores.contains(usuario)){
            System.out.println("Usuario já votou");
            return false;
        }else{
            return votacaoDAO.votar(restaurante,usuario);
        }
    }

    public Votacao getVotacao(){
        return votacaoDAO.getVotacao();
    }

}
