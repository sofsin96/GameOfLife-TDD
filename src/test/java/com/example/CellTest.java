package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.example.State.ALIVE;
import static com.example.State.DEAD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, 1 })
    void cellShouldDieIfItHasFewerThanTwoLiveNeighbors(int neighbors) {
        Cell cell = new Cell(ALIVE);
        cell.calculateNextGeneration(neighbors);

        assertEquals(DEAD, cell.getState());
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 3 })
    void cellShouldLiveIfItHasTwoOrThreeNeighbors(int neighbors) {
        Cell cell = new Cell(ALIVE);
        cell.calculateNextGeneration(neighbors);

        assertEquals(ALIVE, cell.getState());
    }

    @Test
    void cellShouldDieIfItHasMoreThanThreeNeighbors() {
        Cell cell = new Cell(ALIVE);
        cell.calculateNextGeneration(4);

        assertEquals(DEAD, cell.getState());
    }

    @Test
    void deadCellShouldComeAliveWithThreeNeighbors() {
        Cell cell = new Cell(DEAD);
        cell.calculateNextGeneration(3);

        assertEquals(ALIVE, cell.getState());
    }

    @Test
    void deadCellShouldHaveDeadState() {
        Cell cell = new Cell(DEAD);

        assertEquals(DEAD, cell.getState());
    }

    @Test
    void liveCellShouldHaveAliveState() {
        Cell cell = new Cell(ALIVE);

        assertEquals(ALIVE, cell.getState());
    }
}
