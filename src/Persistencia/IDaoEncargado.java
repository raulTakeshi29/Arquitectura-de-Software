package Persistencia;

import java.util.List;

public interface IDaoEncargado<En> {
   void insertar(En obj);
    void actualizar(En obj);
    En buscar(int id);
    void eliminar(En obj);       
    List<En> listado();
    List<En> listadoPorNombre(String input); 
}
