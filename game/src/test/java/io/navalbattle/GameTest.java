package io.navalbattle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    void shouldCreateABoard() {
        assertNotNull(board);
    }
    
    @Test
    void whenShipIsPlacedAt00Then00IsOccupied() {
        Ship ship = Ship.Boat();

        board.placeShip(ship, Coordinate.valueOf(0, 0));

        assertTrue(board.isOccupied(Coordinate.valueOf(0, 0)));
    }

    @Test
    void whenShipIsPlacedThenItIsAtPosition() {
        Ship ship = Ship.Boat();

        board.placeShip(ship, Coordinate.valueOf(0, 0));

        assertSame(ship, board.shipAt(Coordinate.valueOf(0, 0)));
    }

    @Test
    void shouldThrowWhenTryingToPlaceShipAtOccupiedPosition() {
        Ship ship1 = Ship.Boat();

        board.placeShip(ship1, Coordinate.valueOf(0, 0));

        Ship ship2 = Ship.Boat();

        assertThrows(IllegalArgumentException.class,
                () -> board.placeShip(ship2, Coordinate.valueOf(0, 0)));
    }

    @Test
    void shouldThrowWhenTryingToPlaceShitAoPositionOccupiedBySubmarine() {
        Ship submarine = Ship.Submarine();

        board.placeShip(submarine, Coordinate.valueOf(0, 0));

        assertThrows(IllegalArgumentException.class,
            () -> board.placeShip(Ship.Boat(), Coordinate.valueOf(1,0)));
    }

    @Test
    void doNotAllowToPlaceShipSideBySide() {
        Ship ship1 = Ship.Boat();

        board.placeShip(ship1, Coordinate.valueOf(0,0));

        Ship ship2 = Ship.Boat();

        assertThrows(IllegalArgumentException.class, () -> board.placeShip(ship2, Coordinate.valueOf(1,0)));
        assertThrows(IllegalArgumentException.class, () -> board.placeShip(ship2, Coordinate.valueOf(0,1)));
        assertThrows(IllegalArgumentException.class, () -> board.placeShip(ship2, Coordinate.valueOf(1,1)));
    }

    @Test
    void shouldPlaceSubmarine() {
        Ship submarine = Ship.Submarine();

        board.placeShip(submarine, Coordinate.valueOf(0, 0));

        assertSame(submarine, board.shipAt(Coordinate.valueOf(0, 0)));
        assertSame(submarine, board.shipAt(Coordinate.valueOf(1, 0)));
    }

    @Test
    void shouldPlaceSubmarineAtNearEnd() {
        Ship submarine = Ship.Submarine();

        board.placeShip(submarine, Coordinate.valueOf(8, 9));

        assertSame(submarine, board.shipAt(Coordinate.valueOf(8, 9)));
        assertSame(submarine, board.shipAt(Coordinate.valueOf(9, 9)));
    }
}
