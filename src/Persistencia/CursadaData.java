
package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;

public class CursadaData {
      private final Connection con;
      
      public CursadaData(){
      this.con = Conexion.cargarConexion();
      }
      
      String cGreen = "\u001B[32m";
    String cReset = "\u001B[0m";
    
    
    
}
