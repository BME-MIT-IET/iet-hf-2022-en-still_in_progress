package com.InProgress.Model;

import java.util.Random;

/**
 * Represents the Sun. The Sun can start sun storms which kill unhidden Travellers.
 * It also determines which Asteroids are at perihelion.
 * @author InProgress
 */
public class Sun {

    //<editor-fold desc="Attributes">



    private int sunX;
    private int countDownOfSunStorm;

    //</editor-fold>


    //<editor-fold desc="Constructor">

    /**
     * Constructor of the Sun class.
     * It sets a random value for the sunX value between 0 and the maximum x-dimension of the asteroid belt.
     * Changes the perihelion status of the asteroids.
     * It sets the countdown to a random value between 5 and 9.
     */
    public Sun() {
        sunX = new Random().nextInt(Game.getMaxX());

        countDownOfSunStorm = new Random().nextInt(5) + 5;
    }
    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     * Increases the sunX value by one.
     * In case the sunX equals the upper boundary it is set back to 0.
     * Calls the perihelionChanger to update the asteroids.
     */
    public void changeSunX() {

        // change atPerihelion to false for current sunX
        for(int j = 0; j < Game.getMaxY(); j++) {
            for (int k = 0; k < Game.getMaxZ(); k++) {
                Game.getAsteroid(sunX, j, k).perihelionChanger(false);
            }
        }

        // change sunX value
        if(this.sunX == Game.getMaxX()-1) {
            this.sunX = 0;
        } else {
            this.sunX++;
        }

        // change atPerihelion to true for current sunX
        for(int j = 0; j < Game.getMaxY(); j++) {
            for (int k = 0; k < Game.getMaxZ(); k++) {
                Game.getAsteroid(sunX, j, k).perihelionChanger(true);
            }
        }
    }

    /**
     *  Decreases the countdown of this sun by 1 after each round.
     */
    public void decreaseCountdown() {
        countDownOfSunStorm--;
    }

    /**
     * launches the sun storm
     */
    public void startSunStorm() {
        Game.controllerInternal(2);
        findTraveller();
        setCountDownOfSunStorm(new Random().nextInt(5) + 5); // new countdown between 5 and 9
    }

    /**
     *  checks the asteroids and if there are any unhidden travellers on them.
     *  Calls die() for unhidden travellers.
     */
    public void findTraveller() {

        for (int i = 0; i < Game.getMaxX(); i++) {
            for (int j = 0; j < Game.getMaxY(); j++) {
                for (int k = 0; k < Game.getMaxZ(); k++) {
                    for (int s = 0; s < Game.getAsteroid(i,j,k).getSettlersOnAsteroid().size(); s++) {
                        if (!Game.getAsteroid(i,j,k).getSettlersOnAsteroid().get(s).getHidden() && Game.getAsteroid(i,j,k).getSettlersOnAsteroid().get(s).getAlive()) {
                            Game.getAsteroid(i,j,k).getSettlersOnAsteroid().get(s).die();
                        }
                    }
                    for (int r = 0; r <Game.getAsteroid(i,j,k).getRobotsOnAsteroid().size(); r++) {
                        if (!Game.getAsteroid(i,j,k).getRobotsOnAsteroid().get(r).getHidden() && Game.getAsteroid(i,j,k).getRobotsOnAsteroid().get(r).getAlive()) {
                            Game.getAsteroid(i,j,k).getRobotsOnAsteroid().get(r).die();
                        }
                    }
                }
            }
        }
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">

    public int getCountdownOfSunStorm() { return countDownOfSunStorm; }
    public void setCountDownOfSunStorm(int countDownOfSunStorm) { this.countDownOfSunStorm = countDownOfSunStorm; }
    public int getSunX() {
        return sunX;
    }

    //</editor-fold>
}
