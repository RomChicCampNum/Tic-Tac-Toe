package model;

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
