
package LogicaPersistencia;

import Logica.Responsable;
import Persistencia.DaoFactory;
import Persistencia.DaoSQL;
import Persistencia.IDaoResponsable;
import java.util.List;

public class LogicaResponsable {
    private DaoFactory fabrica = new DaoSQL(); 
    
    public void crearResponsable(Responsable m){
        IDaoResponsable<Responsable> d = fabrica.getResponsable();
        d.insertar(m);
    }       
    
    public Responsable buscarResponsable(int id){
        IDaoResponsable<Responsable> d = fabrica.getResponsable();
        Responsable r = d.buscar(id);
        return r;
    }
    
    public void actualizarResponsable(Responsable m){
        IDaoResponsable<Responsable> d = fabrica.getResponsable();
        d.actualizar(m);
    }
    
    public void eliminarResponsable(Responsable m){
        IDaoResponsable<Responsable> d = fabrica.getResponsable();
        d.eliminar(m);
    }
    
    public List<Responsable> getResponsables() {
        IDaoResponsable<Responsable> d = fabrica.getResponsable();
        return d.listado();
    }
    
    public List<Responsable> getResponsablePorNombre(String input) {
        IDaoResponsable<Responsable> d = fabrica.getResponsable();
        return d.listadoPorNombre(input);
    }
}
