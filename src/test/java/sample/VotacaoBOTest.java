package sample;

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

import java.util.Date;
import java.util.HashMap;

import static org.mockito.Mockito.when;

public class VotacaoBOTest {

    private VotacaoDAO votacaoDAO = Mockito.mock(VotacaoDAO.class);

    @Test
    void votarTestSucesso() {
        HashMap<Integer,Restaurante> votosMock = new HashMap<>();
        Votacao votacaoMock = new Votacao(new Date());
        Restaurante restaurante = new Restaurante(1,"Palatus");
        votosMock.put(2,restaurante);
        Usuario usuario = new Usuario("Gabriel",1);
        Date date = new Date();

        when(votacaoDAO.getVotacao(date)).thenReturn(votacaoMock);
        when(votacaoDAO.getVotos(date)).thenReturn(votosMock);

        VotacaoBO votacaoBO = new VotacaoBO(votacaoDAO);

        Response response = votacaoBO.votar(restaurante,usuario,date);
        Assertions.assertEquals(Status.SUCESSO,response.getTipo());

    }
    @Test
    void votarTestErro() {
        HashMap<Integer,Restaurante> votosMock = new HashMap<>();
        Votacao votacaoMock = new Votacao(new Date());
        Restaurante restaurante = new Restaurante(1,"Palatus");
        votosMock.put(1,restaurante);
        Usuario usuario = new Usuario("Gabriel",1);
        Date date = new Date();

        when(votacaoDAO.getVotacao(date)).thenReturn(votacaoMock);
        when(votacaoDAO.getVotos(date)).thenReturn(votosMock);

        VotacaoBO votacaoBO = new VotacaoBO(votacaoDAO);

        Response response = votacaoBO.votar(restaurante,usuario,date);
        Assertions.assertEquals(Status.ERRO,response.getTipo());

    }

}
