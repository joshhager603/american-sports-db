import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cities {
    public static void insertCity(String name, String state, int population, String connectionUrl) {

        String callStoredProc = "{call dbo.insertCity(?,?,?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setString(1, name);
            prepsStoredProc.setString(2, state);
            prepsStoredProc.setInt(3, population);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCity(int id, String connectionUrl) {

        String callStoredProc = "{call dbo.deleteCity(?)}";

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

    public static void updateCityPop(int id, int newPop, String connectionUrl) {

        String callStoredProc = "{call dbo.updateCityPop(?, ?)}";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, id);
            prepsStoredProc.setInt(2, newPop);
            prepsStoredProc.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<String>> getAllCities(String connectionUrl) {

        String callStoredProc = "{call dbo.getAllCities()}";

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

    public static ArrayList<ArrayList<String>> getCity(String name, String connectionUrl) {

        String callStoredProc = "{call dbo.getCity(?)}";

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

    public static ArrayList<ArrayList<String>> getArenasInCity(int id, String connectionUrl) {

        String callStoredProc = "{call dbo.getArenasInCity(?)}";

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, id);
            prepsStoredProc.execute();

            ResultSet rs = prepsStoredProc.getResultSet();

            table = RSParser.getTable(rs);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return table;
    }

    public static ArrayList<ArrayList<String>> getActiveTeamsInCity(int id, String connectionUrl) {

        String callStoredProc = "{call dbo.getActiveTeamsInCity(?)}";

        ArrayList<ArrayList<String>> table = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                CallableStatement prepsStoredProc = connection.prepareCall(callStoredProc);) {

            connection.setAutoCommit(false);

            prepsStoredProc.setInt(1, id);
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
