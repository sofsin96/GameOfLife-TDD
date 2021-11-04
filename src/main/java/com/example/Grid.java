package com.example;

import static com.example.State.ALIVE;

public class Grid {

    private final Cell[][] cellState;

    public Grid(State[][] states) {
        cellState = new Cell[states.length][];
        initializeGrid(states);
    }

    private void initializeGrid(State[][] states) {
        for (int row = 0; row < states.length; row++) {
            cellState[row] = new Cell[states[row].length];
            for (int col = 0; col < states[row].length ; col++) {
                cellState[row][col] = new Cell(states[row][col]);
            }
        }
    }

    public State[][] getState() {
        State[][] states = new State[cellState.length][];
        for (int row = 0; row < cellState.length; row++) {
            states[row] = new State[cellState[row].length];
            for (int col = 0; col < cellState[row].length ; col++) {
                states[row][col] = cellState[row][col].getState();
            }
        }
        return states;
    }

    public void getNextState() {
        State[][] states = getState();
        for (int row = 0; row < cellState.length; row++) {
            for (int col = 0; col < cellState[row].length; col++) {
                int aliveNeighbors = countAliveNeighbors(states, row, col);
                cellState[row][col].calculateNextGeneration(aliveNeighbors);
            }
        }
    }

    private int countAliveNeighbors(State[][] state, int row, int col) {
        int aliveNeighbors = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < state.length)
                for (int j = col - 1; j <= col + 1; j++)
                    if (j >= 0 && j < state[i].length)
                        if (i != row || j != col)
                            if (state[i][j] == ALIVE)
                                aliveNeighbors++;
        }
        return aliveNeighbors;
    }
}
