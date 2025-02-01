package io.navalbattle;

public record Coordinate(int x, int y) {

    public static Coordinate valueOf(int x, int y) {
        return new Coordinate(x, y);
    }
}
