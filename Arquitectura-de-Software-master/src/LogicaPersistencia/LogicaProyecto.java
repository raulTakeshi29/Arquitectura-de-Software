package LogicaPersistencia;

import Logica.Proyecto;
import Persistencia.DaoFactory;
import Persistencia.DaoSQL;
import Persistencia.IDaoProyecto;
import java.util.List;

public class LogicaProyecto {
    private DaoFactory fabrica = new DaoSQL(); 
    public void crearProyecto(Proyecto p){
        IDaoProyecto<Proyecto> d = fabrica.getProyecto();
        d.insertar(p);
    }       
    
    public Proyecto buscarProyecto(int id){
        IDaoProyecto<Proyecto> d = fabrica.getProyecto();
        Proyecto p = d.buscar(id);
        return p;
    }
    
    public void actualizarProyecto(Proyecto p){
        IDaoProyecto<Proyecto> d = fabrica.getProyecto();
        d.actualizar(p);
    }
    
    public void eliminarProyecto(Proyecto p){
        IDaoProyecto<Proyecto> d = fabrica.getProyecto();
        d.eliminar(p);
    }
    
    public List<Proyecto> getProyectos() {
        IDaoProyecto<Proyecto> d = fabrica.getProyecto();
        return d.listado();
    }
    
    public List<Proyecto> getProyectoPorNombre(String input) {
        IDaoProyecto<Proyecto> d = fabrica.getProyecto();
        return d.listadoPorNombre(input);
    }
}
