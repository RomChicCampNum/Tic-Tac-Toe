package model.rules;

import model.Cell;
import model.rules.GameRules;

public class GomokuRules implements GameRules {
    @Override
    public boolean isWon(Cell[][] board, int winCondition) {
        return checkAlignments(board, 1, 0, winCondition) || // Horizontal
                checkAlignments(board, 0, 1, winCondition) || // Vertical
                checkAlignments(board, 1, 1, winCondition) || // Diagonale descendante
                checkAlignments(board, -1, 1, winCondition);  // Diagonale montante
    }

    private boolean checkAlignments(Cell[][] board, int deltaRow, int deltaCol, int length) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (checkLine(board, row, col, deltaRow, deltaCol, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(Cell[][] board, int startRow, int startCol, int deltaRow, int deltaCol, int length) {
        Cell startCell = board[startRow][startCol];
        if (startCell.isEmpty()) {
            return false;
        }

        for (int i = 1; i < length; i++) {
            int newRow = startRow + i * deltaRow;
            int newCol = startCol + i * deltaCol;
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length ||
                    board[newRow][newCol].getState() != startCell.getState()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isDraw(Cell[][] board) {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    return false; // Le plateau contient encore des cellules vides
                }
            }
        }
        return true; // Le plateau est plein
    }
}
