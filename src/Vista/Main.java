package Vista;
import Modelo.Alumno;
import Modelo.Conexion;
import Persistencia.AlumnoData;
import java.time.LocalDate;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerLine = new Scanner(System.in);
    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection con = (Connection) conexion.cargarConexion();
        
        //Alumno alumn = new Alumno(0,23456,"Julian",LocalDate.of(2002, 2, 2),true);
        AlumnoData alumnData = new AlumnoData(con);
        
        //alumnData.insert(alumn); // agregar
        //alumn.setNombre("MAXIMO");
        //alumnData.update(alumn);
        //alumnData.eliminarAlumno(1); // eliminar
        boolean finishProgram = false;
        
        while (!finishProgram) {
            boolean finishOptions = false;
            alumnList(alumnData);
            
            System.out.println("\nOPCIONES:\n1 - Agregar un Alumno\n2 - Eliminar un Alumno\n3 - Editar un Alumno\n4 - Salir");
            while (!finishOptions) {
                try {
                    System.out.print("\nIngrese el numero de su opcion: ");
                    int optionResult = scannerInt.nextInt();
                    switch(optionResult) {
                        case 1: {
                            Alumno alumn = alumnCreate();
                            finishOptions = true;
                        }
                        case 2: {
                            
                            finishOptions = true;
                        }
                        case 3: {
                            
                            finishOptions = true;
                        }
                        case 4: {
                            
                            finishOptions = true;
                        }
                        default: {
                            System.err.println("ERROR: Ingrese un valor disponible!!");
                        }
                    }
                }catch(Exception e) {
                    System.err.println("ERROR: Ingrese un valor valido!!");
                    scannerInt.nextLine();
                }
            }
        }
    }
    
    static public void alumnList (AlumnoData data){
            System.out.println("Lista de Alumnos:");
            ArrayList<Alumno> list = data.getList();
            String formatList = "%-3s %-11s %s%n";
            System.out.printf(formatList,"ID:","| DNI:","| NOMBRE COMPLETO:");
            for (Alumno i: list) {System.out.printf(formatList,i.getIdAlumno(),"| "+i.getDni(),"| "+i.getNombre());}
    }
    
    static public Alumno alumnCreate() {
        scannerInt.nextLine(); scannerLine.nextLine();
        
        while (true) {
            try {
                System.out.print("\nIngrese el DNI del Alumno: ");
                int dni = scannerInt.nextInt();
                if (String.valueOf(dni).length() == 8) {
                    // Tiene exactamente 8 dígitos
                }else{
                    
                }
                break;
            }catch(Exception e) {
                System.err.println("ERROR: Ingrese un valor valido!!");
                scannerInt.nextLine();
            }
        }
        
        System.out.print("\nIngrese el nombre del Alumno: ");
        String name = scannerLine.nextLine();
        
        Alumno result = new Alumno(0,23456,"Julian",LocalDate.of(2002, 2, 2),true);
        return result;
    }
}
