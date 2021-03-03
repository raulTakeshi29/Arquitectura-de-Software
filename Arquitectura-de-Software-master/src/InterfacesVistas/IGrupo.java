
package InterfacesVistas;

import Presentador.PGrupo;

public interface IGrupo {
    void setPresentador(PGrupo m);
    void iniciar();
    String getnombre();
    String getBusqueda();
    int getItem();
    void setSalida(String[][] lista);
    void mostrarMensaje(String output);
    void restaurar();
    static final String guardar = "Registrar";
    static final String cancelar = "Cancelar";
    static final String editar = "Editar";
    static final String eliminar = "Eliminar";
    static final String buscar = "Buscar";
}
