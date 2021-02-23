package Logica;
public class Proyecto {
    private int idProyecto;
    private String nombre;
    private Encargado encargado;
    private Etapa etapa;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombre, Encargado encargado, Etapa etapa) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.encargado = encargado;
        this.etapa = etapa;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }
    
    
}
