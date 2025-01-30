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

    public void placeShip(final Ship ship, final String coordinates) {
        Coordinate.valueOf(coordinates);
        isEmpty = false;
    }

    public boolean isOccupiedAt(final String coordinates) {
        return true;
    }

    private static class Coordinate {
        public static void valueOf(final String coordinates) {
//            if (!coordinates.matches("[A-J]-[10]-[HV]"))
//                throw new IllegalArgumentException();
//
//            var parts = coordinates.split("-");
//            var row = Character.valueOf(parts[0]);
//            var column = Integer.parseInt(parts[1]);
//            var orientation = ORIENTATION.valueOf(parts[2]);
//


        }

        private enum ORIENTATION { H , V }
    }
}
