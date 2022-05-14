package com.InProgress.Model;

import  java.lang.String;

/**
 * Base class of the Resources. Resources can be found in the core of Asteroids.
 * They can be mined and transported by Settlers or be stored on Asteroids.
 * Resources are used to build the Space Station, Robots and TransportGates.
 * @author InProgress
 */
public class ResourceBase {

    //<editor-fold desc="Attributes">

    protected String resourceType;

    //</editor-fold>


    //<editor-fold desc="Constructor">

    /**
     * constructor for ResourceBase
     *
     * @param resourceType Name of the resource
     */
    public ResourceBase(String resourceType) { this.resourceType = resourceType; }

    //</editor-fold">

    //<editor-fold desc="Methods">

    /**
     * Virtual method. Implementation is in Uranium class.
     *
     * @param A Asteroid that has this Resource
     */
    protected void explode(Asteroid A)  { }

    /**
     * Virtual method. Implementation is in WaterIce class.
     *
     * @param A Asteroid that has this Resource
     */
    protected void sublime(Asteroid A) { }

    //</editor-fold>

    //<editor-fold desc="Getters and Setters">

    public String getResourceType() { return resourceType; }

    //</editor-fold>

}
