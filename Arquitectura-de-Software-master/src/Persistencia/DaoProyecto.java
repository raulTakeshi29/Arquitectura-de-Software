package Persistencia;

import Logica.Encargado;
import Logica.Etapa;
import Logica.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoProyecto implements IDao<Proyecto>{
    private Connection connect = conexion.getInstance();

    @Override
    public void insertar(Proyecto p) {
        try {
            String sql = "INSERT INTO proyecto (nombre,idencargado,idetapa) VALUES(?,?,?)";
            PreparedStatement ps = this.connect.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getEncargado().getIdEncargado());
            ps.setInt(3, p.getEtapa().getIdEtapa());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Proyecto p) {
        try {
            String sql = "UPDATE proyecto SET nombre=" +p.getNombre() + ",idencargado="+p.getEncargado().getIdEncargado()+ ","
                    + "idetapa="+p.getEtapa().getIdEtapa()+ " WHERE idproyecto="+p.getIdProyecto()+ ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proyecto buscar(int id) {
        try {
            Statement statement = this.connect.createStatement();
            ResultSet rs = statement.executeQuery("select * from Proyecto where idProyecto="+id+";");
            if (rs.next()) {
                Proyecto p= new Proyecto();
                p.setIdProyecto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                Encargado encargado = new Encargado();
                int idEncargado = rs.getInt(3);
                if (idEncargado == 0) {
                    encargado.setNombre("------");
                } else {
                    String sql2 = "select nombre from\n"
                            + "Encargado where\n"
                            + "idencargado="+idEncargado;
                    PreparedStatement statement1 = this.connect.prepareStatement(sql2);
                    ResultSet rs2 = statement1.executeQuery();
                    while (rs2.next()) {
                        encargado.setNombre(rs2.getString(1));
                    }
                }
                p.setEncargado(encargado);
                Etapa etapa= new Etapa();
                int idEtapa = rs.getInt(4);
                if (idEtapa== 0) {
                    etapa.setNombre("------");
                } else {
                    String sql3 = "select nombre from\n"
                            + "Etapa where\n"
                            + "idetapa="+idEtapa;
                    PreparedStatement statement2 = this.connect.prepareStatement(sql3);
                    ResultSet rs3 = statement2.executeQuery();
                    while (rs3.next()) {
                        etapa.setNombre(rs3.getString(1));
                    }
                }
                p.setEtapa(etapa);
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void eliminar(Proyecto p) {
        try {
            String sql = "delete from Proyecto where idProyecto=" +p.getIdProyecto()+ ";";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Proyecto> listado() {
        List<Proyecto> listaProyecto= new ArrayList<>();
        try {
            String sql = "select*from Proyecto";

            PreparedStatement statement = this.connect.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Proyecto p= new Proyecto();
                p.setIdProyecto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                Encargado encargado = new Encargado();
                int idEncargado = rs.getInt(3);
                if (idEncargado == 0) {
                    encargado.setNombre("------");
                } else {
                    String sql2 = "select nombre from\n"
                            + "Encargado where\n"
                            + "idencargado="+idEncargado;
                    PreparedStatement statement1 = this.connect.prepareStatement(sql2);
                    ResultSet rs2 = statement1.executeQuery();
                    while (rs2.next()) {
                        encargado.setNombre(rs2.getString(1));
                    }
                }
                p.setEncargado(encargado);
                Etapa etapa= new Etapa();
                int idEtapa = rs.getInt(4);
                if (idEtapa== 0) {
                    etapa.setNombre("------");
                } else {
                    String sql3 = "select nombre from\n"
                            + "Etapa where\n"
                            + "idetapa="+idEtapa;
                    PreparedStatement statement2 = this.connect.prepareStatement(sql3);
                    ResultSet rs3 = statement2.executeQuery();
                    while (rs3.next()) {
                        etapa.setNombre(rs3.getString(1));
                    }
                }
                p.setEtapa(etapa);
                listaProyecto.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProyecto;
    }

    @Override
    public List<Proyecto> listadoPorNombre(String input) {
        List<Proyecto> listaProyecto = new ArrayList<>();
        try {
            String sql = "select * from Proyecto WHERE nombre like '" + input + "%';";
            PreparedStatement statement = this.connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Proyecto p= new Proyecto();
                p.setIdProyecto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                Encargado encargado = new Encargado();
                int idEncargado = rs.getInt(3);
                if (idEncargado == 0) {
                    encargado.setNombre("------");
                } else {
                    String sql2 = "select nombre from\n"
                            + "Encargado where\n"
                            + "idencargado="+idEncargado;
                    PreparedStatement statement1 = this.connect.prepareStatement(sql2);
                    ResultSet rs2 = statement1.executeQuery();
                    while (rs2.next()) {
                        encargado.setNombre(rs2.getString(1));
                    }
                }
                p.setEncargado(encargado);
                Etapa etapa= new Etapa();
                int idEtapa = rs.getInt(4);
                if (idEtapa== 0) {
                    etapa.setNombre("------");
                } else {
                    String sql3 = "select nombre from\n"
                            + "Etapa where\n"
                            + "idetapa="+idEtapa;
                    PreparedStatement statement2 = this.connect.prepareStatement(sql3);
                    ResultSet rs3 = statement2.executeQuery();
                    while (rs3.next()) {
                        etapa.setNombre(rs3.getString(1));
                    }
                }
                p.setEtapa(etapa);
                listaProyecto.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProyecto;
    }

    
}
