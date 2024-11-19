public abstract class Player {
    private String representation;

    public Player(String representation) {
        this.representation = representation; // Définit le symbole du joueur
    }

    public String getRepresentation() {
        return representation; // Retourne le symbole du joueur
    }

    // Méthode abstraite que chaque type de joueur doit implémenter
    public abstract int[] getMove(Cell[][] board);
}
