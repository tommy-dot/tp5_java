package test_fonctionnel;

import affrontement.Bataille;
import protagonistes.Dragon;
import protagonistes.EtreVivant;
import protagonistes.Heros;
import protagonistes.Homme;
import protagonistes.StockEtreVivant;
import protagonistes.TypeEtreVivant;

public class TestEntites {
	public static void main(String[] args) {
		Heros arthur = new Heros("Arthur");
		Homme thomas = new Homme("Thomas");
		Homme jacques = new Homme("Jacques");
		Dragon dragonNoir = new Dragon("Dragon noir");
		Heros lancelot = new Heros("Lancelot");
		Heros perceval = new Heros("Perceval");

		StockEtreVivant stockEtreVivant = new StockEtreVivant();

		stockEtreVivant.ajouterHeros(arthur);
		stockEtreVivant.ajouterHomme(thomas);
		stockEtreVivant.ajouterHomme(jacques);
		stockEtreVivant.ajouterDragon(dragonNoir);
		stockEtreVivant.ajouterHeros(perceval);
		stockEtreVivant.ajouterHeros(lancelot);

		System.out.println("La liste des personnages non affect�es � une bataille est : ");
		System.out.println(stockEtreVivant.afficherEtreVivant());
		System.out.print("Je selectionne le num�ro 3 : ");
		EtreVivant etreVivantSelectionner = stockEtreVivant.selectionner(3);
		System.out.println(etreVivantSelectionner.getnom());
		System.out.println("Je supprime le num�ro 3");
		etreVivantSelectionner = stockEtreVivant.selectionner(3);
		stockEtreVivant.supprimerEtreVivant(etreVivantSelectionner);
		System.out.println("La liste des personnages non affect�es � une bataille est : ");
		System.out.println(stockEtreVivant.afficherEtreVivant());

		Bataille bataille = new Bataille();

		stockEtreVivant.supprimerEtreVivant(arthur);
		arthur.rejointBataille(bataille);
		stockEtreVivant.supprimerEtreVivant(thomas);
		thomas.rejointBataille(bataille);
		stockEtreVivant.supprimerEtreVivant(jacques);
		jacques.rejointBataille(bataille);
		stockEtreVivant.supprimerEtreVivant(dragonNoir);
		dragonNoir.rejointBataille(bataille);

		System.out.println("Les protagonistes qui ne sont affect�s � aucune bataille sont : ");
		System.out.print(stockEtreVivant.afficherEtreVivant());
		System.out.println("Dans la bataille, le camp des hommes est : ");
		System.out.print(bataille.afficherCamp(TypeEtreVivant.HOMME));
		System.out.println("Dans la bataille, le camp des dragons est : ");
		System.out.print(bataille.afficherCamp(TypeEtreVivant.DRAGON));

		System.out.print("Je selectionne le 1er et le 3eme homme : ");
		EtreVivant homme1 = bataille.selectionner(TypeEtreVivant.HOMME, 1);
		EtreVivant homme3 = bataille.selectionner(TypeEtreVivant.HOMME, 3);
		System.out.println(homme1.getnom() + " et " + homme3.getnom());

		System.out.print("Je selectionne le dragon : ");
		EtreVivant dragon = bataille.selectionner(TypeEtreVivant.DRAGON, 1);
		System.out.println(dragon.getnom());

		System.out.println("Je supprime le 3eme homme et le dragon");
		bataille.eliminer((Homme) homme3);
		bataille.eliminer((Dragon) dragon);

		System.out.println("Dans la bataille, le camp des hommes est : ");
		System.out.print(bataille.afficherCamp(TypeEtreVivant.HOMME));
		System.out.println("Dans la bataille, il n'y a plus de dragon ");
		System.out.print(bataille.afficherCamp(TypeEtreVivant.DRAGON));

		// RESULTAT ATTENDU
		// La liste des personnages non affect�es � une bataille est :
		// - 1 - le h�ros Arthur
		// - 2 - le h�ros Perceval
		// - 3 - le h�ros Lancelot
		// - 4 - l'homme Thomas
		// - 5 - l'homme Jacques
		// - 6 - le dragon Dragon noir
		//
		// Je selectionne le num�ro 3 : Lancelot
		// Je supprime le num�ro 3
		// La liste des personnages non affect�es � une bataille est :
		// - 1 - le h�ros Arthur
		// - 2 - le h�ros Perceval
		// - 3 - l'homme Thomas
		// - 4 - l'homme Jacques
		// - 5 - le dragon Dragon noir
		//
		// Les protagonistes qui ne sont affect�s � aucune bataille sont :
		// - 1 - le h�ros Perceval
		// Dans la bataille, le camp des hommes est :
		// - 1 - Arthur
		// - 2 - Thomas
		// - 3 - Jacques
		// Dans la bataille, le camp des dragons est :
		// - 1 - Dragon noir
		// Je selectionne le 1er et le 3eme homme : Arthur et Jacques
		// Je selectionne le dragon : Dragon noir
		// Je supprime le 3eme homme et le dragon
		// Dans la bataille, le camp des hommes est :
		// - 1 - Arthur
		// - 2 - Thomas
		// Dans la bataille, il n'y a plus de dragon
	}
}
