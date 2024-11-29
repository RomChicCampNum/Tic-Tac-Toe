package controller;

import model.Player;
import model.HumanPlayer;
import model.ArtificialPlayer;
import model.State;
import view.View;
import view.Messages;

import java.util.Scanner;

public class InteractionUtilisateur {
    private final Scanner scanner = new Scanner(System.in);
    private final View view;

    public InteractionUtilisateur(View view) {
        this.view = view;
    }

    public BoardGame chooseGame() {
        view.displayMessage(Messages.WELCOME.getMessage());

        int choice = askForInt(Messages.CHOOSE_GAME.getMessage(), 1, 3);
        Player[] players = choosePlayers();

        return switch (choice) {
            case 1 -> new TicTacToe(players, view);
            case 2 -> new ConnectFour(players, view);
            case 3 -> new Gomoku(players, view);
            default -> {
                view.displayMessage("Choix invalide, par défaut : Tic Tac Toe.");
                yield new TicTacToe(players, view);
            }
        };
    }

    public Player[] choosePlayers() {
        int choice = askForInt(Messages.CHOOSE_PLAYERS.getMessage(), 1, 3);

        return switch (choice) {
            case 1 -> new Player[]{
                    new HumanPlayer(State.X, this),
                    new HumanPlayer(State.O, this)
            };
            case 2 -> new Player[]{
                    new HumanPlayer(State.X, this),
                    new ArtificialPlayer(State.O)
            };
            case 3 -> new Player[]{
                    new ArtificialPlayer(State.X),
                    new ArtificialPlayer(State.O)
            };
            default -> {
                view.displayMessage(Messages.INVALID_INPUT.getMessage());
                yield new Player[]{
                        new HumanPlayer(State.X, this),
                        new ArtificialPlayer(State.O)
                };
            }
        };
    }

    public int askForInt(String message, int min, int max) {
        int value;
        while (true) {
            view.displayMessage(message); // Affiche le message une seule fois
            try {
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (Exception e) {
                scanner.next(); // Ignore les saisies invalides
                view.displayMessage(Messages.INVALID_INPUT.getMessage());
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
