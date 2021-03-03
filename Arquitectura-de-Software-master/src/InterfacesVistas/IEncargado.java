package InterfacesVistas;

import Presentador.PEncargado;

public interface IEncargado {
    void setPresentador(PEncargado e);
    void iniciar();
    String getnombre();
    String getapellido();
    String getBusqueda();
    int getItem();
    void setSalida(String[][] lista);
    void mostrarMensaje(String output);
    void restaurar();
    static final String registrar = "Registrar";
    static final String cancelar = "Cancelar";
    static final String editar = "Editar";
    static final String eliminar = "Eliminar";
    static final String buscar = "Buscar";
}
