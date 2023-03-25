package protagonistes;

import affrontement.Bataille;

public abstract class EtreVivant {
    protected String name;
    protected int life;
    protected Bataille bataille;
    
    public abstract String mourir();

    EtreVivant(String name, int life){
        this.name = name;
        this.life = life;
    }

    public String getName(){
        return name;
    }

    public String rejointBataille(Bataille bataille){
        this.bataille = bataille;
        return "";
    }

}