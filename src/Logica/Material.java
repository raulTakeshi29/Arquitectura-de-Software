
package Logica;
public class Material {
    private int idMaterial;
    private String nombre;
    private String unidad;
    private int idgrupo;

    public Material() {
    }

    public Material(int idMaterial, String nombre, String unidad, int idgrupo) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.unidad = unidad;
        this.idgrupo = idgrupo;
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

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    
    
    
}
