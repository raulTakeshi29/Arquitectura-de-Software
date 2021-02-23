package Persistencia;

import Logica.Encargado;
import Logica.Etapa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEncargado implements IDaoEncargado<Encargado>{
     private Connection connect = conexion.getInstance();    
    @Override
    public void insertar(Encargado en) {
        try{
            String sql = "INSERT INTO encargado (nombre,apellido) VALUES(?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,en.getNombre());
            ps.setString(2,en.getApellido());
            ps.execute();                
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Encargado en) {
        try{
            String sql = "UPDATE Etapa SET nombre='"+en.getNombre()+"',apellido='"+en.getApellido()+"' WHERE idEncargado='"+en.getIdEncargado()+"'";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public Encargado buscar(int id) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from Encargado where idEncargado="+id+";");           
            if(rs.next()){
                Encargado en = new Encargado();
                en.setIdEncargado(rs.getInt(1));
                en.setNombre(rs.getString(2));
                en.setApellido(rs.getString(3));
                return en;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(Encargado en) {
        try{
            String sql = "delete from Encargado where idEncargado="+en.getIdEncargado()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<Encargado> listado() {
        List<Encargado> listaEncargado = new ArrayList<>();
        try {
            String sql = "select * from Encargado";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Encargado en = new Encargado();
                en.setIdEncargado(rs.getInt(1));
                en.setNombre(rs.getString(2));
                en.setApellido(rs.getString(3));
                listaEncargado.add(en);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaEncargado ;
    }
    
    @Override
    public List<Encargado> listadoPorNombre(String input) {
        List<Encargado> listaEncargado = new ArrayList<>();
        try {
            String sql = "select * from Encargado where nombre like '"+input+"%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Encargado en = new Encargado();
                en.setIdEncargado(rs.getInt(1));
                en.setNombre(rs.getString(2));
                en.setApellido(rs.getString(3));
                listaEncargado.add(en);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaEncargado;
    }   

}
