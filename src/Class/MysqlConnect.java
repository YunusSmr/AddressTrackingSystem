package Class;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author yunus
 */
public class MysqlConnect {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressproject", "root", "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return con;

    }
    

}
