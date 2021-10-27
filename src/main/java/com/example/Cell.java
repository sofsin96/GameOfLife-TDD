package com.example;

public class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public enum State {
        ALIVE,
        DEAD
    }
}
