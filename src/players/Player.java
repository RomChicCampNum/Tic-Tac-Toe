package players;

import util.Cell;
import util.State;

public abstract class Player {
    private State state;

    public Player(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getRepresentation() {
        return state.getRepresentation();
    }

    public abstract int[] getMove(Cell[][] board);
}
