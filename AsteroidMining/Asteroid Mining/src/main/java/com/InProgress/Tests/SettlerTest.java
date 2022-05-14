package main.java.com.InProgress.Tests;
import main.java.com.InProgress.Model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SettlerTest {

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
}
