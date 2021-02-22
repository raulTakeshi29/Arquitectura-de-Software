package Persistencia;

import java.util.List;

public interface IDaoMaterial<M> {
    void insertar(M obj,int id);
    void actualizar(M obj,int id);
    M buscar(int id);
    void eliminar(M obj);       
    List<M> listado();
    List<M> listadoPorNombre(String input);
   
    
}
