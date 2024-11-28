package controller;

import model.Cell;
import model.Player;
import view.View;

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
        view.displayMessage("Début du jeu !");
        while (!isOver()) {
            view.displayBoard(board);
            boolean validMove = false;
            while (!validMove) {
                view.displayMessage("C'est au tour de " + currentPlayer.getState());
                int[] move = currentPlayer.getMove(board);
                if (isCellEmpty(move[0], move[1])) {
                    board[move[0]][move[1]].setState(currentPlayer.getState());
                    validMove = true;
                } else {
                    view.displayMessage("Cellule occupée. Choisissez-en une autre.");
                }
            }

            if (isOver()) {
                view.displayBoard(board);
                view.displayMessage("Le gagnant est : " + currentPlayer.getState());
                return;
            }
            switchPlayer();
        }
        view.displayMessage("Match nul !");
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

    protected boolean isWon() {
        return checkAlignments(1, 0) || // Horizontal
                checkAlignments(0, 1) || // Vertical
                checkAlignments(1, 1) || // Diagonal descendante
                checkAlignments(-1, 1);  // Diagonale montante
    }

    private boolean checkAlignments(int deltaRow, int deltaCol) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (checkLine(row, col, deltaRow, deltaCol)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int startRow, int startCol, int deltaRow, int deltaCol) {
        Cell startCell = board[startRow][startCol];
        if (startCell.isEmpty()) {
            return false;
        }

        int requiredAlignments = getWinCondition();
        for (int i = 1; i < requiredAlignments; i++) {
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

    protected boolean isDraw() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    protected abstract int getWinCondition();
}
