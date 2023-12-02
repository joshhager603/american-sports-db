# Instructions for Adding a Menu Option/Query

1. Define your query as a stored procedure and grant dbuser execute permission in SQL Server
   
2. Create a backend function in the .java file that matches the table name, i.e. a query on Arena goes in Arena.java
3. Create your frontend menu using print statements in DatabaseFrontend.java
   * This will call your backend function you created
4. Update the state machine for the menu transitions
   * Step 1: Create a new row in the transition table
   
      * current = current state we're in / menu we're on
      * input = the user's input, should just be a number
      * next = the state to go into after the input is received
      * onTransition = the action to perform when we move to the next state
    * Step 2: Create a new case statement in onTransition function if needed
      * If the onTransition value in the table entry you just made doesn't exist in the onTransition function, you will need to define it
      * This should call the frontend menu(s) you made in step 3