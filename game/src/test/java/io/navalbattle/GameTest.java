package io.navalbattle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    void testCreateBoard() {
        assertNotNull(board);
    }

    @Test
    void testPositionFreeWhenEmptyBoard() {
        assertFalse(board.isPosFree(0,0));
    }
    
    @Test
    void testPlaceShipThenPositionNotFree() {
        Ship ship = new Ship();

        board.placeShip(ship, 0, 0);

        assertTrue(board.isPosFree(0,0));
    }
}
