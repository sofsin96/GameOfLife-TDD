package com.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    Cell cell = new Cell(Cell.State.ALIVE);

    @Test
    void cellShouldDieIfItHasFewerThanTwoLiveNeighbors() {
        Cell.State actualState = cell.calculateNextGeneration(0);
        Cell.State expectedState = Cell.State.DEAD;

        assertEquals(expectedState, actualState);
    }

    @Test
    void cellShouldLiveIfItHasTwoOrThreeNeighbors() {
        Cell.State actualState = cell.calculateNextGeneration(2);
        Cell.State expectedState = Cell.State.ALIVE;

        assertEquals(expectedState, actualState);
    }
}
