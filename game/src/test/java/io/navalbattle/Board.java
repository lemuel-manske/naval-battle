package io.navalbattle;

public class Board {

    private final boolean[][] board;

    public Board() {
        this(9);
    }

    public Board(int size) {
        board = new boolean[size][size];
    }

    public boolean isPosFree(int x, int y) {
        return board[x][y];
    }

    public void placeShip(final Ship ship, int x, int y) {
        board[x][y] = true;
    }
}
