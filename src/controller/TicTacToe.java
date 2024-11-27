package controller;

import model.State;
import view.View;
import model.Player;

public class TicTacToe extends BoardGame {
    private static final int SIZE = 3; // Taille du plateau

    public TicTacToe(Player player1, Player player2, View view) {
        super(SIZE, SIZE, new Player[]{player1, player2}, view);
    }

    @Override
    public void play() {
        view.displayMessage("Début du jeu : Tic Tac Toe !");
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
                    view.displayMessage("Cette case est déjà occupée. Essayez une autre.");
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

    @Override
    public boolean isOver() {
        int WIN_CONDITION = 3; // Nombre d'alignements requis pour gagner (3 pour TicTacToe)

        // Vérification horizontale
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col <= board[row].length - WIN_CONDITION; col++) {
                if (checkLine(row, col, 0, 1)) {
                    return true; // Ligne horizontale gagnante
                }
            }
        }

        // Vérification verticale
        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row <= board.length - WIN_CONDITION; row++) {
                if (checkLine(row, col, 1, 0)) {
                    return true; // Colonne verticale gagnante
                }
            }
        }

        // Vérification diagonale (montante)
        for (int row = WIN_CONDITION - 1; row < board.length; row++) {
            for (int col = 0; col <= board[row].length - WIN_CONDITION; col++) {
                if (checkLine(row, col, -1, 1)) {
                    return true; // Diagonale montante gagnante
                }
            }
        }

        // Vérification diagonale (descendante)
        for (int row = 0; row <= board.length - WIN_CONDITION; row++) {
            for (int col = 0; col <= board[row].length - WIN_CONDITION; col++) {
                if (checkLine(row, col, 1, 1)) {
                    return true; // Diagonale descendante gagnante
                }
            }
        }

        // Vérification si le plateau est plein
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].isEmpty()) {
                    return false; // Il reste des cases jouables
                }
            }
        }

        return true; // Plateau plein ou victoire détectée
    }

    private boolean checkLine(int startRow, int startCol, int deltaRow, int deltaCol) {
        State firstState = board[startRow][startCol].getState();
        if (firstState == State.EMPTY) {
            return false; // Pas d'alignement possible avec une case vide
        }

        for (int i = 1; i < 3; i++) { // Vérifier les 3 cases suivantes
            int newRow = startRow + i * deltaRow;
            int newCol = startCol + i * deltaCol;
            if (board[newRow][newCol].getState() != firstState) {
                return false; // Rupture dans l'alignement
            }
        }

        return true; // Alignement détecté
    }
}
