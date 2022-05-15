package main.java.com.InProgress.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidTest {

    Asteroid asteroidUT;
    Asteroid radioactiveAsteroidUT;
    Asteroid waterIceAsteroidUT;
    Asteroid asteroidForTravellingSettler;


    int ROCK_COVER = 5;
    int ROCK_COVER_DRILLED = 0;

    @BeforeEach
    void setUp() {

        asteroidUT = new Asteroid(0,0,0, 1);
        radioactiveAsteroidUT = new Asteroid(0,0,0,3);
        waterIceAsteroidUT = new Asteroid(0,0,0,4);
        asteroidForTravellingSettler = new Asteroid(1,0,0,1);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void decreaseRockCover_AsteroidUT_Success() {
        // Arrange
        asteroidUT.setRockCover(ROCK_COVER);

        // Act
        asteroidUT.decreaseRockCover();

        // Assert
        assertEquals(ROCK_COVER - 1, asteroidUT.getDepth());
    }

    @Test
    void emptyAsteroid_AsteroidUT_Success() {
        // Arrange
        asteroidUT.setRockCover(ROCK_COVER_DRILLED);

        // Act
        asteroidUT.emptyAsteroid();

        // Assert
        assertEquals(0, asteroidUT.getResourceOfAsteroid().size());
        assertTrue(asteroidUT.getHollow());
        assertFalse(asteroidUT.getRadioactive());
    }

    @Test
    void acceptTraveller_AsteroidUT_Success() {
        // Arrange
        Settler travellingSettler = new Settler("travelingSettler", asteroidForTravellingSettler, 1);

        // Act
        boolean resultOfTravel =  asteroidUT.acceptTraveller(travellingSettler);

        // Assert
        assertTrue(resultOfTravel);
    }

    @Test
    void acceptTraveller_AsteroidUT_NoSuccess() {
        // Arrange
        Settler settler01OnAsteroidUT = new Settler("settler01", asteroidUT, 1);
        Settler settler02OnAsteroidUT = new Settler("settler02", asteroidUT, 1);

        Settler travellingSetter = new Settler("travelingSettler", asteroidForTravellingSettler, 1);

        // Act
        boolean resultOfTravel =  asteroidUT.acceptTraveller(travellingSetter);

        // Assert
        assertFalse(resultOfTravel);
    }

    @Test
    void perihelionChanger_AsteroidUT_Success() {
        // Arrange
        asteroidUT.setAtPerihelion(false);
        asteroidUT.setRadioactive(false);
        asteroidUT.setRockCover(ROCK_COVER);

        // Act
        asteroidUT.perihelionChanger(true);

        // Assert
        assertTrue(asteroidUT.getAtPerihelion());
    }

/*    @Test
    void perihelionChanger_RadioactiveAsteroidUT_Explosion() {
        // Arrange
        radioactiveAsteroidUT.setAtPerihelion(false);
        radioactiveAsteroidUT.setRadioactive(true);
        radioactiveAsteroidUT.setRockCover(ROCK_COVER_DRILLED);

        // Act
        radioactiveAsteroidUT.perihelionChanger(true);

        // Assert
        assertTrue(radioactiveAsteroidUT.getAtPerihelion());
        assertTrue(radioactiveAsteroidUT.getExploded());
    }*/

    @Test
    void perihelionChanger_RadioactiveAsteroidUT_NoExplosion() {
        // Arrange
        radioactiveAsteroidUT.setAtPerihelion(false);
        radioactiveAsteroidUT.setRadioactive(true);
        radioactiveAsteroidUT.setRockCover(ROCK_COVER);

        // Act
        radioactiveAsteroidUT.perihelionChanger(true);

        // Assert
        assertTrue(radioactiveAsteroidUT.getAtPerihelion());
        assertFalse(radioactiveAsteroidUT.getExploded());
    }

    @Test
    void perihelionChanger_WaterIceAsteroidUT_Sublimation() {
        // Arrange
        waterIceAsteroidUT.setAtPerihelion(false);
        waterIceAsteroidUT.setRockCover(ROCK_COVER_DRILLED);

        // Act
        waterIceAsteroidUT.perihelionChanger(true);

        // Assert
        assertTrue(waterIceAsteroidUT.getAtPerihelion());
        assertTrue(waterIceAsteroidUT.getHollow());
    }

    // TODO Mention in doc that this test actually found an error in the code
    @Test
    void perihelionChanger_WaterIceAsteroidUT_NoSublimation() {
        // Arrange
        waterIceAsteroidUT.setAtPerihelion(false);
        waterIceAsteroidUT.setHollow(false);
        waterIceAsteroidUT.setRockCover(ROCK_COVER);

        // Act
        waterIceAsteroidUT.perihelionChanger(true);

        // Assert
        assertTrue(waterIceAsteroidUT.getAtPerihelion());
        assertFalse(waterIceAsteroidUT.getHollow());
    }



    @Test
    void hideMyTravellers_AsteroidUT_Success() {
        // Arrange
        Settler settler01OnAsteroidUT = new Settler("settler01", asteroidUT, 1);
        Settler settler02OnAsteroidUT = new Settler("settler02", asteroidUT, 1);

        settler01OnAsteroidUT.setHidden(false);
        settler02OnAsteroidUT.setHidden(false);

        asteroidUT.setRockCover(ROCK_COVER_DRILLED);
        asteroidUT.setHollow(true);

        // Act
        asteroidUT.hideMyTravellers();

        // Assert
        assertTrue(settler01OnAsteroidUT.getHidden());
        assertTrue(settler02OnAsteroidUT.getHidden());
    }


}