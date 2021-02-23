package InterfacesVistas;

import Presentador.PBEtapa;

public interface IBEtapa {
    void setPresentador(PBEtapa p);
    void iniciar();
    String getBusqueda();
    int getItem();
    void setSalida(String[][] lista);
    void mostrarMensaje(String output);   
    void cerrar();
    static final String cancelar = "Cancelar";
    static final String aceptar = "Aceptar";
    static final String buscar = "Buscar";
}
