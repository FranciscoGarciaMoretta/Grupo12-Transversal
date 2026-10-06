
package Modelo;

public class Materia {
    int idMateria;
    String nombre;
    int estado;

    public Materia(int idMateria, String nombre, int estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + '}';
    }

  
    
    
}

