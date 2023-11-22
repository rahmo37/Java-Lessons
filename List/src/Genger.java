
public class Genger extends Pokemon {
	private String color;

	Genger(String name, String catagory, int level, double height, String color) {
		super(name, catagory, level, height);
		setColor(color);
	}

	public void setColor(String color) {
		if (color == "Violet") {
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
		System.out.println("Grrrrrrrrr!");
	}

	@Override
	public String toString() {
		return super.toString() + getColor();
	}
}
