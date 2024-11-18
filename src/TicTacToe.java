public class TicTacToe {
    private static final int SIZE = 3;
    private Cell [][] grid;


    // Constructeur

    public TicTacToe() {
        grid = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            // Construire une ligne de la grille
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j].getRepresentation());
                if (j < SIZE - 1) {
                    System.out.print("|"); // Séparateur vertical
                }
            }
            System.out.println(); // Nouvelle ligne pour la grille
            if (i < SIZE - 1) {
                System.out.println("-----------"); // Séparateur horizontal (plus long)
            }
        }
    }
}

