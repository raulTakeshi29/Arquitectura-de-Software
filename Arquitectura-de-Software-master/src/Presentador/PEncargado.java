package Presentador;

import InterfacesPresentador.IPEncargado;
import InterfacesVistas.IEncargado;
import Logica.Encargado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PEncargado implements ActionListener, IPEncargado{
     private IEncargado vista;
    private Encargado encargado;
    private PComun p = new PComun(this);
    int opcboton = 1;

    public PEncargado(IEncargado vista, Encargado encargado) {
        this.vista = vista;
        this.encargado= encargado;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Encargados"));
    }
    
    @Override
    public void nuevo() {
        vista.habilitar();
        opcboton = 1;
    }

    @Override
    public void guardar() {
        String nombre= vista.getnombre();
        String apellido=vista.getapellido();
        if(!nombre.equals("")&&!apellido.equals("")){
            
            switch(opcboton){
                case 1:
                    p.crearEncargado(nombre,apellido);
                    vista.mostrarMensaje("Encargado creado");
                    vista.restaurar();
                    break;
                case 2:
                    if(vista.getItem()!=-1){
                        p.editarEncargado(vista.getItem(),nombre,apellido);
                        vista.mostrarMensaje("Encargado actualizado");
                        vista.restaurar();
                    } else{
                        vista.mostrarMensaje("Seleccione un encargado");
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
            p.eliminarEncargado(vista.getItem());
            vista.mostrarMensaje("Encargado eliminado");
            vista.restaurar();
        } else{
            vista.mostrarMensaje("Seleccione un encargado");
        }
    }
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }
    
    @Override
    public void buscar(){
        if(!vista.getBusqueda().equals("")){
            p.mostrarEncargadosPorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Encargados"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IEncargado.nuevo)) {
            nuevo();           
        } else if (evento.getActionCommand().equals(IEncargado.guardar)) {
            guardar();
        } else if (evento.getActionCommand().equals(IEncargado.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IEncargado.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IEncargado.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IEncargado.buscar)) {
            buscar();
        }
    }
}
