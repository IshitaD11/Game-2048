package org.example.game2048.models;

import java.util.List;
import java.util.Random;

public class Bot extends Player {
    public void makeMove(Board board) {
        board.recalculateEmptyCells();
        List<Cell> emptyCells = board.getEmptyCells();
        Random rand = new Random();
        emptyCells.get(rand.nextInt(emptyCells.size())).setValue(2);
    }
}
