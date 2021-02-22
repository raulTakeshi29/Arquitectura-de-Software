package LogicaPersistencia;

import Logica.Etapa;
import Persistencia.DaoFactory;
import Persistencia.DaoSQL;
import Persistencia.IDaoEtapa;
import java.util.List;

public class LogicaEtapa {
     private DaoFactory fabrica = new DaoSQL(); 
    
    public void crearEtapa(Etapa e){
        IDaoEtapa<Etapa> d = fabrica.getEtapa();
        d.insertar(e);
    }       
    
    public Etapa buscarEtapa(int id){
        IDaoEtapa<Etapa> d = fabrica.getEtapa();
        Etapa p = d.buscar(id);
        return p;
    }
    
    public void actualizarEtapa(Etapa e){
        IDaoEtapa<Etapa> d = fabrica.getEtapa();
        d.actualizar(e);
    }
    
    public void eliminarEtapa(Etapa e){
        IDaoEtapa<Etapa> d = fabrica.getEtapa();
        d.eliminar(e);
    }
    
    public List<Etapa> getEtapas() {
        IDaoEtapa<Etapa> d = fabrica.getEtapa();
        return d.listado();
    }
    
    public List<Etapa> getEtapaPorNombre(String input) {
        IDaoEtapa<Etapa> d = fabrica.getEtapa();
        return d.listadoPorNombre(input);
    }
}
