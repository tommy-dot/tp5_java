package vue;

import controleur.ControleurFaireRejoindreBataille;

public class BoundaryFaireRejoindreBataille {
	ControleurFaireRejoindreBataille controleur;
	SupportEcriture supportEcriture;

	// Constructeur prenant en paramètre le controleur et le support d'écriture
	public BoundaryFaireRejoindreBataille(ControleurFaireRejoindreBataille controleur, SupportEcriture supportEcriture) {
		this.controleur = controleur;
		this.supportEcriture = supportEcriture;
	}

	// Méthode permettant de faire rejoindre un personnage à la bataille
	public void faireRejoindreBataille() {
		// On vérifie s'il y a des combattants disponibles
		int nombreCombattant = controleur.nombreCombattant();
		if (nombreCombattant == 0) {
			System.out.println("Il n'y a pas de combattant à faire entrer dans la bataille");
		} else {
			// On demande à l'utilisateur de choisir le personnage à faire entrer dans la bataille
			int numTypeProtagoniste;
			String listePersonnage = controleur.afficherEtreVivant();
			do {
				System.out.println("Quel personnage souhaitez-vous faire entrer dans la bataille ?");
				System.out.println(listePersonnage);
				numTypeProtagoniste = Clavier.entrerClavierInt();
				if (numTypeProtagoniste < 1 || numTypeProtagoniste > nombreCombattant) {
					System.out.println("Vous devez entrer un nombre entre 1 et " + nombreCombattant);
				}
			} while (numTypeProtagoniste < 1 || numTypeProtagoniste > nombreCombattant);
			// On fait rejoindre le personnage à la bataille
			supportEcriture.ecrire(controleur.faireRejoindreBataille(numTypeProtagoniste));
		}
	}
}
