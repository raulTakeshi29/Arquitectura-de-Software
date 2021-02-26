/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentador;

import InterfacesPresentador.IPBMaterial;
import InterfacesVistas.IBMaterial;
import Logica.Material;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sroma
 */
public class PBMaterial implements ActionListener, IPBMaterial{
    private IBMaterial vista;
    private Material material;
    private PComun p = new PComun(this);

    public PBMaterial(IBMaterial vista) {
        this.vista = vista;
        p.actionPerformed(new ActionEvent(this, 1, "Mostrar Materiales"));
    }
    
    @Override
    public void asignarMaterial(){
        if(vista.getItem()!=-1){
            material = p.buscarMaterial(vista.getItem());            
            vista.cerrar();
        } else{
            vista.mostrarMensaje("Seleccione un material");
        }
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
        if (evento.getActionCommand().equals(IBMaterial.aceptar)) {
            asignarMaterial();                     
        } else if (evento.getActionCommand().equals(IBMaterial.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBMaterial.cancelar)) {
            vista.cerrar();
        }
    } 
    
    @Override
    public void mostrar(String[][] matriz){
        vista.setSalida(matriz);
    }

    @Override
    public Material getMaterial() {
        return material;
    }    
}
