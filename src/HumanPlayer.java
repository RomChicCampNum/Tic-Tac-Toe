import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMove(Cell[][] board) {
        Scanner scanner = new Scanner(System.in);
        int row = -1, col = -1;

        while (true) {
            try {
                System.out.print("Entrez la ligne (0, 1 ou 2) : ");
                row = scanner.nextInt();
                System.out.print("Entrez la colonne (0, 1 ou 2) : ");
                col = scanner.nextInt();

                if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col].isEmpty()) {
                    break; // Si le mouvement est valide, sortir de la boucle
                } else {
                    System.out.println("Mouvement invalide. Réessayez.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                scanner.next(); // Ignore l'entrée invalide
            }
        }

        return new int[]{row, col};
    }
}
