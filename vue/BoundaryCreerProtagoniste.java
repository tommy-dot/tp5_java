package vue;

import controleur.ControleurCreerProtagoniste;
import protagonistes.TypeEtreVivant;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BoundaryCreerProtagoniste {
    private ControleurCreerProtagoniste controleur;

    public BoundaryCreerProtagoniste(ControleurCreerProtagoniste controleur){
        this.controleur = controleur;
    }

    public void creerProtagoniste(){
        Scanner clavier = new Scanner(System.in);
        boolean isValide = false;
        TypeEtreVivant typeEtreVivant;
        int number = 0;

        System.out.println("Quel type de personnage souhaitez-vous créer?");
        System.out.println("1-un héros");
        System.out.println("2-un homme");
        System.out.println("3-un dragon");
        
        while (!isValide) {
            try {
                String input = clavier.nextLine();
                if(input.isEmpty()) {
                    continue;
                }

                number = Integer.parseInt(input);
                if (number >= 1 && number <= 3) {
                    switch (number) {
                        case 1:
                            typeEtreVivant = TypeEtreVivant.HEROS;
                            break;
                        case 2:
                            typeEtreVivant = TypeEtreVivant.HOMME;
                            break;
                        default:
                            typeEtreVivant = TypeEtreVivant.DRAGON;
                            break;
                    }
                    isValide = true;
                    System.out.println("Quel est son nom?");
                    String name = clavier.nextLine();
                    controleur.creerEtreVivant(typeEtreVivant, name);
                } else {
                    System.out.println("Veuillez saisir un nombre entre 1 et 3.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Entrez un nombre valide.");
            } catch (NoSuchElementException e) {
                System.out.println("Erreur");
            }
        }
    }

    
}
