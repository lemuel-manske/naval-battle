package com.battle.naval.coordinate;

public class CoordinateDecoder {

    public static Coordinate decode(String encoded) {
        if (!encoded.matches("[A-J]-[0-9]|[01]?[0-9]|2[0-5]"))
            throw new InvalidCoordinates();

        return pointOf(encoded.split("-"));
    }

    public static Coordinate pointOf(String[] axis) {
        int x = Character.codePointAt(axis[0], 0) - 'A';
        int y = Integer.parseInt(axis[1]);
        return new Coordinate(x, y - 1);
    }
}