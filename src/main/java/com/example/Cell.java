package com.example;

public class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public State calculateNextGeneration(int neighbors) {
        return State.DEAD;
    }

    public enum State {
        ALIVE,
        DEAD
    }
}
