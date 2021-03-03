package Presentador;

import InterfacesVistas.IBEncargado;
import InterfacesVistas.IBEtapa;
import InterfacesVistas.IMaterial;
import InterfacesVistas.IProyecto;
import Logica.Encargado;
import Logica.Etapa;
import Logica.Material;
import Logica.Proyecto;
import Persistencia.DaoProyecto;
import Persistencia.IDao;
import Vistas.VBEncargado;
import Vistas.VBEtapa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PProyecto implements ActionListener{
     private IProyecto vista;
    private Proyecto proyecto;
    private Encargado encargado;
    private Etapa etapa;
    IDao dao = new DaoProyecto();

    public PProyecto(IProyecto vista, Proyecto proyecto) {
        this.vista = vista;
        this.proyecto = proyecto;
    }
    
    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }

    public void registrar() {
        proyecto.setNombre(vista.getnombre());
        encargado.setIdEncargado(vista.getencargado());
        proyecto.setEncargado(encargado);
        dao.insertar(proyecto);
        mostrarProyectos();
        vista.mostrarMensaje("Proyecto Registrado");
        vista.restaurar();
    }

    public void editar() {
        proyecto = buscarProyecto(vista.getItem());
        proyecto.setNombre(vista.getnombre());
        encargado.setIdEncargado(vista.getencargado());
        proyecto.setEncargado(encargado);
        etapa.setIdEtapa(vista.getetapa());
        proyecto.setEtapa(etapa);
        dao.actualizar(proyecto);
        mostrarProyectos();
        vista.mostrarMensaje("Proyecto Actualizado");
        vista.restaurar();
    }

    public void eliminar() {
        proyecto = buscarProyecto(vista.getItem());
        dao.eliminar(proyecto);
        mostrarProyectos();
        vista.mostrarMensaje("Proyecto Eliminado");
        vista.restaurar();        
    }

    public Proyecto buscarProyecto(int id) {
        proyecto = (Proyecto) dao.buscar(id);
        return proyecto;
    }

    public void mostrarProyectos() {
        List<Proyecto> proyectos = dao.listado();
        String[][] matriz = new String[proyectos.size()][4];
        for (int i = 0; i < proyectos.size(); i++) {
            matriz[i][0] = String.valueOf(proyectos.get(i).getIdProyecto());
            matriz[i][1] = proyectos.get(i).getNombre();
            matriz[i][2] = proyectos.get(i).getEncargado().getNombre();
            matriz[i][3] = proyectos.get(i).getEtapa().getNombre();
        }
        vista.setSalida(matriz);
    }

    public void mostrarProyectosPorNombre() {
        List<Proyecto> proyectos = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[proyectos.size()][4];
        for (int i = 0; i < proyectos.size(); i++) {
            matriz[i][0] = String.valueOf(proyectos.get(i).getIdProyecto());
            matriz[i][1] = proyectos.get(i).getNombre();
            matriz[i][2] = proyectos.get(i).getEncargado().getNombre();
            matriz[i][3] = proyectos.get(i).getEtapa().getNombre();
        }
        vista.setSalida(matriz);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IProyecto.guardar)) {
            registrar();
        } else if (evento.getActionCommand().equals(IProyecto.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IProyecto.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IProyecto.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IProyecto.buscar)) {
            mostrarProyectosPorNombre();
        } else if (evento.getActionCommand().equals(IProyecto.buscarEncargado)){
            buscarEncargado();
        }
    }    

    public void mostrarEncargado() {
        vista.mostrarEncargado(encargado.getIdEncargado());
    }
    
    public void buscarEncargado(){
        IBEncargado ib = new VBEncargado(null,true);
        PBEncargado pg = new PBEncargado(ib);
        ib.setPresentador(pg);
        ib.iniciar();
        encargado = pg.getEncargado();
        if(encargado!=null){
            mostrarEncargado();
        }
    }
    
    public void mostrarEtapa() {
        vista.mostrarEtapa(etapa.getIdEtapa());
    }
    
    public void buscarEtapa(){
        IBEtapa ib = new VBEtapa(null,true);
        PBEtapa pg = new PBEtapa(ib);
        ib.setPresentador(pg);
        ib.iniciar();
        etapa = pg.getEtapa();
        if(etapa!=null){
            mostrarEtapa();
        }
    }

}
