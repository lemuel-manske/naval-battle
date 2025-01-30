package io.naval;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void whenCreatedBoardIsEmpty() {
        assertTrue(board.isEmpty());
    }

    @Test
    void whenShipIsPlacedThenBoardIsNotEmpty() {
        Ship ship = new Ship(1);

        board.placeShip(ship, "A-1");

        assertFalse(board.isEmpty());
    }

    @Test
    void placeShip() {
        Ship ship = new Ship(3);

        board.placeShip(ship, "A-1-H");

        assertOccupiedAt("A-1", "A-2", "A-3");

        assertFalse(board.isOccupiedAt("A-4"));
    }

    private void assertOccupiedAt(String... coordinates) {
        for (String coordinate : coordinates)
            assertTrue(board.isOccupiedAt(coordinate));
    }
}
