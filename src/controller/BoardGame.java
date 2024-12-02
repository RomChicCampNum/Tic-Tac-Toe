package controller;

import model.rules.GameRules;
import model.BoardModel;
import model.Player;
import view.View;

public abstract class BoardGame {
    protected final BoardModel boardModel; // Centralise la gestion du plateau
    protected final Player[] players;
    protected Player currentPlayer;
    protected final View view;
    protected final GameRules rules;

    public BoardGame(int rows, int cols, Player[] players, View view, GameRules rules) {
        this.boardModel = new BoardModel(rows, cols); // Initialise le BoardModel
        this.players = players;
        this.currentPlayer = players[0];
        this.view = view;
        this.rules = rules;
    }

    public void play() {
        view.displayMessage("Début du jeu !");
        while (!isOver()) {
            view.displayBoard(boardModel.getBoard());
            boolean validMove = false;

            while (!validMove) {
                view.displayMessage("C'est au tour de " + currentPlayer.getState());
                int[] move = currentPlayer.getMove(boardModel.getBoard());
                if (boardModel.isCellEmpty(move[0], move[1])) {
                    boardModel.setCellState(move[0], move[1], currentPlayer.getState());
                    validMove = true;
                } else {
                    view.displayMessage("Coup invalide, réessayez.");
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

    protected void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    protected abstract int getWinCondition();

    boolean isOver() {
        return rules.isWon(boardModel.getBoard(), getWinCondition()) || boardModel.isFull();
    }
}
