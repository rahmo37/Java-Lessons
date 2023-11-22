package Polymorphism2;

public class MewTwo extends Pokemon {

	String[] moves = new String[4];

	MewTwo(String m1, String m2, String m3, String m4) {
		moves[0] = m1;
		moves[1] = m2;
		moves[2] = m3;
		moves[3] = m4;

	}

	void moves() {

		System.out.println("MewTwo has : ");
		for (String s : moves) {
			System.out.println(s);

		}
		System.out.println();
	}
}
