package boardgames;

import players.Player;
import util.Cell;
import util.View;

public class TicTacToe extends BoardGame {
    private static final int SIZE = 3; // Taille du plateau

    public TicTacToe(Player[] players) {
        super(SIZE, SIZE, players); // Appelle le constructeur de BoardGame
    }

        public TicTacToe(Player player, Player player1, View view) {
        super();
    }

    @Override
    public void play() {
        System.out.println("Début du jeu : Tic Tac Toe !");
        while (!isOver()) {
            // Afficher le plateau
            displayBoard();

            // Demander un coup au joueur actuel
            boolean validMove = false;
            while (!validMove) {
                System.out.println("C'est au tour de " + currentPlayer.getState());
                int[] move = currentPlayer.getMove(board);

                // Validation : Vérifier si la cellule est vide
                if (isCellEmpty(move[0], move[1])) {
                    board[move[0]][move[1]].setState(currentPlayer.getState());
                    validMove = true;
                } else {
                    System.out.println("La case (" + move[0] + ", " + move[1] + ") est déjà occupée. Veuillez choisir une autre case.");
                }
            }

            // Vérifier si le jeu est terminé
            if (isOver()) {
                displayBoard();
                System.out.println("Le gagnant est : " + currentPlayer.getState());
                return;
            }

            // Changer de joueur
            switchPlayer();
        }
        System.out.println("Match nul !");
    }


    @Override
    public boolean isOver() {
        // Implémentez les règles pour vérifier les lignes, colonnes et diagonales
        // Exemple pour les lignes :
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0].getRepresentation() != null &&
                    board[i][0].getRepresentation() == board[i][1].getRepresentation() &&
                    board[i][1].getRepresentation() == board[i][2].getRepresentation()) {
                return true;
            }
        }
        // Ajoutez les vérifications pour colonnes, diagonales, et plateau plein
        return false;
    }

    private void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getState().getRepresentation() + " ");
            }
            System.out.println();
        }
    }
}
