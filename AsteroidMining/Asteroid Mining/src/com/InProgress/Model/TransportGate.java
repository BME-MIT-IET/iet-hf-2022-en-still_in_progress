package com.InProgress.Model;

/**
 * Represents a TransportGate that allow Settlers to travel further distances at once.
 * They are build by Settlers using 2 unit of Iron, 1 unit of WaterIce and Uranium.
 * Robots travel randomly from Asteroid to Asteroid and drill them until they reach the core.
 * They are vulnerable to explosions and sun storms.
 * @author InProgress
 */
public class TransportGate {

    //<editor-fold desc="Attributes">

    private Boolean isActive;
    private Asteroid currentPosition;
    private TransportGate pair;

    //</editor-fold>


    //<editor-fold desc="Constructor">

    /**
     * Constructor of the TransportGate class.
     */
    public TransportGate()
    {
        this.isActive = Boolean.FALSE;
    }

    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     * Activates the Gate after both the gates have been
     * deployed
     */
    public void activateTransportGate() {

        this.isActive = Boolean.TRUE;
        this.pair.isActive = Boolean.TRUE;
    }

    /**
     * Deactivates the Gate after the other gate has been
     * destroyed in an explosion
     */
    public void deactivateTransportGate() {
        this.isActive = Boolean.FALSE;
        this.getPair().setActive(false);
        Game.setNumberOfGates(Game.getNumberOfGates()-2);
    }

    /**
     * Assigns the Transport Gate with a pair
     * which is necessary for activation
     *
     * @param tg2 the second Transport gate
     */
    public void makePair(TransportGate tg2) {

        this.pair= tg2;
        tg2.pair = this;
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">

    public Asteroid getCurrentPosition() { return currentPosition; }
    public void setCurrentPosition(Asteroid currentPosition) { this.currentPosition = currentPosition; }

    public Boolean getActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }

    public TransportGate getPair() { return pair; }
    public void setPair(TransportGate pair) { this.pair = pair; }

    //</editor-fold>

}
