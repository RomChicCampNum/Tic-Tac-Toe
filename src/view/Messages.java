package view;

public enum Messages {
    WELCOME("Bienvenue dans le jeu !"),
    WELCOME_CONNECT4("Bienvenue dans le jeu Puissance 4 !"),
    CHOOSE_GAME("Choisissez un jeu : 1. Tic Tac Toe \n2. Puissance 4 \n3. Gomoku"),
    CHOOSE_PLAYERS("1. Humain contre Humain \n2. Humain contre IA \n3. IA contre IA"),
    INVALID_INPUT("Veuillez entrer un nombre valide."),
    PLAYER_TURN("C'est au tour de : "),
    INVALID_MOVE("Coup invalide, réessayez."),
    COLUMN_FULL("Colonne pleine. Choisissez une autre colonne."),
    VICTORY("Le gagnant est : "),
    DRAW("Match nul !");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
