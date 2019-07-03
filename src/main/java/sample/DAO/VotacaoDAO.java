package sample.DAO;

import sample.DBMock;
import sample.DTO.Restaurante;
import sample.DTO.Votacao;

import java.util.HashMap;

public class VotacaoDAO {

    public VotacaoDAO() {
    }

    public boolean votar(Restaurante restaurante) {
        DBMock db = DBMock.getInstance();

        Votacao votacao = db.getVotacao();
        HashMap<Integer,Integer> votos = votacao.getVotos();
        if(votos == null){
            votos = new HashMap<>();
        }
        if(votos.containsKey(restaurante.getId())){
            Integer nVotos = votos.get(restaurante.getId());
            votos.replace(restaurante.getId(),nVotos+1);
        }else {
            votos.put(restaurante.getId(),1);
        }

        System.out.println(votos.get(restaurante.getId()));

        votacao.setVotos(votos);

        return true;
    }

    public Votacao getVotacao(){
        DBMock db = DBMock.getInstance();

        return db.getVotacao();
    }
}
