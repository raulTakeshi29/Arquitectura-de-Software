package InterfacesVistas;

import Presentador.PProyecto;

public interface IProyecto {
    void setPresentador(PProyecto p);
    void iniciar();
    String getnombre();
    String getencargado();
    String getetapa();
    String getBusqueda();
    int getItem();
    void setSalida(String[][] lista);
    void mostrarMensaje(String output);
    void mostrarEncargado(String id);
    void mostrarEtapa(String id);
    void habilitar();
    void restaurar();
    static final String nuevo = "Nuevo";
    static final String guardar = "Guardar";
    static final String cancelar = "Cancelar";
    static final String editar = "Editar";
    static final String eliminar = "Eliminar";
    static final String buscar = "Buscar";
    static final String buscarEncargado = "Buscar Encargado";
    static final String buscarEtapa = "Buscar Etapa";
}
