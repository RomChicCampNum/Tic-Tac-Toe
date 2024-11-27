package controller;

import view.View;
import model.Cell;
import model.Player;

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

    public abstract void play();
    public abstract boolean isOver();

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }
}
