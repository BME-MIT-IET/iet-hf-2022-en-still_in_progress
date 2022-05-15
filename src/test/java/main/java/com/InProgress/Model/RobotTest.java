package main.java.com.InProgress.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Asteroid asteroid01;
    Asteroid asteroid02;
    Asteroid asteroid03;
    Asteroid asteroid04;
    Robot robotUT;

    int  ROCK_COVER = 5;


    @BeforeEach
    void setUp() {
        // A Game must be initialized for some internal checks
        Game.startGame(1,5,5,5);

        asteroid01 = new Asteroid(0, 0, 0, 0); // Asteroid on location 0/0/0
        asteroid02 = new Asteroid(0, 0, 1, 0); // Asteroid on location 0/0/1
        asteroid03 = new Asteroid(9, 0, 0, 0); // Asteroid on location 9/0/0
        asteroid04 = new Asteroid(0, 0, 5, 0); // Asteroid on location 0/0/5 reachable only with gate
        robotUT = new Robot(asteroid01);
    }

    @AfterEach
    void tearDown() {
        Game.getPlayers().clear();
        Game.getRobots().clear();
    }

    @Test
    void travel_RobotUT_Success() {
        // Arrange
        asteroid02.setHollow(false);

        // Act
        robotUT.travel(asteroid02);

        // Assert
        assertEquals(asteroid02.getX(), robotUT.currentPosition.getX());
        assertEquals(asteroid02.getY(), robotUT.currentPosition.getY());
        assertEquals(asteroid02.getZ(), robotUT.currentPosition.getZ());
    }


    /*@Test
    void fastTravel_RobotUT_Success() {
        // Arrange
        TransportGate originGate = new TransportGate();
        originGate.setCurrentPosition(asteroid01);
        originGate.setActive(true);
        asteroid01.setGate(originGate);
        TransportGate destinationGate = new TransportGate();
        destinationGate.setCurrentPosition(asteroid04);
        destinationGate.setActive(true);
        originGate.setPair(destinationGate);

        // Act
        robotUT.fastTravel(robotUT.currentPosition);

        // Assert
        assertEquals(robotUT.currentPosition.getX(), destinationGate.getCurrentPosition().getX());
        assertEquals(robotUT.currentPosition.getY(), destinationGate.getCurrentPosition().getY());
        assertEquals(robotUT.currentPosition.getZ(), destinationGate.getCurrentPosition().getZ());
    }*/


    @Test
    void drill_RobotUT_Success() {
        // Arrange
        asteroid01.setRockCover(ROCK_COVER);

        // Act
        robotUT.drill(asteroid01);

        // Assert
        assertEquals(asteroid01.getDepth(), ROCK_COVER - 1);
    }


    @Test
    void increaseDamage_RobotUT_Dies() {
        // Arrange
        robotUT.setDamageCount(1);

        // Act
        robotUT.increaseDamage();

        // Assert
        assertFalse(robotUT.getAlive());
    }

    @Test
    void increaseDamage_RobotUT_Survives() {
        // Arrange
        robotUT.setDamageCount(0);

        // Act
        robotUT.increaseDamage();

        // Assert
        assertTrue(robotUT.getAlive());
    }
}