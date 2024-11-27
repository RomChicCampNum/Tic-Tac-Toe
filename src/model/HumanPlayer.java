package model;

import controller.InteractionUtilisateur;

public class HumanPlayer extends Player {
    private InteractionUtilisateur interactionUtilisateur;

    public HumanPlayer(State state, InteractionUtilisateur interactionUtilisateur) {
        super(state);
        this.interactionUtilisateur = interactionUtilisateur;
    }

    @Override
    public int[] getMove(Cell[][] board) {
        int row = interactionUtilisateur.askForInt("Entrez la ligne : ", 0, board.length - 1);
        int col = interactionUtilisateur.askForInt("Entrez la colonne : ", 0, board[0].length - 1);
        return new int[]{row, col};
    }
}
