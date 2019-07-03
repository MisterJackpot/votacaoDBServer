package sample;

import sample.DTO.Restaurante;
import sample.DTO.Usuario;
import sample.DTO.Votacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DBMock {
    private static DBMock ourInstance = new DBMock();
    private ArrayList<Usuario> usuarios;
    private ArrayList<Restaurante> restaurantes;
    private HashMap<Date,Votacao> votacao;


    public static DBMock getInstance() {
        return ourInstance;
    }

    private DBMock() {

        //Usuarios
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Joao",1));
        usuarios.add(new Usuario("Gabriel",2));
        usuarios.add(new Usuario("Leo",3));

        //Restaurantes
        restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante(1,"Palatus"));
        restaurantes.add(new Restaurante(2,"Novo Sabor"));
        restaurantes.add(new Restaurante(3,"Panorama"));

        //Votação
        votacao = new HashMap<>();

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public Votacao getVotacao(Date dataVotacao) {
        return votacao.get(dataVotacao);
    }

    public void setVotacao(Votacao votacao) {
        this.votacao.put(votacao.getData(),votacao);
    }
}
