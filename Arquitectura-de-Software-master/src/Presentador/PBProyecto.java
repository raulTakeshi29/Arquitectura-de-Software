package Presentador;

import InterfacesPresentador.IPBProyecto;
import InterfacesVistas.IBProyecto;
import Logica.Proyecto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PBProyecto implements ActionListener,IPBProyecto {
    private IBProyecto vista;
    private Proyecto proyecto;
    private PComun p = new PComun(this);

    public PBProyecto(IBProyecto vista) {
        this.vista = vista;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Proyectos"));
    }
    
    @Override
    public void asignarProyecto(){
        if(vista.getItem()!=-1){
            proyecto = p.buscarProyecto(vista.getItem());            
            vista.cerrar();
        } else{
            vista.mostrarMensaje("Seleccione un proyecto");
        }
    }  
    
    @Override
    public void buscar(){
        if(!vista.getBusqueda().equals("")){
            p.mostrarProyectosPorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Proyectos"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IBProyecto.aceptar)) {
            asignarProyecto();                     
        } else if (evento.getActionCommand().equals(IBProyecto.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBProyecto.cancelar)) {
            vista.cerrar();
        }
    } 
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }

    @Override
    public Proyecto getProyecto() {
        return proyecto;
    }     
}
