package Persistencia;

import Logica.Grupo;
import Logica.Responsable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoResponsable implements IDao <Responsable>{

    private Connection connect = conexion.getInstance();

    @Override
    public void insertar(Responsable obj) {
         try{
            String sql = "INSERT INTO Responsable (nombre,apellido) VALUES(?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.execute();                
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Responsable obj) {
        try{
            String sql = "UPDATE Responsable SET nombre="+obj.getNombre()+", apellido="+obj.getApellido()+" WHERE id="+obj.getId()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public Responsable buscar(int id) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from Responsable where id="+id+";");           
            if(rs.next()){
                Responsable r = new Responsable();
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido(rs.getString(3));
                return r;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(Responsable obj) {
        try{
            String sql = "delete from grupo where idGrupo="+obj.getId()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<Responsable> listado() {
        List<Responsable> lista = new ArrayList<>();
        try {
            String sql = "select * from Grupo";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Responsable r = new Responsable();
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido(rs.getString(3));
                lista.add(r);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }

    @Override
    public List<Responsable> listadoPorNombre(String input) {
        List<Responsable> lista = new ArrayList<>();
        try {
            String sql = "select * from Grupo where nombre like '"+input+"%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Responsable r = new Responsable();
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido(rs.getString(3));
                lista.add(r);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return lista;
    }

    

}
