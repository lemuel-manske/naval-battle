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
        Ship ship = new Ship();

        board.placeShip(ship);

        assertFalse(board.isEmpty());
    }

}
