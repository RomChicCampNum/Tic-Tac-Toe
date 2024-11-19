import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player playerX, playerO;

        System.out.println("Choisissez la configuration des joueurs :");
        System.out.println("1. Humain contre Humain");
        System.out.println("2. Humain contre IA");
        System.out.println("3. IA contre IA");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                playerX = new HumanPlayer(" X ");
                playerO = new HumanPlayer(" O ");
                break;
            case 2:
                playerX = new HumanPlayer(" X ");
                playerO = new ArtificialPlayer(" O ");
                break;
            case 3:
                playerX = new ArtificialPlayer(" X ");
                playerO = new ArtificialPlayer(" O ");
                break;
            default:
                System.out.println("Choix invalide, par défaut Humain contre IA.");
                playerX = new HumanPlayer(" X ");
                playerO = new ArtificialPlayer(" O ");
        }

        TicTacToe ticTacToe = new TicTacToe(playerX, playerO);
        ticTacToe.play();
    }
}
