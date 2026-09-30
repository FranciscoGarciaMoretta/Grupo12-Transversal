package Vista;
import Modelo.Alumno;
import Modelo.Conexion;
import Persistencia.AlumnoData;
import java.time.LocalDate;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.cargarConexion();
        
        Alumno alumn = new Alumno(0,23456,"Julian",LocalDate.of(2002, 2, 2),true);
        AlumnoData alumnData = new AlumnoData(con);
        
        alumnData.insert(alumn); // agregar
        alumn.setNombre("MAXIMO");
        alumnData.update(alumn);
        //alumnData.eliminarAlumno(1); // eliminar
    }
}
