package test_fonctionnel;

import affrontement.Bataille;
import armes.Arc;
import armes.Epee;
import armes.LancePierre;
import protagonistes.Dragon;
import protagonistes.Heros;
import protagonistes.Homme;

public class TestArme {
	public static void main(String[] args) {
		Bataille bataille = new Bataille();
		Homme homme = new Homme("Thomas");
		Heros heros = new Heros("Arthur");
		Dragon dragon = new Dragon("Dragonnet");
		System.out.println(homme.rejointBataille(bataille));
		System.out.println(heros.rejointBataille(bataille));
		System.out.println(dragon.rejointBataille(bataille));
		LancePierre lancePierre = new LancePierre();
		Epee epee = new Epee("Excalibur");
		Arc arc = new Arc(1);
		System.out.println("Le lance-pierre a un propri�taire ? " + lancePierre.estPris());
		System.out.println("Thomas prend le " + lancePierre.getNature() + ".");
		lancePierre.setProprietaire(homme);
		System.out.println("Le lance-pierre � un propri�taire ? " + lancePierre.estPris());
		lancePierre.attaque(dragon);
		System.out.println("Thomas lache le lance-pierre.");
		lancePierre.lacher();
		System.out.println("Le lance-pierre � un propri�taire ? " + lancePierre.estPris());
		arc.setProprietaire(homme);
		System.out.println("Thomas prend son " + arc.getNature() + ".");
		System.out.println(arc.attaque(dragon));
		System.out.println(arc.attaque(dragon));
		epee.setProprietaire(heros);
		System.out.println("Arthur se saisit de son " + epee.getNature() + " " + epee.getNom() + ".");
		System.out.println(epee.attaque(dragon));
		System.out.println(epee.attaque(dragon));

		// RESULAT :
		// Thomas est le premier � se joindre � la derni�re bataille entre les Hommes et
		// les dragons.
		// Le h�ros Arthur : Bonjour, je m'appelle Arthur et je viens me joindre au
		// combat.
		// Le dragon Dragonnet fut le premier � arriver sur le champ de bataille.
		// Le lance-pierre a un propri�taire ? false
		// Thomas prend le lance-pierre.
		// Le lance-pierre � un propri�taire ? true
		// Thomas lache le lance-pierre.
		// Le lance-pierre � un propri�taire ? false
		// Thomas prend son arc.
		// Thomas attaque Dragonnet avec son arc.
		// Dragonnet subit une violente attaque, mais il parvient � se relever.
		// Thomas attaque Dragonnet avec son arc.
		// Malheureusement il ne poss�dait plus de fl�ches.
		// Arthur se saisit de son �p�e Excalibur.
		// Arthur attaque Dragonnet avec son �p�e.
		// Dragonnet subit une violente attaque, mais il parvient � se relever.
		// Arthur attaque Dragonnet avec son �p�e.
		// Dragonnet subit une violente attaque, trop violente pour survivre.
		// C�est ainsi que le dragon Dragonnet mourut.
		// Les Hommes ont conquis la lande, leurs villages n'auront plus jamais � trembler devant les dragons.
	}
}
