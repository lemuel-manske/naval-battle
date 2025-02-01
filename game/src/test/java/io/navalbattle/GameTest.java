package io.navalbattle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
        Coordinate c = new Coordinate(1,2);
        assertFalse(board.isPosFree(c));
    }
    
    @Test
    void testPlaceShipThenPositionNotFree() {
        Ship ship = new Ship();

        Coordinate start = new Coordinate(0, 0);

        board.placeShip(ship, start);

        assertTrue(board.isPosFree(start));
    }

    @Test
    void testShipAtPositionAfterPlacing() {
        Ship ship = new Ship();

        Coordinate start = new Coordinate(0, 0);

        board.placeShip(ship, start);

        assertSame(ship, board.shipAt(start));
    }
}
