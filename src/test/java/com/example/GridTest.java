package com.example;

import org.junit.jupiter.api.Test;

import static com.example.State.*;
import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private static final State A = ALIVE;
    private static final State D = DEAD;

    @Test
    void givenStateShouldBeStored() {
        State[][] initialState = new State[][] {
                { D, D, D, D, D, D, D, D },
                { D, D, D, D, A, D, D, D },
                { D, D, D, A, A, D, D, D },
                { D, D, D, D, D, D, D, D }
        };

        Grid grid = new Grid(initialState);
        State[][] actualState = grid.getState();

        assertArrayEquals(initialState, actualState);
    }

    @Test
    void givenCellShouldBeDeadInTheNextGeneration() {
        State[][] initialCellState = new State[][] { { A } };
        Grid grid = new Grid(initialCellState);
        grid.getNextState();
        State[][] actualCellState = grid.getState();

        assertEquals(DEAD, actualCellState[0][0]);
    }

    @Test
    void givenGridOfCellsShouldBeUpdatedInTheNextGeneration() {
        State[][] initialState = new State[][] {
                { D, D, D, D, D, D, D, D },
                { D, D, D, D, A, D, D, D },
                { D, D, D, A, A, D, D, D },
                { D, D, D, D, D, D, D, D }
        };

        Grid grid = new Grid(initialState);

        State[][] expectedState = new State[][] {
                { D, D, D, D, D, D, D, D },
                { D, D, D, A, A, D, D, D },
                { D, D, D, A, A, D, D, D },
                { D, D, D, D, D, D, D, D }
        };

        grid.getNextState();
        State[][] actualState = grid.getState();

        assertArrayEquals(expectedState, actualState);
    }
}
