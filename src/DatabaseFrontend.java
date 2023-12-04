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
                "3. Team\n" +
                "7. Owner\n" + 
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
                "6. View all arenas in a specific city\n" +
                "7. View all active teams in a specific city\n" +
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

    public static void getArenasInCityMenu(Scanner s) {
        System.out.print("\nCity ID: ");
        int id = s.nextInt();

        ArrayList<ArrayList<String>> arenasInCity = Cities.getArenasInCity(id, connectionUrl);

        printTable(arenasInCity);
    }

    public static void getActiveTeamsInCityMenu(Scanner s) {
        System.out.print("\nCity ID: ");
        int id = s.nextInt();

        ArrayList<ArrayList<String>> activeTeamsInCity = Cities.getActiveTeamsInCity(id, connectionUrl);

        printTable(activeTeamsInCity);
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

    
    // ---------------------------- TEAM ------------------------------- //
    public static void teamMenu() {
        System.out.print("\nWhat would you like to do?\n" +
                "0. Back\n" +
                "1. Add a team\n" +
                "2. Delete a team\n" +
                "3. Update the name of a team\n" +
                "4. Update the division of a team\n" +
                "5. Update the mascot of a team\n" +
                "6. Update the valuation of a team\n" +
                "7. View all teams\n" +
                "8. View a specific team\n" +
                "9. Assign a team to a city\n" +
                "10. Set the active status of a team in a city\n" +
                "11. View the city a team is active in\n" +
                "\n" +
                "Choice: ");
    }

    public static void insertTeamMenu(Scanner s) {
        System.out.print("\nID of Arena: ");
        int arenaId = s.nextInt();
        s.nextLine();

        System.out.print("\nName: ");
        String name = s.nextLine();

        System.out.print("\nLeague: ");
        String league = s.nextLine();

        System.out.print("\nYear Founded: ");
        int yearFounded = s.nextInt();
        s.nextLine();

        System.out.print("\nNumber of Championships: ");
        int championships = s.nextInt();
        s.nextLine();

        System.out.print("\nDivision: ");
        String division = s.nextLine();

        System.out.print("\nMascot: ");
        String mascot = s.nextLine();

        System.out.print("\nValuation: ");
        long valuation = s.nextLong();

        Team.insertTeam(arenaId, name, league, yearFounded, championships, division, mascot, valuation, connectionUrl);

        System.out.print("\nSuccessfully added " + name + "!\n");
    }

    public static void deleteTeamMenu(Scanner s) {
        System.out.print("\nTeam ID: ");
        int id = s.nextInt();
        s.nextLine();

        Team.deleteTeam(id, connectionUrl);

        System.out.print("\nSuccessfully deleted team with ID " + id + ".\n");
    }

    public static void updateTeamNameMenu(Scanner s) {
        System.out.print("\nTeam ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\nNew name: ");
        String newName = s.nextLine();

        Team.updateTeamName(id, newName, connectionUrl);

        System.out.print("\nSuccessfully updated team with ID " + id + "!\n");
    }

    public static void updateTeamDivisionMenu(Scanner s) {
        System.out.print("\nTeam ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\nNew division: ");
        String newDivision = s.nextLine();

        Team.updateTeamDivision(id, newDivision, connectionUrl);

        System.out.print("\nSuccessfully updated team with ID " + id + "!\n");
    }

    public static void updateTeamMascotMenu(Scanner s) {
        System.out.print("\nTeam ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\nNew mascot: ");
        String newMascot = s.nextLine();

        Team.updateTeamMascot(id, newMascot, connectionUrl);

        System.out.print("\nSuccessfully updated team with ID " + id + "!\n");
    }

    public static void updateTeamValuationMenu(Scanner s) {
        System.out.print("\nTeam ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\nNew valuation: ");
        long newValuation = s.nextLong();

        Team.updateTeamValuation(id, newValuation, connectionUrl);

        System.out.print("\nSuccessfully updated team with ID " + id + "!\n");
    }

    public static void getAllTeamsMenu() {
        ArrayList<ArrayList<String>> arenas = Team.getAllTeams(connectionUrl);

        printTable(arenas);
    }

    public static void getTeamMenu(Scanner s) {
        System.out.print("\nTeam: ");
        String name = s.nextLine();

        ArrayList<ArrayList<String>> team = Team.getTeam(name, connectionUrl);

        printTable(team);
    }

    public static void assignTeamToCityMenu(Scanner s) {
        System.out.print("\nID of Team: ");
        int teamId = s.nextInt();
        s.nextLine();

        System.out.print("\nID of City: ");
        int cityId = s.nextInt();
        s.nextLine();

        System.out.print("\nIs this team active in this city? (y/n): ");
        String activeString = s.nextLine();
        boolean active = activeString.equals("y") ? true : false;

        PlaysIn.assignTeamToCity(teamId, cityId, active, connectionUrl);

        System.out.print("\nSuccessfully assigned team ID " + teamId + " to city ID " + cityId + "!\n");
    }

    public static void setActiveStatusMenu(Scanner s) {
        System.out.print("\nID of Team: ");
        int teamId = s.nextInt();
        s.nextLine();

        System.out.print("\nID of City: ");
        int cityId = s.nextInt();
        s.nextLine();

        System.out.print("\nIs this team active in this city? (y/n): ");
        String activeString = s.nextLine();
        boolean active = activeString.equals("y") ? true : false;

        PlaysIn.setActiveStatus(teamId, cityId, active, connectionUrl);

        System.out.print("\nSuccessfully set the status of team ID " + teamId + " in city ID " + cityId + "!\n");
    }

    public static void getActiveCityMenu(Scanner s) {
        System.out.print("\nID of Team: ");
        int teamId = s.nextInt();

        ArrayList<ArrayList<String>> team = Team.getActiveCity(teamId, connectionUrl);

        printTable(team);
    }
    // ----------------------------------------------------------------- //

    // ---------------------------- Owner ------------------------------ //

    public static void ownerMenu() {
        System.out.print("\nWhat would you like to do?\n" +
                "0. Back\n" +
                "1. Add an owner\n" +
                "2. Delete an owner/ownership group\n" +
                "3. Update an owner/ownership group\n" +
                "4. View all owners\n" +
                "5. View all single owners\n" +
                "6. View all ownership groups\n" +
                "7. Assign owner to team\n" +
                "8. Update owner and acquisition value\n" +
                "9. Get owners from a league" + 
                "\n" +
                "Choice: ");
    }

    public static void insertOwnerMenu(Scanner s) {
        System.out.print("\n1. Owner 2. Owner Group \n");
        int ownerOption = s.nextInt();
        s.nextLine();

        System.out.print("\nName: ");
        String name = s.nextLine();

        if(ownerOption == 1){
            Owner.insertOwner(name, null, connectionUrl);
            System.out.print("\nSuccessfully added " + name + "!\n");
        }
        else if (ownerOption == 2){
            Owner.insertOwner(null, name, connectionUrl);
            System.out.print("\nSuccessfully added " + name + "!\n");
        }
    }

    public static void deleteOwnerMenu(Scanner s) {
        System.out.print("\nOwner ID: ");
        int id = s.nextInt();

        Owner.deleteOwner(id, connectionUrl);

        System.out.print("\nSuccessfully deleted owner with ID " + id + ".\n");
    }

    public static void updateOwnerMenu(Scanner s) {
        System.out.print("\nOwner ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("\n1. Owner 2. Owner Group \n");
        int ownerOption = s.nextInt();
        s.nextLine();

        System.out.print("\nName: ");
        String name = s.nextLine();

        if(ownerOption == 1){
            Owner.updateOwner(id, name, null, connectionUrl);
            System.out.print("\nSuccessfully updated " + name + "!\n");
        }
        else if (ownerOption == 2){
            Owner.updateOwner(id, null, name, connectionUrl);
            System.out.print("\nSuccessfully updated " + name + "!\n");
        }
    }

   public static void getAllOwnersMenu() {
        ArrayList<ArrayList<String>> owners = Owner.getAllOwners(connectionUrl);
        
        printTable(owners);
    }

    public static void getOwnersMenu() {
        ArrayList<ArrayList<String>> owners = Owner.getOwners(connectionUrl);

        printTable(owners);
    }

    public static void getOwnerGroupsMenu() {
        ArrayList<ArrayList<String>> owners = Owner.getOwnerGroups(connectionUrl);

        printTable(owners);
    }

    public static void assignOwnerMenu(Scanner s){
        System.out.print("\nOwner ID: ");
        int ownerId = s.nextInt();
        s.nextLine();

        System.out.print("\nTeam ID: ");
        int teamId = s.nextInt();
        s.nextLine();

        Owns.assignOwnerToTeam(ownerId, teamId, connectionUrl);

        System.out.print("Assigned!");
    }

    public static void updateOwnerAndAcquisitionMenu(Scanner s){
        System.out.print("\nOwner ID: ");
        int owner_id = s.nextInt();
        s.nextLine();

        System.out.print("\nTeam ID: ");
        int team_id = s.nextInt();
        s.nextLine();

        System.out.print("\n1. Owner 2. Owner Group \n");
        int ownerOption = s.nextInt();
        s.nextLine();

        System.out.print("\nName: ");
        String name = s.nextLine();

        System.out.print("\nAcquisition Cost: ");
        int valuation = s.nextInt();
        s.nextLine();

        if(ownerOption == 1){
            Owner.updateOwnerAndAcquisition(owner_id, team_id, name, null, valuation, connectionUrl);
            System.out.print("\nSuccessfully updated " + name + " for a cost of " + valuation +"!\n");
        }
        else if (ownerOption == 2){
            Owner.updateOwnerAndAcquisition(owner_id, team_id, null, name, valuation, connectionUrl);
            System.out.print("\nSuccessfully updated " + name + " for a cost of " + valuation +"!\n");
        }
    }

    public static void getLeagueOwnersMenu(Scanner s){
        System.out.print("League: ");
        String league = s.nextLine();
        ArrayList<ArrayList<String>> owners = Owner.getLeagueOwners(league, connectionUrl);
        printTable(owners);
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