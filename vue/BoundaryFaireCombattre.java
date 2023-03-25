package vue;

import controleur.ControleurFaireCombattre;
import protagonistes.TypeEtreVivant;

public class BoundaryFaireCombattre {
    // Déclaration des attributs
    ControleurFaireCombattre controleur;
    SupportEcriture supportEcriture;

    // Constructeur de la classe BoundaryFaireCombattre
    public BoundaryFaireCombattre(ControleurFaireCombattre controleur, SupportEcriture supportEcriture) {
        this.controleur = controleur;
        this.supportEcriture = supportEcriture;
    }

    // Méthode pour lancer la séquence de combat
    public void faireCombattre() {
        // Récupération du nombre de dragons et d'hommes
        int nombreDragon = controleur.donnerNombreDragon();
        int nombreHomme = controleur.donnerNombreHommes();
        // Vérification qu'il y a au moins un combattant dans chaque camp pour pouvoir combattre
        if (nombreDragon == 0 || nombreHomme == 0) {
            System.out.println("Il faut avoir au moins un combattant dans chaque camps pour pouvoir combattre !");
        } else {
            // Sélection du type d'attaquant (homme ou dragon)
            int numType;
            do {
                System.out.println("Qui attaque ?");
                System.out.println("1 - un homme,");
                System.out.println("2 - un dragon.");
                numType = Clavier.entrerClavierInt();
            } while (numType < 1 || numType > 2);

            // Sélection de l'attaquant et de la cible en fonction du type d'attaquant
            int numAttaquant;
            int numCible;
            TypeEtreVivant typeAttaquant = TypeEtreVivant.HOMME;
            if (numType == 1) {
                numAttaquant = selectionnerHomme("qui attaque.", nombreHomme);
                numCible = selectionnerDragon("qui est attaqu�.", nombreDragon);
            } else {
                numAttaquant = selectionnerDragon("qui attaque.", nombreDragon);
                numCible = selectionnerHomme("qui est attaqu�.", nombreHomme);
                typeAttaquant = TypeEtreVivant.DRAGON;
            }

            // Appel à la méthode faireCombattre du controleur avec les paramètres sélectionnés
            supportEcriture.ecrire(controleur.faireCombattre(typeAttaquant, numAttaquant, numCible));
        }
    }

    // Méthode pour sélectionner un dragon parmi une liste de dragons
    private int selectionnerDragon(String typeActeur, int nombreDragons) {
        String listeDragons = controleur.afficherCombattantDragon();
        int numDragon;
        do {
            System.out.println("Selectionner le dragon " + typeActeur);
            System.out.println(listeDragons);
            numDragon = Clavier.entrerClavierInt();
        } while (numDragon < 1 || numDragon > nombreDragons);

        return numDragon;
    }


	private int selectionnerHomme(String typeActeur, int nombreHommes) {
		String listeHommes = controleur.afficherCombattantHomme();
		int numHomme;
		do {
			System.out.println("Selectionner l'homme " + typeActeur);
			System.out.println(listeHommes);
			numHomme = Clavier.entrerClavierInt();
		} while (numHomme < 1 || numHomme > nombreHommes);

		return numHomme;
	}
}
