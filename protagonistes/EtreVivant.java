package protagonistes;

import affrontement.Bataille;

public abstract class EtreVivant {
    protected String name; // Nom de l'être vivant
    protected int life; // Points de vie restants de l'être vivant
    protected Bataille bataille; // Bataille actuelle à laquelle l'être vivant participe
    
    // Méthode abstraite qui sera implémentée par les sous-classes
    public abstract String mourir();

    // Constructeur qui initialise le nom et les points de vie de l'être vivant
    EtreVivant(String name, int life){
        this.name = name;
        this.life = life;
    }

    // Méthode qui renvoie le nom de l'être vivant
    public String getnom(){
        return name;
    }

    // Méthode qui fait rejoindre l'être vivant à une bataille spécifiée
    // et met à jour la bataille actuelle de l'être vivant
    public String rejointBataille(Bataille bataille){
        this.bataille = bataille;
        return ""; // Cette méthode ne retourne aucune valeur significative
    }
}
