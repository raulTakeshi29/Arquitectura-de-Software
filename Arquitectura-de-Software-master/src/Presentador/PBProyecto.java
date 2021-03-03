package Presentador;
import InterfacesVistas.IBProyecto;
import Logica.Proyecto;
import Persistencia.DaoProyecto;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PBProyecto implements ActionListener {
    private IBProyecto vista;
    private Proyecto proyecto;
    IDao dao = new DaoProyecto();

    public PBProyecto(IBProyecto vista) {
        this.vista = vista;
    }
    
    public void asignarProyecto(){
        proyecto = (Proyecto) dao.buscar(vista.getItem());            
        vista.cerrar();
    }  
    
    public void mostrar() {
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

    public void buscar() {
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
        if (evento.getActionCommand().equals(IBProyecto.aceptar)) {
            asignarProyecto();                     
        } else if (evento.getActionCommand().equals(IBProyecto.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBProyecto.cancelar)) {
            vista.cerrar();
        }
    } 
    
    public Proyecto getProyecto() {
        return proyecto;
    }     
}
