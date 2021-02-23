package Presentador;

import InterfacesPresentador.IPBEncargado;
import InterfacesVistas.IBEncargado;
import Logica.Encargado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PBEncargado implements ActionListener, IPBEncargado{
     private IBEncargado vista;
    private Encargado encargado;
    private PComun p = new PComun(this);

    public PBEncargado(IBEncargado vista) {
        this.vista = vista;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Encargados"));
    }
    
    @Override
    public void asignarEncargado(){
        if(vista.getItem()!=-1){
            encargado = p.buscarEncargado(vista.getItem());            
            vista.cerrar();
        } else{
            vista.mostrarMensaje("Seleccione un encargado");
        }
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
        if (evento.getActionCommand().equals(IBEncargado.aceptar)) {
            asignarEncargado();                     
        } else if (evento.getActionCommand().equals(IBEncargado.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBEncargado.cancelar)) {
            vista.cerrar();
        }
    } 
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }

    @Override
    public Encargado getEncargado() {
        return encargado;
    }    
}
