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

        int topRow = row - 1;
        int leftCol = col - 1;
        int rightCol = col + 1;
        int bottomRow = row + 1;

        if (row > 0) {
            if (col > 0 ) {
                if (state[topRow][leftCol] == ALIVE) aliveNeighbors++;
            }
            if (state[topRow][col] == ALIVE) aliveNeighbors++;
            if (col < state[row].length - 1) {
                if (state[topRow][rightCol] == ALIVE) aliveNeighbors++; {
                }
            }
        }

        if (col > 0 ) {
            if (state[row][leftCol] == ALIVE) aliveNeighbors++;
        }
        if (state[row][col] == ALIVE) aliveNeighbors++;
        if (col < state[row].length - 1) {
            if (state[row][rightCol] == ALIVE) aliveNeighbors++; {
            }
        }

        if (row < state.length - 1) {
            if (col > 0 ) {
                if (state[bottomRow][leftCol] == ALIVE) aliveNeighbors++;
            }
            if (state[bottomRow][col] == ALIVE) aliveNeighbors++;
            if (col < state[row].length - 1) {
                if (state[bottomRow][rightCol] == ALIVE) aliveNeighbors++; {
                }
            }
        }
        return aliveNeighbors;
    }
}
