public class Main {
    public static void main(String[] args) {
        InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();
        View view = new View();

        // Choix des joueurs via InteractionUtilisateur
        Player[] players = interactionUtilisateur.choosePlayers();

        // Lancer le jeu avec les joueurs sélectionnés
        TicTacToe ticTacToe = new TicTacToe(players[0], players[1], view);
        ticTacToe.play();

        interactionUtilisateur.close(); // Libère les ressources
    }
}
