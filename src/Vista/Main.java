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
    
    static public Alumno alumnCreate(Alumno alumnEdit) {
        int idAlumn = 0;
        int dni = 0; boolean cDni = true;
        String name = ""; boolean cName = true;
        int day = 1; boolean cDay = true;
        int month = 1; boolean cMonth = true;
        int year = 2007; boolean cYear = true;
        boolean active = false; boolean cActive = true;
        
        if (alumnEdit != null) {
            idAlumn = alumnEdit.getIdAlumno();
            dni = alumnEdit.getDni();
            name = alumnEdit.getNombre();
            day =  alumnEdit.getFecNac().getDayOfMonth();
            month = alumnEdit.getFecNac().getMonthValue();
            year = alumnEdit.getFecNac().getYear();
            active = alumnEdit.getActivo();
        }
        
        if (alumnEdit != null) {
            while (true) {
                System.out.print("Desea modificar el dni? (s/n): ");
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {cDni = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        if (cDni) {
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
        
        if (alumnEdit != null) {
            while (true) {
                System.out.print("Desea modificar el nombre? (s/n): ");
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {cName = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        if (cName) {
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

        if (alumnEdit != null) {
            while (true) {
                System.out.print("Desea modificar el dia de nacimiento? (s/n): ");
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {cDay = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        if (cDay) {
            while (true) {
                try {
                    System.out.print("Ingrese el dia de nacimiento: ");
                    day = scannerInt.nextInt();
                    if (day > 0 && day < 32) {
                        break;
                    } else {
                        System.err.println("ERROR: Ingrese un dia valido!!");
                    }
                }catch(Exception e) {
                    System.err.println("ERROR: Solo se permiten valores numericos!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (alumnEdit != null) {
            while (true) {
                System.out.print("Desea modificar el mes de nacimiento? (s/n): ");
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {cMonth = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        if (cMonth) {
            while (true) {
                try {
                    System.out.print("Ingrese el mes de nacimiento: ");
                    month = scannerInt.nextInt();
                    if (month > 0 && month < 32) {
                        break;
                    } else {
                        System.err.println("ERROR: Ingrese un mes valido!!");
                    }
                }catch(Exception e) {
                    System.err.println("ERROR: Solo se permiten numeros!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (alumnEdit != null) {
            while (true) {
                System.out.print("Desea modificar el anio de nacimiento? (s/n): ");
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {cYear = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        if (cYear) {
            while (true) {
                try {
                    System.out.print("Ingrese el anio de nacimiento: ");
                    year = scannerInt.nextInt();
                    if (year > 1925 && year < 2009 ) {
                        break;
                    } else {
                        System.err.println("ERROR: Ingrese un anio coherente!!");
                    }
                }catch(Exception e) {
                    System.err.println("ERROR: Solo se permiten numeros!!");
                    scannerInt.nextLine();
                }
            }
        }
        
        if (alumnEdit != null) {
            while (true) {
                System.out.print("Desea modificar el activo? (s/n): ");
                String resp = scannerLine.nextLine();
                if (resp.toLowerCase().contains("s")) {break;
                } else {
                    if (resp.toLowerCase().contains("n")) {cActive = false; break;}
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        if (cActive) {
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
        
        return new Alumno(idAlumn,dni,name,LocalDate.of(year, month, day),active);
    }
}
