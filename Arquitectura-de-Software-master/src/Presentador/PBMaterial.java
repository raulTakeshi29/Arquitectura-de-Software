/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentador;
import InterfacesVistas.IBMaterial;
import Logica.Material;
import Persistencia.DaoMaterial;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author sroma
 */
public class PBMaterial implements ActionListener {
    private IBMaterial vista;
    private Material material;
    IDao dao = new DaoMaterial();

    public PBMaterial(IBMaterial vista) {
        this.vista = vista;
    }
    
    public void asignarMaterial(){
            material = (Material) dao.buscar(vista.getItem());            
            vista.cerrar();
    }  
    
    public void mostrar() {
        List<Material> materiales = dao.listado();
        String[][] matriz = new String[materiales.size()][4];
        for (int i = 0; i < materiales.size(); i++) {
            matriz[i][0] = String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1] = materiales.get(i).getNombre();
            matriz[i][2] = materiales.get(i).getUnidad();
            matriz[i][3] = materiales.get(i).getGrupo().getNombre();
        }
        vista.setSalida(matriz);
    }

    public void buscar() {
        List<Material> materiales = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[materiales.size()][4];
        for (int i = 0; i < materiales.size(); i++) {
            matriz[i][0] = String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1] = materiales.get(i).getNombre();
            matriz[i][2] = materiales.get(i).getUnidad();
            matriz[i][3] = materiales.get(i).getGrupo().getNombre();
        }
        vista.setSalida(matriz);
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
    
    public Material getMaterial() {
        return material;
    }    
}
