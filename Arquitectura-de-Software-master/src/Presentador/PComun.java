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
    private IPEncargado pencargado;
    private IPResponsable presponsable;
    private IPProyecto pproyecto;
    private IPBGrupo pbgrupo;
    private IPBEtapa pbetapa;
    private IPBEncargado pbencargado;
    private IPBMaterial pbmaterial;
    private LogicaMaterial lm = new LogicaMaterial();
    private LogicaGrupo lg = new LogicaGrupo();
    private LogicaResponsable lr = new LogicaResponsable();
    private LogicaEtapa le=new LogicaEtapa();
    private LogicaEncargado len= new LogicaEncargado();
    private LogicaProyecto lp=new LogicaProyecto();
    
    public PComun(IPMaterial pmaterial) {
        this.pmaterial = pmaterial;
    }
    public PComun(IPGrupo pgrupo) {
        this.pgrupo = pgrupo;
    }
    public PComun(IPEtapa petapa){
        this.petapa=petapa;
    }
    public PComun(IPEncargado pencargado){
        this.pencargado=pencargado;
    }
    public PComun(IPProyecto pproyecto){
        this.pproyecto=pproyecto;
    }
     public PComun(IPBEtapa pbetapa){
        this.pbetapa=pbetapa;
    }
    public PComun(IPBEncargado pbencargado){
        this.pbencargado=pbencargado;
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
        else if(pbmaterial!=null){
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
            matriz[i][3] = materiales.get(i).getGrupo().getNombre();
        }
        if (pmaterial != null) {
            pmaterial.mostrar(matriz);
        }
        else if(pbmaterial!=null){
           pbmaterial.mostrar(matriz);
        }      
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
    
     
    public void crearEncargado(String nombre,String apellido) {
        Encargado e = new Encargado();
        e.setNombre(nombre);
        e.setApellido(apellido);
        len.crearEncargado(e);

    }

    public void editarEncargado(int pos, String nombre,String apellido) {
        Encargado e = buscarEncargado(pos);
        e.setNombre(nombre);
        e.setApellido(apellido);
        len.actualizarEncargado(e);

    }

    public void eliminarEncargado(int pos) {
        Encargado e = buscarEncargado(pos);
        len.eliminarEncargado(e);
    }

    public void mostrarEncargados() {
        List<Encargado> encargados = len.getEncargados();
        String[][] matriz = new String[encargados.size()][3];

        for (int i = 0; i < encargados.size(); i++) {
            matriz[i][0] = String.valueOf(encargados.get(i).getIdEncargado());
            matriz[i][1] = encargados.get(i).getNombre();
            matriz[i][2]= encargados.get(i).getApellido();
        }
        if (pencargado != null) {
            pencargado.mostrar(matriz);
        } 
        else{
            pbencargado.mostrar(matriz);
        }  

    }
    
    public void mostrarEncargadosPorNombre(String input){
         List<Encargado> encargados = len.getEncargadoPorNombre(input);
        String[][] matriz = new String[encargados.size()][3];

        for (int i = 0; i < encargados.size(); i++) {
            matriz[i][0] = String.valueOf(encargados.get(i).getIdEncargado());
            matriz[i][1] = encargados.get(i).getNombre();
            matriz[i][2]= encargados.get(i).getApellido();
        }
        if (pencargado != null) {
            pencargado.mostrar(matriz);
        } 
        else{
            pbencargado.mostrar(matriz);
        }  
    }

    public Encargado buscarEncargado(int pos) {
        Encargado e = len.buscarEncargado(pos);
        return e;
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
    
    
    public void crearProyecto(String nombre,int idencargado, int idetapa) {
        Proyecto p = new Proyecto();
        p.setNombre(nombre);
        Encargado e = new Encargado();
        e.setIdEncargado(idencargado);
        p.setEncargado(e);
        lp.crearProyecto(p);
        mostrarProyectos();
    }

    public void editarProyecto(int pos, String nombre,int idencargado, int idetapa) {
        Proyecto p = buscarProyecto(pos);
        p.setNombre(nombre);
        Encargado e = new Encargado();
        e.setIdEncargado(idencargado);
        p.setEncargado(e);
        lp.actualizarProyecto(p);
        mostrarProyectos();
    }

    public void eliminarProyecto(int pos) {
        Proyecto p = buscarProyecto(pos);
        lp.eliminarProyecto(p);
        mostrarProyectos();
    }

    public Proyecto buscarProyecto(int id) {
        Proyecto p = lp.buscarProyecto(id);
        return p;
    }

    public void mostrarProyectos() {
        List<Proyecto> proyectos = lp.getProyectos();
        String[][] matriz = new String[proyectos.size()][4];
        for (int i = 0; i < proyectos.size(); i++) {
            matriz[i][0] = String.valueOf(proyectos.get(i).getIdProyecto());
            matriz[i][1] = proyectos.get(i).getNombre();
            matriz[i][2] = proyectos.get(i).getEncargado().getNombre();
            matriz[i][3] = proyectos.get(i).getEtapa().getNombre();
        }
        if (pproyecto != null) {
            pproyecto.mostrar(matriz);
        }
        //else if(pbmaterial!=null){
          // pbmaterial.mostrar(matriz);
        //}
    }

    public void mostrarProyectosPorNombre(String input) {
        List<Proyecto> proyectos = lp.getProyectoPorNombre(input);
        String[][] matriz = new String[proyectos.size()][4];
        for (int i = 0; i < proyectos.size(); i++) {
            matriz[i][0] = String.valueOf(proyectos.get(i).getIdProyecto());
            matriz[i][1] = proyectos.get(i).getNombre();
            matriz[i][2] = proyectos.get(i).getEncargado().getNombre();
            matriz[i][3] = proyectos.get(i).getEtapa().getNombre();
        }
        if (pproyecto != null) {
            pproyecto.mostrar(matriz);
        }
        //else if(pbmaterial!=null){
          // pbmaterial.mostrar(matriz);
        //}
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Mostrar Materiales")) {
            mostrarMateriales();
        } else if (evento.getActionCommand().equals("Mostrar Grupos")) {
            mostrarGrupos();
        } else if (evento.getActionCommand().equals("Mostrar Responsables")){
            mostrarResponsables();
        }else if (evento.getActionCommand().equals("Mostrar Encargados")){
            mostrarEncargados();
        }else if (evento.getActionCommand().equals("Mostrar Etapas")){
            mostrarEtapas();
        }else if (evento.getActionCommand().equals("Mostrar Proyectos")){
            mostrarProyectos();
        }
    }

}
