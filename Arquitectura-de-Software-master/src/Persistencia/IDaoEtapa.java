package Persistencia;

import java.util.List;

public interface IDaoEtapa<E> {
    void insertar(E obj);
    void actualizar(E obj);
    E buscar(int id);
    void eliminar(E obj);       
    List<E> listado();
    List<E> listadoPorNombre(String input);
}
