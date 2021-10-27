package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static com.example.State.ALIVE;
import static com.example.State.DEAD;

public class GridTest {
    State[][] initialState = new State[][] {
            { DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD },
            { DEAD, DEAD, DEAD, DEAD, ALIVE, DEAD, DEAD, DEAD },
            { DEAD, DEAD, DEAD, ALIVE, ALIVE, DEAD, DEAD, DEAD},
            { DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, DEAD }
    };

    @Test
    void givenStateShouldBeStored() {
        Grid grid = new Grid(initialState);
        State[][] actualState = grid.getState();

        assertArrayEquals(initialState, actualState);
    }
}
