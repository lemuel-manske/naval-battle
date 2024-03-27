import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    private Board board;

    @BeforeEach
    void createBoard() {
        board = new Board(10);
    }

    @Test
    void testInvalidBoardSize() {
        assertThrows(InvalidBoardSizeException.class,
                () -> new Board(16));
    }

    @Test
    void testBoardSizeConfiguration() {
        assertEquals("10x10", board.toString());
    }

    @Test
    void testInvalidPosition() {
        Point invalidPoint = new Point(0, 3);
        assertNull(board.shipAt(invalidPoint));

        Point outOfBoundsPoint = new Point(1, 11);
        assertThrows(InvalidShipPositionException.class,
                () -> board.shipAt(outOfBoundsPoint));
    }

    @Test
    void testInvalidPlacement() {
        assertThrows(InvalidShipPositionException.class,
                () -> board.placeShipVertical(new Ship(1), new Point(1,11)));
    }

    @Test
    void testHorizontalPlacement() {
        Ship ship = new Ship(2);

        board.placeShipHorizontal(ship, new Point(0, 1));

        assertEquals(ship, board.shipAt(new Point(0, 1)));
        assertEquals(ship, board.shipAt(new Point(0, 2)));
    }

    @Test
    void testVerticalPlacement() {
        Ship ship = new Ship(2);

        board.placeShipVertical(ship, new Point(0, 1));

        assertEquals(ship, board.shipAt(new Point(0, 1)));
        assertEquals(ship, board.shipAt(new Point(1, 1)));
    }

    void testShipSideBySide() {
        board.placeShipVertical(
                new Ship(1), new Point(0, 0));

        assertThrows(InvalidShipPositionException.class,
                () -> board.placeShipVertical(
                        new Ship(1), new Point(0, 1)));
    }

}
