package armes;

import protagonistes.Dragon;

public class Arc extends Arme{
    private int nbrFleches;

    public Arc(int nbrFleches){
        super("Arc", 30);
        this.nbrFleches = nbrFleches;
    }

    public int getNbrFleches() {
        return nbrFleches;
    }

    public String attaque(Dragon dragon){
        if (nbrFleches > 0) {
            String text1 = proprietaire.getName() + " attaque " + dragon.getName() + " avec son " + this.nature + "\n";
            String text = text1 + dragon.subirAttaque(degat);
            nbrFleches--;
            return text;
        } else {
            String text1 = proprietaire.getName() + " attaque " + dragon.getName() + " avec son " + this.nature + "\n";
            String text = text1 + "Malheuresement il n'a plus de flèches!";
            return text;
        }
        
    }
}
