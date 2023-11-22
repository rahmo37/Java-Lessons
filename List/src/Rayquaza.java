
public class Rayquaza extends Pokemon {
	private String color;

	Rayquaza(String name, String catagory, int level, double height, String color) {
		super(name, catagory, level, height);
		this.color = color;
	}

	public void setColor(String color) {
		if (color == "Green") {
			this.color = color;
		} else {
			this.color = "specified color is not true";
		}
	}

	public String getColor() {
		return this.color;
	}

	@Override
	public void Noise() {
		System.out.println("Rrrrrrrrrr!");
	}

	@Override
	public String toString() {
		return super.toString() + getColor();
	}
}
