package io.navalbattle;

public class Board {

    private final Ship[][] board;

    public Board() {
        this(9);
    }

    public Board(int size) {
        board = new Ship[size][size];
    }

    public boolean isPosFree(final Coordinate c) {
        return board[c.x()][c.y()] != null;
    }

    public void placeShip(final Ship ship, final Coordinate c) {
        if (board[c.x()][c.y()] != null) {
            throw new IllegalArgumentException("Coordinate occupied");
        }

        board[c.x()][c.y()] = ship;
    }

    public Ship shipAt(final Coordinate c) {
        return board[c.x()][c.y()];
    }
}
