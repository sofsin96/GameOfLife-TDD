package com.example;

import static com.example.State.*;

public class Cell {

    public static final int MIN_NEIGHBORS_PER_CELL = 2, MAX_NEIGHBORS_PER_CELL = 3, THREE_NEIGHBORS_PER_DEAD_CELL = 3;
    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public void calculateNextGeneration(int neighbors) {
        switch (state) {
            case ALIVE -> state = neighbors == MIN_NEIGHBORS_PER_CELL || neighbors == MAX_NEIGHBORS_PER_CELL ? ALIVE : DEAD;
            case DEAD -> state = neighbors == THREE_NEIGHBORS_PER_DEAD_CELL ? ALIVE : DEAD;
        }
    }

    public State getState() {
        return state;
    }
}

