package players;

import util.Cell;
import util.State;

public abstract class Player {
    private final State state;

    public Player(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public abstract int[] getMove(Cell[][] board);
}
