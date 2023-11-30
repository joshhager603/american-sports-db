import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cities {
    public static void insertCity(String name, String state, int population, String connectionUrl){

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

    public static void deleteCity(String name, String connectionUrl){

        String callStoredProc = "{call dbo.deleteCity(?)}";
        
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {
                
            prepsStoredProc.setString(1, name);
            
            prepsStoredProc.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCityPop(String name, int newPop, String connectionUrl){

        String callStoredProc = "{call dbo.updateCityPop(?, ?)}";
        
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {
                
            prepsStoredProc.setString(1, name);
            prepsStoredProc.setInt(2, newPop);
            
            prepsStoredProc.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
