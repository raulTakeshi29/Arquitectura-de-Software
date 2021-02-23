package Persistencia;

import java.util.List;

public interface IDaoProyecto<P> {
    void insertar(P obj);
    void actualizar(P obj);
    P buscar(int id);
    void eliminar(P obj);       
    List<P> listado();
    List<P> listadoPorNombre(String input);
    
}
