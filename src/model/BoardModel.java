package model;

public class BoardModel {
    private final Cell[][] board;

    public BoardModel(int rows, int cols) {
        board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    public void setCellState(int row, int col, State state) {
        board[row][col].setState(state);
    }

    public boolean isFull() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                cell.setState(State.EMPTY);
            }
        }
    }
}
