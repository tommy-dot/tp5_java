package controleur;

import affrontement.Bataille;
import protagonistes.EtreVivant;
import protagonistes.StockEtreVivant;

public class ControleurFaireRejoindreBataille {

	// Déclaration des variables de classe
	private StockEtreVivant stockEtreVivant; // variable pour le stock d'êtres vivants
	private Bataille bataille; // variable pour la bataille

	// Constructeur pour initialiser les variables de classe
	public ControleurFaireRejoindreBataille(StockEtreVivant stockEtreVivant, Bataille bataille) {
		this.stockEtreVivant = stockEtreVivant;
		this.bataille = bataille;
	}
	
	// Méthode pour retourner le nombre de combattants dans le stock
	public int nombreCombattant() {
		return stockEtreVivant.donnerNombrePersonnage();
	}
	
	// Méthode pour afficher les êtres vivants dans le stock
	public String afficherEtreVivant() {
		return stockEtreVivant.afficherEtreVivant();
	}

	// Méthode pour faire rejoindre un être vivant à la bataille
	public String faireRejoindreBataille(int numeroEtreVivant) {
		// Sélection de l'être vivant à partir de son numéro
		EtreVivant etreVivant = stockEtreVivant.selectionner(numeroEtreVivant);
		
		// Suppression de l'être vivant du stock
		stockEtreVivant.supprimerEtreVivant(etreVivant);
		
		// Ajout de l'être vivant à la bataille
		return etreVivant.rejointBataille(bataille);
	}
}
