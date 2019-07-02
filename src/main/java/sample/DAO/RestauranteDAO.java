package sample.DAO;

import sample.DBMock;
import sample.DTO.Restaurante;

import java.util.ArrayList;

public class RestauranteDAO {

    public RestauranteDAO() {
    }

    public ArrayList<Restaurante> getRestaurantes() {
        DBMock db = DBMock.getInstance();

        return db.getRestaurantes();
    }
}
