package boardgames;
import players.Player;
import util.Cell;

import java.util.Arrays;

public class ConnectFour extends BoardGame {

    private static final int ROWS = 6;    // Nombre de rangées
    private static final int COLUMNS = 7; // Nombre de colonnes

    public ConnectFour(Player player1, Player player2) {
        super(player1, player2); // Initialiser les joueurs via la classe parent

        // Initialiser une grille 6x7 pour le Puissance 4
        board = new Cell[ROWS][COLUMNS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    @Override
    public void play() {
        System.out.println("Début du jeu : Puissance 4 !");
        while (!isOver()) {
            // Afficher le plateau
            displayBoard();

            // Demander un coup au joueur actuel
            boolean validMove = false;
            while (!validMove) {
                System.out.println("C'est au tour de " + currentPlayer.getState());
                int column = currentPlayer.getMove(board)[1]; // Le joueur choisit une colonne
                int row = getAvailableRow(column); // Trouver la rangée disponible dans cette colonne

                if (row != -1) {
                    board[row][column].setState(currentPlayer.getState());
                    validMove = true;
                } else {
                    System.out.println("La colonne " + column + " est pleine. Veuillez choisir une autre colonne.");
                }
            }

            // Changer de joueur
            if (!isOver()) {
                switchPlayer();
            }
        }

        // Afficher le plateau final
        displayBoard();

        // Résultat final
        if (isWon()) {
            System.out.println("Le gagnant est : " + currentPlayer.getState());
        } else {
            System.out.println("Match nul !");
        }
    }

    /**
     * Retourne la première rangée disponible pour une colonne donnée.
     * Si la colonne est pleine, retourne -1.
     */
    private int getAvailableRow(int column) {
        for (int row = ROWS - 1; row >= 0; row--) { // Parcourir de bas en haut
            if (board[row][column].isEmpty()) {
                return row;
            }
        }
        return -1; // Colonne pleine
    }

    @Override
    public boolean isOver() {
        // TODO: Implémenter la logique pour vérifier les alignements (victoire ou match nul)
        return isWon() || isDraw();
    }

    private boolean isWon() {
        // TODO: Ajouter la logique pour détecter un alignement de 4 jetons
        return false;
    }

    private boolean isDraw() {
        for (int col = 0; col < COLUMNS; col++) {
            if (getAvailableRow(col) != -1) {
                return false; // Il reste des colonnes jouables
            }
        }
        return true; // Aucune colonne jouable -> Match nul
    }


    public void displayBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("| " + board[row][col].getState().getRepresentation() + " ");
            }
            System.out.println("|");
        }
        System.out.println("  0   1   2   3   4   5   6"); // Indiquer les colonnes
    }
}
