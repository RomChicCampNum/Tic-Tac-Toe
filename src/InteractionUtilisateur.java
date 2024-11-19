import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner;

    public InteractionUtilisateur() {
        scanner = new Scanner(System.in);
    }


    // Affiche une question et récupère la répone sous forme d'entier
    public int askForInt(String question, int min, int max ) {
        int value = -1;
        while (true) {
            try {
                System.out.println(question + " ");
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    break; // Sort si la valeur est valide
                }
                System.out.println("Veuillez entrer un nombre entre " + min + " et " + max + ".");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
                scanner.next(); // Ignore l'entrée invalide
            }
        }
        return value;
    }

    // Ferme le scanner à la fin de l'utilisation
    public void close() {
        scanner.close();
    }
}