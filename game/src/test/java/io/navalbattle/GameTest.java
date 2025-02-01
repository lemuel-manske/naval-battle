package io.navalbattle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        assertFalse(board.isPosFree(Coordinate.valueOf(1,2)));
    }
    
    @Test
    void testPlaceShipThenPositionNotFree() {
        Ship ship = new Ship();

        board.placeShip(ship, Coordinate.valueOf(0, 0));

        assertTrue(board.isPosFree(Coordinate.valueOf(0, 0)));
    }

    @Test
    void testShipAtPositionAfterPlacing() {
        Ship ship = new Ship();

        board.placeShip(ship, Coordinate.valueOf(0, 0));

        assertSame(ship, board.shipAt(Coordinate.valueOf(0, 0)));
    }
    @Test
    void testCannotPlaceShipOnOccupiedPosition() {
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        board.placeShip(ship1, Coordinate.valueOf(0, 0));

        var exception = assertThrows(IllegalArgumentException.class, () -> board.placeShip(ship2, Coordinate.valueOf(0, 0)));

        assertEquals("Coordinate occupied", exception.getMessage());
    }
}
