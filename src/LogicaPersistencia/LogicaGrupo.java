/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaPersistencia;

import Logica.Grupo;
import Persistencia.DaoFactory;
import Persistencia.DaoSQL;
import Persistencia.IDaoGrupo;
import java.util.List;

public class LogicaGrupo {
    private DaoFactory fabrica = new DaoSQL(); 
    
    public void crearGrupo(Grupo m){
        IDaoGrupo<Grupo> d = fabrica.getGrupo();
        d.insertar(m);
    }       
    
    public Grupo buscarGrupo(int id){
        IDaoGrupo<Grupo> d = fabrica.getGrupo();
        Grupo p = d.buscar(id);
        return p;
    }
    
    public void actualizarGrupo(Grupo m){
        IDaoGrupo<Grupo> d = fabrica.getGrupo();
        d.actualizar(m);
    }
    
    public void eliminarGrupo(Grupo m){
        IDaoGrupo<Grupo> d = fabrica.getGrupo();
        d.eliminar(m);
    }
    
    public List<Grupo> getGrupos() {
        IDaoGrupo<Grupo> d = fabrica.getGrupo();
        return d.listado();
    }
    
    public List<Grupo> getGrupoPorNombre(String input) {
        IDaoGrupo<Grupo> d = fabrica.getGrupo();
        return d.listadoPorNombre(input);
    }
}
