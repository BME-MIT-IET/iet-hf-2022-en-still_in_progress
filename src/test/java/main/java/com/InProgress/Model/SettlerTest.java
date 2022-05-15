package main.java.com.InProgress.Model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SettlerTest {
    int ROCK_COVER = 3;
    private Asteroid sourceAsteroid = new Asteroid( 0, 0, 0,3);
    private Asteroid destinationAsteroid = new Asteroid( 2, 0, 0,3);
    private Asteroid wrongDestinationAsteroid = new Asteroid( 4, 4, 4,3);
    private TransportGate sourceGate = new TransportGate();
    private TransportGate destinationGate = new TransportGate();

    private Settler testSettler;
    @BeforeEach
    private void Arrange(){
        this.destinationAsteroid.setRockCover(3);
        this.destinationAsteroid.setResourceOfAsteroid(new Carbon("Carbon"));
        this.testSettler = new Settler("Test",this.sourceAsteroid,0);
        this.sourceAsteroid.setGate(this.sourceGate);
        this.destinationAsteroid.setGate(this.destinationGate);
        this.sourceGate.setPair(this.destinationGate);
        this.sourceGate.setActive(true);
        this.destinationGate.setActive(true);

    }


    @Test
    void Travel_Settler_Success(){
        testSettler.travel(destinationAsteroid);
        assertSame(testSettler.getCurrentPosition().getX(),this.destinationAsteroid.getX());
        assertSame(testSettler.getCurrentPosition().getY(),this.destinationAsteroid.getY());
        assertSame(testSettler.getCurrentPosition().getZ(),this.destinationAsteroid.getZ());

    }
    @Test
    void Travel_Settler_Failure(){
        testSettler.travel(this.wrongDestinationAsteroid);
        assertNotEquals(testSettler.getCurrentPosition().getX(),this.wrongDestinationAsteroid.getX());
        assertNotEquals(testSettler.getCurrentPosition().getY(),this.wrongDestinationAsteroid.getY());
        assertNotEquals(testSettler.getCurrentPosition().getZ(),this.wrongDestinationAsteroid.getZ());
    }
    /*

    @Test
    void FastTravel_Settler_Success(){
        testSettler.fastTravel(this.wrongDestinationAsteroid);
        assertNotEquals(testSettler.getCurrentPosition().getX(),this.wrongDestinationAsteroid.getX());
        assertNotEquals(testSettler.getCurrentPosition().getY(),this.wrongDestinationAsteroid.getY());
        assertNotEquals(testSettler.getCurrentPosition().getZ(),this.wrongDestinationAsteroid.getZ());

    }


    void FastTravel_Settler_Failure(){
        testSettler.fastTravel(this.destinationAsteroid);
        ;
    }

     */
    @Test
    void Drill_Settler_Success(){
        this.sourceAsteroid.setRockCover(ROCK_COVER);

        this.testSettler.drill(this.sourceAsteroid);

        assertEquals(ROCK_COVER-1,this.sourceAsteroid.getDepth());
    }
    @Test
    void Drill_Settler_Failure()
    {
        this.sourceAsteroid.setRockCover(0);
        this.testSettler.drill(this.sourceAsteroid);
        assertNotEquals(-1,this.sourceAsteroid.getDepth());
    }
    @Test
    void Mine_Settler_Success()
    {
        this.sourceAsteroid.setResourceOfAsteroid(new Carbon("Carbon"));
        this.sourceAsteroid.setRockCover(0);

        this.testSettler.mine(this.sourceAsteroid);

        String nameOfResource = this.testSettler.getItsInventory().getStoredResources().get(0).getResourceType();

        assertEquals(nameOfResource,"Carbon");
    }
    @Test
    void Mine_Settler_Failure()
    {
        this.sourceAsteroid.setResourceOfAsteroid(new Carbon("Carbon"));
        this.sourceAsteroid.setRockCover(1);

        this.testSettler.mine(this.sourceAsteroid);

        List<ResourceBase> emptyList = new ArrayList<ResourceBase>();

        assertEquals(this.testSettler.getItsInventory().getStoredResources(),emptyList);

    }

}
