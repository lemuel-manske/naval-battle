package com.battle.naval.board;

import com.battle.naval.coordinate.Coordinate;
import com.battle.naval.ship.Destroyer;
import com.battle.naval.ship.Ship;
import com.battle.naval.ship.Submarine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    @Test
    void testInvalidBoardSize() {
        assertThrows(InvalidBoardSize.class, () -> new Board(16));
        assertThrows(InvalidBoardSize.class, () -> new Board(9));
    }

    @Nested
    class GivenBoard {
        private Board board;

        @BeforeEach
        void createBoard() {
            board = new Board(10);
        }

        @Test
        void placeShip() throws InvalidPosition {
            Ship destroyer = new Destroyer();

            board.placeShip(destroyer, Coordinate.valueOf(new int[]{ 1, 5 }));

            assertEquals(destroyer, board.shipAt(Coordinate.valueOf(new int[]{ 1, 5 })));
            assertEquals(destroyer, board.shipAt(Coordinate.valueOf(new int[]{ 1, 6 })));
            assertEquals(destroyer, board.shipAt(Coordinate.valueOf(new int[]{ 1, 7 })));

            Ship submarine = new Submarine();

            board.placeShip(submarine, Coordinate.valueOf(new int[]{ 3, 3 }));

            assertEquals(submarine, board.shipAt(Coordinate.valueOf(new int[]{ 3, 3 })));
            assertEquals(submarine, board.shipAt(Coordinate.valueOf(new int[]{ 3, 4 })));
        }

        @Test
        void doNotAllowShipsSideBySide() throws InvalidPosition {
            board.placeShip(new Destroyer(), Coordinate.valueOf(new int[]{ 0, 3 }));

            assertThrows(InvalidPosition.class, // Submarine will overflow Destroyer
                    () -> board.placeShip(new Submarine(), Coordinate.valueOf(new int[]{ 0, 2 })));

            assertThrows(InvalidPosition.class, // Submarine can not touch Destroyer
                    () -> board.placeShip(new Submarine(), Coordinate.valueOf(new int[]{ 1, 4 })));
        }

    }

}
