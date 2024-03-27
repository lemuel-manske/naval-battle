package com.battle.naval.coordinate;

import com.battle.naval.board.SizingStrategy;

public record Coordinate(int x, int y) {

    public static Coordinate decode(String encoded, SizingStrategy strategy) {
        if (!encoded.matches(makePattern(strategy)))
            throw new InvalidCoordinates();

        return pointOf(encoded.split("-"));
    }

    private static String makePattern(SizingStrategy strategy) {
        int maxY = strategy.get();
        char maxX = (char) (strategy.get() + (int) 'A');

        return String.format("[A-%c]-[0-%d]", maxX, maxY);
    }

    private static Coordinate pointOf(String[] axis) {
        int x = Character.codePointAt(axis[0], 0) - 'A';
        int y = Integer.parseInt(axis[1]);
        return new Coordinate(x, y);
    }

    @Override
    public boolean equals(Object object) {
        Coordinate that = (Coordinate) object;
        return x == that.x && y == that.y;
    }

}
