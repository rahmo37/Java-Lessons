package Polymorphism2;

public class Main {
	public static void main(String[] args) {
		Pokemon[] p = new Pokemon[4];
		p[0] = new Rayquaza("Dragon Ascend", "Sword Dance", "Outrage", "Extreem Speed");
		p[1] = new MewTwo("Ice punch", "Psykestrike", "Fire punch", "Psychic");
		p[2] = new Kyogre("Thunder", "Calm Mind", "Surf", "Hydropump");
		p[3] = new Groudon("Earthquake", "Lava pulm", "Samdstorm", "Earth power");

		for (Pokemon poke : p) {
			poke.moves();
		}

	}
}
