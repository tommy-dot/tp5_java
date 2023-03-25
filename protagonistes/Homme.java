package protagonistes;

import affrontement.Bataille;
import armes.Arme;
import armes.Epee;

public class Homme extends EtreVivant{
    // Déclaration de la variable maPossession qui peut contenir une arme
    private Arme maPossession = null;

    // Constructeur de la classe Homme qui hérite de la classe EtreVivant
    public Homme(String name){
        // Appel du constructeur de la classe parente avec les paramètres name et 100
        super(name, 100);
    }

    // Fonction permettant au personnage de parler
    public String parler(String text){
        // Concaténation du nom du personnage et du texte à dire
        String textToSpeach = name + ": " + text;
        return textToSpeach;
    }

    // Fonction permettant au personnage de rejoindre une bataille
    public String rejointBataille(Bataille bataille){
        // Assignation de la bataille à laquelle le personnage rejoint
        this.bataille = bataille;
        // Appel de la méthode ajouter de la classe Bataille avec le personnage en paramètre
        return bataille.ajouter(this);
    }

    // Fonction permettant au personnage de mourir
    public String mourir(){
        // Message de mort avec le nom du personnage
        String mourirText = "C'est ainsi que le courageux: " + this.name + " mourut.";
        // Si le personnage avait une arme, il la lâche
        if (maPossession != null) {
            lacher();
        }
        // Élimination du personnage de la bataille en cours
        this.bataille.eliminer(this);
        return mourirText;
    }

    // Fonction permettant au personnage de subir une attaque
    public String subirAttaque(int degat){
        // Déclaration d'une chaîne vide pour stocker le texte à retourner
        String text = "";
        // Réduction de la vie du personnage en fonction des dégâts subis
        this.life = this.life - degat;
        // Si le personnage est toujours en vie
        if (this.life > 0) {
            // Message indiquant que le personnage a subi une attaque, mais qu'il est encore debout
            text = this.name + " subit une violente attaque, mais il parvient à se relever!";
        } else {
            // Si le personnage est mort, message indiquant qu'il a subi une attaque fatale et appel de la fonction mourir
            text = this.name + " subit une violente attaque, trop violente pour survivre! \n" + mourir();
        }
        return text;
    }


    public String lacher() {
        String text = "";

        // Vérifie si le personnage a une arme en sa possession
        if (maPossession != null) {
            text = this.getnom() + " a laché son " + maPossession.getnature();
            maPossession.lacher();
            maPossession = null;
        } else {
            text = "Personne ne peut lacher cette arme car personne ne la possède !";
        }

        return text;
    }

    // Méthode pour prendre une arme
    public String prendre(Arme arme) {
        String text = "";

        // Si le personnage a déjà une arme, il la lâche d'abord
        if (maPossession != null) {
            lacher();
            maPossession = arme;
            maPossession.setProprietaire(this);
        }

        // Si une autre personne possède déjà l'arme, le personnage essaie de la lui emprunter
        if (arme.estpris()) {
            String text1 = this.parler(arme.getproprietair().getnom() + " peux-tu me laisser ton " + arme.getnature());
            String text2 = arme.getproprietair().parler("Pas de souci, cela me permettra de reprendre mon souffle.");
            text = text1 + "\n" + text2 + "\n" + arme.getproprietair().lacher() + "\n";
        }

        // Si l'arme est une épée et que le personnage est un héros, il peut la prendre
        if (arme instanceof Epee) {
            if (this instanceof Heros) {
                this.maPossession = arme;
            }
            return text + prendreEpee((Epee) arme);
        }

        // Le personnage prend l'arme
        text = this.parler(" Je prends mon " + arme.getnature() + ".");
        maPossession = arme;
        maPossession.setProprietaire(this);

        return text;
    }

    // Méthode pour combattre un dragon
    public String combattre(Dragon dragon) {
        String text = "";

        // Si le personnage n'a pas d'arme, il essaie d'attaquer le dragon sans arme
        if (maPossession == null) {
            text = this.getnom() + " s'attaque sans aucune arme à " + dragon.getnom() + "\n" + this.mourir();
        } else {
            // Le personnage attaque le dragon avec son arme
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
