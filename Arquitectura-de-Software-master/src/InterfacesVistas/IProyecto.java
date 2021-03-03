package InterfacesVistas;

import Presentador.PProyecto;

public interface IProyecto {
    void setPresentador(PProyecto p);
    void iniciar();
    String getnombre();
    int getencargado();
    int getetapa();
    String getBusqueda();
    int getItem();
    void setSalida(String[][] lista);
    void mostrarMensaje(String output);
    void mostrarEncargado(int id);
    void mostrarEtapa(int id);
    void restaurar();
    static final String guardar = "Registrar";
    static final String cancelar = "Cancelar";
    static final String editar = "Editar";
    static final String eliminar = "Eliminar";
    static final String buscar = "Buscar";
    static final String buscarEncargado = "Buscar Encargado";
    static final String buscarEtapa = "Buscar Etapa";
}
