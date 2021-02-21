package Presentador;

import InterfacesPresentador.IPBGrupo;
import InterfacesPresentador.IPGrupo;
import InterfacesPresentador.IPMaterial;
import Logica.Grupo;
import Logica.Material;
import LogicaPersistencia.LogicaGrupo;
import LogicaPersistencia.LogicaMaterial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PComun implements ActionListener {

    private IPMaterial pmaterial;
    private IPGrupo pgrupo;
    private IPBGrupo pbgrupo;
    private LogicaMaterial lm = new LogicaMaterial();
    private LogicaGrupo lg = new LogicaGrupo();

    public PComun(IPMaterial pmaterial) {
        this.pmaterial = pmaterial;
    }

    public PComun(IPGrupo pgrupo) {
        this.pgrupo = pgrupo;
    }
    public PComun(IPBGrupo pbgrupo){
         this.pbgrupo=pbgrupo;
     }

    public void crearMaterial(String nombre, String unidad, int idgrupo) {
        Material m = new Material();
        m.setNombre(nombre);
        m.setUnidad(unidad);
        m.setIdgrupo(idgrupo);
        lm.crearMaterial(m);
        mostrarMateriales();
    }

    public void editarMaterial(int pos, String nombre, String unidad, int idgrupo) {
        Material m = buscarMaterial(pos);
        m.setNombre(nombre);
        m.setUnidad(unidad);
        m.setIdgrupo(idgrupo);
        lm.actualizarMaterial(m);
        mostrarMateriales();
    }

    public void eliminarMaterial(int pos) {
        Material m = buscarMaterial(pos);
        lm.eliminarMaterial(m);
        mostrarMateriales();
    }

    public Material buscarMaterial(int id) {
        Material p = lm.buscarMaterial(id);
        return p;
    }

    public void mostrarMateriales() {
        List<Material> materiales = lm.getMateriales();
        String[][] matriz = new String[materiales.size()][4];
        for (int i = 0; i < materiales.size(); i++) {
            matriz[i][0] = String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1] = materiales.get(i).getNombre();
            matriz[i][2] = materiales.get(i).getUnidad();
            matriz[i][3] = String.valueOf(materiales.get(i).getIdgrupo());
        }
        if (pmaterial != null) {
            pmaterial.mostrar(matriz);
        }
        //else if(pbproducto!=null){
        //pbproducto.mostrar(matriz);
        //}
    }

    public void mostrarMaterialesPorNombre(String input) {
        List<Material> materiales = lm.getMaterialPorNombre(input);
        String[][] matriz = new String[materiales.size()][4];
        for (int i = 0; i < materiales.size(); i++) {
            matriz[i][0] = String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1] = materiales.get(i).getNombre();
            matriz[i][2] = materiales.get(i).getUnidad();
            matriz[i][3] = String.valueOf(materiales.get(i).getIdgrupo());
        }
        if (pmaterial != null) {
            pmaterial.mostrar(matriz);
        }
        //else{
        //pbproducto.mostrar(matriz);
        //}       
    }

    public void crearGrupo(String nombre) {
        Grupo g = new Grupo();
        g.setNombre(nombre);
        lg.crearGrupo(g);

    }

    public void editarGrupo(int pos, String nombre) {
        Grupo g = buscarGrupo(pos);
        g.setNombre(nombre);
        lg.actualizarGrupo(g);

    }

    public void eliminarGrupo(int pos) {
        Grupo g = buscarGrupo(pos);
        lg.eliminarGrupo(g);
    }

    public void mostrarGrupos() {
        List<Grupo> grupos = lg.getGrupos();
        String[][] matriz = new String[grupos.size()][2];

        for (int i = 0; i < grupos.size(); i++) {
            matriz[i][0] = String.valueOf(grupos.get(i).getIdGrupo());
            matriz[i][1] = grupos.get(i).getNombre();
        }
        if (pgrupo != null) {
            pgrupo.mostrar(matriz);
        } else{
            pbgrupo.mostrar(matriz);
        }  

    }
    
    public void mostrarGruposPorNombre(String input){
         List<Grupo> grupos = lg.getGrupoPorNombre(input);
        String[][] matriz = new String[grupos.size()][2];

        for (int i = 0; i < grupos.size(); i++) {
            matriz[i][0] = String.valueOf(grupos.get(i).getIdGrupo());
            matriz[i][1] = grupos.get(i).getNombre();
        }
        if (pgrupo != null) {
            pgrupo.mostrar(matriz);
        }else{
            pbgrupo.mostrar(matriz);
        }
    }

    public Grupo buscarGrupo(int pos) {
        Grupo g = lg.buscarGrupo(pos);
        return g;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Mostrar Materiales")) {
            mostrarMateriales();
        } else if (evento.getActionCommand().equals("Mostrar Grupos")) {
            mostrarGrupos();
        }
    }

}
