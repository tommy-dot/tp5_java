package controleur;

import protagonistes.Dragon;
import protagonistes.Heros;
import protagonistes.Homme;
import protagonistes.StockEtreVivant;
import protagonistes.TypeEtreVivant;

public class ControleurCreerProtagoniste {
    private StockEtreVivant stockEtreVivant;

    // Le constructeur prend un objet StockEtreVivant en paramètre
    public ControleurCreerProtagoniste(StockEtreVivant stockEtreVivant){
        this.stockEtreVivant = stockEtreVivant;
    }

    // Cette méthode crée un être vivant de type donné avec un nom donné
    public void creerEtreVivant(TypeEtreVivant typeEtreVivant, String nomEtreVivant){
        // Un switch est utilisé pour créer un être vivant en fonction de son type
        switch (typeEtreVivant) {
            // Si le type est HEROS, un nouvel objet Heros est créé avec le nom donné et ajouté à l'objet StockEtreVivant
            case HEROS:
                Heros hero = new Heros(nomEtreVivant);
                this.stockEtreVivant.ajouterHeros(hero);
                break;

            // Si le type est HOMME, un nouvel objet Homme est créé avec le nom donné et ajouté à l'objet StockEtreVivant
            case HOMME:
                Homme homme = new Homme(nomEtreVivant);
                this.stockEtreVivant.ajouterHomme(homme);
                break;

            // Par défaut, si le type n'est ni HEROS ni HOMME, un nouvel objet Dragon est créé avec le nom donné et ajouté à l'objet StockEtreVivant
            default:
                Dragon dragon = new Dragon(nomEtreVivant);
                this.stockEtreVivant.ajouterDragon(dragon);
                break;
        }
    }
}
