import java.util.Scanner;


public class StateMachine {
    
    private String currentState = "main";

    private Scanner s;

    private final String[][] transitionTable = new String[][] 
    {
    //      Current            Input       Next                     onTransition
    //   +------------------+----------+-----------------+----------------------------------+
        {   "main",             "0",     "exit",                    "none"                          },
        {   "main",             "1",     "cities",                  "citiesMenu"                    },
        {   "main",             "2",     "arena",                   "arenaMenu"                     },
        {   "main",             "3",     "team",                    "teamMenu"                      }, 
        {   "main",             "4",     "super_bowl",              "superBowlMenu"                 }, 
        {   "main",             "5",     "nba_championship",        "nbaChampionshipMenu"           },
        {   "main",             "6",     "stanley_cup",             "stanleyCupMenu"                },
        {   "main",             "7",     "owner",                   "ownerMenu"                     },
        {   "cities",           "0",     "main",                    "mainMenu"                      },  
        {   "cities",           "1",     "cities",                  "insertCity"                    },
        {   "cities",           "2",     "cities",                  "deleteCity"                    },
        {   "cities",           "3",     "cities",                  "updateCityPop"                 },
        {   "cities",           "4",     "cities",                  "getAllCities"                  },
        {   "cities",           "5",     "cities",                  "getCity"                       },
        {   "cities",           "6",     "cities",                  "getArenasInCity"               },
        {   "cities",           "7",     "cities",                  "getActiveTeamsInCity"          },
        {   "cities",           "8",     "cities",                  "deleteCitiesNoTeams"           },
        {   "cities",           "9",     "cities",                  "getCitiesNoTeams"              },
        {   "cities",           "10",    "cities",                  "getWinsByCity"                 },
        {   "arena",            "0",     "main",                    "mainMenu"                      },
        {   "arena",            "1",     "arena",                   "insertArena"                   },
        {   "arena",            "2",     "arena",                   "deleteArena"                   },
        {   "arena",            "3",     "arena",                   "updateArenaName"               },
        {   "arena",            "4",     "arena",                   "updateArenaYearOpened"         },
        {   "arena",            "5",     "arena",                   "getAllArenas"                  },
        {   "arena",            "6",     "arena",                   "getArena"                      },
        {   "team",             "0",     "main",                    "mainMenu"                      },
        {   "team",             "1",     "team",                    "insertTeam"                    },
        {   "team",             "2",     "team",                    "deleteTeam"                    },
        {   "team",             "3",     "team",                    "updateTeamName"                },
        {   "team",             "4",     "team",                    "updateTeamDivision"            },
        {   "team",             "5",     "team",                    "updateTeamMascot"              },
        {   "team",             "6",     "team",                    "updateTeamValuation"           },
        {   "team",             "7",     "team",                    "getAllTeams"                   },
        {   "team",             "8",     "team",                    "getTeam"                       },
        {   "team",             "9",     "team",                    "assignTeamToCity"              },
        {   "team",             "10",    "team",                    "setActiveStatus"               },
        {   "team",             "11",    "team",                    "getActiveCity"                 },
        {   "team",             "12",    "team",                    "insertNewTeamWithOwner"        },
        {   "super_bowl",       "0",     "main",                    "mainMenu"                      },
        {   "super_bowl",       "1",     "super_bowl",              "insertSuperBowl"               },
        {   "super_bowl",       "2",     "super_bowl",              "deleteSuperBowl"               },
        {   "super_bowl",       "3",     "super_bowl",              "updateSuperBowlWinner"         },
        {   "super_bowl",       "4",     "super_bowl",              "getAllSuperBowls"              },
        {   "super_bowl",       "5",     "super_bowl",              "getSuperBowlWinner"            },
        {   "super_bowl",       "6",     "super_bowl",              "getSuperBowlsWon"              },
        {   "nba_championship", "0",     "main",                    "mainMenu"                      },
        {   "nba_championship", "1",     "nba_championship",        "insertNBAChampionship"         },
        {   "nba_championship", "2",     "nba_championship",        "deleteNBAChampionship"         },
        {   "nba_championship", "3",     "nba_championship",        "updateNBAChampionshipWinner"   },
        {   "nba_championship", "4",     "nba_championship",        "getAllNBAChampionships"        },
        {   "nba_championship", "5",     "nba_championship",        "getNBAChampionshipWinner"      },
        {   "nba_championship", "6",     "nba_championship",        "getNBAChampionshipsWon"        },
        {   "stanley_cup",      "0",     "main",                    "mainMenu"                      },
        {   "stanley_cup",      "1",     "stanley_cup",             "insertStanleyCup"              },
        {   "stanley_cup",      "2",     "stanley_cup",             "deleteStanleyCup"              },
        {   "stanley_cup",      "3",     "stanley_cup",             "updateStanleyCupWinner"        },
        {   "stanley_cup",      "4",     "stanley_cup",             "getAllStanleyCups"             },
        {   "stanley_cup",      "5",     "stanley_cup",             "getStanleyCupWinner"           },
        {   "stanley_cup",      "6",     "stanley_cup",             "getStanleyCupsWon"             },
        {   "owner",            "0",     "main",                    "mainMenu"                      },
        {   "owner",            "1",     "owner",                   "insertOwner"                   },
        {   "owner",            "2",     "owner",                   "deleteOwner"                   },
        {   "owner",            "3",     "owner",                   "updateOwner"                   },
        {   "owner",            "4",     "owner",                   "getAllOwners"                  },
        {   "owner",            "5",     "owner",                   "getOwners"                     },
        {   "owner",            "6",     "owner",                   "getOwnerGroupsMenu"            },
        {   "owner",            "7",     "owner",                   "assignOwnerToTeam"             },
        {   "owner",            "8",     "owner",                   "updateOwnerAndAcquisition"     },
        {   "owner",            "9",     "owner",                   "getLeagueOwners"               }
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
            case "deleteCitiesNoTeams":
                DatabaseFrontend.deleteCitiesNoTeamsMenu();
                DatabaseFrontend.citiesMenu();
                break;
            case "getCitiesNoTeams":
                DatabaseFrontend.getCitiesNoTeamsMenu();
                DatabaseFrontend.citiesMenu();
                break;
            case "getWinsByCity":
                DatabaseFrontend.getWinsByCityMenu(s);
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
            case "insertNewTeamWithOwner":
                DatabaseFrontend.insertNewTeamWithOwnerMenu(s);
                DatabaseFrontend.teamMenu();
                break;
            case "superBowlMenu":
                DatabaseFrontend.superBowlMenu();
                break;
            case "insertSuperBowl":
                DatabaseFrontend.insertSuperBowlMenu(s);
                DatabaseFrontend.superBowlMenu();
                break;
            case "deleteSuperBowl":
                DatabaseFrontend.deleteSuperBowlMenu(s);
                DatabaseFrontend.superBowlMenu();
                break;
            case "updateSuperBowlWinner":
                DatabaseFrontend.updateSuperBowlWinnerMenu(s);
                DatabaseFrontend.superBowlMenu();
                break;
            case "getAllSuperBowls":
                DatabaseFrontend.getAllSuperBowls();
                DatabaseFrontend.superBowlMenu();
                break;
            case "getSuperBowlWinner":
                DatabaseFrontend.getSuperBowlWinner(s);
                DatabaseFrontend.superBowlMenu();
                break;
            case "getSuperBowlsWon":
                DatabaseFrontend.getSuperBowlsWon(s);
                DatabaseFrontend.superBowlMenu();
                break;
            case "nbaChampionshipMenu":
                DatabaseFrontend.nbaChampionshipMenu();
                break;
            case "insertNBAChampionship":
                DatabaseFrontend.insertNBAChampionshipMenu(s);
                DatabaseFrontend.nbaChampionshipMenu();
                break;
            case "deleteNBAChampionship":
                DatabaseFrontend.deleteNBAChampionshipMenu(s);
                DatabaseFrontend.nbaChampionshipMenu();
                break;
            case "updateNBAChampionshipWinner":
                DatabaseFrontend.updateNBAChampionshipWinnerMenu(s);
                DatabaseFrontend.nbaChampionshipMenu();
                break;
            case "getAllNBAChampionships":
                DatabaseFrontend.getAllNBAChampionships();
                DatabaseFrontend.nbaChampionshipMenu();
                break;
            case "getNBAChampionshipWinner":
                DatabaseFrontend.getNBAChamionshipWinner(s);
                DatabaseFrontend.nbaChampionshipMenu();
                break;
            case "getNBAChampionshipsWon":
                DatabaseFrontend.getNBAChampionshipsWon(s);
                DatabaseFrontend.nbaChampionshipMenu();
                break;
            case "stanleyCupMenu":
                DatabaseFrontend.stanleyCupMenu();
                break;
            case "insertStanleyCup":
                DatabaseFrontend.insertStanleyCupMenu(s);
                DatabaseFrontend.stanleyCupMenu();
                break;
            case "deleteStanleyCup":
                DatabaseFrontend.deleteStanleyCupMenu(s);
                DatabaseFrontend.stanleyCupMenu();
                break;
            case "updateStanleyCupWinner":
                DatabaseFrontend.updateStanleyCupMenu(s);
                DatabaseFrontend.stanleyCupMenu();
                break;
            case "getAllStanleyCups":
                DatabaseFrontend.getAllStanleyCups();
                DatabaseFrontend.stanleyCupMenu();
                break;
            case "getStanleyCupWinner":
                DatabaseFrontend.getStanleyCupWinner(s);
                DatabaseFrontend.stanleyCupMenu();
                break;
            case "getStanleyCupsWon":
                DatabaseFrontend.getStanleyCupsWon(s);
                DatabaseFrontend.stanleyCupMenu();
                break;
            case "ownerMenu":
                DatabaseFrontend.ownerMenu();
                break;
            case "insertOwner":
                DatabaseFrontend.insertOwnerMenu(s);
                DatabaseFrontend.ownerMenu();
                break;
            case "deleteOwner":
                DatabaseFrontend.deleteOwnerMenu(s);
                DatabaseFrontend.ownerMenu();
                break;
            case "updateOwner":
                DatabaseFrontend.updateOwnerMenu(s);
                DatabaseFrontend.ownerMenu();
                break;
            case "getOwners":
                DatabaseFrontend.getOwnersMenu();
                DatabaseFrontend.ownerMenu();
                break;
            case "getOwnerGroupsMenu":
                DatabaseFrontend.getOwnerGroupsMenu();
                DatabaseFrontend.ownerMenu();
                break;
            case "getAllOwners":
                DatabaseFrontend.getAllOwnersMenu();
                DatabaseFrontend.ownerMenu();
                break;
            case "assignOwnerToTeam":
                DatabaseFrontend.assignOwnerMenu(s);
                DatabaseFrontend.ownerMenu();
                break;
            case "updateOwnerAndAcquisition":
                DatabaseFrontend.updateOwnerAndAcquisitionMenu(s);
                DatabaseFrontend.ownerMenu();
                break;
            case "getLeagueOwners":
                DatabaseFrontend.getLeagueOwnersMenu(s);
                DatabaseFrontend.ownerMenu();
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
