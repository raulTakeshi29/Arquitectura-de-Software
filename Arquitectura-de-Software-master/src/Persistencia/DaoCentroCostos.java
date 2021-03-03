
package Persistencia;

import Logica.CentroCostos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoCentroCostos implements IDao<CentroCostos>{
    private Connection connect = conexion.getInstance();

    @Override
    public void insertar(CentroCostos obj) {
         try{
            String sql = "INSERT INTO centrocostos (tipo) VALUES(?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,obj.getTipo());
            
            ps.execute();                
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void actualizar(CentroCostos obj) {
         try{
            String sql = "UPDATE centrocostos SET tipo="+obj.getTipo()+", apellido="+" WHERE idCentroCostos="+obj.getIdCentroCostos()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public CentroCostos buscar(int id) {
         try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from centrocostos where idCentroCostos="+id+";");           
            if(rs.next()){
                CentroCostos r = new CentroCostos();
                r.setIdCentroCostos(rs.getInt(1));
                r.setTipo(rs.getString(2));
                
                return r;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(CentroCostos obj) {
         try{
            String sql = "delete from centrocostos where idCentroCostos="+obj.getIdCentroCostos()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<CentroCostos> listado() {
        List<CentroCostos> lista = new ArrayList<>();
        try {
            String sql = "select * from centrocostos";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                CentroCostos r = new CentroCostos();
                r.setIdCentroCostos(rs.getInt(1));
                 r.setTipo(rs.getString(2));
                lista.add(r);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }

    @Override
    public List<CentroCostos> listadoPorNombre(String input) {
        List<CentroCostos> lista = new ArrayList<>();
        try {
            String sql = "select * from centrocostos where tipo like '"+input+"%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                CentroCostos r = new CentroCostos();
                r.setIdCentroCostos(rs.getInt(1));
                r.setTipo(rs.getString(2));
                
                lista.add(r);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }

    
    }
        
  


