import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SuperBowl {
    public static void insertSuperBowl(int year, int teamId, String connectionUrl){
        String callStoredProc = "{call dbo.insertSuperBowl(?,?)}";

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

    public static void deleteSuperBowl(int year, String connectionUrl) {

        String callStoredProc = "{call dbo.deleteSuperBowl(?)}";

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

    public static void updateSuperBowlWinner(int year, int winnerId, String connectionUrl){
        String callStoredProc = "{call dbo.updateSuperBowlWinner(?,?)}";

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

    public static ArrayList<ArrayList<String>> getAllSuperBowls(String connectionUrl) {

        String callStoredProc = "{call dbo.getAllSuperBowls()}";

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

    public static ArrayList<ArrayList<String>> getSuperBowlWinner(int year, String connectionUrl) {

        String callStoredProc = "{call dbo.getSuperBowlWinner(?)}";

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

    public static ArrayList<ArrayList<String>> getSuperBowlsWon(int winner_id, String connectionUrl) {

        String callStoredProc = "{call dbo.getSuperBowlsWon(?)}";

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