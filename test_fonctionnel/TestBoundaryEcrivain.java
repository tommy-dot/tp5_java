package test_fonctionnel;

import affrontement.Bataille;
import armes.StockArmes;
import controleur.ControleurCreerArme;
import controleur.ControleurCreerProtagoniste;
import controleur.ControleurFaireCombattre;
import controleur.ControleurFairePrendreArme;
import controleur.ControleurFaireRejoindreBataille;
import protagonistes.StockEtreVivant;
import vue.BoundaryCreerArme;
import vue.BoundaryCreerProtagoniste;
import vue.BoundaryEcrivain;
import vue.BoundaryFaireCombattre;
import vue.BoundaryFairePrendreArme;
import vue.BoundaryFaireRejoindreBataille;

public class TestBoundaryEcrivain {
	public static void main(String[] args) {

		StockArmes stockArmes = new StockArmes();
		StockEtreVivant stockEtreVivant = new StockEtreVivant();
		Bataille bataille = new Bataille();

		ControleurCreerProtagoniste controleurCreerProtagoniste = new ControleurCreerProtagoniste(stockEtreVivant);
		ControleurCreerArme controleurCreerArme = new ControleurCreerArme(stockArmes);
		ControleurFaireRejoindreBataille controleurFaireRejoindreBataille = new ControleurFaireRejoindreBataille(
				stockEtreVivant, bataille);
		ControleurFairePrendreArme controleurFairePrendreArme = new ControleurFairePrendreArme(bataille, stockArmes);
		ControleurFaireCombattre controleurFaireCombattre = new ControleurFaireCombattre(bataille);

		BoundaryCreerProtagoniste boundaryCreerProtagoniste = new BoundaryCreerProtagoniste(
				controleurCreerProtagoniste);

		BoundaryCreerArme boundaryCreerArme = new BoundaryCreerArme(controleurCreerArme);
		BoundaryFaireCombattre boundaryFaireCombattre = new BoundaryFaireCombattre(controleurFaireCombattre);
		BoundaryFairePrendreArme boundaryFairePrendreArme = new BoundaryFairePrendreArme(controleurFairePrendreArme);
		BoundaryFaireRejoindreBataille boundaryFaireRejoindreBataille = new BoundaryFaireRejoindreBataille(
				controleurFaireRejoindreBataille);

		BoundaryEcrivain boundaryEcrivain = new BoundaryEcrivain(boundaryCreerProtagoniste, boundaryCreerArme,
				boundaryFaireCombattre, boundaryFairePrendreArme, boundaryFaireRejoindreBataille);
		boundaryEcrivain.menuEcrivain();

	}
}
