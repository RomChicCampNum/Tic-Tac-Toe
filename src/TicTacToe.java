public class TicTacToe {
    private static final int SIZE = 3;
    private Cell[][] board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private View view;

    public TicTacToe(Player playerX, Player playerO, View view) {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX; // Le joueur X commence
        this.view = view;
    }

    public void play() {
        view.displayMessage("Début de la partie !");
        while (!isOver()) {
            view.displayMessage("C'est au tour de " + currentPlayer.getRepresentation());
            int[] move = currentPlayer.getMove(board);
            setState(move[0], move[1], currentPlayer);

            view.displayBoard(board);

            if (isOver()) {
                view.displayMessage("Partie terminée !");
                view.displayMessage("Le gagnant est : " + currentPlayer.getRepresentation());
                return;
            }

            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
    }

    private void setState(int row, int col, Player player) {
        board[row][col].setState(player.getState()); // Définir l'état sur la cellule
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
                if (board[row][col].isEmpty()) {
                    return false; // Plateau non rempli, le jeu continue
                }
            }
        }

        return true; // Plateau plein et aucune victoire
    }

    private boolean checkLine(Cell a, Cell b, Cell c) {
        return a.getState() == b.getState() &&
                b.getState() == c.getState() &&
                a.getState() != State.EMPTY;
    }
}
