import java.util.Scanner;

public class StateMachine {
    
    private String currentState = "main";

    private Scanner s;

    private final String[][] transitionTable = new String[][] 
    {
    //      Current      Input       Next       onTransition
    //   +------------+----------+-----------+--------------------+
        {   "main",       "0",     "exit",      "none"               },
        {   "main",       "1",     "cities",    "citiesMenu"         },
        {   "cities",     "0",     "main",      "mainMenu"           },
        {   "cities",     "1",     "cities",    "insertCity"         },
        {   "cities",     "2",     "cities",    "deleteCity"         },
        {   "cities",     "3",     "cities",    "updateCityPop"      },
        {   "cities",     "4",     "cities",    "getAllCities"       },
        {   "cities",     "5",     "cities",    "getCity"            }
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
