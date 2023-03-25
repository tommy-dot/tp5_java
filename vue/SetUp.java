package vue;

import affrontement.Bataille;
import armes.StockArmes;
import controleur.ControleurCreerArme;
import controleur.ControleurCreerProtagoniste;
import controleur.ControleurFaireCombattre;
import controleur.ControleurFairePrendreArme;
import controleur.ControleurFaireRejoindreBataille;
import protagonistes.StockEtreVivant;

public class SetUp {
	public static void main(String[] args) {
		// Déclaration des variables et initialisation du choix de support d'écriture
		SupportEcriture supportEcriture;
		int choixSupport;
		do {
			System.out.println("Souhaitez-vous afficher votre texte de l'écran ou l'écrire dans un fichier ?");
			System.out.println("1 - Affichage écran");
			System.out.println("2 - Ecriture fichier");
			// Lecture de la réponse de l'utilisateur
			choixSupport = Clavier.entrerClavierInt();
		} while (choixSupport < 1 || choixSupport > 2);

		// Création de l'objet supportEcriture en fonction du choix de l'utilisateur
		if (choixSupport == 1) {
			supportEcriture = new SupportEcriture(new Ecran());
		} else {
			supportEcriture = new SupportEcriture(new Fichier());
		}

		// Initialisation des stocks d'armes et d'êtres vivants, ainsi que de la bataille
		StockArmes stockArmes = new StockArmes();
		StockEtreVivant stockEtreVivant = new StockEtreVivant();
		Bataille bataille = new Bataille();

		// Création des différents contrôleurs
		ControleurCreerProtagoniste controleurCreerProtagoniste = new ControleurCreerProtagoniste(stockEtreVivant);
		ControleurCreerArme controleurCreerArme = new ControleurCreerArme(stockArmes);
		ControleurFaireRejoindreBataille controleurFaireRejoindreBataille = new ControleurFaireRejoindreBataille(stockEtreVivant, bataille);
		ControleurFairePrendreArme controleurFairePrendreArme = new ControleurFairePrendreArme(bataille, stockArmes);
		ControleurFaireCombattre controleurFaireCombattre = new ControleurFaireCombattre(bataille);

		// Création des différentes interfaces graphiques
		BoundaryCreerProtagoniste boundaryCreerProtagoniste = new BoundaryCreerProtagoniste(controleurCreerProtagoniste);
		BoundaryCreerArme boundaryCreerArme = new BoundaryCreerArme(controleurCreerArme);
		BoundaryFaireRejoindreBataille boundaryFaireRejoindreBataille = new BoundaryFaireRejoindreBataille(controleurFaireRejoindreBataille, supportEcriture);
		BoundaryFaireCombattre boundaryFaireCombattre = new BoundaryFaireCombattre(controleurFaireCombattre, supportEcriture);
		BoundaryFairePrendreArme boundaryFairePrendreArme = new BoundaryFairePrendreArme(controleurFairePrendreArme, supportEcriture);
		BoundaryEcrivain boundaryEcrivain = new BoundaryEcrivain(boundaryCreerProtagoniste, boundaryCreerArme,
				boundaryFaireCombattre, boundaryFairePrendreArme, boundaryFaireRejoindreBataille);
		boundaryEcrivain.menuEcrivain();
	}

}
