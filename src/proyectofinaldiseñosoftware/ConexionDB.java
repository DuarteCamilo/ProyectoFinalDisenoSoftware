
package proyectofinaldiseñosoftware;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diazje
 */
public class ConexionDB {
    
    private final String base = "base";
    private final String user = "root";
    private final String password = "";

    private final String url = "jdbc:mariadb://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch(SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;        
    } 
}
