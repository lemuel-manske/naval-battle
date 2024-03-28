package com.battle.naval.coordinate;

public record Coordinate(int x, int y) {

    @Override
    public boolean equals(Object object) {
        Coordinate that = (Coordinate) object;
        return x == that.x && y == that.y;
    }

}
