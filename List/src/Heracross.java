
public class Heracross extends Pokemon {
	private String color;

	Heracross(String name, String catagory, int level, double height, String color) {
		super(name, catagory, level, height);
		this.setColor(color);
	}

	public void setColor(String color) {
		if (color == "Ocean Blue") {
			this.color = color;
		}
		else {
			this.color = "specified color is not true";
		}
	}

	public String getColor() {
		return this.color;
	}

	@Override
	public void Noise() {
		System.out.println("Hrrrrrrrrr!");
	}

	@Override
	public String toString() {
		return super.toString() + getColor();
	}
}
