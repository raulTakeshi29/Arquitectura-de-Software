
package LogicaPersistencia;

import Persistencia.DaoSQL;
import Persistencia.DaoFactory;
import Persistencia.DaoSQL;
import java.util.List;
import Persistencia.IDaoCentroCostos;
import Logica.CentroCostos;

public class LogicaCentroCostos {
        private DaoFactory fabrica = new DaoSQL(); 
    
    public void crearCentroCostos(CentroCostos m){
        IDaoCentroCostos<CentroCostos> d = fabrica.getCentroCostos();
        d.insertar(m);
    }       
    
    public CentroCostos buscarCentroCostos(int id){
        IDaoCentroCostos<CentroCostos> d = fabrica.getCentroCostos();
        CentroCostos r = d.buscar(id);
        return r;
    }
    
    public void actualizarCentroCostros(CentroCostos m){
        IDaoCentroCostos<CentroCostos> d = fabrica.getCentroCostos();
        d.actualizar(m);
    }
    
    public void eliminarCentroCostos(CentroCostos m){
        IDaoCentroCostos<CentroCostos> d = fabrica.getCentroCostos();
        d.eliminar(m);
    }
    
    public List<CentroCostos> getCentroCostos() {
        IDaoCentroCostos< CentroCostos> d = fabrica.getCentroCostos();
        return d.listado();
    }
    
    public List<CentroCostos> getCentroCostosTipo(String input) {
        IDaoCentroCostos<CentroCostos> d = fabrica.getCentroCostos();
        return d.listadoTipo(input);
    }
}
