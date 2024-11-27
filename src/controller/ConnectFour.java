package controller;

import model.State;
import view.View;
import model.Player;

public class ConnectFour extends BoardGame {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final int WIN_CONDITION = 4; // Alignement requis pour gagner

    public ConnectFour(Player player1, Player player2, View view) {
        super(ROWS, COLUMNS, new Player[]{player1, player2}, view);
    }

    @Override
    public void play() {
        view.displayMessage("Début du jeu : Puissance 4 !");
        while (!isOver()) {
            view.displayBoard(board);

            boolean validMove = false;
            while (!validMove) {
                view.displayMessage("C'est au tour de " + currentPlayer.getState());
                int column = currentPlayer.getMove(board)[1]; // Le joueur choisit une colonne
                int row = getAvailableRow(column);

                if (row != -1) {
                    board[row][column].setState(currentPlayer.getState());
                    validMove = true;
                } else {
                    view.displayMessage("La colonne " + column + " est pleine. Essayez une autre.");
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

    private int getAvailableRow(int column) {
        for (int row = board.length - 1; row >= 0; row--) { // Parcourir de bas en haut
            if (board[row][column].isEmpty()) {
                return row;
            }
        }
        return -1; // Colonne pleine
    }

    @Override
    public boolean isOver() {
        return isWon() || isDraw();
    }

    private boolean isWon() {
        // Vérification horizontale
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - WIN_CONDITION; col++) {
                if (checkLine(row, col, 0, 1)) {
                    return true; // Ligne horizontale gagnante
                }
            }
        }

        // Vérification verticale
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row <= ROWS - WIN_CONDITION; row++) {
                if (checkLine(row, col, 1, 0)) {
                    return true; // Colonne verticale gagnante
                }
            }
        }

        // Vérification diagonale (montante)
        for (int row = WIN_CONDITION - 1; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - WIN_CONDITION; col++) {
                if (checkLine(row, col, -1, 1)) {
                    return true; // Diagonale montante gagnante
                }
            }
        }

        // Vérification diagonale (descendante)
        for (int row = 0; row <= ROWS - WIN_CONDITION; row++) {
            for (int col = 0; col <= COLUMNS - WIN_CONDITION; col++) {
                if (checkLine(row, col, 1, 1)) {
                    return true; // Diagonale descendante gagnante
                }
            }
        }

        return false; // Aucun alignement gagnant
    }

    private boolean checkLine(int startRow, int startCol, int deltaRow, int deltaCol) {
        State firstState = board[startRow][startCol].getState();
        if (firstState == State.EMPTY) {
            return false; // Pas d'alignement possible avec une case vide
        }

        for (int i = 1; i < WIN_CONDITION; i++) {
            int newRow = startRow + i * deltaRow;
            int newCol = startCol + i * deltaCol;
            if (board[newRow][newCol].getState() != firstState) {
                return false; // Rupture dans l'alignement
            }
        }

        return true; // Alignement détecté
    }

    private boolean isDraw() {
        for (int col = 0; col < COLUMNS; col++) {
            if (getAvailableRow(col) != -1) {
                return false; // Une colonne est encore jouable
            }
        }
        return true; // Toutes les colonnes sont pleines
    }
}
