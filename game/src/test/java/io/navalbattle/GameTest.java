package io.navalbattle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertFalse(board.isOccupied(Coordinate.valueOf(1,2)));
    }
    
    @Test
    void testPlaceShipThenPositionNotFree() {
        Ship ship = Ship.Boat();

        board.placeShip(ship, Coordinate.valueOf(0, 0));

        assertTrue(board.isOccupied(Coordinate.valueOf(0, 0)));
    }

    @Test
    void testShipAtPositionAfterPlacing() {
        Ship ship = Ship.Boat();

        board.placeShip(ship, Coordinate.valueOf(0, 0));

        assertSame(ship, board.shipAt(Coordinate.valueOf(0, 0)));
    }

    @Test
    void testCannotPlaceShipOnOccupiedPosition() {
        Ship ship1 = Ship.Boat();

        board.placeShip(ship1, Coordinate.valueOf(0, 0));

        Ship ship2 = Ship.Boat();

        assertThrows(IllegalArgumentException.class,
                () -> board.placeShip(ship2, Coordinate.valueOf(0, 0)));
    }
    
    @Test
    void testOutOfBoardBounds() {
        Coordinate outOfBoundsCoords = Coordinate.valueOf(10, 10);

        assertThrows(IllegalArgumentException.class,
                () -> board.placeShip(Ship.Boat(), outOfBoundsCoords));

        assertThrows(IllegalArgumentException.class,
                () -> board.shipAt(outOfBoundsCoords));

        assertThrows(IllegalArgumentException.class,
                () -> board.isOccupied(outOfBoundsCoords));
    }

    @Test
    void testPlaceShipsAtDifferentPositions() {
        Ship ship1 = Ship.Boat();

        board.placeShip(ship1, Coordinate.valueOf(0,0));

        Ship ship2 = Ship.Boat();

        board.placeShip(ship2, Coordinate.valueOf(1,0));

        assertSame(ship1, board.shipAt(Coordinate.valueOf(0,0)));
        assertSame(ship2, board.shipAt(Coordinate.valueOf(1,0)));
    }
}
