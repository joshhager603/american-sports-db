import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NbaChampionship {
    public static void insertNBAChampionship(int year, int teamId, String connectionUrl){
        String callStoredProc = "{call dbo.insertNBAChampionship(?,?)}";

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

    public static void deleteNBAChampionship(int year, String connectionUrl) {

        String callStoredProc = "{call dbo.deleteNBAChampionship(?)}";

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

    public static void updateNBAChampionshipWinner(int year, int winnerId, String connectionUrl){
        String callStoredProc = "{call dbo.updateNBAChampionshipWinner(?,?)}";

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

    public static ArrayList<ArrayList<String>> getAllNBAChampionships(String connectionUrl) {

        String callStoredProc = "{call dbo.getAllNBAChampionships()}";

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

    public static ArrayList<ArrayList<String>> getNBAChampionshipWinner(int year, String connectionUrl) {

        String callStoredProc = "{call dbo.getNBAChampionshipWinner(?)}";

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

    public static ArrayList<ArrayList<String>> getNBAChampionshipsWon(int winner_id, String connectionUrl) {

        String callStoredProc = "{call dbo.getNBAChampionshipsWon(?)}";

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