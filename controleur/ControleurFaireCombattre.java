package controleur;

import affrontement.Bataille;
import protagonistes.Dragon;
import protagonistes.EtreVivant;
import protagonistes.Homme;
import protagonistes.TypeEtreVivant;

public class ControleurFaireCombattre {
    Bataille bataille;

    public ControleurFaireCombattre(Bataille bataille) {
        this.bataille = bataille;
    }

    // Cette méthode renvoie le nombre d'hommes présents dans la bataille
    public int donnerNombreHommes() {
        return bataille.donnerNombreHommes();
    }

    // Cette méthode renvoie le nombre de dragons présents dans la bataille
    public int donnerNombreDragon() {
        return bataille.donnerNombreDragons();
    }

    // Cette méthode renvoie une chaîne de caractères décrivant tous les Hommes présents dans la bataille
    public String afficherCombattantHomme() {
        return bataille.afficherCamp(TypeEtreVivant.HOMME);
    }

    // Cette méthode renvoie une chaîne de caractères décrivant tous les Dragons présents dans la bataille
    public String afficherCombattantDragon() {
        return bataille.afficherCamp(TypeEtreVivant.DRAGON);
    }

    // Cette méthode permet à un être vivant d'un type donné (Homme ou Dragon) de s'attaquer à un autre être vivant (Dragon ou Homme) donné par leur numéro dans leur camp respectif
    public String faireCombattre(TypeEtreVivant typeAttaquant, int numAttaquant, int numCible) {
        // Le premier être vivant est sélectionné en fonction de son type et de son numéro dans son camp
        EtreVivant attaquant = bataille.selectionner(typeAttaquant, numAttaquant);

        // Le type de la cible est déterminé en fonction du type de l'attaquant
        TypeEtreVivant typeCible = TypeEtreVivant.DRAGON;
        if(typeAttaquant == TypeEtreVivant.DRAGON) {
            typeCible = TypeEtreVivant.HOMME;
        }

        // La cible est sélectionnée en fonction de son type et de son numéro dans son camp
        EtreVivant cible = bataille.selectionner(typeCible, numCible);

        // Si l'attaquant est un Homme, il attaque un Dragon et la méthode combattre de l'Homme est appelée pour lancer le combat
        if(typeAttaquant == TypeEtreVivant.HOMME) {
            Homme homme = (Homme)attaquant;
            Dragon dragon = (Dragon)cible;
            return homme.combattre(dragon);
        }

        // Si l'attaquant est un Dragon, il attaque un Homme et la méthode cracheBouleFeu du Dragon est appelée pour lancer le combat
        Dragon dragon = (Dragon)attaquant;
        Homme homme = (Homme)cible;
        return dragon.cracheBouleFeu(homme);
    }
}
