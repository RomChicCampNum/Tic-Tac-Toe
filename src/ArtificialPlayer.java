import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random;

    public ArtificialPlayer(String representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public int[] getMove(Cell[][] board) {
        int row, col;
        do {
            row = random.nextInt(board.length); // Ligne aléatoire
            col = random.nextInt(board[0].length); // Colonne aléatoire
        } while (!board[row][col].isEmpty()); // Continue jusqu'à trouver une case vide

        System.out.println("L'IA joue en (" + row + ", " + col + ")");
        return new int[]{row, col};
    }
}
