package controller;

import model.Cell;
import model.Player;
import view.View;
import view.Messages;

public abstract class BoardGame {
    protected Cell[][] board;
    protected Player[] players;
    protected Player currentPlayer;
    protected View view;

    public BoardGame(int rows, int cols, Player[] players, View view) {
        this.board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.board[i][j] = new Cell();
            }
        }
        this.players = players;
        this.currentPlayer = players[0];
        this.view = view;
    }

    public void play() {
        view.displayMessage(Messages.WELCOME.getMessage());
        while (!isOver()) {
            view.displayBoard(board);
            boolean validMove = false;
            while (!validMove) {
                view.displayMessage(Messages.PLAYER_TURN.getMessage() + currentPlayer.getState());
                int[] move = currentPlayer.getMove(board);
                if (isCellEmpty(move[0], move[1])) {
                    board[move[0]][move[1]].setState(currentPlayer.getState());
                    validMove = true;
                } else {
                    view.displayMessage(Messages.INVALID_MOVE.getMessage());
                }
            }

            if (isOver()) {
                view.displayBoard(board);
                view.displayMessage(Messages.VICTORY.getMessage() + currentPlayer.getState());
                return;
            }
            switchPlayer();
        }
        view.displayMessage(Messages.DRAW.getMessage());
    }

    protected boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    protected void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public boolean isOver() {
        return isWon() || isDraw();
    }

    private boolean isWon() {
        return checkAlignments(1, 0) || checkAlignments(0, 1) || checkAlignments(1, 1) || checkAlignments(-1, 1);
    }

    private boolean checkAlignments(int deltaRow, int deltaCol) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (checkLine(row, col, deltaRow, deltaCol, getWinCondition())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int startRow, int startCol, int deltaRow, int deltaCol, int length) {
        Cell startCell = board[startRow][startCol];
        if (startCell.isEmpty()) {
            return false;
        }

        for (int i = 1; i < length; i++) {
            int newRow = startRow + i * deltaRow;
            int newCol = startCol + i * deltaCol;
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                return false;
            }
            if (board[newRow][newCol].getState() != startCell.getState()) {
                return false;
            }
        }
        return true;
    }

    private boolean isDraw() {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    protected abstract int getWinCondition();
}
