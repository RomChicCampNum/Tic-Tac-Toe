package controller;

import model.Player;
import view.View;
import view.Messages;

public class ConnectFour extends BoardGame {
    public ConnectFour(Player[] players, View view) {
        super(6, 7, players, view); // Plateau de 6 lignes x 7 colonnes
    }

    @Override
    public void play() {
        view.displayMessage(Messages.WELCOME_CONNECT4.getMessage());
        while (!isOver()) {
            view.displayBoard(board);
            boolean validMove = false;

            while (!validMove) {
                view.displayMessage(Messages.PLAYER_TURN.getMessage() + currentPlayer.getState());
                int col = currentPlayer.getMove(board)[1]; // Demande uniquement la colonne
                int row = findAvailableRow(col); // Trouve la première ligne disponible
                if (row != -1) { // Si une ligne est disponible
                    board[row][col].setState(currentPlayer.getState());
                    validMove = true;
                } else {
                    view.displayMessage(Messages.COLUMN_FULL.getMessage());
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

    @Override
    protected int getWinCondition() {
        return 4; // 4 jetons alignés pour gagner
    }

    /**
     * Trouve la première ligne disponible dans une colonne donnée.
     *
     * @param col La colonne choisie par le joueur.
     * @return L'index de la première ligne vide, ou -1 si la colonne est pleine.
     */
    private int findAvailableRow(int col) {
        for (int row = board.length - 1; row >= 0; row--) { // Parcourt de bas en haut
            if (board[row][col].isEmpty()) {
                return row; // Retourne la première ligne vide
            }
        }
        return -1; // Colonne pleine
    }
}
