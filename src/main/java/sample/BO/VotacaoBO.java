package sample.BO;

import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;
import sample.DTO.Votacao;

public class VotacaoBO {

    private VotacaoDAO votacaoDAO;

    public VotacaoBO() {
        votacaoDAO = new VotacaoDAO();
    }

    public boolean votar(Restaurante restaurante){
        return votacaoDAO.votar(restaurante);
    }

    public Votacao getVotacao(){
        return votacaoDAO.getVotacao();
    }

}
