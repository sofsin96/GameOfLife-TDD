package com.example;

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
}
