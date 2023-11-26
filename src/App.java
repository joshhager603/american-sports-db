import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLWarning;

public class App {
    // Connect to database.
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://cxp-sql-02\\jrh236;"
                + "database=AmericanSports;"
                + "user=dbuser;"
                + "password= @StrongPa55word;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=15;";

        String execStoredProcSQL = "insert into cities(name, state, population) values ('Buffalo', 'New York', 276807)";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsExec = connection.prepareStatement(execStoredProcSQL);) {

            prepsExec.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}