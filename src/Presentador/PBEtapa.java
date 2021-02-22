package Presentador;

import InterfacesPresentador.IPBEtapa;
import InterfacesVistas.IBEtapa;
import Logica.Etapa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PBEtapa implements ActionListener,IPBEtapa{
    private IBEtapa vista;
    private Etapa etapa;
    private PComun p = new PComun(this);

    public PBEtapa(IBEtapa vista) {
        this.vista = vista;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Etapas"));
    }
    
    @Override
    public void asignarEtapa(){
        if(vista.getItem()!=-1){
            etapa = p.buscarEtapa(vista.getItem());            
            vista.cerrar();
        } else{
            vista.mostrarMensaje("Seleccione un etapa");
        }
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
        if (evento.getActionCommand().equals(IBEtapa.aceptar)) {
            asignarEtapa();                     
        } else if (evento.getActionCommand().equals(IBEtapa.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBEtapa.cancelar)) {
            vista.cerrar();
        }
    } 
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }

    @Override
    public Etapa getEtapa() {
        return etapa;
    }    
}
