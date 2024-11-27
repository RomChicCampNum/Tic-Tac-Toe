package view;

import model.Cell;

public class View {
    // Affiche une grille générique
    public void displayBoard(Cell[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print("| " + board[row][col].getState().getRepresentation() + " ");
            }
            System.out.println("|");
        }
        // Ajoute des indices de colonnes pour ConnectFour ou autres jeux nécessitant un marquage
        System.out.print(" ");
        for (int col = 0; col < board[0].length; col++) {
            System.out.print("  " + col + " ");
        }
        System.out.println();
    }

    // Affiche un message à l'utilisateur
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
