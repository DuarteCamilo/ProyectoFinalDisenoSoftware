
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

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Genial, estamos en linea");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionDB app = new ConexionDB();
        app.connect();
    }
}
