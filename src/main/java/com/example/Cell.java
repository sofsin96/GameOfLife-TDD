package com.example;

public class Cell {

    public static final int MIN_NEIGHBORS_PER_CELL = 2;
    public static final int MAX_NEIGHBORS_PER_CELL = 3;
    public static final int THREE_NEIGHBORS_PER_DEAD_CELL = 3;
    private final State state;

    public Cell(State state) {
        this.state = state;
    }

    public State calculateNextGeneration(int neighbors) {
        if (state == State.ALIVE) {
            if (neighbors == MIN_NEIGHBORS_PER_CELL || neighbors == MAX_NEIGHBORS_PER_CELL) {
                return State.ALIVE;
            }
        }
        else if (state == State.DEAD) {
            if (neighbors == THREE_NEIGHBORS_PER_DEAD_CELL) {
                return State.ALIVE;
            }
        }
        return State.DEAD;
    }
}
