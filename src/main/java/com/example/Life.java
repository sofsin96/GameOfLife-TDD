package com.example;

import static com.example.State.*;
import static java.lang.System.out;
import static java.lang.Thread.sleep;

public class Life {
    private static final State A = ALIVE;
    private static final State D = DEAD;
    private static final int TIME_BETWEEN_ITERATIONS_MS = 500;

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
        sleep(TIME_BETWEEN_ITERATIONS_MS);

        int iterations = 2;

        for (int g = 0; g < iterations; g++) {
            State[][] nextState = grid.getState();
            displayGrid(nextState);
            grid.getNextState();
            sleep(TIME_BETWEEN_ITERATIONS_MS);
        }
    }

    private static void displayGrid(State[][] states) {
        for (State[] state : states) {
            for (State value : state) {
                out.print(value.getLabel() + " ");
            }
            out.println();
        }
        out.println();
    }
}
