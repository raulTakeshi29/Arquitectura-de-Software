package Presentador;

import InterfacesVistas.IEncargado;
import Logica.Encargado;
import Persistencia.DaoEncargado;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PEncargado implements ActionListener{
    private IEncargado vista;
    private Encargado encargado;
    IDao dao= new DaoEncargado();

    public PEncargado(IEncargado vista, Encargado encargado) {
        this.vista = vista;
        this.encargado= encargado;
    }
   
    public void registrar() {
        encargado.setNombre(vista.getnombre());
        encargado.setApellido(vista.getapellido());
        dao.insertar(encargado);
        vista.mostrarMensaje("Encargado Registrado");
        vista.restaurar();
    }

    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }


    public void editar() {
        encargado = buscarEncargado(vista.getItem());
        encargado.setNombre(vista.getnombre());
        encargado.setApellido(vista.getapellido());
        dao.actualizar(encargado);
        vista.mostrarMensaje("Encargado Actualizado");
        vista.restaurar();
    }

    public void eliminar() {
        encargado= buscarEncargado(vista.getItem());
        dao.eliminar(encargado);
        vista.mostrarMensaje("Encargado eliminado");
    }
        
    public void mostrarEncargados() {
        List<Encargado> encargados = dao.listado();
        String[][] matriz = new String[encargados.size()][3];

        for (int i = 0; i < encargados.size(); i++) {
            matriz[i][0] = String.valueOf(encargados.get(i).getIdEncargado());
            matriz[i][1] = encargados.get(i).getNombre();
            matriz[i][2]= encargados.get(i).getApellido();
        }
        vista.setSalida(matriz);

    }
    
    public void mostrarEncargadosPorNombre(){
         List<Encargado> encargados = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[encargados.size()][3];

        for (int i = 0; i < encargados.size(); i++) {
            matriz[i][0] = String.valueOf(encargados.get(i).getIdEncargado());
            matriz[i][1] = encargados.get(i).getNombre();
            matriz[i][2]= encargados.get(i).getApellido();
        }
        vista.setSalida(matriz);
    }

    public Encargado buscarEncargado(int pos) {
        encargado = (Encargado) dao.buscar(pos);
        return encargado;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IEncargado.registrar)) {
            registrar();
        } else if (evento.getActionCommand().equals(IEncargado.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IEncargado.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IEncargado.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IEncargado.buscar)) {
            mostrarEncargadosPorNombre();
        }
    }
}
