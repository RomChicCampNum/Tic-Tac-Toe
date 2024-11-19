import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private Cell[][] board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public TicTacToe(Player playerX, Player playerO) {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX; // Le joueur X commence
    }

    public void play() {
        while (!isOver()) {
            System.out.println("C'est au tour de " + currentPlayer.getRepresentation());
            int[] move = currentPlayer.getMove(board); // Appelle la méthode getMove du joueur
            setOwner(move[0], move[1], currentPlayer);

            display();

            if (isOver()) {
                System.out.println("Partie terminée !");
                System.out.println("Le gagnant est : " + currentPlayer.getRepresentation());
                return;
            }

            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getRepresentation());
                if (j < SIZE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("-----------");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col].isEmpty();
    }

    public void setOwner(int row, int col, Player player) {
        board[row][col].setOwner(player);
    }

    public boolean isOver() {
        // Vérification des lignes, colonnes et diagonales
        for (int i = 0; i < SIZE; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2]) || // Ligne i
                    checkLine(board[0][i], board[1][i], board[2][i])) { // Colonne i
                return true; // Victoire
            }
        }

        // Vérification des diagonales
        if (checkLine(board[0][0], board[1][1], board[2][2]) || // Première diagonale
                checkLine(board[0][2], board[1][1], board[2][0])) { // Deuxième diagonale
            return true; // Victoire
        }

        // Vérification si le plateau est plein (match nul)
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col].getRepresentation().equals("   ")) {
                    return false; // Plateau non rempli, le jeu continue
                }
            }
        }

        return true; // Plateau plein et aucune victoire
    }

    // Méthode utilitaire pour vérifier si trois cases sont identiques et non vides
    private boolean checkLine(Cell a, Cell b, Cell c) {
        return a.getRepresentation().equals(b.getRepresentation()) &&
                b.getRepresentation().equals(c.getRepresentation()) &&
                !a.getRepresentation().equals("   ");
    }
}
