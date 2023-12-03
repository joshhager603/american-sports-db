import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PlaysIn {
    public static void assignTeamToCity(int teamId, int cityId, boolean active, String connectionUrl) {

        String callStoredProc = "{call dbo.assignTeamToCity(?,?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, teamId);
            prepsStoredProc.setInt(2, cityId);
            prepsStoredProc.setBoolean(3, active);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setActiveStatus(int team_id, int city_id, boolean active, String connectionUrl){
        String callStoredProc = "{call dbo.setActiveStatus(?,?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, city_id);
            prepsStoredProc.setInt(2, team_id);
            prepsStoredProc.setBoolean(3, active);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
