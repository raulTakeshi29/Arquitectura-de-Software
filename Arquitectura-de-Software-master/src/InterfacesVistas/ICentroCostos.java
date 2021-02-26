/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesVistas;

import Presentador.PCentroCostos;

/**
 *
 * @author Paolo
 */
public interface ICentroCostos {
    void setPresentador(PCentroCostos m);
    void iniciar();
    String getTipo();
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
