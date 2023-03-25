package armes;

import protagonistes.Dragon;
import protagonistes.Homme;

public class Arme {
    protected Homme proprietaire;
    protected String nature;
    protected int degat;

    Arme(String nature, int degat){
        this.nature = nature;
        this.degat = degat;
    }

    public void setProprietaire(Homme proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Homme getProprietaire() {
        return proprietaire;
    }

    public String getNature() {
        return nature;
    }

    public Boolean estPris(){
        if (proprietaire != null) {
            return true;
        } else {
            return false;
        }
    }

    public void lacher(){
        setProprietaire(null);
    }

    public String attaque(Dragon dragon){
        String text = proprietaire.getName() + " attaque " + dragon.getName() + " avec son " + this.nature + "\n" + dragon.subirAttaque(degat);
        return text;
    }
}
