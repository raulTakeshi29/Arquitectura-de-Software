package Presentador;

import InterfacesPresentador.IPProyecto;
import InterfacesVistas.IBEncargado;
import InterfacesVistas.IBEtapa;
import InterfacesVistas.IMaterial;
import InterfacesVistas.IProyecto;
import Logica.Encargado;
import Logica.Etapa;
import Logica.Material;
import Logica.Proyecto;
import Vistas.VBEncargado;
import Vistas.VBEtapa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PProyecto implements ActionListener, IPProyecto{
     private IProyecto vista;
    private Proyecto proyecto;
    private Encargado enc;
    private Etapa et;
    private PComun p = new PComun(this);
    int opcboton = 1;

    public PProyecto(IProyecto vista, Proyecto proyecto) {
        this.vista = vista;
        this.proyecto = proyecto;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Proyectos"));
    }
    
    @Override
    public void nuevo() {
        vista.habilitar();
        opcboton = 1;
    }

    @Override
    public void guardar() {
        String nombre= vista.getnombre();
        String encargado= vista.getencargado();
        String etapa= vista.getetapa();
        
        if(!nombre.equals("")&&!encargado.equals("")&&!etapa.equals("")){
            int Encargado=Integer.parseInt(encargado);
            int Etapa=Integer.parseInt(etapa);
            switch(opcboton){
                case 1:
                    p.crearProyecto(nombre,Encargado,Etapa);
                    vista.mostrarMensaje("Proyecto creado");
                    vista.restaurar();
                    break;
                case 2:
                    if(vista.getItem()!=-1){
                        p.editarProyecto(vista.getItem(),nombre,Encargado,Etapa);
                        vista.mostrarMensaje("Proyecto actualizado");
                        vista.restaurar();
                    } else{
                        vista.mostrarMensaje("Seleccione un proyecto");
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
            p.eliminarProyecto(vista.getItem());
            vista.mostrarMensaje("Proyecto eliminado");
            vista.restaurar();
        } else{
            vista.mostrarMensaje("Seleccione un proyecto");
        }
    }
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
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
        if (evento.getActionCommand().equals(IProyecto.nuevo)) {
            nuevo();           
        } else if (evento.getActionCommand().equals(IProyecto.guardar)) {
            guardar();
        } else if (evento.getActionCommand().equals(IProyecto.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IProyecto.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IProyecto.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IProyecto.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IProyecto.buscarEncargado)){
            buscarEncargado();
        }
    }    

    @Override
    public void mostrarEncargado() {
        vista.mostrarEncargado(String.valueOf(enc.getIdEncargado()));
    }
    
    public void buscarEncargado(){
        IBEncargado ib = new VBEncargado(null,true);
        PBEncargado pg = new PBEncargado(ib);
        ib.setPresentador(pg);
        ib.iniciar();
        enc = pg.getEncargado();
        if(enc!=null){
            mostrarEncargado();
        }
    }
    
    @Override
    public void mostrarEtapa() {
        vista.mostrarEtapa(String.valueOf(et.getIdEtapa()));
    }
    
    public void buscarEtapa(){
        IBEtapa ib = new VBEtapa(null,true);
        PBEtapa pg = new PBEtapa(ib);
        ib.setPresentador(pg);
        ib.iniciar();
        et = pg.getEtapa();
        if(et!=null){
            mostrarEtapa();
        }
    }

}
