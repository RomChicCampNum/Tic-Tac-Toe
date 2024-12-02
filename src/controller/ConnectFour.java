package controller;

import model.rules.ConnectFourRules;
import model.Player;
import view.View;

public class ConnectFour extends BoardGame {
    public ConnectFour(Player[] players, View view) {
        super(6, 7, players, view, new ConnectFourRules());
    }

    @Override
    protected int getWinCondition() {
        return 4; // Alignement de 4 pour gagner
    }

    @Override
    public void play() {
        view.displayMessage("Début du jeu Puissance 4 !");
        while (!isOver()) {
            view.displayBoard(boardModel.getBoard()); // Utilisation de BoardModel
            boolean validMove = false;

            while (!validMove) {
                view.displayMessage("C'est au tour de " + currentPlayer.getState());
                int col = currentPlayer.getMove(boardModel.getBoard())[1]; // Demande uniquement la colonne
                int row = findAvailableRow(col); // Trouve la première ligne disponible
                if (row != -1) { // Si une ligne est disponible
                    boardModel.setCellState(row, col, currentPlayer.getState()); // Mise à jour via BoardModel
                    validMove = true;
                } else {
                    view.displayMessage("Colonne pleine. Choisissez une autre colonne.");
                }
            }

            if (rules.isWon(boardModel.getBoard(), getWinCondition())) {
                view.displayBoard(boardModel.getBoard());
                view.displayMessage("Le gagnant est : " + currentPlayer.getState());
                return;
            }
            switchPlayer();
        }
        view.displayMessage("Match nul !");
    }

    private int findAvailableRow(int col) {
        for (int row = boardModel.getBoard().length - 1; row >= 0; row--) { // Utilisation de BoardModel
            if (boardModel.isCellEmpty(row, col)) {
                return row; // Retourne la première ligne vide
            }
        }
        return -1; // Colonne pleine
    }
}
