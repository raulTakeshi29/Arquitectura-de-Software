
package Presentador;

import InterfacesPresentador.IPCentroCostos;
import InterfacesVistas.ICentroCostos;
import Logica.CentroCostos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCentroCostos implements IPCentroCostos,ActionListener {
    private ICentroCostos vista;
    private  CentroCostos centroCostos;
    private PComun p = new PComun(this);
    int opcboton = 1;
    public PCentroCostos(ICentroCostos vista,CentroCostos centroCostos) {
        this.vista = vista;
        this.centroCostos = centroCostos;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Centro de costos"));
    }

    @Override
    public void nuevo() {
        vista.habilitar();
        opcboton = 1;
      
    }

    @Override
    public void guardar() {
        String tipo= vista.getTipo();
       
        
        if(!tipo.equals("")){
            
            switch(opcboton){
                case 1:
                    p.crearCentroCostos(tipo);
                    vista.mostrarMensaje("Usuario centro creado");
                    vista.restaurar();
                    break;
                case 2:
                    if(vista.getItem()!=-1){
                        p.editarCentroCostos(vista.getItem(),tipo);
                        vista.mostrarMensaje("Centro de costo actualizado");
                        vista.restaurar();
                    } else{
                        vista.mostrarMensaje("Seleccione un Centro de costo");
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
            p.eliminarCentroCostos(vista.getItem());
            vista.mostrarMensaje("Centro de costo eliminado");
            vista.restaurar();
        } else{
            vista.mostrarMensaje("Seleccione un centro de costo");
        }    }

    @Override
    public void mostrar(String[][] matriz) {
        vista.setSalida(matriz);
    }

    @Override
    public void buscar() {
         if(!vista.getBusqueda().equals("")){
            p.mostrarCentroCostoTipo(vista.getBusqueda());
        } else{ 
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar centros de costos"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
       if (evento.getActionCommand().equals(ICentroCostos.nuevo)) {
            nuevo();           
        } else if (evento.getActionCommand().equals(ICentroCostos.guardar)) {
            guardar();
        } else if (evento.getActionCommand().equals(ICentroCostos.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(ICentroCostos.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(ICentroCostos.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(ICentroCostos.buscar)) {
            buscar();
        }
    } 
    }
    
