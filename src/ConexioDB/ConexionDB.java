
package ConexioDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cduar
 */
public class ConexionDB{
    private final String url = "jdbc:postgresql://db.guijhwetrkvdjnnrsloj.supabase.co:5432/postgres?user=postgres&password=kmilo_1004826575";
    private static ConexionDB INSTANCE;
    private static Connection conn;


    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    private ConexionDB () {
        
        try {
            conn = DriverManager.getConnection(url);
            //System.out.println("Genial, estamos en linea");
        } catch (SQLException e) {
            //System.out.println(e.getCause());
        }
    }
    public static ConexionDB getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ConexionDB();
        }
        return INSTANCE;
    }
    public Connection getConnection(){
        return conn;
    }

   
}
