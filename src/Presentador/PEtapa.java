package Presentador;

import InterfacesPresentador.IPEtapa;
import InterfacesVistas.IEtapa;
import Logica.Etapa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PEtapa implements ActionListener, IPEtapa{
    private IEtapa vista;
    private Etapa etapa;
    private PComun p = new PComun(this);
    int opcboton = 1;

    public PEtapa(IEtapa vista, Etapa etapa) {
        this.vista = vista;
        this.etapa= etapa;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Etapas"));
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
                    p.crearEtapa(nombre);
                    vista.mostrarMensaje("Etapa creado");
                    vista.restaurar();
                    break;
                case 2:
                    if(vista.getItem()!=-1){
                        p.editarEtapa(vista.getItem(),nombre);
                        vista.mostrarMensaje("Etapa actualizado");
                        vista.restaurar();
                    } else{
                        vista.mostrarMensaje("Seleccione un etapa");
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
            p.eliminarEtapa(vista.getItem());
            vista.mostrarMensaje("Etapa eliminado");
            vista.restaurar();
        } else{
            vista.mostrarMensaje("Seleccione un etapa");
        }
    }
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }
    
    @Override
    public void buscar(){
        if(!vista.getBusqueda().equals("")){
            p.mostrarEtapasPorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Etapas"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IEtapa.nuevo)) {
            nuevo();           
        } else if (evento.getActionCommand().equals(IEtapa.guardar)) {
            guardar();
        } else if (evento.getActionCommand().equals(IEtapa.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IEtapa.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IEtapa.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IEtapa.buscar)) {
            buscar();
        }
    }
    
}
