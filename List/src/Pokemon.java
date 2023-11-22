
public abstract class Pokemon {
	private String name;
	private String catagory;
	private int level;
	private double height;

	Pokemon(String name, String catagory, int level, double height) {
		this.setName(name);
		this.setCatagory(catagory);
		this.setLevel(level);
		this.setHeight(height);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public String getCatagory() {
		return this.catagory;
	}

	public int getLevel() {
		return this.level;
	}

	public double getHeight() {
		return this.height;
	}
	
	public abstract void Noise();
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("pokemon name :" + getName() + "\n");
		string.append("pokemon catagory :" + getCatagory() + "\n");
		string.append("pokemon level :" + getLevel() + "\n");
		string.append("pokemon height :" + getHeight() + "\n");
		return string.toString();
	}
}
