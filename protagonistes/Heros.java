package protagonistes;

import armes.Epee;

public class Heros extends Homme{
    
    // Constructeur qui prend un nom et initialise les points de vie à 150
    public Heros(String name){
        super(name); // Appel du constructeur de la superclasse
        this.life = 150; // Initialisation des points de vie à 150
    }

    // Méthode qui renvoie une chaîne de caractères représentant une parole du héros
    public String parler(String text){
        String textToSpeach = "Le héros " + name + ": " + text;
        return textToSpeach;
    }

    // Méthode qui permet au héros de prendre une épée spécifiée
    // et met à jour le propriétaire de l'épée
    public String prendreEpee(Epee epee){
        epee.setProprietaire(this); // Mise à jour du propriétaire de l'épée
        return parler("Je prends " + epee.getnom()); // Parole du héros pour annoncer la prise de l'épée
    }
}
