package protagonistes;

import affrontement.Bataille;

public class Dragon extends EtreVivant{
    private int nbrBouleDeFeu = 10;
    
    public Dragon(String name){
        super(name, 200);
    }

    public String rejointBataille(Bataille bataille){
        this.bataille = bataille;
        return bataille.ajouter(this);
    }

    public String mourir(){
        String mourirText = "C'est ainsi que le dragon " + this.name + " mourut. \n" + this.bataille.eliminer(this);
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

    public String cracheBouleFeu(Homme homme){
        if (nbrBouleDeFeu > 0) {
            String text = this.getName() + " crache une boule de feu sur " + homme.getName() + "!"+ "\n" + homme.subirAttaque(100);
            nbrBouleDeFeu--;
            return text;
        } else {
            String text = this.getName() + " a voulu attaquer " + homme.getName() + " mais il n’avait plus de feu en lui. " + homme.getName() + " a eu beaucoup de chance !" ;
            return text;
        }
        
    }
}
