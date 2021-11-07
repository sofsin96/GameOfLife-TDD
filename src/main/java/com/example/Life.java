package com.example;

import static com.example.State.ALIVE;
import static com.example.State.DEAD;
import static java.lang.Thread.sleep;

public class Life {
    private static final State A = ALIVE;
    private static final State D = DEAD;
    private static final int TIME_BETWEEN_ITERATIONS_MS = 500, ITERATIONS = 5;

    public static void main(String[] args) throws InterruptedException {
        State[][] initialState = new State[][] {
                { A, D, D, D, D, D, D, D },
                { D, D, D, D, A, D, D, D },
                { D, D, D, A, A, D, D, D },
                { D, D, D, D, D, D, A, A }
        };

        System.out.println("Generation: 1");
        Grid grid = Grid.displayGrid(initialState);
        grid.getNextState();
        sleep(TIME_BETWEEN_ITERATIONS_MS);

        for (int i = 1; i <= ITERATIONS; i++) {
            System.out.println("Generation: " + (i + 1));
            State[][] nextState = grid.getState();
            Grid.displayGrid(nextState);
            grid.getNextState();
            sleep(TIME_BETWEEN_ITERATIONS_MS);
        }
    }
}
