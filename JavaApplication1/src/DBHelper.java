
/**
 *
 * @author Harun Serkan Metin
 */
import java.sql.*;

public class DBHelper {
    private String userName = "root";
    private String password = "1234";
    private String port="3306";
    private String schema = "flightapp";
    private String dbUrl = "jdbc:mysql://localhost:"+port+"/"+schema+"?useSSL=false&serverTimezone=UTC";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,userName,password);
    }    
    
    void showError(SQLException E){
        System.out.println("Error: "+ E.getMessage());
        System.out.println("Error Code: "+ E.getErrorCode());
    }
}
