package sample.BO;

import sample.DAO.VotacaoDAO;
import sample.DTO.Votacao;

public class VotacaoBO {

    private VotacaoDAO votacaoDAO;

    public VotacaoBO() {
        votacaoDAO = new VotacaoDAO();
    }

    public boolean votar(){
        return votacaoDAO.votar();
    }

    public Votacao getVotacao(){
        return votacaoDAO.getVotacao();
    }

}
