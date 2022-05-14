package main.java.com.InProgress.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsteroidTest {

    Asteroid asteroidUT;
    Asteroid asteroidForTravellingSettler;


    int ROCK_COVER = 5;
    int ROCK_COVER_DRILLED = 0;

    @BeforeEach
    void setUp() {

        asteroidUT = new Asteroid(0,0,0, 0);
        asteroidForTravellingSettler = new Asteroid(1,0,0,0);
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
        Settler travellingSettler = new Settler("settler1", asteroidForTravellingSettler, 1);

        // Act
        boolean resultOfTravel =  asteroidUT.acceptTraveller(travellingSettler);

        // Assert
        assertTrue(resultOfTravel);
    }

    @Test
    void acceptTraveller_AsteroidUT_NoSuccess() {
        // Arrange
        Settler settler01OnAsteroidUT = new Settler("settler1", asteroidUT, 1);
        Settler settler02OnAsteroidUT = new Settler("settler1", asteroidUT, 1);

        Settler travellingSetter = new Settler("settler1", asteroidForTravellingSettler, 1);

        // Act
        boolean resultOfTravel =  asteroidUT.acceptTraveller(travellingSetter);

        // Assert
        assertFalse(resultOfTravel);
    }

    @Test
    void perihelionChanger() {
    }

    @Test
    void hideMyTravellers() {
    }
}