package io.navalbattle;

public class Board {

    private final int size;
    private final Ship[][] board;

    public Board() {
        this(10);
    }

    public Board(int size) {
        this.size = size;
        this.board = new Ship[size][size];
    }

    public boolean isOccupied(final Coordinate c) {
        requireInBounds(c);

        return board[c.x()][c.y()] != null;
    }

    public void placeShip(final Ship ship, final Coordinate c) {
        if (isOccupied(c)) {
            throw new IllegalArgumentException("Coordinate occupied");
        }

        int pos = c.x();

        do {
            board[pos++][c.y()] = ship;
        } while (pos < c.x() + ship.size());
    }

    public Ship shipAt(final Coordinate c) {
        requireInBounds(c);

        return board[c.x()][c.y()];
    }

    private void requireInBounds(Coordinate c) {
        if (c.x() >= size || c.y() >= size) {
            throw  new IllegalArgumentException("Coordinate out of bounds");
        }
    }
}
