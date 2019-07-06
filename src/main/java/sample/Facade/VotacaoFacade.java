package sample.Facade;

import sample.BO.UsuarioBO;
import sample.BO.RestauranteBO;
import sample.BO.VotacaoBO;
import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;
import sample.Utils.Formatador;
import sample.Utils.Response;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class VotacaoFacade {

    private Date data;
    private RestauranteBO restauranteBO;
    private VotacaoBO votacaoBO;
    private UsuarioBO usuarioBO;
    private ArrayList<Restaurante> restaurantes;
    private Votacao votacaoAtual;

    public VotacaoFacade() {
        restauranteBO = new RestauranteBO();
        votacaoBO = new VotacaoBO();
        usuarioBO = new UsuarioBO();
    }

    public void inicializarFacade(){
        data = new Date();
        String dateS = Formatador.formatarData(data);
        data = Formatador.parseData(dateS);

        atualizarVotacao();

        restaurantes = getRestaurantes();
    }

    public void atualizarVotacao(){
        votacaoAtual = votacaoBO.getVotacao(data);

        if(votacaoAtual == null){
            votacaoAtual = new Votacao(data);
            votacaoAtual.setStatus("A");
            votacaoBO.addVotacao(votacaoAtual);
        }
    }

    public ArrayList<Restaurante> getRestaurantes(){
        restaurantes = restauranteBO.getRestaurantesDisponiveis(data);
        return restaurantes;
    }

    public Date getVotacaoDate(){
        return votacaoAtual.getData();
    }

    public Response votar(Restaurante restaurante, Usuario usuario){
        return votacaoBO.votar(restaurante,usuario,votacaoAtual.getData());
    }

    public Restaurante getVoto(Usuario usuario){
        HashMap<Integer,Restaurante> votos = votacaoBO.getVotos(votacaoAtual);

        return votos.getOrDefault(usuario.getId(), null);
    }

    public boolean verificaTempo(){
        Date d = new Date();
        if(!data.after(Formatador.parseData(Formatador.formatarData(d)))){
            if(Formatador.parseHoras(Formatador.formatarHoras(d)).after(Formatador.parseHoras("12:00"))){
                votacaoAtual.setStatus("F");
                votacaoBO.atualizaStatus(votacaoAtual);
                verificaVencedor();
                d = Formatador.adicionarDia(d);
                data = Formatador.parseData(Formatador.formatarData(d));
                atualizarVotacao();
                return true;
            }
        }
        return false;
    }

    public boolean verificaVencedor(){
        ArrayList<Usuario> usuarios = usuarioBO.getUsuarios();
        return votacaoBO.verificaVencedor(votacaoAtual,usuarios);
    }
}
