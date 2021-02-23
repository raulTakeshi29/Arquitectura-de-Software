
package Persistencia;

import java.util.List;

public interface IDaoResponsable<G> {
    void insertar(G obj);
    void actualizar(G obj);
    G buscar(int id);
    void eliminar(G obj);       
    List<G> listado();
    List<G> listadoPorNombre(String input);
}
