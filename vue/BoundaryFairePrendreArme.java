package vue;

import controleur.ControleurFairePrendreArme;

public class BoundaryFairePrendreArme {
    ControleurFairePrendreArme controleur;
    SupportEcriture supportEcriture;

    // Constructeur de la classe BoundaryFairePrendreArme
    public BoundaryFairePrendreArme(ControleurFairePrendreArme controleur, SupportEcriture supportEcriture) {
        this.controleur = controleur;
        this.supportEcriture = supportEcriture;
    }

    // Méthode pour faire prendre une arme à un combattant
    public void fairePrendreArme() {
        int nombreArmes = controleur.donnerNombreArmes();
        int nombreHommes = controleur.donnerNombreHommes();

        // Vérifier s'il y a des armes disponibles
        if (nombreArmes == 0) {
            System.out.println("Il n'y a aucune arme disponible");
        }

        // Vérifier s'il y a des combattants
        if (nombreHommes == 0) {
            System.out.println("Il n'y a aucun combattant");
        }

        // Si des combattants et des armes sont disponibles, faire choisir un homme et une arme
        if (nombreHommes != 0 && nombreArmes != 0) {
            int numHomme = choisirHomme(nombreHommes);
            int numArme = choisirArme(nombreArmes);
            supportEcriture.ecrire(controleur.fairePrendreArme(numHomme, numArme));
        }
    }

    // Méthode pour choisir un combattant
    private int choisirHomme(int nombreHommes) {
        String listeHommes = controleur.afficherCombattantHomme();
        int numHomme;

        // Demander à l'utilisateur de choisir un homme jusqu'à ce que le choix soit valide
        do {
            System.out.println("Quel homme va prendre l'arme ?");
            System.out.println(listeHommes);
            numHomme = Clavier.entrerClavierInt();
        } while (numHomme < 1 || numHomme > nombreHommes);
        return numHomme;
    }

    // Méthode pour choisir une arme
    private int choisirArme(int nombreArmes) {
        String listeArmes = controleur.afficherArmes();
        int numArme;

        // Demander à l'utilisateur de choisir une arme jusqu'à ce que le choix soit valide
        do {
            System.out.println("Quelle arme va prendre l'homme ?");
            System.out.println(listeArmes);
            numArme = Clavier.entrerClavierInt();
        } while (numArme < 1 || numArme > nombreArmes);
        return numArme;
    }
}
