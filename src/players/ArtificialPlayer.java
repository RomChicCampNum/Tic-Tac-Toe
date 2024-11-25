package players;

import util.Cell;
import util.State;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random = new Random();

    public ArtificialPlayer(State state) {
        super(state);
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
