package com.battle.naval;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateDecoderTest {

    @Test
    void testInvalidEncodes() {
        assertThrows(InvalidCoordinates.class, () -> Point.decode("8-1"));
        assertThrows(InvalidCoordinates.class, () -> Point.decode("A-B"));
        assertThrows(InvalidCoordinates.class, () -> Point.decode("Z-12"));
    }

    @Test
    void testDecoder() {
        assertDecoded("B-5", 1, 5);
        assertDecoded("C-6", 2, 6);
    }

    private static void assertDecoded(String encoded, int expectedX, int expectedY) {
        Point decoded = Point.decode(encoded);
        assertEquals(expectedX, decoded.x());
        assertEquals(expectedY, decoded.y());
    }

}
