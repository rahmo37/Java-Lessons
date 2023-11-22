package Constructor;

public class main {

	public static void main(String[] args) {
		pokemon pokemon1 = new pokemon("Rayquaza", 100, "Legendary");
		System.out.println(pokemon1);
		pokemon1.moveSet("Dragon Acsend", "Extreem Speed", "Dragon Dance", "Outrage");

		pokemon pokemon2 = new pokemon("Cinderace", 100, "Starter");
		System.out.println(pokemon2);
		pokemon2.moveSet("Pyro ball", "Focus punch", "Sword dance", "Bounce");

	}

}
