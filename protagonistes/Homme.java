package protagonistes;

import affrontement.Bataille;
import armes.Arme;
import armes.Epee;

public class Homme extends EtreVivant{
    private Arme maPossession = null;

    public Homme(String name){
        super(name, 100);
    }

    public String parler(String text){
        String textToSpeach = name + ": " + text;
        return textToSpeach;
    }

    public String rejointBataille(Bataille bataille){
        this.bataille = bataille;
        return bataille.ajouter(this);
    }

    public String mourir(){
        String mourirText = "C'est ainsi que le courageux: " + this.name + " mourut.";
        if (maPossession != null) {
            lacher();
        }
        this.bataille.eliminer(this);
        return mourirText;
    }

    public String subirAttaque(int degat){
        String text = "";
        this.life = this.life - degat;
        if (this.life > 0) {
            text = this.name + " subit une violente attaque, mais il parvient à se relever!";
        } else {
            text = this.name + " subit une violente attaque, trop violente pour survivre! \n" + mourir();
        }
        return text;
    }

    public String lacher(){
        String text = "";
        if (maPossession != null){
            text = this.getnom() + " a laché son " + maPossession.getnature();
            maPossession.lacher();
            maPossession = null;
        } else {
            text = "Personne ne peut lacher cette arme car personne ne la possède !";
        }
        return text;
    }

    public String prendre(Arme arme){
        String text = "";

        if (maPossession != null) {
            lacher();
            maPossession = arme;
            maPossession.setProprietaire(this);
        }
        
        if (arme.estpris()) {
            String text1 = this.parler(arme.getproprietair().getnom() + " peux-tu me laisser ton " + arme.getnature());
            String text2 = arme.getproprietair().parler("Pas de souci, cela me permettra de reprendre mon souffle.");
            text = text1 + "\n" + text2 + "\n" + arme.getproprietair().lacher() + "\n";
        }

        if (arme instanceof Epee) {
            if (this instanceof Heros) {
                this.maPossession = arme;
            }
            return text + prendreEpee((Epee) arme);
        }

        text = this.parler(" Je prends mon " + arme.getnature() + ".");
        maPossession = arme;
        maPossession.setProprietaire(this);

        return text;
    }

    public String combattre(Dragon dragon){
        String text = "";
        if (maPossession == null) {
            text = this.getnom() + " s'attaque sans aucune arme à " + dragon.getnom() + "\n" +this.mourir();
        } else {
            text = maPossession.attaque(dragon);
        }

        return text;
    }

    public String prendreEpee(Epee epee){
        String text = "";
        this.life = this.life - 10;
        if (this.life > 0){
            text = this.getnom() + ": Je prends l’épée même si pour cela je dois perdre des forces.";
            maPossession = epee;
            maPossession.setProprietaire(this);
        } else {
            text = this.getnom() + " a voulu prendre l’épée mais son état de fatigue ne lui permettait pas cet ultime effort, il en est mort! \n" + this.mourir();
        }

        return text;
    }
}
