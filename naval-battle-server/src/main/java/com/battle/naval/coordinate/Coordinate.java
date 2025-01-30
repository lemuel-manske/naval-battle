package com.battle.naval.coordinate;

public record Coordinate(int x, int y) {

    public static Coordinate valueOf(int[] axis) {
        return new Coordinate(axis[0], axis[1]);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        Coordinate that = (Coordinate) object;
        return x == that.x && y == that.y;
    }

}
