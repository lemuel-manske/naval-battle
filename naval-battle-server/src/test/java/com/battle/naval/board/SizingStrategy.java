package com.battle.naval.board;

public class SizingStrategy {

    private final int value;

    public SizingStrategy(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    public static SizingStrategy getDefault() {
        return new SizingStrategy(9);
    }

}