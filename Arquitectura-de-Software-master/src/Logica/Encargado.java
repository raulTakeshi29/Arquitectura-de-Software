
package Logica;
public class Encargado {
    public int idEncargado;
    public String nombre;
    public String apellido;

    public Encargado() {
    }

    public Encargado(int idEncargado, String nombre, String apellido) {
        this.idEncargado = idEncargado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
