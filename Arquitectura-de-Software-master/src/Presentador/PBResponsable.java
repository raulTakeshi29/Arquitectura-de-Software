
package Presentador;
import InterfacesVistas.IBResponsable;
import Logica.Etapa;
import Logica.Responsable;
import Persistencia.DaoResponsable;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PBResponsable implements ActionListener{
    private IBResponsable vista;
    private Responsable responsable;
    IDao dao = new DaoResponsable();

    public PBResponsable(IBResponsable vista) {
        this.vista = vista;
    }
    
    public void asignarResponsable(){
        responsable = (Responsable) dao.buscar(vista.getItem());            
        vista.cerrar();
    }  
    
   public void mostrar() {
        List<Responsable> responsables = dao.listado();
        String[][] matriz = new String[responsables.size()][3];
        for (int i = 0; i < responsables.size(); i++) {
            matriz[i][0] = String.valueOf(responsables.get(i).getId());
            matriz[i][1] = responsables.get(i).getNombre();
            matriz[i][2] = responsables.get(i).getApellido();
        }
        vista.setSalida(matriz);
    }
    public void buscar(){
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
        if (evento.getActionCommand().equals(IBResponsable.aceptar)) {
            asignarResponsable();                     
        } else if (evento.getActionCommand().equals(IBResponsable.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBResponsable.cancelar)) {
            vista.cerrar();
        }
    } 
    
    public Responsable getResponsable() {
        return responsable;
    }     
}
