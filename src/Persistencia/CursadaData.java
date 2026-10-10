
package Persistencia;

import Modelo.Conexion;
import Modelo.Cursada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursadaData {
    private final Connection con;

    public CursadaData(){
    this.con = Conexion.cargarConexion();
    }
     
    String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";
    
     public void insert(Cursada c) {
        try {
            String sql = "insert into cursada(idAlumno, idMateria, nota, asist, cursa) values (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, c.getIdAlumno());
            ps.setObject(2, c.getIdMateria());
            ps.setFloat(3, c.getNota());
            ps.setFloat(4, c.getAsist());
            ps.setInt(5, c.getCursa());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Curso registrado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos del Curso incompatibles!!\n");
        }
    }
     
    public void remove(int id) {
        try{
            String sql = "delete from cursada where idCursada = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Se ha eliminado la cursada correctamente!!\n"+cReset);
            }else
                System.err.println("ERROR: No se ha encontrado la cursada!!\n");
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado la cursada!!\n");
        }
    }
    
    public void update(Cursada c) {
        try {
            String sql = "update cursada set idAlumno = ?, idMateria = ?, nota = ?, asist = ?, cursa = ? where idCursada = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, c.getIdAlumno());
            ps.setObject(2, c.getIdMateria());
            ps.setFloat(3, c.getNota());
            ps.setFloat(4, c.getAsist());
            ps.setInt(5, c.getCursa());
            ps.setInt(6, c.getIdCursada());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println(cGreen+"Cursada editado con exito!!\n"+cReset);
            }
        }catch(SQLException e) {
            System.err.println("ERROR: Datos de la Cursada incompatibles!!\n");
        }
    }
    
    public Cursada getById(int id) {
        Cursada cursada = null;
        try{
            String sql = "select * from cursada where idCursada = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                cursada = new Cursada(
                    res.getInt("idCursada"),
                    res.getInt("idAlumno"),
                    res.getInt("idMateria"),
                    res.getFloat("nota"),
                    res.getFloat("asist"),
                    res.getInt("cursa")
                );
            }
        }catch(SQLException e) {
            System.err.println("ERROR: No se ha encontrado la cursada!! "+e+"\n");
        }
        return cursada;
    }
    
    public ArrayList<Cursada> getList() {
        ArrayList<Cursada> cursadas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cursada";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cursada c = new Cursada(
                    rs.getInt("idCursada"),
                    rs.getInt("idAlumno"),
                    rs.getInt("idMateria"),
                    rs.getFloat("nota"),
                    rs.getFloat("asist"),
                    rs.getInt("cursa")
                );
                cursadas.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursadas;
    }
    
}
