package com.InProgress.Model;

/**
 * Base class of the Travellers.
 * It contains the common methods of the Settler and Robot class.
 * @author InProgress
 */
public abstract class TravellerBase {

    //<editor-fold desc="Attributes">

    protected Asteroid currentPosition;
    protected boolean isAlive = true;
    protected boolean isHidden = false;

    //</editor-fold>


    //<editor-fold desc="Constructor">

    /**
     * Constructor of the TravellerBase
     *
     * @param currentPosition Starting Asteroid of the Traveller.
     */
    public TravellerBase(Asteroid currentPosition) {
        this.currentPosition = currentPosition;
    }

    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     * Abstract method for travelling
     *
     * @param A destination Asteroid
     */
    public abstract int travel(Asteroid A);


    /**
     * Abstract method for fast travel using a gate
     *
     * @param A Asteroid to which the gate belongs
     */
    public abstract int fastTravel(Asteroid A);



    /**
     * The traveller hides inside the Asteroid.
     * Hiding is only possible if the Asteroid is drilled through, hollow and
     * has enough space for the traveller.
     *
     * @param A Asteroid this traveller hides in
     */
    public void hide(Asteroid A) {
        if (A.getDepth() == 0 && A.getHollow()) {
            int cntRobots = 0;
            int cntSettlers = 0;
            for (int i = 0; i < A.getRobotsOnAsteroid().size(); i++) {
                if (A.getRobotsOnAsteroid().get(i).getHidden()) // to check if hidden
                    cntRobots++; // number of hidden robots on this asteroid
            }
            for (int i = 0; i < A.getSettlersOnAsteroid().size(); i++) {
                if (A.getSettlersOnAsteroid().get(i).getHidden())   // to check if hidden
                    cntSettlers++; // number of hidden settlers on this asteroid
            }
            if ((cntRobots == 1 && cntSettlers == 0) || (cntSettlers == 1 && cntRobots == 0) || (cntRobots ==0 && cntSettlers == 0)) { // 2 robots or 1 robot and 1 settler
                isHidden = true;
            }
        }
    }


    /**
     * Abstract method for drilling
     *
     * @param A Asteroid that is being drilled
     */
    public abstract int drill(Asteroid A);

    /**
     * Checks if the Destination of this Traveller is valid,
     * s. t. it is not exploded and in the neighborhood.
     *
     * @param Destination Travel destination of this Traveller
     * @return True if the Destination is valid. False if not.
     */
    public boolean checkDestination(Asteroid Destination) {
        if (Destination.getExploded()) {
            return false;
        }

        // Flags to check if the coordinate value is valid for travel
        boolean xFlag = false;
        boolean yFlag = false;
        boolean zFlag = false;

        if((Math.abs(this.currentPosition.getX() - Destination.getX()) < 3)) {
            xFlag = true;
        } else if((Math.abs(this.currentPosition.getX() + Destination.getX() - Game.getMaxX()) < 3)) { // check in case travel goes over the boundary, e.g. from 9 to 0
            xFlag = true;
        }

        if(Math.abs(this.currentPosition.getY() - Destination.getY()) < 3){
            yFlag = true;
        }

        if(Math.abs(this.currentPosition.getZ() - Destination.getZ()) < 3){
            zFlag = true;
        }
        return xFlag && yFlag && zFlag;
    }

    /**
     * This method kills the object.
     */
    public void die() {
        this.isAlive = false;

        if(this instanceof Settler) {
            Game.controllerInternal(3);
        }
        if(Game.getCurrentPlayer().checkSettlers())
        {
            for(Settler i : Game.getCurrentPlayer().getSettlers())
            {
                if(i.isAlive) {
                    Game.setActiveSettler(i);
                    return;
                }
            }
        }
        else
        {
            Game.getCurrentPlayer().setPlaying(false);
            Game.getCurrentPlayer().endMyTurn();
        }
    }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">

    public Asteroid getCurrentPosition() { return currentPosition; }
    public void setCurrentPosition(Asteroid currentPosition) { this.currentPosition = currentPosition; }


    public boolean getHidden() { return isHidden; }
    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean getAlive() { return isAlive; }
    public void setAlive(boolean alive) { isAlive = alive; }

    //</editor-fold>
}
