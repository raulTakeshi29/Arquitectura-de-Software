/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesVistas;

import Presentador.PBMaterial;

/**
 *
 * @author sroma
 */
public interface IBMaterial {
    void setPresentador(PBMaterial p);
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
