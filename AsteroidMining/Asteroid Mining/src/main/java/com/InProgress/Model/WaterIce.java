package main.java.com.InProgress.Model;

/**
 * Represents a WaterIce Resource. It is derived from ResourceBase.
 * WaterIce is needed to build the SpaceStation, Robots or TransportGates.
 * WaterIce can sublime when it is on an Asteroid at perihelion
 * @author InProgress
 */
public class WaterIce extends ResourceBase{

    //<editor-fold desc="Constructor">

    /**
     * Constructor of WaterIce class.
     *
     * @param resourceType Name of the resource.
     */
    public WaterIce(String resourceType) {
        super(resourceType);
    }

    //</editor-fold>


    //<editor-fold desc="Methods">

    /**
     * Removes the WaterIce from the Asteroid when it is
     * drilled through at perihelion.
     *
     * @param A Asteroid of this WaterIce Resource
     */
    @Override
    public void sublime(Asteroid A) {

        A.getResourceOfAsteroid().clear(); // Removes the resource form the asteroid
        A.setHollow(true); // Asteroid is hollow now
    }

    //</editor-fold>
}
