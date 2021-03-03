package Presentador;
import InterfacesVistas.IBEtapa;
import Logica.Etapa;
import Persistencia.DaoEtapa;
import Persistencia.IDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PBEtapa implements ActionListener{
    private IBEtapa vista;
    private Etapa etapa;
    IDao dao = new DaoEtapa();

    public PBEtapa(IBEtapa vista) {
        this.vista = vista;
    }
    
    public void asignarEtapa(){
        etapa = (Etapa) dao.buscar(vista.getItem());            
        vista.cerrar();
    }  
    
    public void mostrar() {
        List<Etapa> etapas = dao.listado();
        String[][] matriz = new String[etapas.size()][2];

        for (int i = 0; i < etapas.size(); i++) {
            matriz[i][0] = String.valueOf(etapas.get(i).getIdEtapa());
            matriz[i][1] = etapas.get(i).getNombre();
        }
        vista.setSalida(matriz);

    }
    
    public void buscar(){
         List<Etapa> etapas = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[etapas.size()][2];

        for (int i = 0; i < etapas.size(); i++) {
            matriz[i][0] = String.valueOf(etapas.get(i).getIdEtapa());
            matriz[i][1] = etapas.get(i).getNombre();
        }
        vista.setSalida(matriz);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IBEtapa.aceptar)) {
            asignarEtapa();                     
        } else if (evento.getActionCommand().equals(IBEtapa.buscar)) {
            buscar();
        } else if (evento.getActionCommand().equals(IBEtapa.cancelar)) {
            vista.cerrar();
        }
    } 
    
    public Etapa getEtapa() {
        return etapa;
    }    
}
