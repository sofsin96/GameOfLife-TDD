package com.example;

public enum State {
    ALIVE("*"),
    DEAD(".");

    private final String label;

    State(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
