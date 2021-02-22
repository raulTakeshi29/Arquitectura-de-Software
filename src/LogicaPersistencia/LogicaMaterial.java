package LogicaPersistencia;

import Logica.Material;
import Persistencia.DaoFactory;
import Persistencia.DaoSQL;
import Persistencia.IDaoMaterial;
import java.util.List;

public class LogicaMaterial {
    private DaoFactory fabrica = new DaoSQL(); 
    public void crearMaterial(Material m,int id){
        IDaoMaterial<Material> d = fabrica.getMaterial();
        d.insertar(m,id);
    }       
    
    public Material buscarMaterial(int id){
        IDaoMaterial<Material> d = fabrica.getMaterial();
        Material p = d.buscar(id);
        return p;
    }
    
    public void actualizarMaterial(Material m,int id){
        IDaoMaterial<Material> d = fabrica.getMaterial();
        d.actualizar(m,id);
    }
    
    public void eliminarMaterial(Material m){
        IDaoMaterial<Material> d = fabrica.getMaterial();
        d.eliminar(m);
    }
    
    public List<Material> getMateriales() {
        IDaoMaterial<Material> d = fabrica.getMaterial();
        return d.listado();
    }
    
    public List<Material> getMaterialPorNombre(String input) {
        IDaoMaterial<Material> d = fabrica.getMaterial();
        return d.listadoPorNombre(input);
    }
}
