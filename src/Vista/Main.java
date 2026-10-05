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
        AlumnoData alumnData = new AlumnoData(con);

        boolean finishProgram = false;
        
        while (!finishProgram) {
            boolean finishOptions = false;
            alumnList(alumnData);
            
            System.out.println("OPCIONES:\n1 - Agregar un Alumno\n2 - Eliminar un Alumno\n3 - Editar un Alumno\n4 - Salir");
            while (!finishOptions) {
                try {
                    System.out.print("\nIngrese el numero de su opcion: ");
                    int optionResult = scannerInt.nextInt();
                    switch(optionResult) {
                        case 1: {
                            Alumno alumn = alumnCreate(null);
                            alumnData.insert(alumn);
                            finishOptions = true;
                            break;
                        }
                        case 2: {
                            Alumno select = alumnSelect(alumnData);
                            alumnData.remove(select.getIdAlumno());
                            finishOptions = true;
                            break;
                        }
                        case 3: {
                            Alumno select = alumnSelect(alumnData);
                            select = alumnCreate(select);
                            alumnData.update(select);
                            finishOptions = true;
                            break;
                        }
                        case 4: {
                            finishOptions = true;
                            finishProgram = true;
                            break;
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
            System.out.println("");
    }
    
    static public Alumno alumnSelect(AlumnoData data) {
        ArrayList<Alumno> list = data.getList();
        System.out.println("");
        alumnList(data);
        Alumno find = null;
        while(true) {
            try {
                System.out.print("Ingrese la ID del alumno que desea tomar: ");
                int id = scannerInt.nextInt();
                for(Alumno i: list) {if (id == i.getIdAlumno()) {find = i; break;}}
                if (find != null) {
                    break;
                }else{
                    System.err.println("ERROR: No se encontro al alumno!!");
                }
            }catch(Exception e) {
                System.err.println("ERROR: Solo se permiten valores numericos!!");
                scannerInt.nextLine();
            }
        }
        return find;
    }
    
    static public boolean verifyChange(Alumno alumnEdit, String msg) {
        boolean result = true;
        if (alumnEdit != null) {
            while (true) {
                System.out.print(msg);
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {result = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        return result;
    }
    
    static public Alumno alumnCreate(Alumno alumnEdit) {
        int id = 0;
        int dni = 0;
        String name = "";
        int day = 1;
        int month = 1;
        int year = 2007;
        boolean active = false;
        
        if (alumnEdit != null) {
            id = alumnEdit.getIdAlumno();
            dni = alumnEdit.getDni();
            name = alumnEdit.getNombre();
            day =  alumnEdit.getFecNac().getDayOfMonth();
            month = alumnEdit.getFecNac().getMonthValue();
            year = alumnEdit.getFecNac().getYear();
            active = alumnEdit.getActivo();
        }
        
        if (verifyChange(alumnEdit,"Desea modificar el dni? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el DNI del Alumno: ");
                    dni = scannerInt.nextInt();
                    if (String.valueOf(dni).length() == 8) {
                        break;
                    }else{
                        System.err.println("ERROR: Ingrese exactamente 8 numeros!!");
                        scannerInt.nextLine();
                    }
                }catch(Exception e) {
                    System.err.println("ERROR: Ingrese un valor valido!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(alumnEdit,"Desea modificar el nombre? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el nombre del Alumno: ");
                name = scannerLine.nextLine();
                if (name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.err.println("ERROR: El nombre solo puede contener letras!!");
                }
            }
        }

        if (verifyChange(alumnEdit,"Desea modificar el anio de nacimiento? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el anio de nacimiento: ");
                    year = scannerInt.nextInt();
                    LocalDate date = LocalDate.of(year, month, day);
                    if (year > 1925 && year < 2009 ) {
                        break;
                    } else {
                        System.err.println("ERROR: Ingrese un anio coherente!!");
                    }
                }catch(Exception e) {
                    System.err.println("ERROR: Ingrese un anio valido!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(alumnEdit,"Desea modificar el mes de nacimiento? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el mes de nacimiento: ");
                    month = scannerInt.nextInt();
                    LocalDate date = LocalDate.of(year, month, day);
                    break;
                }catch(Exception e) {
                    System.err.println("ERROR: Ingrese un mes valido!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(alumnEdit,"Desea modificar el dia de nacimiento? (s/n): ")) {
            while (true) {
                try {
                    System.out.print("Ingrese el dia de nacimiento: ");
                    day = scannerInt.nextInt();
                    LocalDate date = LocalDate.of(year, month, day);
                    break;
                }catch(Exception e) {
                    System.err.println("ERROR: Ingrese un dia valido!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (verifyChange(alumnEdit,"Desea modificar el activo? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese si el Alumno esta activo (s/n): ");
                String sactive = scannerLine.nextLine();
                if (sactive.toLowerCase().contains("s")) {
                    active = true;
                    break;
                } else {
                    if (sactive.toLowerCase().contains("n")) {
                    break;
                    }
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        
        return new Alumno(id,dni,name,LocalDate.of(year, month, day),active);
    }
}
