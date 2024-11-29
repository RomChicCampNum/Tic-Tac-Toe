package controller;

import model.Player;
import view.View;

public class Gomoku extends BoardGame {
    public Gomoku(Player[] players, View view) {
        super(15, 15, players, view);
    }

    @Override
    protected int getWinCondition() {
        return 5;
    }
}
