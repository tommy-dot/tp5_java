package protagonistes;

import armes.Epee;

public class Heros extends Homme{
    
    public Heros(String name){
        super(name);
        this.life = 150;
    }

    public String parler(String text){
        String textToSpeach = "Le héro " + name + ": " + text;
        return textToSpeach;
    }

    public String prendreEpee(Epee epee){
        epee.setProprietaire(this);
        return parler("Je prends " + epee.getnom());
    }
}
