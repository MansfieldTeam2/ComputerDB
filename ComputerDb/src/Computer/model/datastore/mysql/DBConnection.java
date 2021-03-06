package Computer.model.datastore.mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBConnection {

    /**
     * This method connects to and checks the connection to the database.
     * @return 
     */
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;
        try {
            props.load(new FileInputStream("res/mysql/db.properties"));
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            con = DriverManager.getConnection(
                    props.getProperty("DB_URL")
                    + "?user=" + props.getProperty("DB_USERNAME")
                    + "&password=" + props.getProperty("DB_PASSWORD")
                    + "&useSSL=" + props.getProperty("USE_SSL"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("db error in getConnection()");
        }
        return con;
    }

    public static void main(String[] args) {
        getConnection();
    }
}