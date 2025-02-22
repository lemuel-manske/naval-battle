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
        int pos = c.x();

        do {
            if (board[pos][c.y()] != null && !board[pos][c.y()].equals(ship)) {
                throw new IllegalArgumentException("Coordinate occupied");
            }

            for (int i = c.y() - 1; i < c.y() + 1; i++) {
                if (i < 0f) continue;
                if (i >= size-1) break;
                board[pos][i] = ship;
            }

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
