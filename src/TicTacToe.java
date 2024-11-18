import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3; // Taille de la grille
    private Cell[][] board;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Cell[SIZE][SIZE]; // Crée un tableau 3x3 de cellules
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(); // Initialiser chaque cellule
            }
        }
        currentPlayer = new Player(" X "); // Définit le joueur actuel (X pour commencer)
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getRepresentation()); // Affiche la cellule
                if (j < SIZE - 1) {
                    System.out.print("|"); // Ajoute une barre verticale entre les cellules
                }
            }
            System.out.println(); // Nouvelle ligne après chaque rangée
            if (i < SIZE - 1) {
                System.out.println("-----------"); // Ligne horizontale entre les rangées
            }
        }
    }

    public void getMoveFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.print("Entrez la ligne (0, 1 ou 2) : ");
            row = scanner.nextInt(); // Lecture de la ligne
            System.out.print("Entrez la colonne (0, 1 ou 2) : ");
            col = scanner.nextInt(); // Lecture de la colonne

            if (isValidMove(row, col)) {
                break; // Si le mouvement est valide, on sort de la boucle
            } else {
                System.out.println("Mouvement invalide. Réessayez !");
            }
        }

        setOwner(row, col, currentPlayer); // Capturer la case pour le joueur actuel
    }

    private boolean isValidMove(int row, int col) {
        // Vérifie que les coordonnées sont valides et que la cellule est vide
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col].isEmpty();
    }

    public void setOwner(int row, int col, Player player) {
        board[row][col].setOwner(player); // Assigne le joueur à la cellule
    }
}
