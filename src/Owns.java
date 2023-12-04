import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Owns {
    public static void assignOwnerToTeam(int ownerId, int teamId, String connectionUrl) {

        String callStoredProc = "{call dbo.assignOwnerToTeam(?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, ownerId);
            prepsStoredProc.setInt(2, teamId);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
