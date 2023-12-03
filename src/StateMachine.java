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
        {   "main",       "3",     "team",      "teamMenu"                  }, 
        {   "cities",     "0",     "main",      "mainMenu"                  },
        {   "cities",     "1",     "cities",    "insertCity"                },
        {   "cities",     "2",     "cities",    "deleteCity"                },
        {   "cities",     "3",     "cities",    "updateCityPop"             },
        {   "cities",     "4",     "cities",    "getAllCities"              },
        {   "cities",     "5",     "cities",    "getCity"                   },
        {   "cities",     "6",     "cities",    "getArenasInCity"           },
        {   "cities",     "7",     "cities",    "getActiveTeamsInCity"      },
        {   "arena",      "0",     "main",      "mainMenu"                  },
        {   "arena",      "1",     "arena",     "insertArena"               },
        {   "arena",      "2",     "arena",     "deleteArena"               },
        {   "arena",      "3",     "arena",     "updateArenaName"           },
        {   "arena",      "4",     "arena",     "updateArenaYearOpened"     },
        {   "arena",      "5",     "arena",     "getAllArenas"              },
        {   "arena",      "6",     "arena",     "getArena"                  },
        {   "team",       "0",     "main",      "mainMenu"                  },
        {   "team",       "1",     "team",      "insertTeam"                },
        {   "team",       "2",     "team",      "deleteTeam"                },
        {   "team",       "3",     "team",      "updateTeamName"            },
        {   "team",       "4",     "team",      "updateTeamDivision"        },
        {   "team",       "5",     "team",      "updateTeamMascot"          },
        {   "team",       "6",     "team",      "updateTeamValuation"       },
        {   "team",       "7",     "team",      "getAllTeams"               },
        {   "team",       "8",     "team",      "getTeam"                   },
        {   "team",       "9",     "team",      "assignTeamToCity"          },
        {   "team",       "10",    "team",      "setActiveStatus"           },
        {   "team",       "11",    "team",      "getActiveCity"             }
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
            case "getArenasInCity":
                DatabaseFrontend.getArenasInCityMenu(s);
                DatabaseFrontend.citiesMenu();
                break;
            case "getActiveTeamsInCity":
                DatabaseFrontend.getActiveTeamsInCityMenu(s);
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
            case "teamMenu":
                DatabaseFrontend.teamMenu();
                break;
            case "insertTeam":
                DatabaseFrontend.insertTeamMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "deleteTeam":
                DatabaseFrontend.deleteTeamMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "updateTeamName":
                DatabaseFrontend.updateTeamNameMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "updateTeamDivision":
                DatabaseFrontend.updateTeamDivisionMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "updateTeamMascot":
                DatabaseFrontend.updateTeamMascotMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "updateTeamValuation":
                DatabaseFrontend.updateTeamValuationMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "getAllTeams":
                DatabaseFrontend.getAllTeamsMenu();
                DatabaseFrontend.teamMenu();
                break;
            case "getTeam":
                DatabaseFrontend.getTeamMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "assignTeamToCity":
                DatabaseFrontend.assignTeamToCityMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "setActiveStatus":
                DatabaseFrontend.setActiveStatusMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "getActiveCity":
                DatabaseFrontend.getActiveCityMenu(s);
                DatabaseFrontend.teamMenu();
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
