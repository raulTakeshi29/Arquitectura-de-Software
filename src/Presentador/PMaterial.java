package Presentador;

import InterfacesPresentador.IPMaterial;
import InterfacesVistas.IBGrupo;
import InterfacesVistas.IMaterial;
import Logica.Grupo;
import Logica.Material;
import Vistas.VBGrupo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PMaterial implements ActionListener, IPMaterial{
    private IMaterial vista;
    private Material material;
    private Grupo g;
    private PComun p = new PComun(this);
    int opcboton = 1;

    public PMaterial(IMaterial vista, Material material) {
        this.vista = vista;
        this.material = material;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Materiales"));
    }
    
    @Override
    public void nuevo() {
        vista.habilitar();
        opcboton = 1;
    }

    @Override
    public void guardar() {
        String nombre= vista.getnombre();
        String unidad= vista.getunidad();
        String grupo= vista.getgrupo();
        
        if(!nombre.equals("")&&!unidad.equals("")&&!grupo.equals("")){
            int Grupo=Integer.parseInt(grupo);
            switch(opcboton){
                case 1:
                    p.crearMaterial(nombre,unidad,Grupo);
                    vista.mostrarMensaje("Material creado");
                    vista.restaurar();
                    break;
                case 2:
                    if(vista.getItem()!=-1){
                        p.editarMaterial(vista.getItem(),nombre,unidad,Grupo);
                        vista.mostrarMensaje("Material actualizado");
                        vista.restaurar();
                    } else{
                        vista.mostrarMensaje("Seleccione un material");
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
            p.eliminarMaterial(vista.getItem());
            vista.mostrarMensaje("Material eliminado");
            vista.restaurar();
        } else{
            vista.mostrarMensaje("Seleccione un material");
        }
    }
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }
    
    @Override
    public void buscar(){
        if(!vista.getBusqueda().equals("")){
            p.mostrarMaterialesPorNombre(vista.getBusqueda());
        } else{
            p.actionPerformed(new ActionEvent(this, 1, "Mostrar Materiales"));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IMaterial.nuevo)) {
            nuevo();           
        } else if (evento.getActionCommand().equals(IMaterial.guardar)) {
            guardar();
        } else if (evento.getActionCommand().equals(IMaterial.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IMaterial.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IMaterial.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IMaterial.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IMaterial.buscarGrupo)){
            buscarGrupo();
        }
    }    

    @Override
    public void mostrarGrupo() {
        vista.mostrarGrupo(String.valueOf(g.getIdGrupo()));
    }
    public void buscarGrupo(){
        IBGrupo ib = new VBGrupo(null,true);
        PBGrupo pg = new PBGrupo(ib);
        ib.setPresentador(pg);
        ib.iniciar();
        g = pg.getGrupo();
        if(g!=null){
            mostrarGrupo();
        }
    }
}
