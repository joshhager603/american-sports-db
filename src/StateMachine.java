import java.util.Scanner;

public class StateMachine {
    
    private String currentState = "main";

    private Scanner s;

    private final String[][] transitionTable = new String[][] 
    {
    //      Current      Input       Next           onTransition
    //   +------------+----------+-----------+--------------------------+
        {   "main",       "0",     "exit",      "none"                      },
        {   "main",       "1",     "cities",    "citiesMenu"                },
        {   "main",       "2",     "arena",     "arenaMenu"                 },
        {   "cities",     "0",     "main",      "mainMenu"                  },
        {   "cities",     "1",     "cities",    "insertCity"                },
        {   "cities",     "2",     "cities",    "deleteCity"                },
        {   "cities",     "3",     "cities",    "updateCityPop"             },
        {   "cities",     "4",     "cities",    "getAllCities"              },
        {   "cities",     "5",     "cities",    "getCity"                   },
        {   "arena",      "0",     "main",      "mainMenu"                  },
        {   "arena",      "1",     "arena",     "insertArena"               },
        {   "arena",      "2",     "arena",     "deleteArena"               },
        {   "arena",      "3",     "arena",     "updateArenaName"           },
        {   "arena",      "4",     "arena",     "updateArenaYearOpened"     },
        {   "arena",      "5",     "arena",     "getAllArenas"              },
        {   "arena",      "6",     "arena",     "getArena"                  }
    };

    public StateMachine(Scanner s){
        this.s = s;
    }

    public String feed(String input){
        for(int i = 0; i < transitionTable.length; i++){
            if(transitionTable[i][0].equals(currentState) && transitionTable[i][1].equals(input)){
                currentState = transitionTable[i][2];

                onTransition(transitionTable[i][3]);

                break;
            }
        }

        return currentState;
    }

    public void onTransition(String action){
        switch (action){
            case "mainMenu":
                DatabaseFrontend.mainMenu();
                break;
            case "citiesMenu":
                DatabaseFrontend.citiesMenu();
                break;
            case "insertCity":
                DatabaseFrontend.insertCityMenu(s);
                DatabaseFrontend.citiesMenu();
                break;
            case "deleteCity":
                DatabaseFrontend.deleteCityMenu(s);
                DatabaseFrontend.citiesMenu();
                break;
            case "updateCityPop":
                DatabaseFrontend.updateCityPopMenu(s);
                DatabaseFrontend.citiesMenu();
                break;
            case "getAllCities":
                DatabaseFrontend.getAllCitiesMenu();
                DatabaseFrontend.citiesMenu();
                break;
            case "getCity":
                DatabaseFrontend.getCityMenu(s);
                DatabaseFrontend.citiesMenu();
                break;
            case "arenaMenu":
                DatabaseFrontend.arenaMenu();
                break;
            case "insertArena":
                DatabaseFrontend.insertArenaMenu(s);
                DatabaseFrontend.arenaMenu();
                break;
            case "deleteArena":
                DatabaseFrontend.deleteArenaMenu(s);
                DatabaseFrontend.arenaMenu();
                break;
            case "updateArenaName":
                DatabaseFrontend.updateArenaNameMenu(s);
                DatabaseFrontend.arenaMenu();
                break;
            case "updateArenaYearOpened":
                DatabaseFrontend.updateArenaYearOpenedMenu(s);
                DatabaseFrontend.arenaMenu();
                break;
            case "getAllArenas":
                DatabaseFrontend.getAllArenasMenu();
                DatabaseFrontend.arenaMenu();
                break;
            case "getArena":
                DatabaseFrontend.getArenaMenu(s);
                DatabaseFrontend.arenaMenu();
                break;
            case "none":
                break;
        }
    }

    public String getCurrentState(){
        return currentState;
    }

    public void setCurrentState(String state){
        this.currentState = state;
    }
}
