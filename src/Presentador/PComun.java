package Presentador;

import InterfacesPresentador.IPBGrupo;
import InterfacesPresentador.IPGrupo;
import InterfacesPresentador.IPMaterial;
import InterfacesPresentador.IPResponsable;
import Logica.Grupo;
import Logica.Material;
import Logica.Responsable;
import LogicaPersistencia.LogicaGrupo;
import LogicaPersistencia.LogicaMaterial;
import LogicaPersistencia.LogicaResponsable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PComun implements ActionListener {

    private IPMaterial pmaterial;
    private IPGrupo pgrupo;
    private IPBGrupo pbgrupo;
    private IPResponsable presponsable;
    private LogicaMaterial lm = new LogicaMaterial();
    private LogicaGrupo lg = new LogicaGrupo();
    private LogicaResponsable lr = new LogicaResponsable();

    public PComun(IPMaterial pmaterial) {
        this.pmaterial = pmaterial;
    }

    public PComun(IPGrupo pgrupo) {
        this.pgrupo = pgrupo;
    }
    public PComun(IPBGrupo pbgrupo){
         this.pbgrupo=pbgrupo;
     }
    public PComun(IPResponsable presponsable){
        this.presponsable=presponsable;
    }

    public void crearMaterial(String nombre, String unidad, int idgrupo) {
        Material m = new Material();
        m.setNombre(nombre);
        m.setUnidad(unidad);
        Grupo g = new Grupo();
        g.setIdGrupo(idgrupo);
        m.setGrupo(g);
        lm.crearMaterial(m);
        mostrarMateriales();
    }

    public void editarMaterial(int pos, String nombre, String unidad, int idgrupo) {
        Material m = buscarMaterial(pos);
        m.setNombre(nombre);
        m.setUnidad(unidad);
        Grupo g = new Grupo();
        g.setIdGrupo(idgrupo);
        m.setGrupo(g);
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
            matriz[i][3] = materiales.get(i).getGrupo().getNombre();
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
            matriz[i][3] = materiales.get(i).getGrupo().getNombre();
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
        mostrarGrupos();

    }

    public void editarGrupo(int pos, String nombre) {
        Grupo g = buscarGrupo(pos);
        g.setNombre(nombre);
        lg.actualizarGrupo(g);
        mostrarGrupos();

    }

    public void eliminarGrupo(int pos) {
        Grupo g = buscarGrupo(pos);
        lg.eliminarGrupo(g);
        mostrarGrupos();
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
    
    public void crearResponsable(String nombre, String apellido){
        Responsable r = new Responsable();
        r.setNombre(nombre);
        r.setApellido(apellido);
        lr.crearResponsable(r);
        mostrarResponsables();
    }
    
    public void editarResponsable(int pos, String nombre, String apellido){
        Responsable r= buscarResponsable(pos);
        r.setNombre(nombre);
        r.setApellido(apellido);
        lr.actualizarResponsable(r);
        mostrarResponsables();
    }
    public void eliminarResponsable(int pos){
        Responsable r = buscarResponsable(pos);
        lr.eliminarResponsable(r);
        mostrarResponsables();
    }
    
    public Responsable buscarResponsable(int id) {
        Responsable r = lr.buscarResponsable(id);
        return r;
    }
    
    public void mostrarResponsables() {
        List<Responsable> responsables = lr.getResponsables();
        String[][] matriz = new String[responsables.size()][3];
        for (int i = 0; i < responsables.size(); i++) {
            matriz[i][0] = String.valueOf(responsables.get(i).getId());
            matriz[i][1] = responsables.get(i).getNombre();
            matriz[i][2] = responsables.get(i).getApellido();
        }
        if (presponsable != null) {
            presponsable.mostrar(matriz);
        }
        //else if(pbproducto!=null){
        //pbproducto.mostrar(matriz);
        //}
    }
    public void mostrarResponsablePorNombre(String input){
        List<Responsable> responsables = lr.getResponsablePorNombre(input);
        String[][] matriz = new String[responsables.size()][3];
        for (int i = 0; i < responsables.size(); i++) {
            matriz[i][0] = String.valueOf(responsables.get(i).getId());
            matriz[i][1] = responsables.get(i).getNombre();
            matriz[i][2] = responsables.get(i).getApellido();
        }
        if (presponsable != null) {
            presponsable.mostrar(matriz);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Mostrar Materiales")) {
            mostrarMateriales();
        } else if (evento.getActionCommand().equals("Mostrar Grupos")) {
            mostrarGrupos();
        } else if (evento.getActionCommand().equals("Mostrar Responsables")){
            mostrarResponsables();
        }
    }

}
