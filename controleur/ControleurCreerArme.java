package controleur;

import armes.Arc;
import armes.Epee;
import armes.LancePierre;
import armes.StockArmes;

public class ControleurCreerArme {
	private StockArmes stockArmes; // Le stock d'armes géré par le contrôleur

	public ControleurCreerArme(StockArmes stockArmes) {
		this.stockArmes = stockArmes; // Initialise le stock d'armes
	}
	
	public void creerArme() {
		stockArmes.ajouterArme(new LancePierre()); // Crée et ajoute une lance-pierre au stock d'armes
	}
	
	public void creerArme(int nombreFleches) {
		stockArmes.ajouterArme(new Arc(nombreFleches)); // Crée et ajoute un arc avec le nombre de flèches donné au stock d'armes
	}
	
	public void creerArme(String nom) {
		stockArmes.ajouterArme(new Epee(nom)); // Crée et ajoute une épée avec le nom donné au stock d'armes
	}
}
