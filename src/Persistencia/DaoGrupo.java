package Persistencia;

import Logica.Grupo;
import Logica.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoGrupo implements IDaoGrupo<Grupo>{
    private Connection connect = conexion.getInstance();    
    @Override
    public void insertar(Grupo g) {
        try{
            String sql = "INSERT INTO grupo (nombre) VALUES(?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,g.getNombre());
            ps.execute();                
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Grupo g) {
        try{
            String sql = "UPDATE grupo SET nombre='"+g.getNombre()+"' WHERE idgrupo='"+g.getIdGrupo()+"'";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public Grupo buscar(int id) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from grupo where idGrupo="+id+";");           
            if(rs.next()){
                Grupo g = new Grupo();
                g.setIdGrupo(rs.getInt(1));
                g.setNombre(rs.getString(2));
                return g;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(Grupo g) {
        try{
            String sql = "delete fromgrupo where idgrupo="+g.getIdGrupo()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<Grupo> listado() {
        List<Grupo> listaGrupo = new ArrayList<>();
        try {
            String sql = "select * from grupo";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Grupo g = new Grupo();
                g.setIdGrupo(rs.getInt(1));
                g.setNombre(rs.getString(2));
                listaGrupo.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaGrupo;
    }
    
    @Override
    public List<Grupo> listadoPorNombre(String input) {
        List<Grupo> listaGrupo = new ArrayList<>();
        try {
            String sql = "select * from grupo where nombre like '"+input+"%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Grupo g = new Grupo();
                g.setIdGrupo(rs.getInt(1));
                g.setNombre(rs.getString(2));
                listaGrupo.add(g);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaGrupo;
    }   
}
