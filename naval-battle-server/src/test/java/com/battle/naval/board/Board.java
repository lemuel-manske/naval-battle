package com.battle.naval.board;

import com.battle.naval.coordinate.Coordinate;
import com.battle.naval.ship.Ship;

public class Board {

    private final SizingStrategy boardSize;

    private final Ship[][] grid;

    public Board(int boardSize) {
        if (boardSize > 15 || boardSize < 10)
            throw new InvalidBoardSize();
        this.boardSize = new SizingStrategy(boardSize);
        this.grid = new Ship[boardSize][boardSize];
    }

    public void placeShip(Ship ship, String encodedCoordinate) {
        Coordinate headCoordinate = parseCoordinate(encodedCoordinate);

        Coordinate[] shipCoordinates = new Coordinate[ship.size()];

        for (int offset = 0; offset < ship.size(); offset++)
            shipCoordinates[offset] = new Coordinate(headCoordinate.x(), headCoordinate.y() + offset);

        if (!canShipBePlacedHere(shipCoordinates))
            throw new InvalidPosition();

        for (Coordinate c : shipCoordinates)
            grid[c.x()][c.y()] = ship;
    }

    private boolean canShipBePlacedHere(Coordinate[] coords) {
        for (Coordinate c : coords)
            for (int i = Math.max(0, c.x() - 1); i < Math.min(c.x() + 2, boardSize.get()); i++)
                for (int j = Math.max(0, c.y() - 1); j < Math.min(c.y() + 2, boardSize.get()); j++)
                    if (!(i == c.x() && j == c.y()) && grid[i][j] != null)
                        return false;

        return true;
    }

    public Ship shipAt(String encodedCoordinate) {
        Coordinate coordinate = parseCoordinate(encodedCoordinate);
        return grid[coordinate.x()][coordinate.y()];
    }

    private Coordinate parseCoordinate(String encodedCoordinate) {
        return Coordinate.decode(encodedCoordinate, SizingStrategy.getDefault());
    }

}
