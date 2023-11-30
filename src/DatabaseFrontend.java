import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class DatabaseFrontend {
    private static String connectionUrl = "jdbc:sqlserver://cxp-sql-02\\jrh236;"
                + "database=AmericanSports;"
                + "user=dbuser;"
                + "password= @StrongPa55word;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=15;";

    public static void insertCity(String name, String state, int population){

        String callStoredProc = "{call dbo.insertCity(?,?,?)}";
        
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            prepsStoredProc.setString(1, name);
            prepsStoredProc.setString(2, state);
            prepsStoredProc.setInt(3, population);
            
            prepsStoredProc.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Connect to database.
    public static void main(String[] args) {
        insertCity("Detroit", "Michigan", 632464);
    }
}