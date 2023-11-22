package Polymorphism2;

public class Groudon extends Pokemon {
	String[] moves = new String[4];

	Groudon(String m1, String m2, String m3, String m4) {
		moves[0] = m1;
		moves[1] = m2;
		moves[2] = m3;
		moves[3] = m4;

	}

	void moves() {
		System.out.println("Groudon has :");
		for (String s : moves) {
			System.out.println(s);

		}
		System.out.println();
	}
}
