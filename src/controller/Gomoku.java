package controller;

import model.rules.GomokuRules;
import model.Player;
import view.View;

public class Gomoku extends BoardGame {
    public Gomoku(Player[] players, View view) {
        super(15, 15, players, view, new GomokuRules());
    }

    @Override
    protected int getWinCondition() {
        return 5; // Alignement de 5 pour gagner
    }
}
