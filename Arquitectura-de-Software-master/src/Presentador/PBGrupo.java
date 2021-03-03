package Presentador;
import InterfacesVistas.IBGrupo;
import Logica.Grupo;
import Persistencia.DaoGrupo;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PBGrupo implements ActionListener{
    private IBGrupo vista;
    private Grupo grupo;
    IDao dao = new DaoGrupo();

    public PBGrupo(IBGrupo vista) {
        this.vista = vista;
    }
    
    public void asignarGrupo(){
        grupo = (Grupo) dao.buscar(vista.getItem());            
        vista.cerrar();
    }  
    
    public void mostrar() {
        List<Grupo> grupos = dao.listado();
        String[][] matriz = new String[grupos.size()][2];

        for (int i = 0; i < grupos.size(); i++) {
            matriz[i][0] = String.valueOf(grupos.get(i).getIdGrupo());
            matriz[i][1] = grupos.get(i).getNombre();
        }
        vista.setSalida(matriz);

    }
    
    public void buscar(){
         List<Grupo> grupos = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[grupos.size()][2];

        for (int i = 0; i < grupos.size(); i++) {
            matriz[i][0] = String.valueOf(grupos.get(i).getIdGrupo());
            matriz[i][1] = grupos.get(i).getNombre();
        }
        vista.setSalida(matriz);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IBGrupo.aceptar)) {
            asignarGrupo();                     
        } else if (evento.getActionCommand().equals(IBGrupo.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBGrupo.cancelar)) {
            vista.cerrar();
        }
    } 
    
    public Grupo getGrupo() {
        return grupo;
    }    
}
