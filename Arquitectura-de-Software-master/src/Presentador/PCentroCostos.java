
package Presentador;
import InterfacesVistas.ICentroCostos;
import Logica.CentroCostos;
import Persistencia.DaoCentroCostos;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PCentroCostos implements ActionListener {
    private ICentroCostos vista;
    private  CentroCostos centroCostos;
    IDao dao = new DaoCentroCostos();
    
    public PCentroCostos(ICentroCostos vista,CentroCostos centroCostos) {
        this.vista = vista;
        this.centroCostos = centroCostos;
    }

    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }

     public void registrar(){
        centroCostos.setTipo(vista.getTipo());
        dao.insertar(centroCostos);
        mostrarCentroCostos();
        vista.mostrarMensaje("Centro de Costos Registrado");
        vista.restaurar();
    }
     public void editar(){
        centroCostos = buscarCentroCostos(vista.getItem());
        centroCostos.setTipo(vista.getTipo());
        dao.actualizar(centroCostos);
        mostrarCentroCostos();
        vista.mostrarMensaje("Centro de Costos Actualizado");
        vista.restaurar();
    }
     
      public void eliminar(){
        centroCostos = buscarCentroCostos(vista.getItem());
        dao.eliminar(centroCostos);
        mostrarCentroCostos();
        vista.mostrarMensaje("Centro de Costos Eliminado");
    }
    
    public CentroCostos buscarCentroCostos(int id) {
        centroCostos = (CentroCostos) dao.buscar(id);
        return centroCostos;
    }
    
    public void mostrarCentroCostos() {
        List<CentroCostos> centroc = dao.listado();
        String[][] matriz = new String[centroc.size()][3];
        for (int i = 0; i < centroc.size(); i++) {
            matriz[i][0] = String.valueOf(centroc.get(i).getIdCentroCostos());
            matriz[i][1] = centroc.get(i).getTipo();
        }
        vista.setSalida(matriz);
    }
    public void mostrarCentroCostoTipo(){
        List<CentroCostos> centroc = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[centroc.size()][2];
        for (int i = 0; i < centroc.size(); i++) {
            matriz[i][0] = String.valueOf(centroc.get(i).getIdCentroCostos());
            matriz[i][1] = centroc.get(i).getTipo();
        }
        vista.setSalida(matriz);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
       if (evento.getActionCommand().equals(ICentroCostos.guardar)) {
            registrar();
        } else if (evento.getActionCommand().equals(ICentroCostos.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(ICentroCostos.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(ICentroCostos.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(ICentroCostos.buscar)) {
            mostrarCentroCostoTipo();
        }
    } 
    }
    
