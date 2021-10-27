package com.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    void cellShouldDieIfItHasFewerThanTwoLiveNeighbors() {
        Cell cell = new Cell(Cell.State.ALIVE);
        Cell.State actualStateWithZeroNeighbors = cell.calculateNextGeneration(0);
        Cell.State actualStateWithOneNeighbor = cell.calculateNextGeneration(1);
        Cell.State expectedState = Cell.State.DEAD;

        assertEquals(expectedState, actualStateWithZeroNeighbors);
        assertEquals(expectedState, actualStateWithOneNeighbor);
    }

    @Test
    void cellShouldLiveIfItHasTwoOrThreeNeighbors() {
        Cell cell = new Cell(Cell.State.ALIVE);
        Cell.State actualStateWithTwoNeighbors = cell.calculateNextGeneration(2);
        Cell.State actualStateWithThreeNeighbors = cell.calculateNextGeneration(3);
        Cell.State expectedState = Cell.State.ALIVE;

        assertEquals(expectedState, actualStateWithTwoNeighbors);
        assertEquals(expectedState, actualStateWithThreeNeighbors);
    }

    @Test
    void cellShouldDieIfItHasMoreThanThreeNeighbors() {
        Cell cell = new Cell(Cell.State.ALIVE);
        Cell.State actualStateWithFourNeighbors = cell.calculateNextGeneration(4);
        Cell.State expectedState = Cell.State.DEAD;

        assertEquals(expectedState, actualStateWithFourNeighbors);
    }

    @Test
    void deadCellShouldComeAliveWithThreeNeighbors() {
        Cell cell = new Cell(Cell.State.DEAD);
        Cell.State actualStateWithThreeNeighbors = cell.calculateNextGeneration(3);
        Cell.State expectedState = Cell.State.ALIVE;

        assertEquals(expectedState, actualStateWithThreeNeighbors);
    }
}
