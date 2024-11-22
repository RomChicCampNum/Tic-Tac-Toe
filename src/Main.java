import boardgames.BoardGame;
import boardgames.TicTacToe;
import players.Player;
import util.InteractionUtilisateur;
import util.View;

public class Main {
    public static void main(String[] args) {
        InteractionUtilisateur interaction = new InteractionUtilisateur();
        BoardGame game = interaction.chooseGame();
        game.play();
        interaction.close();
    }
}

