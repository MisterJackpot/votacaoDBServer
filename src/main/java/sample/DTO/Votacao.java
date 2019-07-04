package sample.DTO;

import java.util.Date;
import java.util.HashMap;

public class Votacao {

    private Date data;
    private HashMap<Usuario,Restaurante> votadores;
    private Restaurante vencedor;
    private String status;
    private int id;

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

    public HashMap<Usuario, Restaurante> getVotadores() {
        return votadores;
    }

    public void setVotadores(HashMap<Usuario, Restaurante> votadores) {
        this.votadores = votadores;
    }

    public Restaurante getVencedor() {
        return vencedor;
    }

    public void setVencedor(Restaurante vencedor) {
        this.vencedor = vencedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return data + " - " + vencedor.getNome();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
