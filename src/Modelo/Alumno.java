package Modelo;
import java.time.LocalDate;
import java.util.Date;

public class Alumno {
    int idAlumno;
    int dni;
    String nombre;
    LocalDate fecNac;
    boolean activo;

    public Alumno(int idAlumno, int dni, String nombre, LocalDate fecNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return nombre + " " + dni;
    }
}
