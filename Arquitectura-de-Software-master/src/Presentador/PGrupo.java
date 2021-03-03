package Presentador;

import InterfacesVistas.IGrupo;
import Logica.Grupo;
import Persistencia.DaoGrupo;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PGrupo implements ActionListener{
    private IGrupo vista;
    private Grupo grupo;
    IDao dao= new DaoGrupo();

    public PGrupo(IGrupo vista, Grupo grupo) {
        this.vista = vista;
        this.grupo = grupo;
    }
    
    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }

    public void registrar() {
        grupo.setNombre(vista.getnombre());
        dao.insertar(grupo);
        vista.mostrarMensaje("Grupo Creado");
        vista.restaurar();
        mostrarGrupos();

    }

    public void editar() {
        grupo = buscarGrupo(vista.getItem());
        grupo.setNombre(vista.getnombre());
        dao.actualizar(grupo);
        mostrarGrupos();
        vista.mostrarMensaje("Grupo Actualizado");
        vista.restaurar();
    }

    public void eliminar() {
        grupo = buscarGrupo(vista.getItem());
        dao.eliminar(grupo);
        mostrarGrupos();
        vista.mostrarMensaje("Grupo Eliminado");
    }

    public void mostrarGrupos() {
        List<Grupo> grupos = dao.listado();
        String[][] matriz = new String[grupos.size()][2];

        for (int i = 0; i < grupos.size(); i++) {
            matriz[i][0] = String.valueOf(grupos.get(i).getIdGrupo());
            matriz[i][1] = grupos.get(i).getNombre();
        }
        vista.setSalida(matriz);

    }
    
    public void mostrarGruposPorNombre(){
         List<Grupo> grupos = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[grupos.size()][2];

        for (int i = 0; i < grupos.size(); i++) {
            matriz[i][0] = String.valueOf(grupos.get(i).getIdGrupo());
            matriz[i][1] = grupos.get(i).getNombre();
        }
        vista.setSalida(matriz);
    }

    public Grupo buscarGrupo(int pos) {
        grupo = (Grupo) dao.buscar(pos);
        return grupo;
    }
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IGrupo.guardar)) {
            registrar();
        } else if (evento.getActionCommand().equals(IGrupo.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IGrupo.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IGrupo.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IGrupo.buscar)) {
            mostrarGruposPorNombre();
        }
    }
    
      
}
