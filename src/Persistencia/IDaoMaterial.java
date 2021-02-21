package Persistencia;

import java.util.List;

public interface IDaoMaterial<M> {
    void insertar(M obj);
    void actualizar(M obj);
    M buscar(int id);
    void eliminar(M obj);       
    List<M> listado();
    List<M> listadoPorNombre(String input);
    
}
