package com.example;

import static com.example.State.*;

public class Life {
    private static final State A = ALIVE;
    private static final State D = DEAD;

    public static void main(String[] args) throws InterruptedException {
        State[][] initialState = new State[][] {
                { A, D, D, D, D, D, D, A },
                { A, A, D, D, A, D, A, A },
                { A, A, D, A, A, D, A, A },
                { A, D, D, D, D, D, D, A }
        };

        Grid grid = new Grid(initialState);
        displayGrid(initialState);
        grid.getNextState();
        Thread.sleep(500);

        int iterations = 2;

        for (int g = 0; g < iterations; g++) {
            State[][] nextState = grid.getState();
            displayGrid(nextState);
            grid.getNextState();
            Thread.sleep(500);
        }
    }

    private static void displayGrid(State[][] states) {
        for (int row = 0; row < states.length; row++) {
            for (int col = 0; col < states[row].length; col++) {
                System.out.print(states[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
    }
}
