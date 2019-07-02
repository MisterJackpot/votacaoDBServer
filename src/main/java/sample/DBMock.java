package sample;

import sample.DTO.Restaurante;
import sample.DTO.Usuario;

import java.util.ArrayList;

public class DBMock {
    private static DBMock ourInstance = new DBMock();
    private ArrayList<Usuario> usuarios;
    private ArrayList<Restaurante> restaurantes;


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
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }
}
