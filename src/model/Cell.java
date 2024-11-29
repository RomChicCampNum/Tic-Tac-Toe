package model;

public class Cell {
    private State state;

    public Cell() {
        this.state = State.EMPTY;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isEmpty() {
        return state == State.EMPTY;
    }
}
