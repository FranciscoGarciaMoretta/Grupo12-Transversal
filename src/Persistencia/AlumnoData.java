package Persistencia;
import Modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class AlumnoData {
    private Connection con;
    
    public AlumnoData(Connection con) {
        this.con = con;
    }
    
    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";
    
     public void insert(Alumno a) {
        try {
            String sql = "insert into alumno(dni, nombre, fecNac, activo) values (?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(a.getFecNac()));
            ps.setBoolean(4, a.getActivo());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Alumno registrado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos de alumno incompatibles!!\n");
        }
    }
     
    public void remove(int id) {
        try{
            String sql = "delete from alumno where idAlumno = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Se ha eliminado al alumno correctamente!!\n"+cReset);
            }else
                System.err.println("ERROR: No se ha encontrado al alumno!!\n");
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado al alumno!!\n");
        }
    }
    
    public void update(Alumno a) {
        try {
            String sql = "update alumno set dni = ?, nombre = ?, fecNac = ?, activo = ? where idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setDate(3, java.sql.Date.valueOf(a.getFecNac()));
            ps.setBoolean(4, a.getActivo());
            ps.setInt(5, a.getIdAlumno());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Alumno editado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos de alumno incompatibles!!\n");
        }
    }
    
    
    
    public Alumno getById(int id) {
        Alumno alumno = null;
        try{
            String sql = "select * from alumno where idAlumno = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                alumno = new Alumno(
                    res.getInt("idAlumno"),
                    res.getInt("dni"),
                    res.getString("nombre"),
                    res.getDate("fecNac").toLocalDate(),
                    res.getBoolean("activo")
                );
            }
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado al alumno!! "+e+"\n");
        }
        return alumno;
    }
     
    public ArrayList<Alumno> getList() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno(
                    rs.getInt("idAlumno"),
                    rs.getInt("dni"),
                    rs.getString("nombre"),
                    rs.getDate("fecNac").toLocalDate(),
                    rs.getBoolean("activo")
                );
                alumnos.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}
