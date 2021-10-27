package com.example;

public class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public State calculateNextGeneration(int neighbors) {
        if (state == State.ALIVE) {
            if (neighbors == 2 || neighbors == 3) {
                return State.ALIVE;
            }
        }
        else if (state == State.DEAD) {
            if (neighbors == 3) {
                return State.ALIVE;
            }
        }
        return State.DEAD;
    }

    public enum State {
        ALIVE,
        DEAD
    }
}
