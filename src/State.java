public enum State {
    EMPTY("   "), // État vide
    X(" X "),
    O(" O ");

    private final String representation;

    State(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
