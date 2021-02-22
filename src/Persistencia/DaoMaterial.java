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
    public void insertar(Material m,int grupo) {
        try{
            String sql = "INSERT INTO material (nombre,unidad,idgrupo) VALUES(?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1,m.getNombre());
            ps.setString(2,m.getUnidad());
            ps.setInt(3,grupo);
            ps.execute();                
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Material m,int grupo) {
        try{
            String sql = "UPDATE material SET nombre='"+m.getNombre()+"', unidad='"+m.getUnidad()+"',"
                    + "idgrupo='"+grupo+" WHERE idmaterial='"+m.getIdMaterial()+"'";
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
            ResultSet rs = statement.executeQuery("select m.idMaterial,m.nombre,m.unidad,g.nombre from Material m inner join Grupo g on m.idGrupo=g.idGrupo and idmaterial='"+id+"';");           
            if(rs.next()){
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                m.setGrupo(rs.getString(4));
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
            String sql = "select m.idMaterial,m.nombre,m.unidad,g.nombre from Material m inner join Grupo g on m.idGrupo=g.idGrupo";
            
            PreparedStatement statement = this.connect.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery(); 
           
            while(rs.next()){
                Material m =new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                m.setGrupo(rs.getString(4));
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
            String sql = "select m.idMaterial,m.nombre,m.unidad,g.nombre from Material m inner join Grupo g on m.idGrupo=g.idGrupo and m.nombre like '"+input+"%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();           
            while(rs.next()){
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                m.setGrupo(rs.getString(4));
                listaMaterial.add(m);
            }  
        }catch (Exception e){
            e.printStackTrace();
        } 
        return listaMaterial;
    }
     
}
