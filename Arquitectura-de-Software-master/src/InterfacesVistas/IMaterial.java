package InterfacesVistas;

import Presentador.PMaterial;

public interface IMaterial {
    void setPresentador(PMaterial m);
    void iniciar();
    String getnombre();
    String getunidad();
    int getgrupo();
    String getBusqueda();
    int getItem();
    void setSalida(String[][] lista);
    void mostrarMensaje(String output);
    void mostrarGrupo(int id);
    void restaurar();
    static final String guardar = "Registrar";
    static final String cancelar = "Cancelar";
    static final String editar = "Editar";
    static final String eliminar = "Eliminar";
    static final String buscar = "Buscar";
    static final String buscarGrupo = "Buscar Grupo";
}
