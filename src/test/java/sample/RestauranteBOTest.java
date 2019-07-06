package sample;

import org.junit.jupiter.api.BeforeEach;
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
    private Date date;
    private Restaurante restaurante1,restaurante2,restaurante3;
    private ArrayList<Votacao> votacaosMock;
    private Votacao votacao1;
    private ArrayList<Restaurante> restaurantesMock;
    private RestauranteBO restauranteBO;

    @BeforeEach
    void init(){
        restauranteBO = new RestauranteBO(restauranteDAO,votacaoDAO);
        date = new Date();
        restaurante1 = new Restaurante(1,"Palatus");
        restaurante2 = new Restaurante(2,"Vitoria");
        restaurante3 = new Restaurante(3,"Panorama");
        votacaosMock = new ArrayList<>();
        votacao1 = new Votacao(date);
        restaurantesMock = new ArrayList<>();
        restaurantesMock.add(restaurante1);
        restaurantesMock.add(restaurante2);
        restaurantesMock.add(restaurante3);
    }

    @Test
    void getRestaurantesDisponiveisTesteSucesso(){
        ArrayList<Restaurante> result = new ArrayList<>();
        result.add(restaurante1);
        result.add(restaurante3);
        votacao1.setStatus("F");
        votacao1.setVencedor(restaurante2);
        votacaosMock.add(votacao1);

        when(votacaoDAO.getVotacaoByStatus("F")).thenReturn(votacaosMock);
        when(restauranteDAO.getRestaurantes()).thenReturn(restaurantesMock);

        ArrayList<Restaurante> restaurantes = restauranteBO.getRestaurantesDisponiveis(date);

        Assertions.assertArrayEquals(new ArrayList[]{result}, new ArrayList[]{restaurantes});
    }

    @Test
    void getRestaurantesDisponiveisTesteSucesso2(){
        ArrayList<Restaurante> result = new ArrayList<>();
        result.add(restaurante1);
        result.add(restaurante2);
        result.add(restaurante3);

        when(votacaoDAO.getVotacaoByStatus("F")).thenReturn(votacaosMock);
        when(restauranteDAO.getRestaurantes()).thenReturn(restaurantesMock);

        ArrayList<Restaurante> restaurantes = restauranteBO.getRestaurantesDisponiveis(date);

        Assertions.assertArrayEquals(new ArrayList[]{result}, new ArrayList[]{restaurantes});
    }
}
