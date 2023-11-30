public class DatabaseFrontend {
    private static String connectionUrl = "jdbc:sqlserver://cxp-sql-02\\jrh236;"
                + "database=AmericanSports;"
                + "user=dbuser;"
                + "password= @StrongPa55word;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=15;";

    // Connect to database.
    public static void main(String[] args) {
        Cities.updateCityPop("Detroit", 10, connectionUrl);
    }
}