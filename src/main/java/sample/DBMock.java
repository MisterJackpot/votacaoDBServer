package sample;

import sample.DTO.Usuario;

import java.util.ArrayList;

public class DBMock {
    private static DBMock ourInstance = new DBMock();
    private ArrayList<Usuario> usuarios;

    public static DBMock getInstance() {
        return ourInstance;
    }

    private DBMock() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Joao",1));
        usuarios.add(new Usuario("Gabriel",2));
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
