package main.java.com.InProgress.Model;

/**
 * Represents a Carbon Resource. It is derived from ResourceBase.
 * Carbon is needed to build the SpaceStation, Robots or TransportGates.
 * @author InProgress
 */
public class Carbon extends ResourceBase {

    /**
     * Constructor of Carbon class
     *
     * @param resourceType Name of the Resource
     */
    public Carbon(String resourceType) {
        super(resourceType);
    }

}
