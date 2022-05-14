package com.InProgress.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the different Players. There can be up to 3 Players in 1 Game. They are distinguished by their ID.
 * Each Player has 3 Settlers. In each round the Player can perform up to 5 actions.
 * @author InProgress
 */
public class Player {

    //<editor-fold desc="Attributes">
    private int playerID;
    private int numberOfMoves;
    private ArrayList<Settler> settlers = new ArrayList<>();
    private Boolean isPlaying; // determines whether a Player still has active Settlers, he can play with.

    //<editor-fold desc="Constructor"

    /**
     * Constructor of the Player class.
     *
     * @param playerID ID of the Player
     */
    public Player(int playerID) {
        this.playerID = playerID;
        this.numberOfMoves = 5;

        // A Player gets 3 Settlers to play with
        this.settlers.add( new Settler("Settler1", Game.getAsteroid(new Random().nextInt(Game.getMaxX()), new Random().nextInt(Game.getMaxY()), new Random().nextInt(Game.getMaxZ())), this.playerID));
        this.settlers.add( new Settler("Settler2", Game.getAsteroid(new Random().nextInt(Game.getMaxX()), new Random().nextInt(Game.getMaxY()), new Random().nextInt(Game.getMaxZ())), this.playerID));
        this.settlers.add( new Settler("Settler3", Game.getAsteroid(new Random().nextInt(Game.getMaxX()), new Random().nextInt(Game.getMaxY()), new Random().nextInt(Game.getMaxZ())), this.playerID));
        this.isPlaying = true;
    }

    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     * Decreases the number of moves of this Player after each successful action.
     */
    public void decreaseNumberOfMoves(){

        numberOfMoves--;
        System.out.println(numberOfMoves);
    }

    /**
     * Checks if the Settlers of this Player are alive.
     *
     * @return true if the player has alive settlers
     *         false if all the settlers of the player are dead
     */
    public boolean checkSettlers() {
        int cnt = settlers.size(); //counter to keep track of living Settlers

        for (Settler settler : settlers) {
            if (!settler.getAlive())
                cnt--; //decrease counter if Settler is dead
        }

        if (cnt == 0) { // if no Settler is alive return false
            this.isPlaying = false; // Player is not Playing anymore
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method ends the turn of this Player.
     * It is called whenever the Player decides to end its turn,
     * when no more moves are left or when all the Settlers are dead.
     */
    public void endMyTurn() {
        Game.setCurrentPlayer(getNextPlayer());
        for(Settler i: Game.getCurrentPlayer().getSettlers())
        {
            if(i.isAlive)
            {
                Game.setActiveSettler(i);
            }
        }
        // assigns the next Player
        if(this.playerID == Game.getCurrentPlayer().getPlayerID() || this.playerID > Game.getCurrentPlayer().getPlayerID() ) { // checks if a complete round was played
            Game.nextRound();
        }
    }

    /**
     * Checks which Player is the next one.
     *
     * @return pNext the next Player.
     */
    public Player getNextPlayer() {
        Player pNext = this;

        if(Game.getPlayers().size() == 1) { // check for a single player game
            return pNext; // if there is only one Player, he is always the next one.
        }
        else if (Game.getPlayers().size() == 2) { // check for a game with 2 players

            if (this.getPlayerID() == 0) {

                if (Game.getPlayers().get(1).getPlaying()) {
                    pNext = Game.getPlayers().get(1);
                } else if (Game.getPlayers().get(2).getPlaying()) {
                    pNext = Game.getPlayers().get(0);
                }
            } else if (this.getPlayerID() == 1) {

                if (Game.getPlayers().get(0).getPlaying()) {
                    pNext = Game.getPlayers().get(0);
                } else if (Game.getPlayers().get(1).getPlaying()) {
                    pNext = Game.getPlayers().get(1);
                }
            }
        } else { // check for a game with 3 players
            if (this.getPlayerID() == 0) {

                if (Game.getPlayers().get(1).getPlaying()) {
                    pNext = Game.getPlayers().get(1);
                } else if (Game.getPlayers().get(2).getPlaying()) {
                    pNext = Game.getPlayers().get(2);
                }
            } else if (this.getPlayerID() == 1) {

                if (Game.getPlayers().get(2).getPlaying()) {
                    pNext = Game.getPlayers().get(2);
                } else if (Game.getPlayers().get(0).getPlaying()) {
                    pNext = Game.getPlayers().get(0);
                }
            } else if (this.getPlayerID() == 2) {

                if (Game.getPlayers().get(0).getPlaying()) {
                    pNext = Game.getPlayers().get(0);
                } else if (Game.getPlayers().get(1).getPlaying()) {
                    pNext = Game.getPlayers().get(1);
                }
            }
        }

        System.out.println("CurrentPlayer: Player " + pNext.getPlayerID() + " previous Player: Player " + this.getPlayerID());
        return pNext;
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">

    public int getPlayerID() { return playerID; }
    public void setPlayerID(int playerID) { this.playerID = playerID; }

    public int getNumberOfMoves() { return numberOfMoves; }
    public void setNumberOfMoves(int numberOfMoves) { this.numberOfMoves = numberOfMoves; }

    public ArrayList<Settler> getSettlers() { return settlers; }
    public void setSettlers(ArrayList<Settler> settlers) { this.settlers = settlers; }

    public Boolean getPlaying() { return isPlaying; }
    public void setPlaying(Boolean playing) { isPlaying = playing; }

    //</editor-fold>
}

