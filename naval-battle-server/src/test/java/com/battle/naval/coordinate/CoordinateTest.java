package com.battle.naval.coordinate;

import com.battle.naval.board.SizingStrategy;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {

    @Test
    void testInvalidEncodes() {
        assertThrows(InvalidCoordinates.class, () -> Coordinate.decode("8-1", SizingStrategy.getDefault()));
        assertThrows(InvalidCoordinates.class, () -> Coordinate.decode("A-B", SizingStrategy.getDefault()));
        assertThrows(InvalidCoordinates.class, () -> Coordinate.decode("Z-12", SizingStrategy.getDefault()));
    }

    @Test
    void testDecoder() {
        assertDecoded(new Coordinate(1, 5), "B-5");
        assertDecoded(new Coordinate(2, 6), "C-6");
    }

    private static void assertDecoded(Coordinate expectedCoordinate, String encoded) {
        Coordinate decoded = Coordinate.decode(encoded, SizingStrategy.getDefault());
        assertEquals(expectedCoordinate, decoded);
    }

}
