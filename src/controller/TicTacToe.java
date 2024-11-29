package controller;

import model.Player;
import view.View;

public class TicTacToe extends BoardGame {
    public TicTacToe(Player[] players, View view) {
        super(3, 3, players, view);
    }

    @Override
    protected int getWinCondition() {
        return 3;
    }
}
