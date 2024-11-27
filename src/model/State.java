package model;

public enum State {
    EMPTY("   "), // Cellule vide
    X(" X "),     // Joueur X
    O(" O ");     // Joueur O

    private final String representation;

    State(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
