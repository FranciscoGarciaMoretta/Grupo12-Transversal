package Persistencia;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class MateriaData {
    private Connection con;
    
    public MateriaData(Connection con) {
        this.con = con;
    }
    
    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";
    
     public void insert(Materia m) {
        try {
            String sql = "insert into materia(nombre, estado) values (?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getEstado());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Materia registrada con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos de materia incompatibles!!\n");
        }
    }
     
    public void remove(int id) {
        try{
            String sql = "delete from materia where idMateria = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Se ha eliminado la materia correctamente!!\n"+cReset);
            }else
                System.err.println("ERROR: No se ha encontrado la materia!!\n");
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado la materia!!\n");
        }
    }
    
    public void update(Materia m) {
        try {
            String sql = "update materia set nombre = ?, estado = ? where idMateria = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getEstado());
            ps.setInt(3, m.getIdMateria());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Materia editada con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos de la materia incompatibles!!\n");
        }
    }
    
    public Materia getById(int id) {
        Materia materia = null;
        try{
            String sql = "select * from materia where idMateria = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                materia = new Materia(
                    res.getInt("idMateria"),
                    res.getString("nombre"),
                    res.getInt("estado")
                );
            }
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado la materia!! "+e+"\n");
        }
        return materia;
    }
    
    public ArrayList<Materia> getList() {
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia a = new Materia(
                    rs.getInt("idMateria"),
                    rs.getString("nombre"),
                    rs.getInt("estado")
                );
                materias.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }
}
