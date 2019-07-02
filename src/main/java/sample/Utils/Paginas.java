package sample.Utils;

public enum Paginas {
    LOGIN("sample.fxml"),PRINCIPAL("principal.fxml");

    private final String pagina;

    Paginas(String pag){
        pagina = pag;
    }

    public String getPagina(){
        return pagina;
    }
}
