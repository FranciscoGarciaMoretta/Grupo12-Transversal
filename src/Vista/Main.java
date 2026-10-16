package Vista;
import Modelo.Alumno;
import Modelo.Cursada;
import Modelo.Materia;
import Persistencia.AlumnoData;
import Persistencia.CursadaData;
import Persistencia.MateriaData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scannerInt = new Scanner(System.in);
    public static Scanner scannerLine = new Scanner(System.in);
    
    public static AlumnoData alumnoData = new AlumnoData();
    public static MateriaData materiaData = new MateriaData();
    public static CursadaData cursadaData = new CursadaData();
    
    public static void main(String[] args) {
        boolean finishProgram = false;
        
        while (!finishProgram) {
            boolean finishAlumn = true;
            boolean finishMateria = true;
            boolean finishInscriptions = true;
            boolean error = false;
            int optionSelected = 0;
            
            try {
                System.out.println("QUE DESEA TESTEAR:\n1 - Alumno\n2 - Materia\n3 - Inscripciones\n4 - Salir");
                System.out.print("\nIngrese el numero de su opcion: ");
                optionSelected = scannerInt.nextInt();
            }catch(Exception e) {
                scannerInt.nextLine();
                System.err.println("ERROR: Ingrese un valor valido!!");
                error = true;
            }
            
            switch(optionSelected) {
                case 1: {
                    finishAlumn = false;
                    break;
                }
                case 2: {
                    finishMateria = false;
                    break;
                }
                case 3: {
                    finishInscriptions = false;
                    break;
                }
                case 4: {
                    finishProgram = true;
                    break;
                }
                default: {
                    if (!error) {System.err.println("ERROR: Ingrese un valor disponible!!");}
                }
            }
            
            System.out.println("");
            
            while (!finishAlumn) {
                boolean finishOptions = false;
                alumnList();
                System.out.println("OPCIONES:\n1 - Agregar un Alumno\n2 - Eliminar un Alumno\n3 - Editar un Alumno\n4 - Salir");
                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();
                        switch(optionResult) {
                            case 1: {
                                Alumno alumn = alumnCreate(null);
                                alumnoData.insert(alumn);
                                finishOptions = true;
                                break;
                            }
                            case 2: {
                                Alumno select = alumnSelect();
                                alumnoData.remove(select.getIdAlumno());
                                finishOptions = true;
                                break;
                            }
                            case 3: {
                                Alumno select = alumnSelect();
                                select = alumnCreate(select);
                                alumnoData.update(select);
                                finishOptions = true;
                                break;
                            }
                            case 4: {
                                finishOptions = true;
                                finishAlumn = true;
                                System.out.println("");
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
            
            while (!finishMateria) {
                boolean finishOptions = false;
                materiaList();
                System.out.println("OPCIONES:\n1 - Agregar una materia\n2 - Eliminar una materia\n3 - Editar una materia\n4 - Salir");
                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();
                        switch(optionResult) {
                            case 1: {
                                Materia materia = materiaCreate(null);
                                materiaData.insert(materia);
                                finishOptions = true;
                                break;
                            }
                            case 2: {
                                Materia select = materiaSelect();
                                materiaData.remove(select.getIdMateria());
                                finishOptions = true;
                                break;
                            }
                            case 3: {
                                Materia select = materiaSelect();
                                select = materiaCreate(select);
                                materiaData.update(select);
                                finishOptions = true;
                                break;
                            }
                            case 4: {
                                finishOptions = true;
                                finishMateria = true;
                                System.out.println("");
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
            
            while (!finishInscriptions) {
                boolean finishOptions = false;
                inscriptionList();
                System.out.println("OPCIONES:\n1 - Agregar una inscripcion\n2 - Eliminar una inscripcion\n3 - Editar una inscripcion\n4 - Salir");
                while (!finishOptions) {
                    try {
                        System.out.print("\nIngrese el numero de su opcion: ");
                        int optionResult = scannerInt.nextInt();
                        switch(optionResult) {
                            case 1: {
                                Cursada cursada = inscriptionCreate(null);
                                cursadaData.insert(cursada);
                                finishOptions = true;
                                break;
                            }
                            case 2: {
                                Cursada select = inscriptionSelect();
                                cursadaData.remove(select.getIdCursada());
                                finishOptions = true;
                                break;
                            }
                            case 3: {
                                Cursada select = inscriptionSelect();
                                select = inscriptionCreate(select);
                                cursadaData.update(select);
                                finishOptions = true;
                                break;
                            }
                            case 4: {
                                finishOptions = true;
                                finishInscriptions = true;
                                System.out.println("");
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
    }
    
    // MÉTODOS DEL ALUMNO
    static public void alumnList (){
            System.out.println("Lista de Alumnos:");
            ArrayList<Alumno> list = alumnoData.getList();
            String formatList = "%-3s %-11s %s%n";
            System.out.printf(formatList,"ID:","| DNI:","| NOMBRE COMPLETO:");
            for (Alumno i: list) {System.out.printf(formatList,i.getIdAlumno(),"| "+i.getDni(),"| "+i.getNombre());}
            System.out.println("");
    }
    
    static public Alumno alumnSelect() {
        System.out.println("");
        alumnList();
        Alumno find = null;
        while(true) {
            try {
                System.out.print("Ingrese la ID del alumno que desea tomar: ");
                int id = scannerInt.nextInt();
                find = alumnoData.getById(id);
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
    
    // MÉTODOS DE LA MATERIA
    static public void materiaList (){
            System.out.println("Lista de Materias:");
            ArrayList<Materia> list = materiaData.getList();
            String formatList = "%-3s %s%n";
            System.out.printf(formatList,"ID:","| NOMBRE:");
            for (Materia i: list) {System.out.printf(formatList,i.getIdMateria(),"| "+i.getNombre());}
            System.out.println("");
    }
    
    static public Materia materiaSelect() {
        System.out.println("");
        materiaList();
        Materia find = null;
        while(true) {
            try {
                System.out.print("Ingrese la ID de la materia que desea tomar: ");
                int id = scannerInt.nextInt();
                find = materiaData.getById(id);
                if (find != null) {
                    break;
                }else{
                    System.err.println("ERROR: No se encontro la materia!!");
                }
            }catch(Exception e) {
                System.err.println("ERROR: Solo se permiten valores numericos!!");
                scannerInt.nextLine();
            }
        }
        return find;
    }
    
    static public Materia materiaCreate(Materia materiaEdit) {
        int id = 0;
        String name = "";
        boolean estate = false;
        
        if (materiaEdit != null) {
            id = materiaEdit.getIdMateria();
            name = materiaEdit.getNombre();
            estate = materiaEdit.getEstado();
        }
        
        if (verifyChange(materiaEdit,"Desea modificar el nombre? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese el nombre de la materia: ");
                name = scannerLine.nextLine();
                if (name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    break;
                } else {
                    System.err.println("ERROR: El nombre solo puede contener letras!!");
                }
            }
        }
        
        if (verifyChange(materiaEdit,"Desea modificar el estado? (s/n): ")) {
            while (true) {
                System.out.print("Ingrese si la materia esta activo (s/n): ");
                String sactive = scannerLine.nextLine();
                if (sactive.toLowerCase().contains("s")) {
                    estate = true;
                    break;
                } else {
                    if (sactive.toLowerCase().contains("n")) {
                    break;
                    }
                    System.err.println("ERROR: solo se permite ingresar s o n!!");
                }
            }
        }
        
        return new Materia(id,name,estate);
    }
    
    // MÉTODOS DE INSCRIPCION
    static public void inscriptionList (){
            System.out.println("Lista de inscripciones:");
            ArrayList<Cursada> list = cursadaData.getList();
            String formatList = "%-5s %-35s %-20s %-5s %-20s %-10s%n";
            System.out.printf(formatList,"ID:","| ALUMNO:","| MATERIA:","| NOTA:","| ASISTENCIA:","| CURSA:");
            
            for (Cursada c: list) {
                String alumno = "";
                for (Alumno a: alumnoData.getList()) {if (c.getIdAlumno() == a.getIdAlumno()) {alumno = a.getNombre();}}
                String materia = "";
                for (Materia m: materiaData.getList()) {if (c.getIdMateria() == m.getIdMateria()) {materia = m.getNombre();}}
                System.out.printf(formatList,c.getIdCursada(),"| "+alumno,"| "+materia,"| "+c.getNota(),"| "+c.getAsist(),"| "+c.getCursa());
            }
            
            System.out.println("");
    }
    
    static public Cursada inscriptionSelect() {
        System.out.println("");
        inscriptionList();
        Cursada find = null;
        while(true) {
            try {
                System.out.print("Ingrese la ID de la inscripcion que desea tomar: ");
                int id = scannerInt.nextInt();
                find = cursadaData.getById(id);
                if (find != null) {
                    break;
                }else{
                    System.err.println("ERROR: No se encontro la inscripcion!!");
                }
            }catch(Exception e) {
                System.err.println("ERROR: Solo se permiten valores numericos!!");
                scannerInt.nextLine();
            }
        }
        return find;
    }
    
    static public Cursada inscriptionCreate(Cursada cursadaEdit) {
        int id = 0;
        int idAlumno = 0;
        int idMateria = 0;
        float nota = 0;
        float asist = 0;
        int year = 0;
        
        if (cursadaEdit != null) {
            id = cursadaEdit.getIdCursada();
            idAlumno = cursadaEdit.getIdAlumno();
            idMateria = cursadaEdit.getIdMateria();
            nota = cursadaEdit.getNota();
            asist = cursadaEdit.getAsist();
            year = cursadaEdit.getCursa();
        }
        
        if (verifyChange(cursadaEdit,"Desea modificar el alumno? (s/n): ")) {
            alumnList();
            idAlumno = alumnSelect().getIdAlumno();
        }
        
        if (verifyChange(cursadaEdit,"Desea modificar la materia? (s/n): ")) {
            materiaList();
            idMateria = materiaSelect().getIdMateria();
        }
        
        if (verifyChange(cursadaEdit,"Desea modificar la nota? (s/n): ")) {
            boolean finish = false;
            while (!finish) {
                System.out.print("Ingrese la nota: ");
                try {
                    float snota = scannerInt.nextFloat();
                    if (snota > 10) {System.err.println("ERROR: el maximo de la nota es 10!!");}
                    else if (snota < 1) {System.err.println("ERROR: el minimo de la nota es 1!!");} else {
                        nota = snota;
                        break;
                    }
                }catch(Exception e) {
                   System.err.println("ERROR: solo se permiten numeros!!");
                }
            }
        }
        
        if (verifyChange(cursadaEdit,"Desea modificar la asistencia? (s/n): ")) {
            boolean finish = false;
            while (!finish) {
                System.out.print("Ingrese el porcentaje de asistencia: ");
                try {
                    float sasist = scannerInt.nextFloat();
                    if (sasist > 100) {System.err.println("ERROR: el maximo de la asistencia es 100!!");}
                    else if (sasist < 0) {System.err.println("ERROR: el minimo de la asistencia es 0!!");} else {
                        asist = sasist;
                        finish = true;
                    }
                }catch(Exception e) {
                   System.err.println("ERROR: solo se permiten numeros!!");
                }
            }
        }
        
        if (verifyChange(cursadaEdit,"Desea modificar el anio de cursada? (s/n): ")) {
            boolean finish = false;
            while (!finish) {
                System.out.print("Ingrese el anio de la cursada: ");
                try {
                   int scursada = scannerInt.nextInt();
                   if (String.valueOf(scursada).length()==4) {
                       LocalDate ynow = LocalDate.now();
                       String ynows = String.valueOf(ynow.getYear());
                       if (scursada > Integer.parseInt(ynows) || scursada < ((Integer.parseInt(ynows))-101)) {
                           System.err.println("ERROR: ingrese un anio coherente!!");
                       }else {
                           year = scursada;
                           finish = true;
                       }
                   }else{
                       System.err.println("ERROR: tienen que ser 4 digitos!!");
                   }
                }catch(Exception e) {
                   System.err.println("ERROR: solo se permiten numeros!!");
                }
            }
        }
        
        return new Cursada(id,idAlumno,idMateria,nota,asist,year);
    }
    
    // OTROS MÉTODOS
    static public boolean verifyChange(Object alumnEdit, String msg) {
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
}
