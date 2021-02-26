package InterfacesVistas;

import Presentador.PBResponsable;

public interface IBResponsable {
    void setPresentador(PBResponsable p);
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
