package view;

import model.Cell;

public class View {
    public void displayBoard(Cell[][] board) {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.print("| " + cell.getState().getRepresentation() + " ");
            }
            System.out.println("|");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
