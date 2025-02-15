package io.navalbattle;

public class Ship {

    private final int size;

    private Ship(int size) {
        this.size = size;
    }

    public static Ship Boat() {
        return  new Ship(1);
    }
}
