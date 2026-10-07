package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection conexion = null;

    public Conexion() {}

    public static Connection cargarConexion() {
        if (conexion==null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion=DriverManager.getConnection("jdbc:mysql://localhost/gp12universidad","root","");
            }catch(SQLException|ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return conexion;
    }
}