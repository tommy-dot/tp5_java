package affrontement;

import protagonistes.Dragon;
import protagonistes.EtreVivant;
import protagonistes.Homme;
import protagonistes.TypeEtreVivant;

public class Bataille {
	private Camps campHomme = new Camps();
	private Camps campDragon = new Camps();

	public String ajouter(Homme homme) {
		String texte = "";
		campHomme.ajouterEtreVivant(homme);
		if (campHomme.nbCompagnon() > 1) {
			texte = homme.parler("Bonjour, je m'appelle " + homme.getnom() + " et je viens me joindre au combat.");
		} else {
			texte += (homme.getnom()
					+ " est le premier � se joindre � la derni�re bataille entre les Hommes et les dragons.\n");
		}
		return texte;
	}

	public String ajouter(Dragon dragon) {
		String texte = "";
		campDragon.ajouterEtreVivant(dragon);
		if (campDragon.nbCompagnon() > 1) {
			texte = ("Un nouveau dragon " + dragon.getnom() + " s'approchait du champ de bataille.\n");
		} else {
			texte = "Le dragon " + dragon.getnom() + " fut le premier � arriver sur le champ de bataille.\n";
		}
		return texte;
	}

	public String eliminer(Dragon dragon) {
		String texte = "";
		campDragon.supprimerCompagnon(dragon);
		if (campDragon.nbCompagnon() == 0 && campHomme.nbCompagnon() > 0) {
			texte = "Les Hommes ont conquis la lande, leurs villages n'auront plus jamais � trembler devant les dragons.\n";
		}
		return texte;
	}

	public String eliminer(Homme humain) {
		String texte = "";
		campHomme.supprimerCompagnon(humain);
		if (campHomme.nbCompagnon() == 0 && campDragon.nbCompagnon() > 0) {
			texte = "Les dragons ont conquis la lande, les Hommes n'ont pas pu survivre dans ce monde hostile.\n";
		}
		return texte;
	}

	public EtreVivant selectionner(TypeEtreVivant typeEtreVivant, int numero) {
		if (typeEtreVivant == TypeEtreVivant.HOMME) {
			return campHomme.selectionner(numero);
		} else {
			return campDragon.selectionner(numero);
		}
	}

	public String afficherCamp(TypeEtreVivant typeEtreVivant) {
		if (typeEtreVivant == TypeEtreVivant.HOMME) {
			return campHomme.afficherCamp();
		} else {
			return campDragon.afficherCamp();
		}
	}

	public int donnerNombreHommes() {
		return campHomme.nbCompagnon();
	}
	public int donnerNombreDragons() {
		return campDragon.nbCompagnon();
	}

}
