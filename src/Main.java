import util.InteractionUtilisateur;
import util.View;
import boardgames.BoardGame;

public class Main {
    public static void main(String[] args) {
        InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();
        View view = new View();

        BoardGame game = interactionUtilisateur.chooseGame(view);
        game.play();

        interactionUtilisateur.close();
    }
}
