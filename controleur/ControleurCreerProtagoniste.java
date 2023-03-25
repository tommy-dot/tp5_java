package controleur;

import protagonistes.Dragon;
import protagonistes.Heros;
import protagonistes.Homme;
import protagonistes.StockEtreVivant;
import protagonistes.TypeEtreVivant;

public class ControleurCreerProtagoniste {
    private StockEtreVivant stockEtreVivant;

    public ControleurCreerProtagoniste(StockEtreVivant stockEtreVivant){
        this.stockEtreVivant = stockEtreVivant;
    }

    public void creerEtreVivant(TypeEtreVivant typeEtreVivant, String nomEtreVivant){
        switch (typeEtreVivant) {
            case HEROS:
                Heros hero = new Heros(nomEtreVivant);
                this.stockEtreVivant.ajouterHeros(hero);
                break;

            case HOMME:
                Homme homme = new Homme(nomEtreVivant);
                this.stockEtreVivant.ajouterHomme(homme);
                break;

            default:
                Dragon dragon = new Dragon(nomEtreVivant);
                this.stockEtreVivant.ajouterDragon(dragon);
                break;
        }
    }
}
