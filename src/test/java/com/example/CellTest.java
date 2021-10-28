package com.example;

import org.junit.jupiter.api.Test;

import static com.example.State.ALIVE;
import static com.example.State.DEAD;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    void cellShouldDieIfItHasFewerThanTwoLiveNeighbors() {
        Cell cell = new Cell(ALIVE);
        State actualStateWithZeroNeighbors = cell.calculateNextGeneration(0);
        State actualStateWithOneNeighbor = cell.calculateNextGeneration(1);
        State expectedState = DEAD;

        assertEquals(expectedState, actualStateWithZeroNeighbors);
        assertEquals(expectedState, actualStateWithOneNeighbor);
    }

    @Test
    void cellShouldLiveIfItHasTwoOrThreeNeighbors() {
        Cell cell = new Cell(ALIVE);
        State actualStateWithTwoNeighbors = cell.calculateNextGeneration(2);
        State actualStateWithThreeNeighbors = cell.calculateNextGeneration(3);
        State expectedState = ALIVE;

        assertEquals(expectedState, actualStateWithTwoNeighbors);
        assertEquals(expectedState, actualStateWithThreeNeighbors);
    }

    @Test
    void cellShouldDieIfItHasMoreThanThreeNeighbors() {
        Cell cell = new Cell(ALIVE);
        State actualStateWithFourNeighbors = cell.calculateNextGeneration(4);

        assertEquals(DEAD, actualStateWithFourNeighbors);
    }

    @Test
    void deadCellShouldComeAliveWithThreeNeighbors() {
        Cell cell = new Cell(DEAD);
        State actualStateWithThreeNeighbors = cell.calculateNextGeneration(3);

        assertEquals(ALIVE,actualStateWithThreeNeighbors);
    }

    @Test
    void deadCellShouldHaveDeadState() {
        Cell cell = new Cell(DEAD);

        assertEquals(DEAD, cell.getState());
    }
}
