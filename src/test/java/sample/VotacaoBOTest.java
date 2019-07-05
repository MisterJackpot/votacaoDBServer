package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import sample.BO.VotacaoBO;
import sample.DAO.VotacaoDAO;
import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;
import sample.Utils.Response;
import sample.Utils.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VotacaoBOTest {

    private VotacaoDAO votacaoDAO = Mockito.mock(VotacaoDAO.class);
    private VotacaoBO votacaoBO;
    private Date date;
    private Votacao votacaoMock;
    private HashMap<Integer,Restaurante> votosMock;
    private ArrayList<Usuario> usuarios;
    private Restaurante restaurante1,restaurante2,restaurante3;
    private Usuario usuario1,usuario2,usuario3;

    @BeforeEach
    void init(){
        votacaoBO = new VotacaoBO(votacaoDAO);
        date = new Date();
        votacaoMock = new Votacao(date);
        votosMock = new HashMap<>();
        usuarios = new ArrayList<>();
        restaurante1 = new Restaurante(1,"Palatus");
        restaurante2 = new Restaurante(2,"Panorama");
        usuario1 = new Usuario("Gabriel",1);
        usuario2 = new Usuario("Joao",2);
        usuario3 = new Usuario("Leo",3);

    }

    @Test
    void votarTestSucesso() {
        votosMock.put(2,restaurante1);


        when(votacaoDAO.getVotacao(date)).thenReturn(votacaoMock);
        when(votacaoDAO.getVotos(date)).thenReturn(votosMock);


        Response response = votacaoBO.votar(restaurante1,usuario1,date);
        Assertions.assertEquals(Status.SUCESSO,response.getTipo());

    }

    @Test
    void votarTestErro() {
        votosMock.put(1,restaurante1);

        when(votacaoDAO.getVotacao(date)).thenReturn(votacaoMock);
        when(votacaoDAO.getVotos(date)).thenReturn(votosMock);


        Response response = votacaoBO.votar(restaurante1,usuario1,date);
        Assertions.assertEquals(Status.ERRO,response.getTipo());

    }

    @Test
    void verificaVencedorTestSemVotos(){
        when(votacaoDAO.getVotos(votacaoMock.getData())).thenReturn(votosMock);


        Assertions.assertTrue(votacaoBO.verificaVencedor(votacaoMock,usuarios));
    }

    @Test
    void verificaVencedorTestSucesso(){
        votosMock.put(1,restaurante1);
        votosMock.put(2,restaurante1);
        votosMock.put(3,restaurante2);
        votacaoMock.setStatus("A");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        when(votacaoDAO.getVotos(votacaoMock.getData())).thenReturn(votosMock);


        Assertions.assertTrue(votacaoBO.verificaVencedor(votacaoMock,usuarios));
        verify(votacaoDAO,times(1)).atualizaVencedor(1,votacaoMock);
    }

    @Test
    void verificaVencedorTestSucesso2(){
        votosMock.put(1,restaurante1);
        votosMock.put(2,restaurante1);
        votacaoMock.setStatus("F");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        when(votacaoDAO.getVotos(votacaoMock.getData())).thenReturn(votosMock);

        Assertions.assertTrue(votacaoBO.verificaVencedor(votacaoMock,usuarios));
        verify(votacaoDAO,times(1)).atualizaVencedor(1,votacaoMock);
    }

    @Test
    void verificaVencedorTestErro(){
        votosMock.put(1,restaurante1);
        votosMock.put(2,restaurante1);
        votacaoMock.setStatus("A");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        when(votacaoDAO.getVotos(votacaoMock.getData())).thenReturn(votosMock);


        Assertions.assertFalse(votacaoBO.verificaVencedor(votacaoMock,usuarios));
    }


}
