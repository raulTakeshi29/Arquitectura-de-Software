/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentador;
import InterfacesVistas.IResponsable;
import Logica.Responsable;
import Persistencia.DaoResponsable;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author TAKESHI
 */
public class PResponsable implements ActionListener{
    private IResponsable vista;
    private Responsable responsable;
    IDao dao = new DaoResponsable();

    public PResponsable(IResponsable vista, Responsable responsable) {
        this.vista = vista;
        this.responsable = responsable;
    }

    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }

     public void registrar(){
        responsable.setNombre(vista.getnombre());
        responsable.setApellido(vista.getApellido());
        dao.insertar(responsable);
        mostrarResponsables();
        vista.mostrarMensaje("Responsable Creado");
        vista.restaurar();
    }
    
    public void editar(){
        responsable = buscarResponsable(vista.getItem());
        responsable.setNombre(vista.getnombre());
        responsable.setApellido(vista.getApellido());
        dao.actualizar(responsable);
        mostrarResponsables();
        vista.mostrarMensaje("Responsable Actualizado");
        vista.restaurar();
    }
    public void eliminar(){
        responsable = buscarResponsable(vista.getItem());
        dao.eliminar(responsable);
        mostrarResponsables();
        vista.mostrarMensaje("Responsable Eliminado");
    }
    
    public Responsable buscarResponsable(int id) {
        responsable = (Responsable) dao.buscar(id);
        return responsable;
    }
    
    public void mostrarResponsables() {
        List<Responsable> responsables = dao.listado();
        String[][] matriz = new String[responsables.size()][3];
        for (int i = 0; i < responsables.size(); i++) {
            matriz[i][0] = String.valueOf(responsables.get(i).getId());
            matriz[i][1] = responsables.get(i).getNombre();
            matriz[i][2] = responsables.get(i).getApellido();
        }
        vista.setSalida(matriz);
    }
    public void mostrarResponsablePorNombre(){
        List<Responsable> responsables = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[responsables.size()][3];
        for (int i = 0; i < responsables.size(); i++) {
            matriz[i][0] = String.valueOf(responsables.get(i).getId());
            matriz[i][1] = responsables.get(i).getNombre();
            matriz[i][2] = responsables.get(i).getApellido();
        }
        vista.setSalida(matriz);
    }
    

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IResponsable.guardar)) {
            registrar();
        } else if (evento.getActionCommand().equals(IResponsable.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IResponsable.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IResponsable.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IResponsable.buscar)) {
            mostrarResponsablePorNombre();
        }
    }
    
}
