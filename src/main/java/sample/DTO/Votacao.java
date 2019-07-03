package sample.DTO;

import java.util.Date;
import java.util.HashMap;

public class Votacao {

    private Date data;
    private HashMap<Integer,Integer> votos;
    private HashMap<Usuario,Restaurante> votadores;

    public Votacao(Date data) {
        this.data = data;
        votadores = new HashMap<>();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public HashMap<Integer, Integer> getVotos() {
        return votos;
    }

    public void setVotos(HashMap<Integer, Integer> votos) {
        this.votos = votos;
    }

    public HashMap<Usuario, Restaurante> getVotadores() {
        return votadores;
    }

    public void setVotadores(HashMap<Usuario, Restaurante> votadores) {
        this.votadores = votadores;
    }
}
