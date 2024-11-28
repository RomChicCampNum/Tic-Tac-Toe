package controller;

import model.Player;
import view.View;

public class ConnectFour extends BoardGame {
    public ConnectFour(Player[] players, View view) {
        super(6, 7, players, view);
    }

    @Override
    protected int getWinCondition() {
        return 4; // Aligner 4 symboles pour gagner
    }
}
