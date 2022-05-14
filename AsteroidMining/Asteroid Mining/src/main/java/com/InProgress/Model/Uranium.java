package main.java.com.InProgress.Model;

/**
 * Represents a Uranium Resource. It is derived from ResourceBase.
 * Uranium is needed to build the SpaceStation, Robots or TransportGates.
 * Uranium can explode when it is on an Asteroid at perihelion and destroy Asteroids and kill Travellers.
 * @author InProgress
 */
public class Uranium extends ResourceBase{

    //<editor-fold desc="Constructor">

    /**
     * radioactive resource
     *
     * @param resourceType Name of the resource.
     */
    public Uranium(String resourceType) {
        super(resourceType);
    }

    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     * Uranium explodes when the Asteroid is drilled through at perihelion.
     * It kills all Settlers on the Asteroid and forces Robots to travel to a neighboring Asteroid.
     * It deactivates any TransportGates related to the Asteroid.
     *
     * @param A Asteroid in which the Uranium is
     */
    @Override
    public void explode(Asteroid A)  {

        Game.controllerInternal(1);

        A.setExploded(true); // change isExploded attribute of Asteroid to true.
        Game.setNumberOfAsteroids(Game.getNumberOfAsteroids()-1);

        if(A.getHasGate()) // check for gates of the Asteroid
        {
            A.getGate().deactivateTransportGate(); // deactivates the TransportGate
        }

        for (int i = 0; i < A.getSettlersOnAsteroid().size(); i++) {
            A.getSettlersOnAsteroid().get(i).die(); // All settler on the Asteroid die.
        }

        for(int i = 0; i < A.getRobotsOnAsteroid().size(); i++) {
            // random values to decide where the Robot travels to
            A.getRobotsOnAsteroid().get(i).increaseDamage(); // increases the damage the robot has taken
            A.getRobotsOnAsteroid().get(i).randomTravel(A); // Robot travels to a different Asteroid
        }
    }
}

//</editor-fold>


