package armes;

public class Epee extends Arme{
    private String nom; // Le nom de l'épée

    public Epee(String nom){
        super("épée", 80); // Appelle le constructeur de la classe mère (Arme) avec la nature "épée" et les dégâts 80
        this.nom = nom; // Initialise le nom de l'épée
    }

    public String getnom() {
        return nom; // Renvoie le nom de l'épée
    }
}
