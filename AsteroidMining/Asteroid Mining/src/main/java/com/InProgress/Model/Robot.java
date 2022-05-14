package com.InProgress.Model;

import java.util.Random;

/**
 * The Robot class is derived from the Traveller base.
 * Represents an autonomously Robot that supports Settlers with drilling operation.
 * They are build by Settlers using 1 unit of Iron, Carbon and Uranium.
 * Robots travel randomly from Asteroid to Asteroid and drill them until they reach the core.
 * They are vulnerable to explosions and sun storms.
 * @author InProgress
 */
public class Robot extends TravellerBase {

    //<editor-fold desc="Attributes">

    private int damageCount;

    //</editor-fold>


    //<editor-fold desc="Constructor"

    /**
     * Constructor of the Robot class
     *
     * @param currentPosition Position of the Robot
     */
    public Robot(Asteroid currentPosition) {
        super(currentPosition);
        this.damageCount = 0;
        currentPosition.setRobotsOnAsteroid(this);
    }

    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     * Moves this Robot to a neighbouring Asteroid.
     * It checks if the Asteroid is not exploded and if it is in the neighbourhood.
     * After a successful travel the Robot tries to hide inside the Asteroid.
     *
     * @param Destination destination Asteroid
     */
    public int travel(Asteroid Destination) {
        if (checkDestination(Destination)) { // checks if the Asteroid is in the neighbourhood.
            currentPosition.getRobotsOnAsteroid().remove(this);  // Robot is removed from the list of the current Asteroid
            isHidden = false; // Robot is unhidden after travel
            currentPosition.hideMyTravellers();
            currentPosition = Destination;  // successful travel
            currentPosition.getRobotsOnAsteroid().add(this); // robot is added to the list of the new Asteroid
            hide(currentPosition); // tires to hide
        } else {
            randomTravel(this.getCurrentPosition());
        }
        return 0; // default return
    }

    /**
     * This method is used for travel by using a transport gate.
     * It first checks if there is a gate available and if it is active.
     *
     * @param A Asteroid to which the gate belongs
     * @return default return (necessary because of the base class)
     */
    public int fastTravel(Asteroid A) {
        TransportGate destGate = A.getGate().getPair();

        A.getRobotsOnAsteroid().remove(this); // Robot is removed from the list of the current Asteroid
        isHidden = false; // Robot is unhidden after travel
        currentPosition.hideMyTravellers();
        currentPosition = destGate.getCurrentPosition();// we travel to the location of the pair.
        currentPosition.getRobotsOnAsteroid().add(this); // robot is added to the list of the new Asteroid
        hide(currentPosition); // tires to hide

        return 0; // default return
    }



    /**
     * The Robot drills the Asteroid and the rockCover is reduced.
     * When the Asteroid is drilled through after the current drilling,
     * if checks whether is explodes or the WaterIce sublimes
     * If the Asteroid is already drilled through the Robots travels to a random neighbouring Asteroid
     * or uses a Transport Gate if available.
     *
     * @param A Asteroid which is drilled
     */
    public int drill(Asteroid A) {
        if (A.getDepth() != 0) { // if the Asteroid is not drilled through, then the robot drills
            A.decreaseRockCover(); //drilling

            if(A.getDepth() ==0 && A.getAtPerihelion() ) { // checks if the remaining rockCover equals 0 and if the Asteroid is at perihelion

                if (A.getResourceOfAsteroid().get(0) instanceof Uranium) // checks if the Asteroid has Uranium in his core
                {
                    A.getResourceOfAsteroid().get(0).explode(A); // Uranium explodes

                } else if (A.getResourceOfAsteroid().get(0) instanceof WaterIce) // checks if the Asteroid has Uranium in his core
                {
                    A.getResourceOfAsteroid().get(0).sublime(A); // WaterIce sublimes
                }
            }
        } else if (A.getHasGate() && A.getGate().getActive()) { // if it cannot drill and the Asteroid has a Gate, the Robots fastTravels
            fastTravel(A);
        } else {  // if it cannot drill and the Asteroid has no Gate, the Robots randomly travels
            randomTravel(A);
        }
        return 0; // default return
    }

    /**
     * Picks a random neighboring Asteroid for the Robot to travel to.
     * It checks if the coordinates are valid and fixes them if they are out of bound.
     *
     * @param A the current Asteroid of the Robot.
     */
    public void randomTravel(Asteroid A) {
        int rndX = A.getX() + new Random().nextInt(5)-2; // adds random number between -2 and 2 to the current X coordinate
        int rndY = A.getY() + new Random().nextInt(5)-2; // adds random number between -2 and 2 to the current Y coordinate
        int rndZ = A.getZ() + new Random().nextInt(5)-2; // adds random number between -2 and 2 to the current Z coordinate

        // checks if rndX is out of bound and adjusts it
        if(rndX < 0 ) {
            rndX = Game.getMaxX() + rndX;
        } else if( rndX > Game.getMaxX()) {
            rndX = rndX - A.getX()+1;
        }

        // checks if rndY is out of bound and adjusts it
        if(rndY < 0 ) {
            rndY = 0;
        } else if( rndY > Game.getMaxY()) {
            rndX = Game.getMaxY()+1;
        }

        // checks if rndZ is out of bound and adjusts it
        if(rndZ < 0 ) {
            rndZ = 0;
        } else if( rndZ > Game.getMaxZ()) {
            rndZ = Game.getMaxZ()+1;
        }

        travel(Game.getAsteroid(rndX, rndY, rndZ));
    }

    /**
     * Increases the damageCount of this Robot.
     * A robot will die when the damageCount equals 2.
     */
    public void increaseDamage() {
        damageCount++;

        if (this.damageCount == 2) {
            this.die();
        }
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">

    public int getDamageCount() {
        return damageCount;
    }
    public void setDamageCount(int damageCount) {
        this.damageCount = damageCount;
    }


    //</editor-fold>

}
