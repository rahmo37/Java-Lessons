package Encapsulation;

public class Pokemon {
	String name = "";
	private int level = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.equals("Pikachu")) {
			System.out.println("Invalid Pokemon");
		} else {
			this.name = name;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level > 0 && level < 100) {
			this.level = level;
		} else {
			System.out.println("The input must be within 0 - 100");
		}

	}

}
