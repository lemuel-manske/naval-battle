package com.battle.naval.board;

import com.battle.naval.ship.Destroyer;
import com.battle.naval.ship.Ship;
import com.battle.naval.ship.Submarine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board(10);
    }

    @Test
    void testInvalidBoardSize() {
        assertThrows(InvalidBoardSize.class, () -> new Board(16));
        assertThrows(InvalidBoardSize.class, () -> new Board(9));
    }

    @Test
    void placeShip() throws InvalidPosition {
        Ship destroyer = new Destroyer();
        board.placeShip(destroyer, "B-5");

        assertEquals(destroyer, board.shipAt("B-5"));
        assertEquals(destroyer, board.shipAt("B-6"));
        assertEquals(destroyer, board.shipAt("B-7"));
    }

    @Test
    void doNotAllowShipsSideBySide() throws InvalidPosition {
        board.placeShip(new Destroyer(), "A-4");

        assertThrows(InvalidPosition.class, // Submarine will overflow Destroyer
                () -> board.placeShip(new Submarine(), "A-2"));

        assertThrows(InvalidPosition.class, // Submarine can not touch Destroyer
                () -> board.placeShip(new Submarine(), "B-5"));
    }

}
