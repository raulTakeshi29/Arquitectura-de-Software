package Presentador;
import InterfacesVistas.IBEncargado;
import Logica.Encargado;
import Persistencia.DaoEncargado;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PBEncargado implements ActionListener {
    private IBEncargado vista;
    private Encargado encargado;
    IDao dao = new DaoEncargado();

    public PBEncargado(IBEncargado vista) {
        this.vista = vista;
    }
    
    public void asignarEncargado(){
        encargado = (Encargado) dao.buscar(vista.getItem());            
        vista.cerrar();
    }  
    
    public void mostrar() {
        List<Encargado> encargados = dao.listado();
        String[][] matriz = new String[encargados.size()][3];

        for (int i = 0; i < encargados.size(); i++) {
            matriz[i][0] = String.valueOf(encargados.get(i).getIdEncargado());
            matriz[i][1] = encargados.get(i).getNombre();
            matriz[i][2]= encargados.get(i).getApellido();
        }
        vista.setSalida(matriz);

    }
    
    public void buscar(){
         List<Encargado> encargados = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[encargados.size()][3];

        for (int i = 0; i < encargados.size(); i++) {
            matriz[i][0] = String.valueOf(encargados.get(i).getIdEncargado());
            matriz[i][1] = encargados.get(i).getNombre();
            matriz[i][2]= encargados.get(i).getApellido();
        }
        vista.setSalida(matriz);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IBEncargado.aceptar)) {
            asignarEncargado();                     
        } else if (evento.getActionCommand().equals(IBEncargado.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBEncargado.cancelar)) {
            vista.cerrar();
        }
    } 
    
    public Encargado getEncargado() {
        return encargado;
    }    
}
