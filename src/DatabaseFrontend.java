import java.util.Scanner;

public class DatabaseFrontend {
    private static String connectionUrl = "jdbc:sqlserver://cxp-sql-02\\jrh236;"
                + "database=AmericanSports;"
                + "user=dbuser;"
                + "password= @StrongPa55word;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=15;";

    public static void mainMenu(){
        System.out.print("\nWelcome to the American Sports Database. What would you like to query?\n"+
                         "0. Exit Program\n" +
                         "1. Cities\n" +
                         "\n" +
                         "Choice: ");
    }

    public static void citiesMenu(){
        System.out.print("\nWhat would you like to do?\n"+
                         "0. Back\n" +
                         "1. Add a city\n" +
                         "2. Delete a city\n" +
                         "3. Update the population of a city\n" +
                         "\n" +
                         "Choice: ");
    }

    public static void insertCityMenu(Scanner s){
        System.out.print("\nName: ");
        String name = s.nextLine();

        System.out.print("\nState: ");
        String state = s.nextLine();

        System.out.print("\nPopulation: ");
        int population = s.nextInt();

        Cities.insertCity(name, state, population, connectionUrl);

        System.out.print("\nSuccessfully added " + name + "!");
    }

    public static void deleteCityMenu(Scanner s){
        System.out.print("\nCity: ");
        String name = s.nextLine();

        System.out.println(name);

        Cities.deleteCity(name, connectionUrl);
        System.out.print("\nSuccessfully deleted " + name + ".");
    }

    public static void updateCityPopMenu(Scanner s){
        System.out.print("\nCity: ");
        String name = s.nextLine();

        System.out.print("\nNew population: ");
        int newPop = s.nextInt();

        System.out.println(name);
        System.out.println(newPop);

        Cities.updateCityPop(name, newPop, connectionUrl);
        System.out.print("\nSuccessfully updated " + name + "!");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        StateMachine stateMachine = new StateMachine(s);

        mainMenu();

       while(true){
            String input = s.nextLine();

            stateMachine.feed(input);

            if(stateMachine.getCurrentState().equals("exit")){
                break;
            }
        }

        s.close();
    }
}