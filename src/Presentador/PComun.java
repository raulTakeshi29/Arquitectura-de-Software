package Presentador;

import InterfacesPresentador.*;
import Logica.*;
import LogicaPersistencia.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PComun implements ActionListener {

    private IPMaterial pmaterial;
    private IPGrupo pgrupo;
    private IPEtapa petapa;
    private IPBGrupo pbgrupo;
    private IPBMaterial pbmaterial;
    private IPBEtapa pbetapa;
    private LogicaMaterial lm = new LogicaMaterial();
    private LogicaGrupo lg = new LogicaGrupo();
    private LogicaEtapa le=new LogicaEtapa();

    public PComun(IPMaterial pmaterial) {
        this.pmaterial = pmaterial;
    }
    public PComun(IPGrupo pgrupo) {
        this.pgrupo = pgrupo;
    }
    public PComun(IPEtapa petapa){
        this.petapa=petapa;
    }
    public PComun(IPBGrupo pbgrupo){
         this.pbgrupo=pbgrupo;
    }
    public PComun(IPBMaterial pbmaterial){
        this.pbmaterial=pbmaterial;
    }
    public PComun(IPBEtapa pbetapa){
        this.pbetapa=pbetapa;
    }

    public void crearMaterial(String nombre, String unidad, int idgrupo) {
        Material m = new Material();
        m.setNombre(nombre);
        m.setUnidad(unidad);
        lm.crearMaterial(m,idgrupo);
        mostrarMateriales();
    }

    public void editarMaterial(int pos, String nombre, String unidad, int idgrupo) {
        Material m = buscarMaterial(pos);
        m.setNombre(nombre);
        m.setUnidad(unidad);
        lm.actualizarMaterial(m,idgrupo);
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
            matriz[i][3] = materiales.get(i).getGrupo();
        }
        if (pmaterial != null) {
            pmaterial.mostrar(matriz);
        }
        else{
            pbmaterial.mostrar(matriz);
        }  
    }

    public void mostrarMaterialesPorNombre(String input) {
        List<Material> materiales = lm.getMaterialPorNombre(input);
        String[][] matriz = new String[materiales.size()][4];
        for (int i = 0; i < materiales.size(); i++) {
            matriz[i][0] = String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1] = materiales.get(i).getNombre();
            matriz[i][2] = materiales.get(i).getUnidad();
            matriz[i][3] = materiales.get(i).getGrupo();
        }
        if (pmaterial != null) {
            pmaterial.mostrar(matriz);
        }
        else{
            pbmaterial.mostrar(matriz);
        }      
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
    
    
    public void crearEtapa(String nombre) {
        Etapa e = new Etapa();
        e.setNombre(nombre);
        le.crearEtapa(e);

    }

    public void editarEtapa(int pos, String nombre) {
        Etapa e = buscarEtapa(pos);
        e.setNombre(nombre);
        le.actualizarEtapa(e);

    }

    public void eliminarEtapa(int pos) {
        Etapa e = buscarEtapa(pos);
        le.eliminarEtapa(e);
    }

    public void mostrarEtapas() {
        List<Etapa> etapas = le.getEtapas();
        String[][] matriz = new String[etapas.size()][2];

        for (int i = 0; i < etapas.size(); i++) {
            matriz[i][0] = String.valueOf(etapas.get(i).getIdEtapa());
            matriz[i][1] = etapas.get(i).getNombre();
        }
        if (petapa != null) {
            petapa.mostrar(matriz);
        } 
        else{
            pbetapa.mostrar(matriz);
        }  

    }
    
    public void mostrarEtapasPorNombre(String input){
         List<Etapa> etapas = le.getEtapaPorNombre(input);
        String[][] matriz = new String[etapas.size()][2];

        for (int i = 0; i < etapas.size(); i++) {
            matriz[i][0] = String.valueOf(etapas.get(i).getIdEtapa());
            matriz[i][1] = etapas.get(i).getNombre();
        }
        if (petapa != null) {
            petapa.mostrar(matriz);
        } 
        else{
            pbetapa.mostrar(matriz);
        }  
    }

    public Etapa buscarEtapa(int pos) {
        Etapa e = le.buscarEtapa(pos);
        return e;
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Mostrar Materiales")) {
            mostrarMateriales();
        } else if (evento.getActionCommand().equals("Mostrar Grupos")) {
            mostrarGrupos();
        }else if (evento.getActionCommand().equals("Mostrar Etapas")) {
            mostrarEtapas();
        }
    }

}
