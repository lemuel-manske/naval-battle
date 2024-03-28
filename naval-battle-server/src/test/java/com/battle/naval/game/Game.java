package com.battle.naval.game;

public class Game {

    private int boardSize;

    public Game() {

    }

    public Game(int boardSize) {
        this.boardSize = boardSize;
    }

    public void attack(String coordinate) {
        if (boardSize == 0)throw new NoOpponent();
        throw new NoShips();
    }

}
