package test_fonctionnel;

import protagonistes.Dragon;
import protagonistes.Heros;
import protagonistes.Homme;

public class TestProtagonistes {
	public static void main(String[] args) {
		Homme homme = new Homme("Thomas");
		Heros heros = new Heros("Arthur");
		Dragon dragon = new Dragon("Dragonnet");

		System.out.println(homme.parler("Je suis " + homme.getName() + ", un homme."));
		System.out.println(heros.parler("Je suis " + heros.getName() + ", un heros."));
		System.out.println("Le dragon " + dragon.getName() + ".");
	}

	// RESULAT :
	// Thomas : Je suis Thomas, un homme.
	// Le h�ros Arthur : Je suis Arthur, un heros.
	// Le dragon Dragonnet.

}
