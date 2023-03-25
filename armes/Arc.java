package armes;

import protagonistes.Dragon;

public class Arc extends Arme{
    private int nbrFleches; // Le nombre de flèches restantes pour l'arc

    public Arc(int nbrFleches){
        super("Arc", 30); // Appelle le constructeur de la classe parente avec un nom et des dégâts
        this.nbrFleches = nbrFleches; // Initialise le nombre de flèches
    }

    public int getNbrFleches() {
        return nbrFleches; // Renvoie le nombre de flèches restantes
    }

    public String attaque(Dragon dragon){
        if (nbrFleches > 0) { // Si le nombre de flèches restantes est supérieur à 0
            String text1 = proprietaire.getnom() + " attaque " + dragon.getnom() + " avec son " + this.nature + "\n"; // Prépare le texte d'attaque
            String text = text1 + dragon.subirAttaque(degat); // Fait subir les dégâts au dragon et ajoute le texte à la suite de la phrase d'attaque
            nbrFleches--; // Décrémente le nombre de flèches restantes
            return text; // Renvoie le texte complet
        } else { // Si le nombre de flèches restantes est égal à 0
            String text1 = proprietaire.getnom() + " attaque " + dragon.getnom() + " avec son " + this.nature + "\n"; // Prépare le texte d'attaque
            String text = text1 + "Malheuresement il n'a plus de flèches!"; // Indique que l'arc n'a plus de flèches
            return text; // Renvoie le texte complet
        }
        
    }
}
