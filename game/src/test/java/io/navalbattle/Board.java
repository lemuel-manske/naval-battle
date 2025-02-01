package io.navalbattle;

public class Board {

    private final int size;
    private final Ship[][] board;

    public Board() {
        this(9);
    }

    public Board(int size) {
        this.size = size;
        board = new Ship[size][size];
    }

    public boolean isPosFree(final Coordinate c) {
        requireInBounds(c);

        return board[c.x()][c.y()] == null;
    }

    public void placeShip(final Ship ship, final Coordinate c) {
        requireInBounds(c);

        if (!isPosFree(c)) {
            throw new IllegalArgumentException("Coordinate occupied");
        }

        board[c.x()][c.y()] = ship;
    }

    public Ship shipAt(final Coordinate c) {
        requireInBounds(c);

        return board[c.x()][c.y()];
    }

    private void requireInBounds(Coordinate c) {
        if (c.x() > size || c.y() > size) {
            throw  new IllegalArgumentException("Coordinate out of bounds");
        }
    }

}
