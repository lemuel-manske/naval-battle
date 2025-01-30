package com.battle.naval.board;

import com.battle.naval.coordinate.Coordinate;
import com.battle.naval.ship.Ship;

public class Board {

    private final Fleet fleet;

    public Board(int rows, int columns) {
        if (rows > 15 || rows < 10)
            throw new InvalidBoardSize();
        this.fleet = new Fleet(rows, columns);
    }

    public Board(int squareSize) {
        this(squareSize, squareSize);
    }

    public Ship shipAt(String encodedCoordinate) throws InvalidPosition {
        return fleet.findShip(decode(encodedCoordinate));
    }

    public void placeShip(Ship ship, String encodedCoordinate) throws InvalidPosition {
        fleet.placeShip(ship, decode(encodedCoordinate));
    }

    private Coordinate decode(String encodedCoordinate) throws InvalidPosition {
        Coordinate coordinate = Coordinate.decode(encodedCoordinate);

        if (coordinate.x() > fleet.rows && coordinate.y() > fleet.columns)
            throw new InvalidPosition();

        return coordinate;
    }

    private static class Fleet {

        private final int rows;
        private final int columns;

        private final Ship[][] fleet;

        public Fleet(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            this.fleet = new Ship[rows][columns];
        }

        public Ship findShip(Coordinate c) {
            return fleet[c.x()][c.y()];
        }

        public void placeShip(Ship ship, Coordinate headCoordinate) throws InvalidPosition {
            Coordinate[] shipCoordinates = makeCoordinatesChain(ship, headCoordinate);

            if (!canShipBePlacedHere(shipCoordinates))
                throw new InvalidPosition();

            putShip(ship, shipCoordinates);
        }

        private void putShip(Ship ship, Coordinate[] shipCoordinates) {
            for (Coordinate c : shipCoordinates)
                fleet[c.x()][c.y()] = ship;
        }

        private Coordinate[] makeCoordinatesChain(Ship ship, Coordinate headCoordinate) {
            Coordinate[] coords = new Coordinate[ship.size()];

            for (int offset = 0; offset < ship.size(); offset++)
                coords[offset] = new Coordinate(headCoordinate.x(), headCoordinate.y() + offset);

            return coords;
        }

        private boolean canShipBePlacedHere(Coordinate[] coords) {
            for (Coordinate c : coords)
                for (int i = Math.max(0, c.x() - 1); i < Math.min(c.x() + 2, rows); i++)
                    for (int j = Math.max(0, c.y() - 1); j < Math.min(c.y() + 2, columns); j++)
                        if (!(i == c.x() && j == c.y()) && fleet[i][j] != null)
                            return false;

            return true;
        }

    }
}
