import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3; // Taille de la grille
    private Cell[][] board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Cell[SIZE][SIZE]; // Crée un tableau 3x3 de cellules
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(); // Initialiser chaque cellule
            }
        }
        playerX = new Player(" X ");
        playerO = new Player(" O ");
        currentPlayer = playerX; // Définit le joueur actuel (X pour commencer)
    }

    public void play() {
        while (!isOver()) {
            // Obtenir le coup du joueur
            int[] move = getMoveFromPlayer(); // Appelle la méthode sécurisée
            setOwner(move[0], move[1], currentPlayer);

            // Afficher le plateau
            display();

            // Vérifier si le jeu est terminé
            if (isOver()) {
                System.out.println("Partie terminée !");
                System.out.println("Le gagnant est : " + currentPlayer.getRepresentation());
                return; // Fin du jeu
            }

            // Alterner les joueurs
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
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

    public int[] getMoveFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int row = -1, col = -1;

        while (true) {
            try {
                System.out.print("Entrez la ligne (0, 1 ou 2) : ");
                row = scanner.nextInt(); // Lecture de la ligne

                System.out.print("Entrez la colonne (0, 1 ou 2) : ");
                col = scanner.nextInt(); // Lecture de la colonne

                // Vérifie si les coordonnées sont valides
                if (isValidMove(row, col)) {
                    break; // Sortie si le mouvement est valide
                } else {
                    System.out.println("Mouvement invalide. Les coordonnées doivent être entre 0 et 2, et la case doit être vide.");
                }
            } catch (java.util.InputMismatchException e) {
                // Gère le cas où l'utilisateur entre un type invalide
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier entre 0 et 2.");
                scanner.next(); // Ignore l'entrée invalide pour éviter une boucle infinie
            }
        }

        return new int[]{row, col}; // Retourne les coordonnées validées
    }


    private boolean isValidMove(int row, int col) {
        // Vérifie que les coordonnées sont valides et que la cellule est vide
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col].isEmpty();
    }

    public void setOwner(int row, int col, Player player) {
        board[row][col].setOwner(player); // Assigne le joueur à la cellule
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

