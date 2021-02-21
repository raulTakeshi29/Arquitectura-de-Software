package Presentador;

import InterfacesPresentador.IPBGrupo;
import InterfacesVistas.IBGrupo;
import Logica.Grupo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PBGrupo implements ActionListener,IPBGrupo{
    private IBGrupo vista;
    private Grupo grupo;
    private PComun p = new PComun(this);

    public PBGrupo(IBGrupo vista) {
        this.vista = vista;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Grupos"));
    }
    
    @Override
    public void asignarGrupo(){
        if(vista.getItem()!=-1){
            grupo = p.buscarGrupo(vista.getItem());            
            vista.cerrar();
        } else{
            vista.mostrarMensaje("Seleccione un grupo");
        }
    }  
    
    @Override
    public void buscar(){
        if(!vista.getBusqueda().equals("")){
            p.mostrarGruposPorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Grupo"));
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IBGrupo.aceptar)) {
            asignarGrupo();                     
        } else if (evento.getActionCommand().equals(IBGrupo.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBGrupo.cancelar)) {
            vista.cerrar();
        }
    } 
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }

    @Override
    public Grupo getGrupo() {
        return grupo;
    }        
}
