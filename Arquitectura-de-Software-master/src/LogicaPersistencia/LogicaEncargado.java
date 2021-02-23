package LogicaPersistencia;

import Logica.Encargado;
import Persistencia.DaoFactory;
import Persistencia.DaoSQL;
import Persistencia.IDaoEncargado;
import java.util.List;

public class LogicaEncargado {
    private DaoFactory fabrica = new DaoSQL(); 
    
    public void crearEncargado(Encargado e){
        IDaoEncargado<Encargado> d = fabrica.getEncargado();
        d.insertar(e);
    }       
    
    public Encargado buscarEncargado(int id){
        IDaoEncargado<Encargado> d = fabrica.getEncargado();
        Encargado p = d.buscar(id);
        return p;
    }
    
    public void actualizarEncargado(Encargado e){
        IDaoEncargado<Encargado> d = fabrica.getEncargado();
        d.actualizar(e);
    }
    
    public void eliminarEncargado(Encargado e){
        IDaoEncargado<Encargado> d = fabrica.getEncargado();
        d.eliminar(e);
    }
    
    public List<Encargado> getEncargados() {
        IDaoEncargado<Encargado> d = fabrica.getEncargado();
        return d.listado();
    }
    
    public List<Encargado> getEncargadoPorNombre(String input) {
        IDaoEncargado<Encargado> d = fabrica.getEncargado();
        return d.listadoPorNombre(input);
    }
}
