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

    public VotacaoBO(VotacaoDAO votacaoDAO) {
        this.votacaoDAO = votacaoDAO;
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

    public ArrayList<Votacao> getVotacaoByStatus(String status){
        return votacaoDAO.getVotacaoByStatus(status);
    }

    public Votacao getVotacao(Date data){
        return votacaoDAO.getVotacao(data);
    }

    public void addVotacao(Votacao votacao){
        votacaoDAO.addVotacao(votacao);
    }

    public boolean verificaVencedor(Votacao votacao,ArrayList<Usuario> usuarios){
        HashMap<Integer,Restaurante> votos = getVotos(votacao);
        if(votos.size() == 0){
            return true;
        }
        if(usuarios.size() == votos.size() || votacao.getStatus().equals("F")){
            HashMap<Integer,Integer> restaurantes = new HashMap<>();
            Integer vencedor = null;
            int vencedorVotos = 0;
            for (Restaurante r: votos.values()) {
                if(restaurantes.containsKey(r.getId())){
                    restaurantes.replace(r.getId(),restaurantes.get(r.getId())+1);

                }else{
                    restaurantes.put(r.getId(),1);
                }
            }
            for (Integer restaurante:restaurantes.keySet()) {
                if(vencedorVotos < restaurantes.get(restaurante)){
                    vencedor = restaurante;
                    vencedorVotos = restaurantes.get(restaurante);
                }
            }

            votacaoDAO.atualizaVencedor(vencedor,votacao);
            return true;
        }else{
            return false;
        }

    }

    public void atualizaStatus(Votacao votacao){
        votacaoDAO.atualizaStatus(votacao);
    }

}
