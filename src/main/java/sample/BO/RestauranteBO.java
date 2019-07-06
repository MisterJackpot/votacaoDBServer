package sample.BO;

import sample.DAO.RestauranteDAO;
import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;
import sample.DTO.Votacao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RestauranteBO {
    private RestauranteDAO restauranteDAO;
    private VotacaoDAO votacaoDAO;

    public RestauranteBO() {
        restauranteDAO = new RestauranteDAO();
        votacaoDAO = new VotacaoDAO();
    }

    public RestauranteBO(RestauranteDAO restauranteDAO, VotacaoDAO votacaoDAO) {
        this.restauranteDAO = restauranteDAO;
        this.votacaoDAO = votacaoDAO;
    }

    public ArrayList<Restaurante> getRestaurantes(){
        return restauranteDAO.getRestaurantes();
    }

    public ArrayList<Restaurante> getRestaurantesDisponiveis(Date data){
        ArrayList<Votacao> votacaos = votacaoDAO.getVotacaoByStatus("F");
        ArrayList<Restaurante> restaurantes = getRestaurantes();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int weekData = cal.get(Calendar.WEEK_OF_YEAR);

        for (Votacao votacao: votacaos) {
            if(votacao.getVencedor() != null) {
                cal = Calendar.getInstance();
                cal.setTime(votacao.getData());
                int week = cal.get(Calendar.WEEK_OF_YEAR);
                if (weekData == week) {
                    restaurantes.removeIf(b -> b.getId() == votacao.getVencedor().getId());
                }
            }
        }

        return restaurantes;
    }

    public boolean validarRestaurante(Restaurante restaurante,Date data) {
        ArrayList<Restaurante> restaurantes = getRestaurantesDisponiveis(data);
        for (Restaurante r: restaurantes) {
            if(r.getId() == restaurante.getId()){
                return true;
            }
        }
        return false;
    }
}
