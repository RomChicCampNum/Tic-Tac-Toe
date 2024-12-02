package model.rules;

import model.Cell;

public interface GameRules {
    boolean isWon(Cell[][] board, int winCondition);
    boolean isDraw(Cell[][] board);
}
