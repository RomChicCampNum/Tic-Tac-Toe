public class Main {
    public static void main(String[] args) {
        InteractionUtilisateur interactionUtilisateur = new InteractionUtilisateur();
        View view = new View();
        Player playerX, playerO;

        view.displayMessage("Choisissez la configuration des joueurs :");
        view.displayMessage("1. Humain contre Humain");
        view.displayMessage("2. Humain contre IA");
        view.displayMessage("3. IA contre IA");

        int choice = interactionUtilisateur.askForInt("Votre choix :", 1, 3);

        switch (choice) {
            case 1:
                playerX = new HumanPlayer(" X ", interactionUtilisateur);
                playerO = new HumanPlayer(" O ", interactionUtilisateur);
                break;
            case 2:
                playerX = new HumanPlayer(" X ", interactionUtilisateur);
                playerO = new ArtificialPlayer(" O ");
                break;
            case 3:
                playerX = new ArtificialPlayer(" X ");
                playerO = new ArtificialPlayer(" O ");
                break;
            default:
                view.displayMessage("Choix invalide, par défaut Humain contre IA.");
                playerX = new HumanPlayer(" X ", interactionUtilisateur);
                playerO = new ArtificialPlayer(" O ");
        }

        TicTacToe ticTacToe = new TicTacToe(playerX, playerO, view);
        ticTacToe.play();

        interactionUtilisateur.close(); // Libère les ressources
    }
}
