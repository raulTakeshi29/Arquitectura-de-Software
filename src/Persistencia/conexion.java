package Persistencia;
import java.sql.DriverManager;

public class conexion {
    private static java.sql.Connection connect;
    public static java.sql.Connection getInstance() {
        if (connect == null) {
            try {
                System.out.println("Cargando base de datos...");
                String driver="com.mysql.jdbc.Driver";
                Class.forName(driver); 
                connect = DriverManager.getConnection("jdbc:mysql://localhost/constructora", "root", "savasroman29");
                if(connect!=null){
                    System.out.println("Conexión Establecida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return connect;
    }
                                      
}
