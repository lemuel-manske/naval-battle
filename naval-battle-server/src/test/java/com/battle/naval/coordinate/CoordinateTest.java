package com.battle.naval.coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {

    @Test
    void testInvalidEncodes() {
        assertThrows(InvalidCoordinates.class, () -> Coordinate.decode("8-1"));
        assertThrows(InvalidCoordinates.class, () -> Coordinate.decode("A-B"));
        assertThrows(InvalidCoordinates.class, () -> Coordinate.decode("Z-12"));
    }

    @Test
    void testDecoder() {
        assertDecoded(new Coordinate(1, 0), "B-1");
        assertDecoded(new Coordinate(2, 8), "C-9");
    }

    private static void assertDecoded(Coordinate expectedCoordinate, String encoded) {
        Coordinate decoded = Coordinate.decode(encoded);
        assertEquals(expectedCoordinate, decoded);
    }

}
