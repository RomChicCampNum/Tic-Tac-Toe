public class Cell {
    private State state;

    public Cell() {
        this.state = State.EMPTY; // Par défaut, une cellule est vide
    }

    public State getState() {
        return state; // Retourne l'état actuel de la cellule
    }

    public void setState(State state) {
        this.state = state; // Définit un nouvel état pour la cellule
    }

    public boolean isEmpty() {
        return state == State.EMPTY; // Vérifie si la cellule est vide
    }

    public String getRepresentation() {
        return state.getRepresentation(); // Retourne la représentation visuelle de l'état
    }
}
