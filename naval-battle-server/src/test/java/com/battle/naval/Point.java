package com.battle.naval;

public record Point(int x, int y) {

    private static final String POINT_PATTERN = "[A-J]-[0-9]";

    public static Point decode(String encoded) {
        if (!encoded.matches(POINT_PATTERN))
            throw new InvalidCoordinates();

        return pointOf(encoded.split("-"));
    }

    private static Point pointOf(String[] axis) {
        int x = Character.codePointAt(axis[0], 0) - 65;
        int y = Integer.parseInt(axis[1]);
        return new Point(x, y);
    }

}
