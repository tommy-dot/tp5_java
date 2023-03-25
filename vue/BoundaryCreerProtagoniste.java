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

        // Demander à l'utilisateur le type de personnage à créer
        System.out.println("Quel type de personnage souhaitez-vous créer?");
        System.out.println("1-un héros");
        System.out.println("2-un homme");
        System.out.println("3-un dragon");
        
        // Boucle tant que l'utilisateur ne fournit pas une réponse valide
        while (!isValide) {
            try {
                // Lire l'entrée utilisateur
                String input = clavier.nextLine();
                if(input.isEmpty()) {
                    continue;
                }

                // Convertir l'entrée utilisateur en un nombre entier
                number = Integer.parseInt(input);
                
                // Vérifier si le nombre est dans la plage valide (entre 1 et 3)
                if (number >= 1 && number <= 3) {
                    // En fonction du nombre fourni par l'utilisateur, définir le type d'entité vivante
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
                    
                    // Marquer la réponse comme valide
                    isValide = true;
                    
                    // Demander à l'utilisateur le nom de l'entité vivante
                    System.out.println("Quel est son nom?");
                    String name = clavier.nextLine();
                    
                    // Créer l'entité vivante en utilisant le contrôleur
                    controleur.creerEtreVivant(typeEtreVivant, name);
                } else {
                    // Si l'utilisateur fournit un nombre invalide, lui demander de fournir un nombre entre 1 et 3
                    System.out.println("Veuillez saisir un nombre entre 1 et 3.");
                }
            } catch(NumberFormatException e) {
                // Si l'utilisateur fournit une entrée qui ne peut pas être convertie en un nombre entier, lui demander d'entrer un nombre valide
                System.out.println("Entrez un nombre valide.");
            } catch (NoSuchElementException e) {
                // Si une exception de type NoSuchElementException est levée, afficher un message d'erreur
                System.out.println("Erreur");
            }
        }
    }
}
