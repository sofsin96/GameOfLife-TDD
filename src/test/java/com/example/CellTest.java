package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    void cellShouldDieIfItHasFewerThanTwoLiveNeighbors() {
        Cell cell = new Cell(State.ALIVE);
        State actualStateWithZeroNeighbors = cell.calculateNextGeneration(0);
        State actualStateWithOneNeighbor = cell.calculateNextGeneration(1);
        State expectedState = State.DEAD;

        assertEquals(expectedState, actualStateWithZeroNeighbors);
        assertEquals(expectedState, actualStateWithOneNeighbor);
    }

    @Test
    void cellShouldLiveIfItHasTwoOrThreeNeighbors() {
        Cell cell = new Cell(State.ALIVE);
        State actualStateWithTwoNeighbors = cell.calculateNextGeneration(2);
        State actualStateWithThreeNeighbors = cell.calculateNextGeneration(3);
        State expectedState = State.ALIVE;

        assertEquals(expectedState, actualStateWithTwoNeighbors);
        assertEquals(expectedState, actualStateWithThreeNeighbors);
    }

    @Test
    void cellShouldDieIfItHasMoreThanThreeNeighbors() {
        Cell cell = new Cell(State.ALIVE);
        State actualStateWithFourNeighbors = cell.calculateNextGeneration(4);
        State expectedState = State.DEAD;

        assertEquals(expectedState, actualStateWithFourNeighbors);
    }

    @Test
    void deadCellShouldComeAliveWithThreeNeighbors() {
        Cell cell = new Cell(State.DEAD);
        State actualStateWithThreeNeighbors = cell.calculateNextGeneration(3);
        State expectedState = State.ALIVE;

        assertEquals(expectedState, actualStateWithThreeNeighbors);
    }
}
