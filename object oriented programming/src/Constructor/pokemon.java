package Constructor;

public class pokemon {

	String name;
	String catagory;
	int level;

	pokemon(String name, int level, String catagory) {
		this.name = name;
		this.level = level;
		this.catagory = catagory;

	}

	void moveSet(String move1, String move2, String move3, String move4) {

		String[] move = { move1, move2, move3, move4 };

		for (int i = 0; i < 4; i++) {
			System.out.println(move[i]);
		}
		System.out.println("\n");

	}

	public String toString() {
		StringBuilder print = new StringBuilder();

		return name + "\n" + level + "\n" + catagory + "\n";
	}
}
