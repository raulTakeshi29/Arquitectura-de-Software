package Presentador;

import InterfacesVistas.IBGrupo;
import InterfacesVistas.IMaterial;
import Logica.Grupo;
import Logica.Material;
import Persistencia.DaoMaterial;
import Persistencia.IDao;
import Vistas.VBGrupo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PMaterial implements ActionListener{
    private IMaterial vista;
    private Material material;
    private Grupo grupo;
    IDao dao = new DaoMaterial();

    public PMaterial(IMaterial vista, Material material) {
        this.vista = vista;
        this.material = material;
    }
    
    public void cancelar() {
        vista.mostrarMensaje("Operación cancelada.");
        vista.restaurar();
    }

    public void registrar() {
        material.setNombre(vista.getnombre());
        material.setUnidad(vista.getunidad());
        grupo.setIdGrupo(vista.getgrupo());
        material.setGrupo(grupo);
        dao.insertar(material);
        mostrarMateriales();
        vista.mostrarMensaje("Material Registrado");
        vista.restaurar();
    }

    public void editar() {
        material = buscarMaterial(vista.getItem());
        material.setNombre(vista.getnombre());
        material.setUnidad(vista.getunidad());
        grupo.setIdGrupo(vista.getgrupo());
        material.setGrupo(grupo);
        dao.actualizar(material);
        mostrarMateriales();
        vista.mostrarMensaje("Material Actualizado");
        vista.restaurar();
    }

    public void eliminar() {
        material = buscarMaterial(vista.getItem());
        dao.eliminar(material);
        mostrarMateriales();
        vista.mostrarMensaje("Material Eliminado");
    }

    public Material buscarMaterial(int id) {
        material = (Material) dao.buscar(id);
        return material;
    }

    public void mostrarMateriales() {
        List<Material> materiales = dao.listado();
        String[][] matriz = new String[materiales.size()][4];
        for (int i = 0; i < materiales.size(); i++) {
            matriz[i][0] = String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1] = materiales.get(i).getNombre();
            matriz[i][2] = materiales.get(i).getUnidad();
            matriz[i][3] = materiales.get(i).getGrupo().getNombre();
        }
        vista.setSalida(matriz);
    }

    public void mostrarMaterialesPorNombre() {
        List<Material> materiales = dao.listadoPorNombre(vista.getBusqueda());
        String[][] matriz = new String[materiales.size()][4];
        for (int i = 0; i < materiales.size(); i++) {
            matriz[i][0] = String.valueOf(materiales.get(i).getIdMaterial());
            matriz[i][1] = materiales.get(i).getNombre();
            matriz[i][2] = materiales.get(i).getUnidad();
            matriz[i][3] = materiales.get(i).getGrupo().getNombre();
        }
        vista.setSalida(matriz);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals(IMaterial.guardar)) {
            registrar();
        } else if (evento.getActionCommand().equals(IMaterial.cancelar)) {
            cancelar();
        } else if (evento.getActionCommand().equals(IMaterial.editar)) {
            editar();
        } else if (evento.getActionCommand().equals(IMaterial.eliminar)) {
            eliminar();
        } else if (evento.getActionCommand().equals(IMaterial.buscar)) {
            mostrarMaterialesPorNombre();
        } else if (evento.getActionCommand().equals(IMaterial.buscarGrupo)){
            buscarGrupo();
        }
    }    

    public void mostrarGrupo() {
        vista.mostrarGrupo(grupo.getIdGrupo());
    }
    public void buscarGrupo(){
        IBGrupo ib = new VBGrupo(null,true);
        PBGrupo pg = new PBGrupo(ib);
        ib.setPresentador(pg);
        ib.iniciar();
        grupo = pg.getGrupo();
        if(grupo!=null){
            mostrarGrupo();
        }
    }
}
