import controller.InteractionUtilisateur;
import controller.BoardGame;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View(); // Initialisation de la vue
        InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur(view); // Passe la vue
        BoardGame game = interactionUtilisateur.chooseGame();
        game.play();
    }
}
