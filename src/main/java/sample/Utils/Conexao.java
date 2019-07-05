package sample.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {


    public static Connection connectionToDerby() throws SQLException {
        // -------------------------------------------
        // URL format is
        // jdbc:derby:<local directory to save data>
        // -------------------------------------------
        String directory = System.getProperty("user.dir");
        String dbUrl = "jdbc:derby:"+directory+"\\DB;create=true";
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(dbUrl);
    }
}
