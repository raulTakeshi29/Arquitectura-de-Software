/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentador;

import InterfacesPresentador.IPGrupo;
import InterfacesVistas.IGrupo;
import Logica.Grupo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author TAKESHI
 */
public class PGrupo implements IPGrupo,ActionListener{
    private IGrupo vista;
    private Grupo grupo;
    private PComun p = new PComun(this);
    int opcboton = 1;

    public PGrupo(IGrupo vista, Grupo grupo) {
        this.vista = vista;
        this.grupo = grupo;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Grupos"));
    }
    
    @Override
    public void nuevo() {
        vista.habilitar();
        opcboton = 1;
    }

    @Override
    public void guardar() {
        String nombre= vista.getnombre();
        
        if(!nombre.equals("")){
            
            switch(opcboton){
                case 1:
                    p.crearGrupo(nombre);
                    vista.mostrarMensaje("Grupo creado");
                    vista.restaurar();
                    break;
                case 2:
                    if(vista.getItem()!=-1){
                        p.editarGrupo(vista.getItem(),nombre);
                        vista.mostrarMensaje("Grupo actualizado");
                        vista.restaurar();
                    } else{
                        vista.mostrarMensaje("Seleccione un grupo");
                    }
                    break;
            }
            
        } else{
            vista.mostrarMensaje("No deje el campo en blanco.");
        }    
    }

    @Override
    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }

    @Override
    public void editar() {
        vista.habilitar();
        opcboton = 2;
    }

    @Override
    public void eliminar() {
        if(vista.getItem()!=-1){
            p.eliminarGrupo(vista.getItem());
            vista.mostrarMensaje("Grupo eliminado");
            vista.restaurar();
        } else{
            vista.mostrarMensaje("Seleccione un grupo");
        }
    }
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }
    
    @Override
    public void buscar(){
        if(!vista.getBusqueda().equals("")){
            p.mostrarGruposPorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Grupos"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IGrupo.nuevo)) {
            nuevo();           
        } else if (evento.getActionCommand().equals(IGrupo.guardar)) {
            guardar();
        } else if (evento.getActionCommand().equals(IGrupo.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IGrupo.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IGrupo.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IGrupo.buscar)) {
            buscar();
        }
    }
    
      
}
