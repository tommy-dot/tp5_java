package vue;
// Importation du controleur qui gère la création d'une arme
import controleur.ControleurCreerArme;

// Définition de la classe BoundaryCreerArme
public class BoundaryCreerArme {
	
	// Déclaration du controleur
	ControleurCreerArme controleur;

	// Constructeur prenant en paramètre le controleur pour la création d'arme
	public BoundaryCreerArme(ControleurCreerArme controleur) {
		this.controleur = controleur;
	}

	// Méthode pour créer une arme
	public void creerArme() {
		// Déclaration de la variable pour stocker le choix du type d'arme
		int numTypeArme;
		// Boucle pour continuer la saisie tant que le choix n'est pas valide
		do {
			// Affichage des choix d'arme
			System.out.println("Quel type d'arme souhaitez-vous créer ?");
			System.out.println("1 - une épée,");
			System.out.println("2 - un arc,");
			System.out.println("3 - un lance-pierre.");
			// Récupération du choix de l'utilisateur
			numTypeArme = Clavier.entrerClavierInt();
			// Switch sur le choix de l'utilisateur
			switch (numTypeArme) {
			// Si choix 1, création d'une épée
			case 1:
				System.out.println("Donnez le nom de votre épée : ");
				// Récupération du nom de l'épée
				String nom = Clavier.entrerClavierString();
				// Appel du controleur pour la création de l'épée
				controleur.creerArme(nom);
				break;
			// Si choix 2, création d'un arc
			case 2:
				System.out.println("Donnez le nombre de flèches : ");
				// Récupération du nombre de flèches
				int nombreFleches = Clavier.entrerClavierInt();
				// Appel du controleur pour la création de l'arc
				controleur.creerArme(nombreFleches);
				break;
			// Si choix 3, création d'un lance-pierre
			case 3:
				// Appel du controleur pour la création du lance-pierre
				controleur.creerArme();
				break;
			// Si choix invalide, affichage d'un message d'erreur
			default:
				System.out.println("Vous devez entrer un nombre entre 1 et 3");
				break;
			}
		} while (numTypeArme < 1 || numTypeArme > 3); // Condition de sortie de la boucle
	}
}
