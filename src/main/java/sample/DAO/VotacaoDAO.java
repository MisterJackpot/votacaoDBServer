package sample.DAO;

import sample.DBMock;
import sample.DTO.Votacao;

public class VotacaoDAO {

    public VotacaoDAO() {
    }

    public boolean votar() {
        return true;
    }

    public Votacao getVotacao(){
        DBMock db = DBMock.getInstance();

        return db.getVotacao();
    }
}
