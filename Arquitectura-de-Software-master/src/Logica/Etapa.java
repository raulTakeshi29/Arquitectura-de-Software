
package Logica;
public class Etapa {
    private int idEtapa;
    private String nombre;

    public Etapa() {
    }

    public Etapa(int idEtapa, String nombre) {
        this.idEtapa = idEtapa;
        this.nombre = nombre;
    }

    public int getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(int idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
