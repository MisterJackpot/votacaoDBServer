package sample.DTO;

import java.util.Date;
import java.util.HashMap;

public class Votacao {

    private Date data;
    private HashMap<Integer,Integer> votos;

    public Votacao(Date data) {
        this.data = data;
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
}
