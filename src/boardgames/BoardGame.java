package boardgames;

import util.View;
import util.Cell;
import players.Player;

public abstract class BoardGame {
    protected Cell[][] board;          // Plateau de jeu
    protected Player[] players;        // Joueurs (X et O)
    protected Player currentPlayer;    // Joueur actuel
    protected View view;               // Vue pour afficher le jeu

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

    public abstract void play();      // Chaque jeu implémente sa boucle principale
    public abstract boolean isOver(); // Vérifie les conditions de fin de jeu

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    public Cell[][] getBoard() {
        return board;
    }
}
