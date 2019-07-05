package sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import sample.BO.RestauranteBO;
import sample.DAO.RestauranteDAO;
import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;
import sample.DTO.Votacao;

import java.util.ArrayList;
import java.util.Date;
import static org.mockito.Mockito.when;

public class RestauranteBOTest {
    private VotacaoDAO votacaoDAO = Mockito.mock(VotacaoDAO.class);
    private RestauranteDAO restauranteDAO = Mockito.mock(RestauranteDAO.class);


    @Test
    void getRestaurantesDisponiveisTesteSucesso(){
        Date date = new Date();
        ArrayList<Votacao> votacaosMock = new ArrayList<>();
        Restaurante restaurante1 = new Restaurante(1,"Palatus");
        Restaurante restaurante2 = new Restaurante(2,"Vitoria");
        Restaurante restaurante3 = new Restaurante(3,"Panorama");
        ArrayList<Restaurante> result = new ArrayList<>();
        result.add(restaurante1);
        result.add(restaurante3);
        Votacao votacao1 = new Votacao(date);
        votacao1.setStatus("F");
        votacao1.setVencedor(restaurante2);
        votacaosMock.add(votacao1);
        ArrayList<Restaurante> restaurantesMock = new ArrayList<>();
        restaurantesMock.add(restaurante1);
        restaurantesMock.add(restaurante2);
        restaurantesMock.add(restaurante3);

        when(votacaoDAO.getVotacaoByStatus("F")).thenReturn(votacaosMock);
        when(restauranteDAO.getRestaurantes()).thenReturn(restaurantesMock);

        RestauranteBO restauranteBO = new RestauranteBO(restauranteDAO,votacaoDAO);

        ArrayList<Restaurante> restaurantes = restauranteBO.getRestaurantesDisponiveis(date);

        Assertions.assertArrayEquals(new ArrayList[]{result}, new ArrayList[]{restaurantes});
    }
}
