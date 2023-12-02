import java.util.Scanner;
import java.util.ArrayList;

public class DatabaseFrontend {
    private static String connectionUrl = "jdbc:sqlserver://cxp-sql-02\\jrh236;"
            + "database=AmericanSports;"
            + "user=dbuser;"
            + "password= @StrongPa55word;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "loginTimeout=15;";

    public static void mainMenu() {
        System.out.print("\nWelcome to the American Sports Database. What would you like to query?\n" +
                "0. Exit Program\n" +
                "1. Cities\n" +
                "2. Arena\n" +
                "\n" +
                "Choice: ");
    }

    // ---------------------------- CITIES ----------------------------- //
    public static void citiesMenu() {
        System.out.print("\nWhat would you like to do?\n" +
                "0. Back\n" +
                "1. Add a city\n" +
                "2. Delete a city\n" +
                "3. Update the population of a city\n" +
                "4. View all cities\n" +
                "5. View a specific city\n" +
                "\n" +
                "Choice: ");
    }

    public static void insertCityMenu(Scanner s) {
        System.out.print("\nName: ");
        String name = s.nextLine();

        System.out.print("\nState: ");
        String state = s.nextLine();

        System.out.print("\nPopulation: ");
        int population = s.nextInt();

        Cities.insertCity(name, state, population, connectionUrl);

        System.out.print("\nSuccessfully added " + name + "!\n");
    }

    public static void deleteCityMenu(Scanner s) {
        System.out.print("\nCity ID: ");
        int id = s.nextInt();

        Cities.deleteCity(id, connectionUrl);

        System.out.print("\nSuccessfully deleted city with ID " + id + ".\n");
    }

    public static void updateCityPopMenu(Scanner s) {
        System.out.print("\nCity ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\nNew population: ");
        int newPop = s.nextInt();

        Cities.updateCityPop(id, newPop, connectionUrl);

        System.out.print("\nSuccessfully updated city with ID " + id + "!\n");
    }

    public static void getAllCitiesMenu() {
        ArrayList<ArrayList<String>> cities = Cities.getAllCities(connectionUrl);

        printTable(cities);
    }

    public static void getCityMenu(Scanner s) {
        System.out.print("\nCity: ");
        String name = s.nextLine();

        ArrayList<ArrayList<String>> city = Cities.getCity(name, connectionUrl);

        printTable(city);
    }
    // ----------------------------------------------------------------- //

    
    // ---------------------------- ARENA ----------------------------- //
    public static void arenaMenu() {
        System.out.print("\nWhat would you like to do?\n" +
                "0. Back\n" +
                "1. Add an arena\n" +
                "2. Delete an arena\n" +
                "3. Update the name of an arena\n" +
                "4. Update the year an arena was opened\n" +
                "5. View all arenas\n" +
                "6. View a specific arena\n" +
                "\n" +
                "Choice: ");
    }

    public static void insertArenaMenu(Scanner s) {
        System.out.print("\nID of City: ");
        int cityId = s.nextInt();
        s.nextLine();

        System.out.print("\nName: ");
        String name = s.nextLine();

        System.out.print("\nYear Opened: ");
        int yearOpened = s.nextInt();

        Arena.insertArena(cityId, name, yearOpened, connectionUrl);

        System.out.print("\nSuccessfully added " + name + "!\n");
    }

    public static void deleteArenaMenu(Scanner s) {
        System.out.print("\nArena ID: ");
        int id = s.nextInt();
        s.nextLine();

        Arena.deleteArena(id, connectionUrl);

        System.out.print("\nSuccessfully deleted arena with ID " + id + ".\n");
    }

    public static void updateArenaNameMenu(Scanner s) {
        System.out.print("\nArena ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\nNew name: ");
        String newName = s.nextLine();

        Arena.updateArenaName(id, newName, connectionUrl);

        System.out.print("\nSuccessfully updated arena with ID " + id + "!\n");
    }

    public static void updateArenaYearOpenedMenu(Scanner s) {
        System.out.print("\nArena ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\nNew year opened: ");
        int newYearOpened = s.nextInt();

        Arena.updateArenaYearOpened(id, newYearOpened, connectionUrl);

        System.out.print("\nSuccessfully updated arena with ID " + id + "!\n");
    }

    public static void getAllArenasMenu() {
        ArrayList<ArrayList<String>> arenas = Arena.getAllArenas(connectionUrl);

        printTable(arenas);
    }

    public static void getArenaMenu(Scanner s) {
        System.out.print("\nArena: ");
        String name = s.nextLine();

        ArrayList<ArrayList<String>> arena = Arena.getArena(name, connectionUrl);

        printTable(arena);
    }
    // ----------------------------------------------------------------- //

    public static void printTable(ArrayList<ArrayList<String>> table) {
        System.out.print("\n");
        for (ArrayList<String> row : table) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        StateMachine stateMachine = new StateMachine(s);

        mainMenu();

        while (true) {
            String input = s.nextLine();

            stateMachine.feed(input);

            if (stateMachine.getCurrentState().equals("exit")) {
                break;
            }
        }

        s.close();
    }
}