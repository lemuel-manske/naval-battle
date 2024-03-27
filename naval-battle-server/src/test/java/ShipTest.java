import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipTest {

    @Test
    void testShipChain() {
        Ship ship = new Ship(2);

        Chain chainOfTwo = new Chain(Ship.part(), Ship.part());

        assertEquals(chainOfTwo, ship.chain());
    }

}
