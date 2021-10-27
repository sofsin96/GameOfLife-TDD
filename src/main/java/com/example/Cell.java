package com.example;

public class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public State calculateNextGeneration(int neighbors) {
        if (state == State.ALIVE && neighbors < 2) {
            return State.DEAD;
        }
        else {
            return State.ALIVE;
        }
    }

    public enum State {
        ALIVE,
        DEAD
    }
}
