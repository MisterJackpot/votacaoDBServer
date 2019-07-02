package sample.BO;

import sample.DAO.RestauranteDAO;
import sample.DTO.Restaurante;

import java.util.ArrayList;

public class RestauranteBO {
    private RestauranteDAO restauranteDAO;

    public RestauranteBO() {
        restauranteDAO = new RestauranteDAO();
    }

    public ArrayList<Restaurante> getRestaurantes(){
        return restauranteDAO.getRestaurantes();
    }
}
