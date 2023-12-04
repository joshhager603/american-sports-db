import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StanleyCup {
    public static void insertStanleyCup(int year, int teamId, String connectionUrl){
        String callStoredProc = "{call dbo.insertStanleyCup(?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, year);
            prepsStoredProc.setInt(2, teamId);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStanleyCup(int year, String connectionUrl) {

        String callStoredProc = "{call dbo.deleteStanleyCup(?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, year);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStanleyCupWinner(int year, int winnerId, String connectionUrl){
        String callStoredProc = "{call dbo.updateStanleyCupWinner(?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, year);
            prepsStoredProc.setInt(2, winnerId);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<String>> getAllStanleyCups(String connectionUrl) {

        String callStoredProc = "{call dbo.getAllStanleyCups()}";

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.execute();

            ResultSet rs = prepsStoredProc.getResultSet();

            table = RSParser.getTable(rs);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }

    public static ArrayList<ArrayList<String>> getStanleyCupWinner(int year, String connectionUrl) {

        String callStoredProc = "{call dbo.getStanleyCupWinner(?)}";

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, year);
            prepsStoredProc.execute();

            ResultSet rs = prepsStoredProc.getResultSet();

            table = RSParser.getTable(rs);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }

    public static ArrayList<ArrayList<String>> getStanleyCupsWon(int winner_id, String connectionUrl) {

        String callStoredProc = "{call dbo.getStanleyCupsWon(?)}";

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, winner_id);
            prepsStoredProc.execute();

            ResultSet rs = prepsStoredProc.getResultSet();

            table = RSParser.getTable(rs);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }
}