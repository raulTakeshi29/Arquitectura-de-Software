/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyecto;

import InterfacesVistas.IMaterial;
import Logica.Material;
import Presentador.PMaterial;
import Vistas.VMaterial;

/**
 *
 * @author sroma
 */
public class Miniproyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       IMaterial vista = new VMaterial();
       Material material=new Material();
       PMaterial p = new PMaterial(vista,material);
       vista.setPresentador(p);
       vista.iniciar();
        System.out.println("SANDY CTM ME LLEGAS A LA GANPI");
    }
    
}
