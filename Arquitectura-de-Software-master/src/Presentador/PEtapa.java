package Presentador;

import InterfacesVistas.IEtapa;
import Logica.Etapa;
import Persistencia.DaoEtapa;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PEtapa implements ActionListener{
    private IEtapa vista;
    private Etapa etapa;
    IDao dao= new DaoEtapa();

    public PEtapa(IEtapa vista, Etapa etapa) {
        this.vista = vista;
        this.etapa= etapa;
    }
    
    
    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }

    public void registrar() {
        etapa.setNombre(vista.getnombre());
        dao.insertar(etapa);
        vista.mostrarMensaje("Etapa Registrada");
        vista.restaurar();

    }

    public void editar() {
        etapa = buscarEtapa(vista.getItem());
        etapa.setNombre(vista.getnombre());
        dao.actualizar(etapa);
        vista.mostrarMensaje("Etapa Actualizada");
        vista.restaurar();

    }

    public void eliminar() {
        etapa = buscarEtapa(vista.getItem());
        dao.eliminar(etapa);
        vista.mostrarMensaje("Etapa Eliminada");
    }

    public void mostrarEtapas() {
        List<Etapa> etapas = dao.listado();
        String[][] matriz = new String[etapas.size()][2];

        for (int i = 0; i < etapas.size(); i++) {
            matriz[i][0] = String.valueOf(etapas.get(i).getIdEtapa());
            matriz[i][1] = etapas.get(i).getNombre();
        }
        vista.setSalida(matriz);

    }
    
    public void mostrarEtapasPorNombre(){
         List<Etapa> etapas = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[etapas.size()][2];

        for (int i = 0; i < etapas.size(); i++) {
            matriz[i][0] = String.valueOf(etapas.get(i).getIdEtapa());
            matriz[i][1] = etapas.get(i).getNombre();
        }
        vista.setSalida(matriz);
    }

    public Etapa buscarEtapa(int pos) {
        etapa = (Etapa) dao.buscar(pos);
        return etapa;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IEtapa.guardar)) {
            registrar();
        } else if (evento.getActionCommand().equals(IEtapa.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IEtapa.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IEtapa.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IEtapa.buscar)) {
            mostrarEtapasPorNombre();
        }
    }
    
}
