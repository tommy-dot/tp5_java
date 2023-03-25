package armes;

import protagonistes.Dragon;
import protagonistes.Homme;

public class Arme {
    protected Homme proprietaire; // Le propriétaire actuel de l'arme
    protected String nature; // La nature de l'arme
    protected int degat; // Les dégâts de l'arme

    Arme(String nature, int degat){
        this.nature = nature; // Initialise la nature de l'arme
        this.degat = degat; // Initialise les dégâts de l'arme
    }

    public void setProprietaire(Homme proprietaire) {
        this.proprietaire = proprietaire; // Définit le propriétaire de l'arme
    }

    public Homme getproprietair() {
        return proprietaire; // Renvoie le propriétaire actuel de l'arme
    }

    public String getnature() {
        return nature; // Renvoie la nature de l'arme
    }

    public Boolean estpris(){
        if (proprietaire != null) { // Si l'arme a un propriétaire
            return true; // Renvoie vrai
        } else {
            return false; // Renvoie faux
        }
    }

    public void lacher(){
        setProprietaire(null); // Définit le propriétaire de l'arme à null
    }

    public String attaque(Dragon dragon){
        String text = proprietaire.getnom() + " attaque " + dragon.getnom() + " avec son " + this.nature + "\n" + dragon.subirAttaque(degat); // Prépare le texte d'attaque en utilisant le nom du propriétaire, le nom du dragon, la nature de l'arme et les dégâts infligés au dragon
        return text; // Renvoie le texte complet
    }
}
