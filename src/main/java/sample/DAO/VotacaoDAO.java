package sample.DAO;

import sample.DBMock;
import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class VotacaoDAO {

    public VotacaoDAO() {
    }

    public boolean votar(Restaurante restaurante, Usuario usuario,Date dataVotacao) {

        Votacao votacao = this.getVotacao(dataVotacao);
        HashMap<Integer,Integer> votos = votacao.getVotos();
        ArrayList<Usuario> usuarios = votacao.getVotadores();
        if(votos == null){
            votos = new HashMap<>();
        }
        if(usuarios == null){
            usuarios = new ArrayList<>();
        }
        usuarios.add(usuario);
        if(votos.containsKey(restaurante.getId())){
            Integer nVotos = votos.get(restaurante.getId());
            votos.replace(restaurante.getId(),nVotos+1);
        }else {
            votos.put(restaurante.getId(),1);
        }

        votacao.setVotadores(usuarios);
        votacao.setVotos(votos);

        return true;
    }

    public Votacao getVotacao(Date data){
        DBMock db = DBMock.getInstance();

        return db.getVotacao(data);
    }

    public void setVotacao(Votacao votacao){
        DBMock db = DBMock.getInstance();

        db.setVotacao(votacao);
    }
}
