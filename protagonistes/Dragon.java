package protagonistes;

import affrontement.Bataille;

public class Dragon extends EtreVivant{
    private int nbrBouleDeFeu = 10; // Variable pour le nombre de boules de feu restantes

    // Constructeur pour initialiser le nom et les points de vie du dragon
    public Dragon(String name){
        super(name, 200);
    }

    // Méthode pour faire rejoindre le dragon à la bataille
    public String rejointBataille(Bataille bataille){
        this.bataille = bataille;
        return bataille.ajouter(this);
    }

    // Méthode pour faire mourir le dragon
    public String mourir(){
        String mourirText = "C'est ainsi que le dragon " + this.name + " mourut. \n" + this.bataille.eliminer(this);
        return mourirText;
    }

    // Méthode pour faire cracher une boule de feu au dragon sur un homme
    public String cracheBouleFeu(Homme homme){
        if (nbrBouleDeFeu > 0) { // Vérifie s'il reste des boules de feu
            String text = this.getnom() + " crache une boule de feu sur " + homme.getnom() + "!"+ "\n" + homme.subirAttaque(100); // Fait subir une attaque de 100 points de dégâts à l'homme
            nbrBouleDeFeu--; // Diminue le nombre de boules de feu restantes
            return text;
        } else {
            String text = this.getnom() + " a voulu attaquer " + homme.getnom() + " mais il n’avait plus de feu en lui. " + homme.getnom() + " a eu beaucoup de chance !" ; // Si le dragon n'a plus de boules de feu, affiche un message pour indiquer que l'attaque a échoué
            return text;
        }
        
    }

    // Méthode pour faire subir une attaque au dragon
    public String subirAttaque(int degat){
        String text = "";
        this.life = this.life - degat; // Diminue les points de vie du dragon en fonction des dégâts infligés
        if (this.life > 0) {
            text = this.name + " subit une violente attaque, mais il parvient à se relever!"; // Si le dragon a encore des points de vie, affiche un message pour indiquer qu'il est encore en vie
        } else {
            text = this.name + " subit une violente attaque, trop violente pour survivre! \n" + mourir(); // Si le dragon n'a plus de points de vie, affiche un message pour indiquer qu'il est mort et appelle la méthode mourir()
        }
        return text;
    }
}
