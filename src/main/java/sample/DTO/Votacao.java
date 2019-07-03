package sample.DTO;

import java.util.Date;
import java.util.HashMap;

public class Votacao {

    private Date data;
    private HashMap<Restaurante,Integer> votos;

    public Votacao(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public HashMap<Restaurante, Integer> getVotos() {
        return votos;
    }

    public void setVotos(HashMap<Restaurante, Integer> votos) {
        this.votos = votos;
    }
}
