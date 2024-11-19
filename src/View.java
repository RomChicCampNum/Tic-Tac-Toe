public class View {
    // Affiche un message simple
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Affiche le plateau de jeu
    public void displayBoard(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getRepresentation());
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----------");
            }
        }
    }
}
