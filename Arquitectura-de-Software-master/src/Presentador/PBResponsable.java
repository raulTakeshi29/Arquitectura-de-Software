
package Presentador;

import InterfacesPresentador.IPBResponsable;
import InterfacesVistas.IBResponsable;
import Logica.Etapa;
import Logica.Responsable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PBResponsable implements ActionListener,IPBResponsable{
    private IBResponsable vista;
    private Responsable responsable;
    private PComun p = new PComun(this);

    public PBResponsable(IBResponsable vista) {
        this.vista = vista;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Responsables"));
    }
    
    @Override
    public void asignarResponsable(){
        if(vista.getItem()!=-1){
            responsable = p.buscarResponsable(vista.getItem());            
            vista.cerrar();
        } else{
            vista.mostrarMensaje("Seleccione un responsable");
        }
    }  
    
    @Override
    public void buscar(){
        if(!vista.getBusqueda().equals("")){
            p.mostrarResponsablePorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Responsables"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IBResponsable.aceptar)) {
            asignarResponsable();                     
        } else if (evento.getActionCommand().equals(IBResponsable.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBResponsable.cancelar)) {
            vista.cerrar();
        }
    } 
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }

    @Override
    public Responsable getResponsable() {
        return responsable;
    }     
}
