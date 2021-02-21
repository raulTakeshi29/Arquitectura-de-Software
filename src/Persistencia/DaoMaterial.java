package Persistencia;
import Logica.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoMaterial implements IDaoMaterial<Material>{
     private Connection connect = conexion.getInstance();    
    @Override
    public void insertar(Material m) {
        try{
            String sql = "INSERT INTO material (nombre,unidad,idgrupo) VALUES(?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,m.getNombre());
            ps.setString(2,m.getUnidad());
            ps.setInt(3,m.getIdgrupo());
            ps.execute();                
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Material m) {
        try{
            String sql = "UPDATE material SET nombre='"+m.getNombre()+"', unidad='"+m.getUnidad()+"',"
                    + "idgrupo='"+m.getIdgrupo()+" WHERE idmaterial='"+m.getIdMaterial()+"'";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public Material buscar(int id) {
        try{
            Statement statement=this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from material where idmaterial="+id+";");           
            if(rs.next()){
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                m.setIdgrupo(rs.getInt(4));
                return m;
            }else{
                return null;
            }         
        }catch(SQLException e){
            return null;
        } 
    }

    @Override
    public void eliminar(Material m) {
        try{
            String sql = "delete from material where idmaterial="+m.getIdMaterial()+";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        }catch (Exception e){
          e.printStackTrace();
        } 
    }

    @Override
    public List<Material> listado() {
        List<Material> listaMaterial = new ArrayList<>();
        try {
            String sql = "select idmaterial,nombre,unidad from material";
            
            PreparedStatement statement = this.connect.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery(); 
           
            while(rs.next()){
                Material m =new Material();
                String query="select nombre from grupo where idgrupo='"+m.getIdgrupo()+"'";
                PreparedStatement st = this.connect.prepareStatement(query);
                ResultSet r = st.executeQuery();
                r.next();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                r.getString(1);
                
                listaMaterial.add(m);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaMaterial;
    }
    
    @Override
    public List<Material> listadoPorNombre(String input) {
        List<Material> listaMaterial = new ArrayList<>();
        try {
            String sql = "select * from material where nombre like '"+input+"%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                m.setIdgrupo(rs.getInt(4));
                listaMaterial.add(m);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaMaterial;
    }   
}
