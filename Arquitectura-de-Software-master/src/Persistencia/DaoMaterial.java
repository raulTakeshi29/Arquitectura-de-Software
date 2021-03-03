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

public class DaoMaterial implements IDao<Material> {

    private Connection connect = conexion.getInstance();

    @Override
    public void insertar(Material m) {
        try {
            String sql = "INSERT INTO material (nombre,unidad,idgrupo) VALUES(?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getUnidad());
            ps.setInt(3, m.getGrupo().getIdGrupo());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Material m) {
        try {
            String sql = "UPDATE material SET nombre=" + m.getNombre() + ", unidad=" + m.getUnidad() + ","
                    + "idgrupo=" + m.getGrupo().getIdGrupo() + " WHERE idmaterial=" + m.getIdMaterial() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Material buscar(int id) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from Material where idmaterial=" + id + ";");
            if (rs.next()) {
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                Grupo grupo = new Grupo();
                int idGrupo = rs.getInt(4);
                if (idGrupo == 0) {
                    grupo.setNombre("------");
                } else {
                    String sql2 = "select nombre from\n"
                            + "Grupo where\n"
                            + "idGrupo=" + idGrupo;
                    PreparedStatement statement1 = this.connect.prepareStatement(sql2);
                    ResultSet rs2 = statement1.executeQuery();
                    while (rs2.next()) {
                        grupo.setNombre(rs2.getString(1));
                    }
                }
                m.setGrupo(grupo);
                return m;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(Material m) {
        try {
            String sql = "delete from material where idmaterial=" + m.getIdMaterial() + ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Material> listado() {
        List<Material> listaMaterial = new ArrayList<>();
        try {
            String sql = "select*from Material";

            PreparedStatement statement = this.connect.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                Grupo grupo = new Grupo();
                int idGrupo = rs.getInt(4);
                if (idGrupo == 0) {
                    grupo.setNombre("------");
                } else {
                    String sql2 = "select nombre from\n"
                            + "Grupo where\n"
                            + "idGrupo=" + idGrupo;
                    PreparedStatement statement1 = this.connect.prepareStatement(sql2);
                    ResultSet rs2 = statement1.executeQuery();
                    while (rs2.next()) {
                        grupo.setNombre(rs2.getString(1));
                    }
                }
                m.setGrupo(grupo);
                listaMaterial.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMaterial;
    }

    @Override
    public List<Material> listadoPorNombre(String input) {
        List<Material> listaMaterial = new ArrayList<>();
        try {
            String sql = "select * from Material WHERE nombre like '" + input + "%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Material m = new Material();
                m.setIdMaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setUnidad(rs.getString(3));
                Grupo grupo = new Grupo();
                int idGrupo = rs.getInt(4);
                if (idGrupo == 0) {
                    grupo.setNombre("------");
                } else {
                    String sql2 = "select nombre from\n"
                            + "Grupo where\n"
                            + "idGrupo=" + idGrupo;
                    PreparedStatement statement1 = this.connect.prepareStatement(sql2);
                    ResultSet rs2 = statement1.executeQuery();
                    while (rs2.next()) {
                        grupo.setNombre(rs2.getString(1));
                    }
                }
                m.setGrupo(grupo);
                listaMaterial.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMaterial;
    }
}
