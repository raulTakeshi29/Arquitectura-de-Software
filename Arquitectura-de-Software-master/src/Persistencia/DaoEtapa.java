package Persistencia;

import Logica.Etapa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEtapa implements IDao<Etapa>{
    private Connection connect = conexion.getInstance();    
    @Override
    public void insertar(Etapa et) {
        try{
            String sql = "INSERT INTO etapa (nombre) VALUES(?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,et.getNombre());
            ps.execute();                
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Etapa et) {
        try{
            String sql = "UPDATE Etapa SET nombre='"+et.getNombre()+"' WHERE idEtapa='"+et.getIdEtapa()+"'";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public Etapa buscar(int id) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from Etapa where idEtapa="+id+";");           
            if(rs.next()){
                Etapa et = new Etapa();
                et.setIdEtapa(rs.getInt(1));
                et.setNombre(rs.getString(2));
                return et;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(Etapa et) {
        try{
            String sql = "delete from Etapa where idEtapa="+et.getIdEtapa()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<Etapa> listado() {
        List<Etapa> listaEtapa = new ArrayList<>();
        try {
            String sql = "select * from Etapa";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Etapa et = new Etapa();
                et.setIdEtapa(rs.getInt(1));
                et.setNombre(rs.getString(2));
                listaEtapa.add(et);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaEtapa ;
    }
    
    @Override
    public List<Etapa> listadoPorNombre(String input) {
        List<Etapa> listaEtapa = new ArrayList<>();
        try {
            String sql = "select * from Etapa where nombre like '"+input+"%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Etapa et = new Etapa();
                et.setIdEtapa(rs.getInt(1));
                et.setNombre(rs.getString(2));
                listaEtapa.add(et);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaEtapa;
    }   

}
