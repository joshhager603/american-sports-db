import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Arena {
    public static void insertArena(int cityId, String name, int yearOpened, String connectionUrl) {

        String callStoredProc = "{call dbo.insertArena(?,?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, cityId);
            prepsStoredProc.setString(2, name);
            prepsStoredProc.setInt(3, yearOpened);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteArena(int id, String connectionUrl) {

        String callStoredProc = "{call dbo.deleteArena(?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, id);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateArenaName(int id, String name, String connectionUrl){
        String callStoredProc = "{call dbo.updateArenaName(?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, id);
            prepsStoredProc.setString(2, name);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateArenaYearOpened(int id, int year_opened, String connectionUrl){
        String callStoredProc = "{call dbo.updateArenaYearOpened(?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, id);
            prepsStoredProc.setInt(2, year_opened);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<String>> getAllArenas(String connectionUrl){
        String callStoredProc = "{call dbo.getAllArenas()}";

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

    public static ArrayList<ArrayList<String>> getArena(String name, String connectionUrl) {

        String callStoredProc = "{call dbo.getArena(?)}";

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setString(1, name);
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
