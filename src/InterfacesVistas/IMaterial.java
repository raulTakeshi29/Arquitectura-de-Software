package InterfacesVistas;

import Presentador.PMaterial;

public interface IMaterial {
    void setPresentador(PMaterial m);
    void iniciar();
    String getnombre();
    String getunidad();
    String getgrupo();
    String getBusqueda();
    int getItem();
    void setSalida(String[][] lista);
    void mostrarMensaje(String output);
    void habilitar();
    void restaurar();
    static final String nuevo = "Nuevo";
    static final String guardar = "Guardar";
    static final String cancelar = "Cancelar";
    static final String editar = "Editar";
    static final String eliminar = "Eliminar";
    static final String buscar = "Buscar";
}
