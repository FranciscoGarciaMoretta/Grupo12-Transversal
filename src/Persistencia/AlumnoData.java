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
                System.out.println("Alumno Registrado con exito");
            }
        }catch(SQLException e) {
            System.err.println("Datos de alumno incompatibles");
        }
    }
     
    public void remove(int id) {
        try{
            String sql = "delete from alumno where idAlumno = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println("Se ha eliminado al alumno correctamente");
            }else
                System.err.println("No se ha encontrado al alumno");
        }catch(SQLException e) {
            System.err.println("Alumno no encontrado "+e);
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
                System.out.println("Alumno Editado con exito");
            }
        }catch(SQLException e) {
            System.err.println("Datos de alumno incompatibles");
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
            System.err.println("Alumno no encontrado "+e);
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
