package util;

import boardgames.BoardGame;
import boardgames.TicTacToe;
import boardgames.ConnectFour;
import players.Player;
import players.HumanPlayer;
import players.ArtificialPlayer;

import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner = new Scanner(System.in);

    public BoardGame chooseGame(View view) {
        System.out.println("Choisissez un jeu :");
        System.out.println("1. Tic Tac Toe");
        System.out.println("2. Puissance 4");

        int choice = askForInt("Votre choix :", 1, 2);
        Player[] players = choosePlayers();

        switch (choice) {
            case 1:
                return new TicTacToe(players[0], players[1], view);
            case 2:
                return new ConnectFour(players[0], players[1], view);
            default:
                System.out.println("Choix invalide. Par défaut : Tic Tac Toe.");
                return new TicTacToe(players[0], players[1], view);
        }
    }

    public Player[] choosePlayers() {
        System.out.println("1. Humain contre Humain");
        System.out.println("2. Humain contre IA");
        System.out.println("3. IA contre IA");

        int choice = askForInt("Votre choix :", 1, 3);
        switch (choice) {
            case 1:
                return new Player[]{new HumanPlayer(State.X, this), new HumanPlayer(State.O, this)};
            case 2:
                return new Player[]{new HumanPlayer(State.X, this), new ArtificialPlayer(State.O)};
            case 3:
                return new Player[]{new ArtificialPlayer(State.X), new ArtificialPlayer(State.O)};
            default:
                return new Player[]{new HumanPlayer(State.X, this), new HumanPlayer(State.O, this)};
        }
    }

    public int askForInt(String question, int min, int max) {
        int value;
        while (true) {
            System.out.println(question);
            try {
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (Exception e) {
                scanner.next(); // Ignore la saisie invalide
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
