package io.naval;

class Board {

    private boolean isEmpty;

    public Board() {
        this.isEmpty = true;
    }

    /**
     * Returns whether the board is empty.
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    public void placeShip(final Ship ship) {
        isEmpty = false;
    }
}
