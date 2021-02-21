package Presentador;

import InterfacesPresentador.IPMaterial;
import Logica.Material;
import LogicaPersistencia.LogicaMaterial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PComun implements ActionListener {
    private IPMaterial pmaterial;
    private LogicaMaterial lm = new LogicaMaterial();
    
     public PComun(IPMaterial pmaterial){
        this.pmaterial = pmaterial;
    }
     
      public void crearMaterial(String nombre,String unidad,int idgrupo){
        Material m = new Material();
        m.setNombre(nombre);
        m.setUnidad(unidad);
        m.setIdgrupo(idgrupo);
        lm.crearMaterial(m);
        mostrarMateriales();
    }
    
    public void editarMaterial(int pos,String nombre,String unidad,int idgrupo){
        Material m = buscarMaterial(pos);
        m.setNombre(nombre);
        m.setUnidad(unidad);
        m.setIdgrupo(idgrupo);
        lm.actualizarMaterial(m);
        mostrarMateriales();
    }
    
    public void eliminarMaterial(int pos){
        Material m = buscarMaterial(pos);
        lm.eliminarMaterial(m);
        mostrarMateriales();
    }
    
    public Material buscarMaterial(int id){
        Material p = lm.buscarMaterial(id);
        return p;
    }
    
    public void mostrarMateriales(){
        List<Material> materiales = lm.getMateriales();
        String[][] matriz =new String[materiales.size()][4];
        for (int i=0;i<materiales.size();i++) {
            matriz[i][0]=String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1]=materiales.get(i).getNombre();   
            matriz[i][2]=materiales.get(i).getUnidad();   
            matriz[i][3]=String.valueOf(materiales.get(i).getIdgrupo());
        }
        if(pmaterial!=null){
            pmaterial.mostrar(matriz);
        } 
        //else if(pbproducto!=null){
          //pbproducto.mostrar(matriz);
        //}
    }
    
    public void mostrarMaterialesPorNombre(String input){
        List<Material> materiales = lm.getMaterialPorNombre(input);
        String[][] matriz =new String[materiales.size()][4];
        for (int i=0;i<materiales.size();i++) {
            matriz[i][0]=String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1]=materiales.get(i).getNombre();   
            matriz[i][2]=materiales.get(i).getUnidad();   
            matriz[i][3]=String.valueOf(materiales.get(i).getIdgrupo());
        }
        if(pmaterial!=null){
            pmaterial.mostrar(matriz);
        } 
        //else{
          //pbproducto.mostrar(matriz);
        //}       
    }
    
     @Override
     public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Mostrar Materiales")) {
            mostrarMateriales();
        } 
}
}
