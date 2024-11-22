package util;

import boardgames.BoardGame;
import boardgames.ConnectFour;
import boardgames.TicTacToe;
import players.ArtificialPlayer;
import players.HumanPlayer;
import players.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner;

    public InteractionUtilisateur() {
        scanner = new Scanner(System.in);
    }

    public BoardGame chooseGame() {
        System.out.println("Choisissez un jeu :");
        System.out.println("1. Tic Tac Toe");
        System.out.println("2. Puissance 4");

        int choice = askForInt("Votre choix :", 1, 2);

        // Sélection des joueurs
        Player[] players = choosePlayers();

        switch (choice) {
            case 1:
                return new TicTacToe(players[0], players[1]);
            case 2:
                return new ConnectFour(players[0], players[1]);
            default:
                System.out.println("Choix invalide, par défaut Tic Tac Toe.");
                return new TicTacToe(players[0], players[1]);
        }
    }


    public int askForInt(String question, int min, int max) {
        int value = -1;
        while (true) {
            try {
                System.out.println(question + " ");
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    break;
                }
                System.out.println("Veuillez entrer un nombre entre " + min + " et " + max + ".");
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                scanner.next(); // Ignore l'entrée invalide
            }
        }
        return value;
    }

    public Player[] choosePlayers() {
        System.out.println("Choisissez la configuration des joueurs :");
        System.out.println("1. Humain contre Humain");
        System.out.println("2. Humain contre IA");
        System.out.println("3. IA contre IA");

        int choice = askForInt("Votre choix :", 1, 3);

        Player playerX, playerO;

        switch (choice) {
            case 1:
                // Les joueurs humains utilisent désormais util.State.X et util.State.O
                playerX = new HumanPlayer(State.X, this);
                playerO = new HumanPlayer(State.O, this);
                break;
            case 2:
                // Humain contre IA
                playerX = new HumanPlayer(State.X, this);
                playerO = new ArtificialPlayer(State.O);
                break;
            case 3:
                // IA contre IA
                playerX = new ArtificialPlayer(State.X);
                playerO = new ArtificialPlayer(State.O);
                break;
            default:
                System.out.println("Choix invalide, par défaut Humain contre IA.");
                playerX = new HumanPlayer(State.X, this);
                playerO = new ArtificialPlayer(State.O);
        }

        return new Player[]{playerX, playerO};
    }

    public void close() {
        scanner.close();
    }
}
