public class Cell {
    private Player owner;

    public String getRepresentation() {
        if (owner == null) {
            return "   ";  // si la cellule n'a pas de joueur, retourne 3 espaces
        }
        return owner.getRepresentation(); // sinon retourne le symbole du joueur
    }

    public void setOwner(Player player) {
        this.owner = player; // assigne un joueur comme propriétaire de la cellule
    }

    public boolean isEmpty(){
        return owner == null; // vérifie si la cellule est vide
    }
}
