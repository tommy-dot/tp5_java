package vue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichier implements ILivre {
	@Override
	public void ecrire(String texte) {
		// Chemin du fichier à écrire
		String chemin = "C:/Users/tommy/OneDrive/Bureau/GIT/tp5_java/document/histoire.txt";
		try (FileWriter fichier = new FileWriter(new File(chemin), true)) {
			// On écrit le texte dans le fichier
			fichier.write(texte);
		} catch (IOException ex) {
			// En cas d'erreur, on affiche la pile d'erreurs pour le débogage
			ex.printStackTrace();
		}
	}
}
