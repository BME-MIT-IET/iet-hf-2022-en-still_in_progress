package com.InProgress.Model;

import com.InProgress.GUI.GameWindow;
import com.InProgress.GUI.MineMessage;
import com.InProgress.GUI.PickUpMessage;
import com.InProgress.GUI.StartWindow;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * Central class that contains the game logic.
 * It is responsible for controlling the game flow.
 * @author InProgress
 */
public class Game implements Serializable {

    //<editor-fold desc="Attributes">

    private static int maxX; // x dimension of the asteroid belt
    private static int maxY; // y dimension of the asteroid belt
    private static int maxZ; // z dimension of the asteroid belt
    private static int roundCounter;
    private static int numberOfAsteroids; // counts the number of active asteroids
    private static int numberOfGates;
    private static boolean winLoose;
    private static  Sun sun; // in charge of sun storms
    private static ArrayList<Player> players; //list of players
    private static Player currentPlayer; // the Player who is currently playing
    private static Settler activeSettler; // the Settler the currentPlayer is controlling
    public static  ArrayList<ArrayList<ArrayList<Asteroid>>> asteroids; // 3D-list of all asteroids
    private static  ArrayList<Robot> robots; //list of robots
    public static GameWindow gameWindow;

    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     *  Instantiates all the main parts of the game.
     *  It sets up the asteroid belt and creates a sun object.
     *  Instantiates the lists and sets the first player and settler as the current ones.
     *
     * @param numberOfPlayers Number of players that play the game
     * @param x size of the x dimension of the asteroid belt
     * @param y size of the x dimension of the asteroid belt
     * @param z size of the z dimension of the asteroid belt
     */
    public static void startGame(int numberOfPlayers, int x, int y, int z) {
        asteroids = new ArrayList<ArrayList<ArrayList<Asteroid>>>();
        setAsteroidBelt(x,y,z);//needs to be called before sun
        roundCounter = 0;
        numberOfAsteroids = x*y*z;
        numberOfGates = 0;
        winLoose = false; // no winner yet

        sun = new Sun();
        robots = new ArrayList<>();

        players = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++) { // creates the players
            players.add(new Player(i));
        }
        currentPlayer = players.get(0);                     // first player is starts
        activeSettler = currentPlayer.getSettlers().get(0); // with its first Settler
    }

    /**
     *  Before each round starts the system checks whether a sunstorm has to occur
     *  and if the perihelion state of the asteroids changes.
     *  The number of moves of the Players is restored and all robots start a drilling action.
     */
    public static void nextRound() {

        roundCounter++;
        System.out.println("roundcounter:"+ roundCounter);
        sun.decreaseCountdown();

        if(sun.getCountdownOfSunStorm() == 0) { // checks if sunstorm occurs in this round
            sun.startSunStorm(); // the sunstrom might kills Settlers or Robots
        }

        if(roundCounter%5 == 0) { // perihelion state changes every 5 rounds
            sun.changeSunX(); // due to the change of the sunX attribute asteroids might explode and kill Settlers or Robots
        }

        for (Robot r : robots ) { // all robots drill on their current asteroid
            if(r.isAlive) {
                r.drill(r.getCurrentPosition()); // drilling might cause an explosion that kills Settlers or Robots
            }
        }

        //-----------------------------------------------------------------------------------
        // the previous 3 checks could kill all remaining settlers.
        // It must be checked if the Players still can play, before the Game can proceed
        boolean isThereStillSomeone = false;
        for (Player p : players ) {
            p.setNumberOfMoves(5);// restore number of moves of all Players
            if(p.checkSettlers()) {
                isThereStillSomeone = true; // if at least one Player remains in the Game
            }
        }
        if(!isThereStillSomeone) {
            Game.endGame(false);
        }
        if(!currentPlayer.getPlaying()) { // if the currentPlayer died during the previous actions we assign a new one
            currentPlayer = currentPlayer.getNextPlayer();
            for(Settler i: Game.getCurrentPlayer().getSettlers())
            {
                if(i.isAlive)
                {
                    Game.setActiveSettler(i);
                }
            }
        }
        //-----------------------------------------------------------------------------------

        for (Player p : players ) { // restore number of moves of all active Players
            if(p.getPlaying()) {
                p.setNumberOfMoves(5);
            }
        }
    }

    /**
     * Checks how many Settlers are still active.
     *
     * @return number of settlers remaining active Settlers
     */
    public static int getNumberOfSettlers() {
        int sum = 0;
        for(Player i:players)
        {
            for(int j=0;j<i.getSettlers().size();j++)
                if(i.getSettlers().get(j).getAlive())
                    sum++;
        }
        return sum;
    }


    /**
     * Whenever a internal action is performed which affects the user a
     * infobox is created to inform the user.
     *
     * @param index Index to determine which infobox must be created
     */
    public static void controllerInternal(int index) {

        switch(index) {

            case 1: { // Asteroid explodes
                infobox("An Asteroid exploded.", "Explosion");
            }
            break;

            case 2: { // Sun storm occured
                infobox("A sun storm occurred.", "Sun storm");
            }
            break;

            case 3: { // Settler died
                infobox("A Settler died", "Dead Settler");
            }
            break;
            //-----------------------------------------------------------------------------------

            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
    }

    /**
     * Connection between the GUI and the Model.
     * The controllerExternal is called whenever a user input is received.
     * It starts the required action.
     *
     * @param index Index to determine which action must be performed
     * @param input contains additional information required to perform certain action
     */
    public static void controllerExternal(int index, ArrayList<String> input) {

        if(index != 0) {
            System.out.println("CurrentPlayer: Player " + currentPlayer.getPlayerID());
            System.out.println("Player " + activeSettler.getPlayerID() + " is playing with " + activeSettler.getName());
        }

        int returnValue;

        switch(index) {

            case 0: { // set up the game
                int p = Integer.parseInt(input.get(0));
                int x = Integer.parseInt(input.get(1));
                int y = Integer.parseInt(input.get(2));
                int z = Integer.parseInt(input.get(3));
                startGame(p,x,y,z);

                gameWindow = new GameWindow();
                gameWindow.initialize();

                return;
            }

            case 1: { // travel
                int x = Integer.parseInt(input.get(0));
                int y = Integer.parseInt(input.get(1));
                int z = Integer.parseInt(input.get(2));

                returnValue = activeSettler.travel(getAsteroid(x,y,z));

                if(returnValue == 0) {
                    currentPlayer.decreaseNumberOfMoves();
                }
                else if(returnValue == 1) {
                    infobox("There is not enough space on the Asteroid.", "Travel Error");
                }
                else if(returnValue == 2) {
                    infobox("Asteroid is not in the neighborhood or is exploded.", "Travel Error");

                }
            }
            break;

            case 2: { // fastTravel
                returnValue = activeSettler.fastTravel(activeSettler.getCurrentPosition());
                if(returnValue == 0) {
                    currentPlayer.decreaseNumberOfMoves();
                }
                else if(returnValue == 1) {
                    infobox("There is not enough space on the Asteroid.", "Travel Error");
                }
                else if(returnValue == 2) {
                    infobox("The Gate is not activated.", "Travel Error");
                }
                else if(returnValue == 3) {
                    infobox("The Asteroid has no Gate.", "Travel Error");
                }
            }
            break;

            case 3: { // drill
                returnValue = activeSettler.drill(activeSettler.getCurrentPosition());
                if(returnValue == 0) {
                    currentPlayer.decreaseNumberOfMoves();
                }
                else {
                    infobox("The Asteroid is already drilled.", "Drill Error");
                }
            }
            break;

            case 4: { // mine
                returnValue = activeSettler.mine(activeSettler.getCurrentPosition());
                if(returnValue == 0) {
                    MineMessage mineMessage = new MineMessage(gameWindow);
                    mineMessage.initialize(gameWindow);
                    currentPlayer.decreaseNumberOfMoves();

                }
                else if(returnValue == 1) {
                    infobox("The Asteroid cannot be mined.", "Mine Error");
                }
                else if(returnValue == 2) {
                    infobox("You cannot mine.\nYour inventory is full", "Mine Error");
                }
            }
            break;

            case 5: { // leave resource
                returnValue = activeSettler.leaveResource(input.get(0));

                if(returnValue == 0) {
                    currentPlayer.decreaseNumberOfMoves();
                }
                else if (returnValue == 1){
                    infobox("You cannot leave this Resource.", "Leave Resource Error");
                }
                else if (returnValue == 2){
                    infobox("You do not have that Resource", "Leave Resource Error");
                }
            }
            break;

            case 6: { // pick up resource
                returnValue = activeSettler.pickUpResources();

                if(returnValue == 0) {
                    PickUpMessage pickUpMessage = new PickUpMessage(GameWindow.resource, gameWindow);
                    pickUpMessage.initialize(GameWindow.resource, gameWindow);
                    currentPlayer.decreaseNumberOfMoves();
                }
                else if(returnValue == 1) {
                    infobox("There is nothing to pick up.", "Pick Up Resource Error");
                }
                else if(returnValue == 2) {
                    infobox("Your inventory is full.", "Pick Up Resource Error");
                }
            }
            break;

            case 7: { // build robot
                returnValue = activeSettler.buildRobot();

                if(returnValue == 0) {
                    currentPlayer.decreaseNumberOfMoves();
                }
                else {
                    infobox("You do not have enough Resources.", "Build Error");
                }
            }
            break;

            case 8: { // build gates
                returnValue = activeSettler.buildTransportGate();

                if(returnValue == 0) {
                    currentPlayer.decreaseNumberOfMoves();
                }
                else if(returnValue == 1) {
                    infobox("You do not have enough Resources.", "Build Error");
                }
                else if(returnValue == 2) {
                    infobox("You cannot carry anymore Gates.", "Build Error");
                }
            }
            break;

            case 9: { // build space station
                returnValue = activeSettler.buildSpaceStation(activeSettler.getCurrentPosition());

                if(returnValue == 0) {
                    activeSettler.buildSpaceStation(activeSettler.getCurrentPosition());
                    endGame(winLoose);
                }
                else {
                    infobox("You do not have enough Resources.", "Build Error");
                }
            }
            break;

            case 10: { // deploy gate
                returnValue = activeSettler.deployTransportGate(activeSettler.getCurrentPosition());

                if(returnValue == 0) {
                    currentPlayer.decreaseNumberOfMoves();
                }
                else {
                    infobox("You cannot deploy a Gate.", "Deploy Error");
                }
            }
            break;

            case 11: { // end turn
                currentPlayer.endMyTurn();
            }
            break;

            case 12: { // change settler
                for (Settler s : currentPlayer.getSettlers() ) {
                    if(s.getName().equals(input.get(0))) {
                        activeSettler = s;
                    }
                }
            }
            break;

            case 13: { // start new game
                // clear all lists
                asteroids.clear();
                players.clear();
                robots.clear();

                StartWindow startWindow = new StartWindow();
                startWindow.initialize();
            }
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }

        System.out.println("Player: " +currentPlayer.getPlayerID() + " Remaining Actions: " + currentPlayer.getNumberOfMoves());
        if(currentPlayer.getNumberOfMoves() == 0) { // ends turn if user has no moves left
            System.out.println("Player: " +currentPlayer.getPlayerID() + "'s turn ended.");
            currentPlayer.endMyTurn();
        }
    }

    /**
     * Ends the game.
     * Decides whether it was successful or not
     */
    public static void endGame(boolean flag) {
        if(flag)
            GameWindow.infobox("Detim imim finyish du wa ting, im ye fo sémpere.","Beltalowda");
        else
            GameWindow.infobox("Setara imalowda mogut nawit milowda.","Inyalowda ");
    }

    /**
     * Places the asteroids in the 3D-list
     *
     * @param x x dimension of the asteroid belt
     * @param y y dimension of the asteroid belt
     * @param z z dimension of the asteroid belt
     */
    public static void setAsteroidBelt(int x, int y, int z) {
        maxX = x;
        maxY = y;
        maxZ = z;

        asteroids = new ArrayList<ArrayList<ArrayList<Asteroid>>>(maxX);
        for (int i = 0; i < maxX; i++) {
            asteroids.add(new ArrayList<ArrayList<Asteroid>>(maxY));
            for (int j = 0; j < maxY; j++)
                asteroids.get(i).add(new ArrayList<Asteroid>(maxZ));
        }

        for (int i = 0; i < maxX; i++) {
            for(int j = 0; j < maxY; j++) {
                for(int k = 0; k < maxZ; k++) {
                    asteroids.get(i).get(j).add(k, new Asteroid(i, j, k, new Random().nextInt(5) + 1));
                }
            }
        }
    }

    /**
     * Creates an infobox to display information to the user.
     *
     * @param message Text of the message to the user
     * @param title Title of the window
     */
    public static void infobox(String message,String title)
    {
        JOptionPane.showMessageDialog(null,message,title, JOptionPane.INFORMATION_MESSAGE);
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">

    public static ArrayList<Player> getPlayers() { return players; }

    public static int getMaxX() { return maxX; }

    public static int getMaxY() { return maxY; }

    public static int getMaxZ() { return maxZ; }

    public static boolean isWinLoose() { return winLoose; }
    public static void setWinLoose(boolean winLoose) { Game.winLoose = winLoose; }

    public static Sun getSun() { return sun; }

    public static ArrayList<Robot> getRobots() { return robots; }

    public static Asteroid getAsteroid(int i, int j, int k) { return asteroids.get(i).get(j).get(k); }

    public static Player getCurrentPlayer() { return currentPlayer; }
    public static void setCurrentPlayer(Player currentPlayer) { Game.currentPlayer = currentPlayer; }

    public static Settler getActiveSettler() { return activeSettler; }
    public static void setActiveSettler(Settler activeSettler) { Game.activeSettler = activeSettler; }

    public static int getNumberOfAsteroids() { return numberOfAsteroids; }
    public static void setNumberOfAsteroids(int numberOfAsteroids) { Game.numberOfAsteroids = numberOfAsteroids; }

    public static int getNumberOfGates() { return numberOfGates; }
    public static void setNumberOfGates(int numberOfGates) { Game.numberOfGates = numberOfGates; }

    //</editor-fold>

}
