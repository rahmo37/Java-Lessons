package toString;

public class pokemon {

	String name;
	int level;
	String catagory;

	//toString method can also take parameters

	public String toString(String name, int level, String catagory) {
		this.name = name;
		this.level = level;
		this.catagory = catagory;
		return name + "\n" + level + "\n" + catagory;
	}

}
