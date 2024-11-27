package model;

public class Cell {
    private State state;

    public Cell() {
        this.state = State.EMPTY; // Par défaut, la cellule est vide
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
