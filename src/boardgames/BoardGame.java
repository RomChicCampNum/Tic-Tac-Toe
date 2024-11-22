package boardgames;

import util.Cell;
import players.Player;

public abstract class BoardGame {
    protected Cell[][] board;         // Plateau de jeu
    protected Player[] players;       // Liste des joueurs
    protected Player currentPlayer;   // Joueur actif

    public BoardGame(int rows, int cols, Player[] players) {
        this.board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.board[i][j] = new Cell();
            }
        }
        this.players = players;
        this.currentPlayer = players[0];
    }

    public BoardGame() {

    }

    public BoardGame(Player player1, Player player2) {

    }

    // Méthodes abstraites (doivent être implémentées dans les sous-classes)
    public abstract void play();
    public abstract boolean isOver();

    // Méthodes communes
    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }
}
