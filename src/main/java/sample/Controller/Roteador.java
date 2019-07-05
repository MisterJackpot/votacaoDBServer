package sample.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.Utils.Paginas;

import java.io.IOException;

public class Roteador {

    public Roteador(){
    }

    public void rotear(Paginas pagina,Scene scene){

        System.out.println(pagina);
        Parent fxml = null;
        try {
            fxml = FXMLLoader.load(getClass().getResource("/" + pagina.getPagina()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene.setRoot(fxml);
    }

}
