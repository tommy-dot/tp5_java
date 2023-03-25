package vue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    // Méthode permettant de lire un entier saisi au clavier
    public static int entrerClavierInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) { // Si la saisie n'est pas un entier, on affiche un message d'erreur
            System.out.println("Vous devez entrer un entier.");
            scanner.next(); // On vide la ligne invalide dans le buffer
            return entrerClavierInt(); // On rappelle la méthode pour une nouvelle saisie
        }
    }

    // Méthode permettant de lire une chaîne de caractères saisie au clavier
    public static String entrerClavierString() {
        return scanner.next();
    }
}
