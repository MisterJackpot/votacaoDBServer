package sample.BO;

import sample.DAO.RestauranteDAO;
import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;

import java.util.ArrayList;

public class RestauranteBO {
    private RestauranteDAO restauranteDAO;
    private VotacaoDAO votacaoDAO

    public RestauranteBO() {
        restauranteDAO = new RestauranteDAO();
        votacaoDAO = new VotacaoDAO();
    }

    public ArrayList<Restaurante> getRestaurantes(){
        return restauranteDAO.getRestaurantes();
    }

    public ArrayList<Restaurante> getRestaurantesDisponiveis(){

    }
}
