package controller;

import model.rules.TicTacToeRules;
import model.Player;
import view.View;

public class TicTacToe extends BoardGame {
    public TicTacToe(Player[] players, View view) {
        super(3, 3, players, view, new TicTacToeRules());
    }

    @Override
    protected int getWinCondition() {
        return 3; // Alignement de 3 pour gagner
    }
}
