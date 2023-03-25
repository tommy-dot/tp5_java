package vue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichier implements ILivre {
	@Override
	public void ecrire(String texte) {
		String chemin = "C:/Users/tommy/OneDrive/Bureau/GIT/tp5_java/document/histoire.txt";
		try (FileWriter fichier = new FileWriter(new File(chemin), true)) {
			fichier.write(texte);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
