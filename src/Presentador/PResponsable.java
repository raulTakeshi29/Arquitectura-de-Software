/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentador;

import InterfacesPresentador.IPResponsable;
import InterfacesVistas.IResponsable;
import Logica.Responsable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author TAKESHI
 */
public class PResponsable implements IPResponsable,ActionListener{
    
    private IResponsable vista;
    private Responsable responsable;
    private PComun p = new PComun(this);
    int opcboton = 1;

    public PResponsable(IResponsable vista, Responsable responsable) {
        this.vista = vista;
        this.responsable = responsable;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Responsables"));
    }

    @Override
    public void nuevo() {
        vista.habilitar();
        opcboton = 1;
    }

    @Override
    public void guardar() {
        String nombre= vista.getnombre();
        String apellido = vista.getApellido();
        
        if(!nombre.equals("")&& !apellido.equals("")){
            
            switch(opcboton){
                case 1:
                    p.crearResponsable(nombre,apellido);
                    vista.mostrarMensaje("Usuario Responsable creado");
                    vista.restaurar();
                    break;
                case 2:
                    if(vista.getItem()!=-1){
                        p.editarResponsable(vista.getItem(),nombre,apellido);
                        vista.mostrarMensaje("Usuario Responsable actualizado");
                        vista.restaurar();
                    } else{
                        vista.mostrarMensaje("Seleccione un Usuario Responsable");
                    }
                    break;
            }
        }else{
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
            p.eliminarResponsable(vista.getItem());
            vista.mostrarMensaje("Usuario Responsable eliminado");
            vista.restaurar();
        } else{
            vista.mostrarMensaje("Seleccione un Responsable");
        }
    }

    @Override
    public void mostrar(String[][] matriz) {
        vista.setSalida(matriz);
    }

    @Override
    public void buscar() {
        if(!vista.getBusqueda().equals("")){
            p.mostrarResponsablePorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Responsables"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IResponsable.nuevo)) {
            nuevo();           
        } else if (evento.getActionCommand().equals(IResponsable.guardar)) {
            guardar();
        } else if (evento.getActionCommand().equals(IResponsable.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IResponsable.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IResponsable.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IResponsable.buscar)) {
            buscar();
        }
    }
    
}
