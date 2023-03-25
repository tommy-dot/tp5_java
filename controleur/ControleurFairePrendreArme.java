package controleur;

import affrontement.Bataille;
import armes.Arme;
import armes.StockArmes;
import protagonistes.Homme;
import protagonistes.TypeEtreVivant;

public class ControleurFairePrendreArme {
    Bataille bataille; // The battle where the men will fight
    StockArmes stockArmes; // The stock of weapons available for the men

    public ControleurFairePrendreArme(Bataille bataille, StockArmes stockArmes) {
        this.bataille = bataille;
        this.stockArmes = stockArmes;
    }

    // Return the number of men fighting
    public int donnerNombreHommes() {
        return bataille.donnerNombreHommes();
    }

    // Return the number of available weapons
    public int donnerNombreArmes() {
        return stockArmes.donnerNombreArme();
    }

    // Show the men fighting in the battle
    public String afficherCombattantHomme() {
        return bataille.afficherCamp(TypeEtreVivant.HOMME);
    }

    // Show the available weapons
    public String afficherArmes() {
        return stockArmes.afficherArmes();
    }

    // Make a man take a weapon
    public String fairePrendreArme(int numHomme, int numArme) {
        Homme homme = (Homme) bataille.selectionner(TypeEtreVivant.HOMME, numHomme);
        Arme arme = stockArmes.selectionner(numArme);
        return homme.prendre(arme); // Return the message of the action (take the weapon)
    }
}
