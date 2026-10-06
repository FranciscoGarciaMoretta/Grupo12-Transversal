
package Modelo;

public class Cursada {
    int idCursada;
    Alumno idAlumno;
    Materia idMateria;
    float nota;
    float asist;
    int cursa;

    public Cursada(int idCursada, Alumno idAlumno, Materia idMateria, float nota, float asist, int cursa) {
        this.idCursada = idCursada;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
        this.asist = asist;
        this.cursa = cursa;
    }

    
    
    
    
    
    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getAsist() {
        return asist;
    }

    public void setAsist(float asist) {
        this.asist = asist;
    }

    public int getCursa() {
        return cursa;
    }

    public void setCursa(int cursa) {
        this.cursa = cursa;
    }

    @Override
    public String toString() {
        return "Cursada{" + "idCursada=" + idCursada + ", idAlumno=" + idAlumno + ", idMateria=" + idMateria + '}';
    }
    
    
    
    
    
    
}
