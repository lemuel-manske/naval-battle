package com.battle.naval.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private Game game;

    @BeforeEach
    void createGame() {
        game = new Game(10);
    }

    @Test
    void testNoOpponent() {
        assertThrows(NoOpponent.class,
                () -> new Game().attack("A-1"));
    }

    @Test
    void testNoShips() {
        assertThrows(NoShips.class,
                () -> game.attack("A-1"));
    }

}
