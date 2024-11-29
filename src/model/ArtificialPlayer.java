package model;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private final Random random;

    public ArtificialPlayer(State state) {
        super(state);
        this.random = new Random();
    }

    @Override
    public int[] getMove(Cell[][] board) {
        int row, col;
        do {
            row = random.nextInt(board.length);
            col = random.nextInt(board[0].length);
        } while (!board[row][col].isEmpty());
        return new int[]{row, col};
    }
}
