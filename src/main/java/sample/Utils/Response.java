package sample.Utils;

public class Response {
    private Status tipo;
    private String mensagem;

    public Response(Status tipo, String mensagem) {
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public Status getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
