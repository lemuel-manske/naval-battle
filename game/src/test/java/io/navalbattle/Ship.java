package io.navalbattle;

public class Ship {

    private final int size;

    private Ship(int size) {
        this.size = size;
    }

    public int size() {
        return size;
    }

    public static Ship Boat() {
        return new Ship(1);
    }

    public static Ship Submarine() {
        return new Ship(2);
    }

    @Override
    public String toString() {
        return "[ size=%s ]".formatted(size);
    }
}
