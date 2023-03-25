package vue;

public class SupportEcriture {
    private ILivre livre;

    public SupportEcriture (ILivre livre){
        this.livre=livre;
    }

    public void ecrire(String texte){
        this.livre.ecrire(texte);
    }
}
