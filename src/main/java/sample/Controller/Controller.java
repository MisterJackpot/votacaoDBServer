package sample.Controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    ChoiceBox users;

    @FXML
    private void initialize()
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("Gabriel");
        list.add("Joao");


        users.setItems(FXCollections.observableArrayList(list));
    }

    @FXML
    public void entrar(){
        try {
            Parent pagina = (Parent) FXMLLoader.load(getClass().getResource("/principal.fxml"));
            Scene scene = users.getScene();
            scene.setRoot(pagina);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
