
package Logica;
public class Material {
    private int idMaterial;
    private String nombre;
    private String unidad;
    private String grupo;

    public Material() {
    }

    public Material(int idMaterial, String nombre, String unidad, String grupo) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.unidad = unidad;
        this.grupo = grupo;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    
    
    
}
